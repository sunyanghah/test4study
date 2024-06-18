package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/5/11
 */
public class Test0511 {

    public static void main(String[] args) {

        String fileName = "metaspace_[http@10.21.20.208@65200]_1.0.1002.2-std.alpha-x64.exe";

        String serverPath = "http@10.21.20.209@65200";

        String substring = "";
        String prefix = "";
        if (fileName.contains("]_")){
            substring = fileName.substring(0, fileName.indexOf("]_")+2);
            prefix = fileName.substring(0,fileName.indexOf("_"));
        }else{
            substring = fileName.substring(0, fileName.indexOf("-")+1);
            prefix = fileName.substring(0,fileName.indexOf("-"));
        }
        System.out.println(substring);
        System.out.println(prefix);

        String finalStr =  fileName.replace(substring,prefix+"_["+serverPath+"]_");
        System.out.println(finalStr);

    }

}
