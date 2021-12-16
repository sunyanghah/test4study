package study.license.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @author sunYang
 * @date 2021/11/30 17:22
 */
@Slf4j
public class CpuUtil {
    /**
     * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
     */
    public static String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }

    /**
     * 获取CPU序列号
     *
     * @return
     */
    public static String getCPUID_Windows() {
        String result = "";
        try {
            File file = File.createTempFile("tmp", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_Processor\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.ProcessorId \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

            // + "    exit for  \r\n" + "Next";
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
            file.delete();
        } catch (Exception e) {
            log.error("获取cpu信息错误",e);
        }
        return result.trim();
    }

    public static String getCPUID_linux() throws InterruptedException {
        String result = "";
        String CPU_ID_CMD = "dmidecode";
        BufferedReader bufferedReader = null;
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(new String[]{ "sh", "-c", CPU_ID_CMD });// 管道
            bufferedReader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line = null;
            int index = -1;
            while ((line = bufferedReader.readLine()) != null) {
                // 寻找标示字符串[hwaddr]
                index = line.toLowerCase().indexOf("uuid");
                if (index >= 0) {// 找到了
                    // 取出mac地址并去除2边空格
                    result = line.substring(index + "uuid".length() + 1).trim();
                    break;
                }
            }

        } catch (IOException e) {
            log.error("获取cpu信息错误",e);
        }
        return result.trim();
    }

    public static String getCPUId() throws InterruptedException {
        String os = getOSName();
        String cpuId = "";
        if (os.startsWith("windows")) {
            cpuId = CpuUtil.getCPUID_Windows();
        } else if (os.startsWith("linux")) {
            cpuId = CpuUtil.getCPUID_linux();
        }
        if (StringUtils.isBlank(cpuId)){
            return "null";
        }
        return cpuId;
    }

    public static void main(String[] args) throws Exception {
        String os = getOSName();
        System.out.println(os);
        String cpuid = getCPUId();
        System.out.println(cpuid);
    }

}