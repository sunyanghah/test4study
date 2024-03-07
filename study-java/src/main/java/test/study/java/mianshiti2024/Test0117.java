package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/1/17
 */
public class Test0117 {

    public static void main(String[] args) {
        System.out.println(formatIPRange("1.1.1.1","1.1.1.30"));
    }

    public static String formatIPRange(String startIp, String endIp) {
        // 将起始IP地址和结束IP地址转换为四个部分的数组
        String[] startIpArr = startIp.split("\\.");
        String[] endIpArr = endIp.split("\\.");

        // 拼接起始IP地址和结束IP地址的共同部分
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (startIpArr[i].equals(endIpArr[i]) && i != 3) {
                sb.append(startIpArr[i]);
            } else {
                sb.append(startIpArr[i]);
                sb.append("-");
                sb.append(endIpArr[i]);
                break; // 只需要找到第一个不相同的部分即可
            }
            if (i < 3) {
                sb.append(".");
            }
        }

        return sb.toString();
    }

    // 辅助方法：将IP地址转换为对应的整数
    private static long ipToLongNum(String ip) {
        String[] ipParts = ip.split("\\.");
        if (ipParts.length != 4) {
            throw new IllegalArgumentException("输入的IP地址格式无效");
        }

        long result = 0;
        for (int i = 0; i < 4; i++) {
            result = result << 8 | Integer.parseInt(ipParts[i]);
        }
        return result;
    }

}
