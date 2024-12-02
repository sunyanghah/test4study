package test.study.jna.su;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author sun yang
 * @date 2024/9/6
 */
@Slf4j
public class SuTest {

    public static void main(String[] args) {
//        testClone();
//        System.out.println("-----------------------------");
//        testVersion();
        testUpdate();
//        testQuit();
    }

    public static PointerByReference getSue(){
        // 获取速鱿引擎实例
        SuLibrary suInstance = SuLibrary.INSTANCE;

        // 初始化引擎
        PointerByReference sue = new PointerByReference();
        int ret = suInstance.SUECtxInit(sue, "./suTestDir");

        if (ret != SUE_RESULT_STATE.SUE_SUCCESS) {
            log.error(String.format("cannot init SU, errorcode = %d", ret));
            return null;
        }

        // 设置引擎配置
        Pointer pValue = new Memory(10240);
        pValue.setString(0, "https://su.spn.asiainfo-sec.com/TWS-ALL-ALL-ALL-ALL-1.0");
//        pValue.setString(0, "https://su-poeopr.spn.asiainfo-sec.com/TWS-ALL-ALL-ALL-ALL-1.0");
        suInstance.SUESetConfig(sue.getValue(),SUE_CONF_KEY.SUE_CONF_GLOBAL_SU_URL,pValue);
        pValue.setString(0, "3.100.7");
        suInstance.SUESetConfig(sue.getValue(),SUE_CONF_KEY.SUE_CONF_PVER,pValue);
        pValue.setString(0, "ND-AMRV-67HS2-BNBPQ-A43DW-EGG36-V5XJQ");
        suInstance.SUESetConfig(sue.getValue(),SUE_CONF_KEY.SUE_CONF_HK,pValue);
//        pValue.setString(0, "1");
//        suInstance.SUESetConfig(sue,SUE_CONF_KEY.SUE_CONF_TENANT_ID,pValue);

        return sue;
    }

    public static void testGetConf(){
        // 获取速鱿引擎实例
        SuLibrary suInstance = SuLibrary.INSTANCE;

        PointerByReference sue = getSue();

        Pointer pValue = new Memory(10240);
        suInstance.SUEGetConfig(sue.getValue(),SUE_CONF_KEY.SUE_CONF_GLOBAL_SU_URL,pValue);
        System.out.println("======" + pValue.getString(0));

        suInstance.SUEGetConfig(sue.getValue(),SUE_CONF_KEY.SUE_CONF_PVER,pValue);
        System.out.println("======" + pValue.getString(0));

        suInstance.SUEGetConfig(sue.getValue(),SUE_CONF_KEY.SUE_CONF_HK,pValue);
        System.out.println("======" + pValue.getString(0));

//        suInstance.SUEQuit(sue);
    }

    public static void testVersion(){
        // 获取速鱿引擎实例
        SuLibrary suInstance = SuLibrary.INSTANCE;

        PointerByReference sue = getSue();

        try {
            SUEOptResult.ByReference optRet = new SUEOptResult.ByReference();
            int optRetCode = suInstance.SUEGetLatestVersion(sue.getValue(), optRet);
            System.out.println("===VERSION===" + optRetCode);
            if (optRetCode == SUE_RESULT_STATE.SUE_SUCCESS) {
                System.out.println(
                        "======dirPath:"+new String(optRet.dirPath)
                        +"======curVer:" + new String(optRet.itemInfo.curVer)
                        +"======curType:"+optRet.itemInfo.type
                        +"======curKlass:"+optRet.itemInfo.klass
                        +"======resultVer:"+new String(optRet.itemInfo.resultInfo.newVer)
                        +"======resultPath:"+new String(optRet.itemInfo.resultInfo.pathInfo)
                        +"======resultMd5:"+new String(optRet.itemInfo.resultInfo.fileMd5)
                );
            }
        }catch (Throwable e){
            System.out.println("error"+e);
        }

    }

    public static void testUpdate(){
        // 获取速鱿引擎实例
        SuLibrary suInstance = SuLibrary.INSTANCE;

        PointerByReference sue = getSue();

        SUEItemInfo.ByReference sueItemInfo = new SUEItemInfo.ByReference();
        sueItemInfo.klass = ITEM_CLASS.ITEM_KLASS_PATTERN;
        sueItemInfo.type = 25313;

        sueItemInfo.curVer = Arrays.copyOf( "3100006".getBytes(StandardCharsets.UTF_8),16);

        // 更新
        int updateRet = suInstance.SUEUpdate(sue.getValue(),sueItemInfo,1);

        if (updateRet != SUE_RESULT_STATE.SUE_SUCCESS) {
            log.error(String.format("cannot update SU, errorcode = %d", updateRet));
            return;
        }

        System.out.println(
                        "======curVer:" + new String(sueItemInfo.curVer)
                        +"======curType:"+sueItemInfo.type
                        +"======curKlass:"+sueItemInfo.klass
                        +"======resultVer:"+new String(sueItemInfo.resultInfo.newVer)
                        +"======resultPath:"+new String(sueItemInfo.resultInfo.pathInfo)
                        +"======resultMd5:"+new String(sueItemInfo.resultInfo.fileMd5)
        );

        System.out.println("111");
    }

    public static void testClone(){
        // 获取速鱿引擎实例
        SuLibrary suInstance = SuLibrary.INSTANCE;

        PointerByReference sue = getSue();

        try {
            SUEOptResult.ByReference optRet = new SUEOptResult.ByReference();
            int optRetCode = suInstance.SUEClone(sue.getValue(), optRet);
            System.out.println("===CLONE===" + optRetCode);
            if (optRetCode == SUE_RESULT_STATE.SUE_SUCCESS) {
                System.out.println(
                        "======dirPath:"+new String(optRet.dirPath)
                        +"======curVer:" + new String(optRet.itemInfo.curVer)
                        +"======curType:"+optRet.itemInfo.type
                        +"======curKlass:"+optRet.itemInfo.klass
                        +"======resultVer:"+new String(optRet.itemInfo.resultInfo.newVer)
                        +"======resultPath:"+new String(optRet.itemInfo.resultInfo.pathInfo)
                        +"======resultMd5:"+new String(optRet.itemInfo.resultInfo.fileMd5)
                );
            }
        }catch (Throwable e){
            System.out.println("error"+e);
        }
    }

    public static void testQuit(){
        // 获取速鱿引擎实例
        SuLibrary suInstance = SuLibrary.INSTANCE;

        PointerByReference sue = getSue();

        suInstance.SUEQuit(sue.getValue());
    }
}
