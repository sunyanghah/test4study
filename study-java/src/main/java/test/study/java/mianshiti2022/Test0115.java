package test.study.java.mianshiti2022;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/1/15 14:41
 */
public class Test0115 {

    public static void main(String[] args) throws Exception{

       String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:ns=\"http://tempuri.org/ns.xsd\">\n" +
               "    <SOAP-ENV:Header></SOAP-ENV:Header>\n" +
               "    <SOAP-ENV:Body>\n" +
               "        <ns:GetCrossInfoEXResponse>\n" +
               "            <rsp>\n" +
               "                <resultType>OPERATE-SUCCESS</resultType>\n" +
               "                <errMsg></errMsg>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>1</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>新南灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>41</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2609683732733E</longitude>\n" +
               "                    <latitude>47.31435695156884N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.71</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 14:46:57</createTime>\n" +
               "                    <updateTime>2021-07-12 16:18:35</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>3</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>盐业公司灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.25772300054948E</longitude>\n" +
               "                    <latitude>47.31767367244068N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.72</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:28:12</createTime>\n" +
               "                    <updateTime>2020-11-13 15:31:57</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>4</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>三元物资灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.27626240420273E</longitude>\n" +
               "                    <latitude>47.326946500667646N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.73</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:29:17</createTime>\n" +
               "                    <updateTime>2020-11-13 16:17:42</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>5</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>南山岗台灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2869323068379E</longitude>\n" +
               "                    <latitude>47.31638258862312N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.10.16</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:33:17</createTime>\n" +
               "                    <updateTime>2020-11-13 16:22:37</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.3.2-20200715.r3755</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>6</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>南山矿公司灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.28866498879373E</longitude>\n" +
               "                    <latitude>47.30978503030198N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.10.27</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:35:47</createTime>\n" +
               "                    <updateTime>2020-11-13 16:31:08</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>7</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>矿史馆灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>21</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.32992811735193E</longitude>\n" +
               "                    <latitude>47.3317531253713N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.81</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:38:17</createTime>\n" +
               "                    <updateTime>2020-11-13 16:35:04</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>8</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>粮厦灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2934982041834E</longitude>\n" +
               "                    <latitude>47.34613064726743N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.82</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:39:14</createTime>\n" +
               "                    <updateTime>2020-05-27 17:31:20</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>9</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>工农加油站灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.267987864555E</longitude>\n" +
               "                    <latitude>47.32454294785659N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.74</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:45:47</createTime>\n" +
               "                    <updateTime>2020-11-13 16:38:52</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>10</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>站前灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.28286607797864E</longitude>\n" +
               "                    <latitude>47.33964574126893N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.75</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:46:45</createTime>\n" +
               "                    <updateTime>2020-11-13 16:40:37</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.3.2-20200715.r3755</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>11</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>向阳分局灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2992757826246E</longitude>\n" +
               "                    <latitude>47.33768999970472N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.76</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:49:24</createTime>\n" +
               "                    <updateTime>2020-11-13 16:43:27</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.3.2-20200715.r3755</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>12</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>七号楼灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2713621085744E</longitude>\n" +
               "                    <latitude>47.32708460350247N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.77</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:50:22</createTime>\n" +
               "                    <updateTime>2020-05-14 15:49:05</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>13</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>南山分局灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2881768518141E</longitude>\n" +
               "                    <latitude>47.30332120953208N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.78</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:51:21</createTime>\n" +
               "                    <updateTime>2020-05-20 09:10:26</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>14</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>血站灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.28188694640662E</longitude>\n" +
               "                    <latitude>47.32237760575625N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.83</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:52:19</createTime>\n" +
               "                    <updateTime>2020-05-14 15:49:34</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>15</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>宇龙宾馆</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2813934951106E</longitude>\n" +
               "                    <latitude>47.327086926990766N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.84</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:53:22</createTime>\n" +
               "                    <updateTime>2020-11-13 09:17:30</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>16</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>胜利街灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.29335351521755E</longitude>\n" +
               "                    <latitude>47.33518879409541N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.85</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:54:32</createTime>\n" +
               "                    <updateTime>2020-05-13 17:44:48</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.3.2-20200715.r3755</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>17</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>南翼灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.3163185386931E</longitude>\n" +
               "                    <latitude>47.33606679642249N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.86</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 15:55:29</createTime>\n" +
               "                    <updateTime>2020-05-14 15:49:50</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>19</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>牧羊厂灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2570183002454E</longitude>\n" +
               "                    <latitude>47.30484856819489N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.88</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 16:00:00</createTime>\n" +
               "                    <updateTime>2020-06-11 16:47:35</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>20</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>工业大厦</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.27621961413092E</longitude>\n" +
               "                    <latitude>47.33049147228997N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.90</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 16:00:54</createTime>\n" +
               "                    <updateTime>2020-02-16 18:29:37</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>21</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>市委灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.27070499239926E</longitude>\n" +
               "                    <latitude>47.300720153615636N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.1</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 16:03:26</createTime>\n" +
               "                    <updateTime>2020-05-27 17:31:58</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.3.2-20200715.r3755</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>22</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>党校灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.27253420883366E</longitude>\n" +
               "                    <latitude>47.30427427923956N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.18</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 16:04:48</createTime>\n" +
               "                    <updateTime>2020-05-22 07:25:13</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>23</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>跃进街道口灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2857923679996E</longitude>\n" +
               "                    <latitude>47.28294614530952N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.3</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 16:06:36</createTime>\n" +
               "                    <updateTime>2020-08-22 15:58:36</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>24</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>鹿林山灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.263291366679E</longitude>\n" +
               "                    <latitude>47.28046782260398N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.4</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 16:07:31</createTime>\n" +
               "                    <updateTime>2020-03-06 16:16:27</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.3.2-20200715.r3755</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>25</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>光宇小区灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.24143126300802E</longitude>\n" +
               "                    <latitude>47.27266834792978N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.8.5</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-14 16:08:30</createTime>\n" +
               "                    <updateTime>2020-06-13 08:32:49</updateTime>\n" +
               "                    <installTime>2020-01-14 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>27</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>南翔物流灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.25351190734628E</longitude>\n" +
               "                    <latitude>47.26541008178039N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.7</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:39:49</createTime>\n" +
               "                    <updateTime>2020-02-16 18:31:48</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>28</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>兴安北桥灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.24824951347517E</longitude>\n" +
               "                    <latitude>47.25210118298192N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.8</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:41:26</createTime>\n" +
               "                    <updateTime>2020-08-22 15:43:28</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>41</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>兴安南桥灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.24101425465057E</longitude>\n" +
               "                    <latitude>47.241648010902956N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.9</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:45:35</createTime>\n" +
               "                    <updateTime>2020-02-16 18:35:23</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>42</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>俊德桥灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2360615807644E</longitude>\n" +
               "                    <latitude>47.210503855883694N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.10</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:47:34</createTime>\n" +
               "                    <updateTime>2020-08-22 15:35:56</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>43</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>黎明小学灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.27244830299693E</longitude>\n" +
               "                    <latitude>47.33308747843652N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.11</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:49:37</createTime>\n" +
               "                    <updateTime>2020-11-13 09:17:55</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>���鵱ǰ�źŻ��Ƿ�������״̬����ȡ�汾��Ϣʧ��!</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>44</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>二道街灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2812835746383E</longitude>\n" +
               "                    <latitude>47.33378183297569N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.13</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:50:56</createTime>\n" +
               "                    <updateTime>2020-08-19 19:11:06</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>���鵱ǰ�źŻ��Ƿ�������״̬����ȡ�汾��Ϣʧ��!</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>45</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>一跨桥灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2863422208562E</longitude>\n" +
               "                    <latitude>47.345170960937544N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.12</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:52:56</createTime>\n" +
               "                    <updateTime>2020-02-16 18:16:20</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>46</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>四道街灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2788589077977E</longitude>\n" +
               "                    <latitude>47.33211302909214N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.14</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:53:52</createTime>\n" +
               "                    <updateTime>2020-02-16 18:15:31</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>47</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>昌盛灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2838906818122E</longitude>\n" +
               "                    <latitude>47.328848083989705N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.15</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:55:01</createTime>\n" +
               "                    <updateTime>2020-08-19 19:14:32</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>���鵱ǰ�źŻ��Ƿ�������״̬����ȡ�汾��Ϣʧ��!</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>48</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>新一灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.33311984587598E</longitude>\n" +
               "                    <latitude>47.33101149578986N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.16</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:56:09</createTime>\n" +
               "                    <updateTime>2020-02-16 18:38:07</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>49</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>工农分局灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2758655124303E</longitude>\n" +
               "                    <latitude>47.32240115738114N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.17</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:57:34</createTime>\n" +
               "                    <updateTime>2020-05-27 17:32:40</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>50</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>良种站灯岗</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.27446539932419E</longitude>\n" +
               "                    <latitude>47.31443140695243N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.6.2</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-15 14:58:46</createTime>\n" +
               "                    <updateTime>2020-05-27 17:32:20</updateTime>\n" +
               "                    <installTime>2020-01-15 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>51</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>五指山南门</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.27623558212528E</longitude>\n" +
               "                    <latitude>47.30410336095232N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.231</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-01-17 13:33:35</createTime>\n" +
               "                    <updateTime>2020-05-27 17:32:30</updateTime>\n" +
               "                    <installTime>2020-01-17 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>���鵱ǰ�źŻ��Ƿ�������״̬����ȡ�汾��Ϣʧ��!</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>54</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>南岗路</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.2935223440531E</longitude>\n" +
               "                    <latitude>47.31760646109746N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.10.41</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-06-13 08:22:14</createTime>\n" +
               "                    <updateTime>2020-10-21 15:03:54</updateTime>\n" +
               "                    <installTime>2020-06-13 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>DS-TSC</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "                <crossInfoList>\n" +
               "                    <crossingID>56</crossingID>\n" +
               "                    <crossingIndex></crossingIndex>\n" +
               "                    <crossingName>兴山菜市场</crossingName>\n" +
               "                    <subRegionID>3</subRegionID>\n" +
               "                    <tmpID>1</tmpID>\n" +
               "                    <iOMSID>0</iOMSID>\n" +
               "                    <dateTimeType>0</dateTimeType>\n" +
               "                    <delayTime>0</delayTime>\n" +
               "                    <StartlossTime>0</StartlossTime>\n" +
               "                    <dHeadway>0</dHeadway>\n" +
               "                    <iDeviceType>0</iDeviceType>\n" +
               "                    <longitude>130.30102200088916E</longitude>\n" +
               "                    <latitude>47.352527295524695N</latitude>\n" +
               "                    <viewInMap>true</viewInMap>\n" +
               "                    <signalIp>23.24.4.87</signalIp>\n" +
               "                    <signalPort>30000</signalPort>\n" +
               "                    <suppler></suppler>\n" +
               "                    <specifications></specifications>\n" +
               "                    <createTime>2020-08-08 13:37:44</createTime>\n" +
               "                    <updateTime>2020-08-08 13:39:19</updateTime>\n" +
               "                    <installTime>2020-08-08 00:00:00</installTime>\n" +
               "                    <MaintainerName></MaintainerName>\n" +
               "                    <MaintainerPhone></MaintainerPhone>\n" +
               "                    <MaxTraffic>0</MaxTraffic>\n" +
               "                    <sigVersion>HIKETSC-V3.2.4-20190829.r3130</sigVersion>\n" +
               "                    <sigPassWd></sigPassWd>\n" +
               "                </crossInfoList>\n" +
               "            </rsp>\n" +
               "        </ns:GetCrossInfoEXResponse>\n" +
               "    </SOAP-ENV:Body>\n" +
               "</SOAP-ENV:Envelope>";

        String s = JaxbUtil.formatXml(str);

        Rsp map = JaxbUtil.xmlToBean(s, Rsp.class);

        System.out.println(map);

    }

}
