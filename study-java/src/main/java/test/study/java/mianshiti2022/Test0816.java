package test.study.java.mianshiti2022;

/**
 * @author sunYang
 * @date 2022/8/16 18:35
 */
public class Test0816 {

    public static void main(String[] args) {
        String version = "9.9.9";
        int versionNum = Integer.parseInt(version.replaceAll("\\.",""));
        versionNum += 1;

        String newVersionNoFormat = String.valueOf(versionNum);

        System.out.println(newVersionNoFormat.substring(0, newVersionNoFormat.length() - 2));
        System.out.println(newVersionNoFormat.substring(newVersionNoFormat.length() - 2,newVersionNoFormat.length()-1));
        System.out.println(newVersionNoFormat.substring(newVersionNoFormat.length() - 1));
        System.out.println("--------");
        String newVersion = newVersionNoFormat.substring(0, newVersionNoFormat.length() - 2) + "." +
                newVersionNoFormat.substring(newVersionNoFormat.length() - 2,newVersionNoFormat.length()-1) + "." +
                newVersionNoFormat.substring(newVersionNoFormat.length() - 1);

        System.out.println(newVersion);


    }

}
