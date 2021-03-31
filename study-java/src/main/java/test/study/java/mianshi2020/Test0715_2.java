package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/7/15.
 */
public class Test0715_2 {

    public static void main(String[] args) {
        String str = "234234.xls";
        System.out.println(str.substring(0,str.lastIndexOf('.')));
        String suffix = str.substring(str.lastIndexOf('.') + 1, str.length());
        for (WpsFileEnum wpsFileEnum : WpsFileEnum.values()) {
            if (wpsFileEnum.toString().equalsIgnoreCase(suffix)){
                System.out.println(wpsFileEnum.getType());
            }
        }
    }

    public enum  WpsFileEnum {

        DOC("w"),
        DOT("w"),
        WPS("w"),
        WPT("w"),
        DOCX("w"),
        DOTX("w"),
        DOCM("w"),
        DOTM("w"),
        RTF("w"),
        XLS("s"),
        XLT("s"),
        ET("s"),
        XLSX("s"),
        XLTX("s"),
        CSV("s"),
        XLSM("s"),
        XLTM("s"),
        PPT("p"),
        PPTX("p"),
        PPTM("p"),
        PPSX("p"),
        PPSM("p"),
        PPS("p"),
        POTX("p"),
        POTM("p"),
        DPT("p"),
        DPS("p"),
        PDF("f");

        private String type;

        WpsFileEnum(String type){
            this.type = type;
        }

        public String getType(){
            return type;
        }

    }

}
