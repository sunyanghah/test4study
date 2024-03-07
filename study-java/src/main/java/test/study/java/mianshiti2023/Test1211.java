package test.study.java.mianshiti2023;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sun yang
 * @date 2023/12/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test1211 {

    private String name;
    private String startIP;
    private String endIP;

    public static void main(String[] args) {
        List<Test1211> deviceGroups = new ArrayList<>();
        deviceGroups.add(new Test1211("Group A", "192.168.1.1", "192.168.2.10"));
        deviceGroups.add(new Test1211("Group B", "192.168.3.1", "192.168.3.5"));
        deviceGroups.add(new Test1211("Group C", "192.168.4.1", "192.168.5.8"));

        String ipToSearch = "192.168.4.256";
        String group = getGroupByIP(deviceGroups, ipToSearch);
        System.out.println("IP " + ipToSearch + " belongs to group: " + group);
    }

    public static String getGroupByIP(List<Test1211> deviceGroups, String ip) {
        for (Test1211 group : deviceGroups) {
            if (isIPInRange(ip, group.getStartIP(), group.getEndIP())) {
                return group.getName();
            }
        }
        return null;
    }

    public static boolean isIPInRange(String ip, String startIP, String endIP) {
        long ipToCheck = ipToLong(ip);
        long start = ipToLong(startIP);
        long end = ipToLong(endIP);
        return ipToCheck >= start && ipToCheck <= end;
    }

    public static long ipToLong(String ip) {
        String[] ipParts = ip.split("\\.");
        long ipLong = 0;
        for (int i = 0; i < 4; i++) {
            ipLong += Long.parseLong(ipParts[i]) << (24 - (8 * i));
        }
        return ipLong;
    }

}
