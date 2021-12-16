package study.license.util;

/**
 * @author sunYang
 * @date 2021/11/30 17:30
 */
public class LicenseUtil {

    public static String salt = "*234ds211uu";

    public static String getMachineCode(String cpuId,String mac,String mainBordId){
        return cpuId+salt+mac+salt+mainBordId;
    }

}
