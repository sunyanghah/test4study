package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/5/7
 */
public class Test0507 {

    public static void main(String[] args) {
        String fileName = "trustworkspace-1.0.1002.4-std.alpha-x64.exe";
        String serverPath = "https@metaspace.asiainfo-sec.com@65200";
        String substring = fileName.substring(0, fileName.indexOf("-")+1);

        System.out.println();

        if ("trustworkspace-".equalsIgnoreCase(substring)){
            System.out.println(fileName.replaceFirst(substring,"trustworkspace_["+serverPath+"]_"));
        }
    }

}
