package test.study.java.mianshiti2024;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * @author sun yang
 * @date 2024/5/21
 */
public class Test0521 {

    public static void main(String[] args) {

        String processName = "trustworkspace.exe"; // 这里替换成你需要查询的进程名
        String accountName = "孙杨"; // 这里替换成系统账户名

        boolean isRunning = isProcessRunningAsUser(processName, accountName);
        if (isRunning) {
            System.out.println("The process is running under the specified account.");
        } else {
            System.out.println("no no no no");
        }

    }


    public static boolean isProcessRunningAsUser(String processName, String userName) {


        String command = "tasklist /FI \"USERNAME eq "+userName+"\" /FI \"IMAGENAME eq "+processName+"\" | findstr \""+processName+"\"";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // 遍历WMIC命令的输出，查找匹配的账户名
                if (StringUtils.isNotBlank(line) && line.contains(processName)) {
                    return true; // 如果找到匹配的进程和账户名，返回true
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }


    public static boolean isProcessRunning(String processName, String accountName) {
        // 构建WMIC查询命令，查找特定名称的进程以及它们运行的账户
        String command = "wmic process where \"name like '%" + processName + "%'\" get Name,ProcessId,ExecutablePath,GetOwner";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // 遍历WMIC命令的输出，查找匹配的账户名
                if (line.contains(processName) && line.contains(accountName)) {
                    return true; // 如果找到匹配的进程和账户名，返回true
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // 如果没有找到，返回false
    }
}
