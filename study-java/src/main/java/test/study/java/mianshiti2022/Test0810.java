
/**
 * @author sunYang
 * @date 2022/8/10 15:07
 */
public class Test0810 {

    public static void main(String[] args)  throws Exception{

        String buildPath = "/uinnova/staticResource/temp/0/8245528995950419968";
        String[] commands = {"cd", buildPath, "&&", "source", "/etc/profile", "&&", "npm", "run", "build:prod"};

        ProcessBuilder builder = new ProcessBuilder(commands);
        builder.redirectErrorStream(true);
        Process ps = builder.start();
        ps.waitFor();
    }

}
