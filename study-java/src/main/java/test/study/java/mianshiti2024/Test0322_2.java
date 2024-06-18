package test.study.java.mianshiti2024;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/3/22
 */
public class Test0322_2 {

    public static void main(String[] args) {
        String userWorkDisk = "F:\\";
        if (StringUtils.isBlank(userWorkDisk)){
            return;
        }

        String userId = "2";
        String folderPath = userWorkDisk+ File.separator+userId;
        File file = new File(folderPath);
        if (!file.exists()){
            file.mkdirs();
        }
        clearSelfAuth(folderPath);
    }

    public static void clearSelfAuth(String folderPath) {

        String currentUser = System.getProperty("user.name"); // 获取当前登录的用户名

        // 构建icacls命令来移除当前用户的权限
        String command = "icacls " + folderPath + " /remove " + currentUser;

        try {
            // 执行命令
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            // 检查命令执行结果
            if (process.exitValue() == 0) {
                System.out.println("Permissions for the current user have been removed successfully.");
            } else {
                System.out.println("Error removing permissions for the current user.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
