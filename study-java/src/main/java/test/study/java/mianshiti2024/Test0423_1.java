package test.study.java.mianshiti2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sun yang
 * @date 2024/4/23
 */
public class Test0423_1 {

    public static void main(String[] args) {
        String systemUserName = System.getProperty("user.name");
        System.out.println(systemUserName);

        test();


    }

    public static String test() {

        String os = System.getProperty("os.name");
        if (os.startsWith("windows")) {
            String[] command = {"cmd.exe", "/c", "systeminfo"};
            try {
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));

                stdInput.readLine();
                stdInput.readLine();
                String osVersion = stdInput.readLine();
                osVersion = osVersion.substring(osVersion.indexOf(":") + 1).trim();
                return osVersion;

            } catch (IOException e) {
                return os;
            }
        } else {
            return os;
        }
    }


}
