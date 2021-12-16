package study.license.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @author sunYang
 * @date 2021/11/30 17:24
 */
@Slf4j
public class MainBordUtil {
    /**
     * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
     */
    public static String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static String getMainBordId_windows() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);

            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

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
        } catch (Exception e) {
            log.error("获取主板信息错误",e);
        }
        return result.trim();
    }

    public static String getMainBordId_linux() {

        String result = "";
        String maniBord_cmd = "dmidecode | grep 'Serial Number' | awk '{print $3}' | tail -1";
        Process p;
        try {
            p = Runtime.getRuntime().exec(
                    new String[] { "sh", "-c", maniBord_cmd });// 管道
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
                break;
            }
            br.close();
        } catch (IOException e) {
            log.error("获取主板信息错误",e);
        }
        return result;
    }

    public static String getMainBordId() throws Exception {
        String os = getOSName();
        String mainBordId = "";
        if (os.startsWith("windows")) {
            mainBordId = getMainBordId_windows();
        } else if (os.startsWith("linux")) {
            mainBordId = getMainBordId_linux();
        }
        if (StringUtils.isBlank(mainBordId)){
            return "null";
        }
        return mainBordId;
    }

    public static void main(String[] args) throws Exception {
        String mainBord = getMainBordId();
        System.out.println(mainBord);
    }
}
