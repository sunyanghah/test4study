package test.study.jna.su;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/9/6
 */
public class SUEOptResult extends Structure {

    public byte[] dirPath = new byte[512];

    public int result;

    public int itemNum;

    public SUEItemInfo.ByReference itemInfo;

    public static class ByReference extends SUEOptResult implements Structure.ByReference {}
    public static class ByValue extends SUEItemInfo implements Structure.ByValue {}

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("dirPath", "result", "itemNum", "itemInfo");
    }
}
