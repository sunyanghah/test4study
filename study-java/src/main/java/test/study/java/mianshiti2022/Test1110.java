package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * @author sunYang
 * @date 2022/11/10 16:43
 */
public class Test1110 {

    public static void main(String[] args) throws Exception{
        String str = "{\"dataList\":[{\"notifyData\":{\"ticketTitle\":\"222.10.0.66 - CPU使用率 - 重要\",\"influenceScope\":5,\"assigneeEmail\":[],\"userName\":\"admin\",\"type\":\"handle\",\"userId\":1,\"token\":\"822fb06981660c805413df225539148016d07a7e628bbf1ecd79ef40dd217d82b2468e7da45dfa67c4fcde1947a59f7dee185742371046f870962e2c114e2f7a\",\"eventInfo\":{\"serial\":\"HW29901-3594\",\"acknowledged\":1,\"severity\":2,\"summary\":\"过高32131dd231dww\",\"sourceCiname\":\"222.10.0.66\",\"sourceAlertkey\":\"CPU使用率\",\"sourceId\":1,\"tally\":1,\"kpiName\":\"CPU使用率\",\"ciApplication\":\"测试\",\"ifNotify\":\"0.0\",\"alarmTicket\":1,\"grade\":0,\"firstOccurrence\":\"Nov 10, 2022 2:22:25 PM\",\"lastOccurrence\":\"Nov 10, 2022 2:22:25 PM\"},\"ticketSeverity\":\"12\",\"customerEmail\":\"test@test.com\",\"eventObject\":{\"ALARMWORKFLOW\":0,\"SOURCEEVENTID\":\"集中监控web服务器2\",\"SOURCENAME\":\"Zabbix\",\"STATUS\":1,\"SUMMARY\":\"过高32131dd231dww\",\"ACKUID\":\"admin\",\"SOURCESEVERITY\":\"1_2\",\"ACKINFO\":\"手动派单时，系统自动确认\",\"LASTOCCURRENCE\":\"Nov 10, 2022 2:22:25 PM\",\"ACKTIME\":\"Nov 10, 2022 3:23:37 PM\",\"KPIINSTANCE\":\"OS-222.10.0.66 \",\"MODIFYTIME\":20221110152337,\"KPINAME\":\"CPU使用率\",\"SOURCEALERTKEY\":\"CPU使用率\",\"SERVERSERIAL\":\"1\",\"SOURCEIDENTIFIER\":\"集中监控web服务器2\",\"SOURCECINAME\":\"222.10.0.66\",\"GRADE\":0,\"FIRSTOCCURRENCE\":\"Nov 10, 2022 2:22:25 PM\",\"SEVERITY\":2,\"BLACKOUT\":0,\"SOURCEID\":1,\"FILTERTYPE\":0,\"OLDSEVERITY\":1,\"IDENTIFIER\":\"222.10.0.66_CPU使用率\",\"ALARMEMAIL\":0,\"CREATETIME\":0,\"CIAPPLICATION\":\"测试\",\"SERIAL\":\"HW29901-3594\",\"IFNOTIFY\":\"0.0\",\"ACKNOWLEDGED\":1,\"SOURCESUMMARY\":\"过高32131dd231dww\",\"ALARMTICKET\":1,\"SERVERNAME\":\"EPServer1\",\"DUPLICATESERIAL\":\"HW29901-3594\",\"ALARMSMS\":0,\"TALLY\":1,\"TAG\":0},\"associatedSerials\":[\"HW29901-3594\"],\"assignee\":[],\"ticketSummary\":\"2022-11-10 14:22:25  Zabbix  发现  222.10.0.66  发生  CPU使用率  的 重要 告警。  |告警详情:过高32131dd231dww\",\"category\":\"测试\"}}],\"type\":3}";
        NotifyDataContainer msgObj = JSON.parseObject(str, NotifyDataContainer.class);
        System.out.println(msgObj.toString());

        NotifyDataContainer msgObj2 = new Gson().fromJson(str, NotifyDataContainer.class);
        System.out.println(msgObj2.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        NotifyDataContainer msgObj3 = objectMapper.readValue(str, NotifyDataContainer.class);
        System.out.println(msgObj3.toString());

    }

}
