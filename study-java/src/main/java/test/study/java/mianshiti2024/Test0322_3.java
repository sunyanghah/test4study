package test.study.java.mianshiti2024;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/3/25
 */
public class Test0322_3 {

    public static void main(String[] args) throws IOException, InterruptedException {

        String userWorkDisk = "F:\\userWorkDir";
        if (StringUtils.isBlank(userWorkDisk)){
            return;
        }

        String userId = "1";
        String folderPath = userWorkDisk+ File.separator+userId;
        File file = new File(folderPath);
        if (!file.exists()){
            file.mkdirs();
        }

        List<String> folderPermissions = getFolderPermissions(folderPath);

        for (String folderPermission : folderPermissions) {
            setFolderVisibility(folderPath,folderPermission);
        }

    }

    public static void setFolderVisibility(String folderPath,String user) throws IOException, InterruptedException {

        // 移除其他用户的权限
        String commandRemoveInherited = "icacls " + folderPath + " /remove:g \""+user+"\"";
        // 执行移除其他用户的权限命令
        Process processRemoveInherited = Runtime.getRuntime().exec(commandRemoveInherited);
        processRemoveInherited.waitFor();

        // 移除其他用户的权限
        String commandRemoveInheritedOfU = "icacls " + folderPath + " /remove:u \""+user+"\"";
        // 执行移除其他用户的权限命令
        Process processRemoveInheritedOfU = Runtime.getRuntime().exec(commandRemoveInheritedOfU);
        processRemoveInheritedOfU.waitFor();

    }



    private static List<String> getFolderPermissions(String folderPath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("icacls", folderPath);
        processBuilder.redirectErrorStream(true); // 重定向错误输出
        Process process = processBuilder.start();

        // 读取icacls命令的输出
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
        List<String> permissionsOutput = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replace(folderPath,"");
            if (line.trim().equals("")){
                break;
            }
            permissionsOutput.add(line.trim());
        }
        process.waitFor(); // 等待进程结束

        return permissionsOutput;
    }

}
