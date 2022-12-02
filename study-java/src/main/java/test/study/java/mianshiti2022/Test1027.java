package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/10/27 11:48
 */
public class Test1027 {

    public static void main(String[] args) {


        String str = "[{\"SYNC_STATUS\":0.0,\"LAST_DATA_TIME\":20221009100954,\"LAST_SYNC_TIME\":1666842208852},{\"SYNC_STATUS\":0.0,\"LAST_DATA_TIME\":20221013173931,\"LAST_SYNC_TIME\":1666842208853},{\"SYNC_STATUS\":0.0,\"LAST_DATA_TIME\":20221009100954,\"LAST_SYNC_TIME\":1666839998852},{\"SYNC_STATUS\":0.0,\"LAST_DATA_TIME\":20221008173343,\"LAST_SYNC_TIME\":1666842208852}]";

        List<Map> list = JSON.parseArray(str, Map.class);

        for (Map<String, Object> m : list) {
            Object lastDataTime = m.get("LAST_DATA_TIME");
            Object lastSyncTime = m.get("LAST_SYNC_TIME");
            Object syncStatus = m.get("SYNC_STATUS");
            BigDecimal lin = new BigDecimal(0);
            boolean a = lastDataTime.equals(lin);
            boolean b = lastSyncTime.equals(lin);
            boolean c = syncStatus.equals(lin);
            if (!(!a && !b && c)) {
                System.out.println("------");
            }
        }
    }

}
