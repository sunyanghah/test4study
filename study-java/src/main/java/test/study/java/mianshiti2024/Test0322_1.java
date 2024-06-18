package test.study.java.mianshiti2024;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/3/22
 */
public class Test0322_1 {

    public static void main(String[] args) {
        String userWorkDisk = "F:\\userWorkDir";
        if (StringUtils.isBlank(userWorkDisk)){
            return;
        }

        String userId = "3";
        String folderPath = userWorkDisk+ File.separator+userId;
        File file = new File(folderPath);
        if (!file.exists()){
            file.mkdirs();
        }
        setFolderVisibility(folderPath);
    }

    public static void setFolderVisibility(String folderPath) {

        // 获取当前登录的用户名
        String currentUser = System.getProperty("user.name");

        // 阻止继承权限
        String commandBlockInheritance = "icacls " + folderPath + " /inheritance:r /T";

        // 移除其他用户的权限
        String commandRemoveInherited = "icacls " + folderPath + " /remove:g \"BUILTIN\\Users\"";
        String commandRemoveAuthenticatedUsers = "icacls " + folderPath + " /remove:g \"NT AUTHORITY\\Authenticated Users\"";

        // 仅为当前用户授予完全控制权限
        String commandGrantPermissions = "icacls " + folderPath + " /grant:r " + currentUser + ":F /T";

        try {
            // 执行阻止继承命令
            Process processBlockInheritance = Runtime.getRuntime().exec(commandBlockInheritance);
            processBlockInheritance.waitFor();

            // 执行移除其他用户的权限命令
            Process processRemoveInherited = Runtime.getRuntime().exec(commandRemoveInherited);
            processRemoveInherited.waitFor();
            Process processRemoveAuthenticatedUsers = Runtime.getRuntime().exec(commandRemoveAuthenticatedUsers);
            processRemoveAuthenticatedUsers.waitFor();

            // 执行仅为当前用户授予权限命令
            Process processGrantPermissions = Runtime.getRuntime().exec(commandGrantPermissions);
            processGrantPermissions.waitFor();

            // 检查命令执行结果
            if (processBlockInheritance.exitValue() == 0 &&
                    processRemoveInherited.exitValue() == 0 &&
                    processRemoveAuthenticatedUsers.exitValue() == 0 &&
                    processGrantPermissions.exitValue() == 0) {
                System.out.println("Folder is now private to the current user.");
            } else {
                System.out.println("An error occurred while setting folder permissions.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
