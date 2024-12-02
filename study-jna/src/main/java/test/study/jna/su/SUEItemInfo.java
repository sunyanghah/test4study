package test.study.jna.su;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/9/6
 */
public class SUEItemInfo extends Structure {

    public int klass;

    public int type;

    public byte[] curVer = new byte[16];

    public SUEResultInfo resultInfo;

    public static class ByValue extends SUEItemInfo implements Structure.ByValue {}
    public static class ByReference extends SUEItemInfo implements Structure.ByReference {}

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("klass", "type", "curVer", "resultInfo");
    }
}
