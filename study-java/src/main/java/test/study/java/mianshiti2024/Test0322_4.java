package test.study.java.mianshiti2024;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/3/25
 */
public class Test0322_4 {

    public static void main(String[] args) throws IOException, InterruptedException {
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

        // 移除其他用户的权限
        String dd = "icacls " + folderPath + " /remove:g \"sunyang1\" /inheritance";
        // 执行移除其他用户的权限命令
        Process ff = Runtime.getRuntime().exec(dd);
        ff.waitFor();
        System.out.println("-----"+ff.exitValue());

        // 移除其他用户的权限
        String commandRemoveInherited = "icacls " + folderPath + " /remove:g \"sunyang1\"";
        // 执行移除其他用户的权限命令
        Process processRemoveInherited = Runtime.getRuntime().exec(commandRemoveInherited);
        processRemoveInherited.waitFor();
        System.out.println("-----"+processRemoveInherited.exitValue());

    }

}
