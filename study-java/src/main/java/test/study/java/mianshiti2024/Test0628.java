package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/6/28
 */
public class Test0628 {

    public static void main(String[] args) {

        System.out.println(detectOS());

    }

    public static int detectOS() {
        String osName = System.getProperty("os.name").toLowerCase();
        String arch = System.getProperty("os.arch").toLowerCase();

        if (osName.contains("windows")) {
            if (arch.equals("x86")) {
                return 0; // Windows 32位
            } else {
                return 1; // Windows 64位
            }
        } else if (osName.contains("mac os x") || osName.contains("darwin")) {
            return 2; // macOS
        } else if (osName.contains("linux")) {
            return 3; // Linux
        } else if (osName.contains("xc")) {
            return 4; // 假设的操作系统 "XC"
        } else {
            throw new UnsupportedOperationException("不支持的操作系统: " + osName);
        }
    }

}
