package test.socket.config;

public class FilePathUtil {

    public static String getFilePath(){
        String filePath ;
        if (isLinux()){
            filePath = "/opt/yuanjie_test/staticResource";
        }else{
            filePath = "C:/yuanjie_test/staticResource";
        }
        return filePath;
    }

    private static boolean isLinux(){
        String systemStr = System.getProperties().getProperty("os.name");
        if (systemStr.contains("Windows")){
            return false;
        }
        return true;
    }

}
