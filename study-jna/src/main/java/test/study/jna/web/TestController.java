package test.study.jna.web;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.jna.dto.InDto;
import test.study.jna.dto.OutDto;
import test.study.jna.maldium.*;

import static test.study.jna.maldium.MALD_OPT.*;
import static test.study.jna.maldium.PTN_DATA_TYPE.PTN_DATA_TYPE_URL;

/**
 * @author sun yang
 * @date 2024/9/4
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping
    public OutDto test(InDto inDto) {

        // 获取魔龙引擎实例
        MaldiumLibrary mald = MaldiumLibrary.INSTANCE;

        // 初始化引擎日志
        mald.MALD_initLog(1, new MALD_LOG_CALLBACK() {
            @Override
            public int onLogCallback(int eLevel, String filename, int nLine, String message) {
                log.info("eLevel:{},filename:{},nLine:{},message:{}", eLevel, filename, nLine, message);
                return 0;
            }
        });

        // 初始化引擎配置
        int ret;
        PointerByReference ppOpts = new PointerByReference();
        ret = mald.MALD_initOpts(ppOpts);
        if (ret != MALD_ERRORCODE.MALD_SUCCESS) {
            log.info(String.format("cannot init MALD_OPTIONS, errorcode = %d", ret));
            throw new RuntimeException("cannot init MALD_OPTIONS");
        }
        Pointer pValue = new Memory(1024);
        pValue.setString(0,"TrustWorkSpace");
        mald.MALD_setOpt(ppOpts.getValue(), MALD_OPT_PRODUCTID, pValue);
        pValue.setString(0,"ND-AMRV-67HS2-BNBPQ-A43DW-EGG36-V5XJQ");
        mald.MALD_setOpt(ppOpts.getValue(), MALD_OPT_TOKEN, pValue);
        String patternPath = "./ptn/";
        pValue.setString(0, patternPath);
        mald.MALD_setOpt(ppOpts.getValue(), MALD_OPT_FPTN_DIR, pValue);
        mald.MALD_setOpt(ppOpts.getValue(), MALD_OPT_DPTN_DIR, pValue);

        // 初始化引擎
        PointerByReference ppEngine = new PointerByReference();
        ret = mald.MALD_initEngine(ppOpts.getValue(), ppEngine);
        if (ret != MALD_ERRORCODE.MALD_SUCCESS) {
            log.info(String.format("cannot init MALD_ENGINE, errorcode = %d", ret));
            throw new RuntimeException("cannot init MALD_ENGINE");
        }

        // 查询
        query(mald, ppEngine.getValue(), "http://asia-info.maldiumtest-botnet.com/", PTN_DATA_TYPE_URL);

        // 析构引擎
        mald.MALD_uninitEngine(ppEngine);
        // 析构引擎配置
        mald.MALD_uninitOpts(ppOpts);
        return null;
    }

    public void query(MaldiumLibrary mald, Pointer pEngine, String queryString, int dataType) {

        MALD_STRING.ByValue sData = new MALD_STRING.ByValue();
        sData.ui32Size = queryString.length();
        sData.pszData = queryString;

        UNIFORM_RESULT_DATA.ByReference pResult = new UNIFORM_RESULT_DATA.ByReference();

        int statusRet = mald.MALD_uniformLookup(pEngine,1, dataType, sData, pResult);

        System.out.println(String.format("lookup statusRet = %d", statusRet));

        String matchType = null;
        if (statusRet >= 200 && statusRet < 300) {
            switch (statusRet) {
                case MALD_ERRORCODE.MALD_LOCAL_PTN_MATCHED:
                    matchType = "MALD_LOCAL_PTN_MATCHED";

                case MALD_ERRORCODE.MALD_REMOTE_CACHE_MATCHED:
                    matchType = "MALD_REMOTE_CACHE_MATCHED";
                    String ruleid = new String(pResult.acRuleId);
                    System.out.println(String.format("query:%s %s result: \nruleid:%s ui8Severity:%d confidence:%d severity:%d category[0]:%d\n",
                            sData.pszData, matchType, ruleid, pResult.ui8Severity,
                            pResult.ui8Confidence, pResult.ui8Severity, pResult.aui8Categories[0].intValue()));
                    break;
                case MALD_ERRORCODE.MALD_WHITE_LIST_MATCHED:
                    matchType = "MALD_WHITE_LIST_MATCHED";
                    System.out.println(String.format("query %s match whilte list\n", queryString));
                    break;
                case MALD_ERRORCODE.MALD_NO_MATCH:
                    matchType = "MALD_NO_MATCH";
                    System.out.println(String.format("query %s no match\n", queryString));
                    break;
                default:
                    System.out.println(String.format("query %s result type is %d\n", queryString, statusRet));
                    break;
            }
        }
        else {
            matchType = "MALD_ERROR";
            System.out.println(String.format("query %s match error [%d]", queryString, statusRet));
        }
    }


}
