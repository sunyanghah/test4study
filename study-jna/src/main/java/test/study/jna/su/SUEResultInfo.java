package test.study.jna.su;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/9/6
 */
public class SUEResultInfo extends Structure {

    public byte[] newVer = new byte[16];

    public byte[] pathInfo = new byte[512];

    public int result;

    public int size;

    public byte[] fileMd5 = new byte[33];

    public static class ByReference extends SUEResultInfo implements Structure.ByReference {}
    public static class ByValue extends SUEResultInfo implements Structure.ByValue {}

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("newVer", "pathInfo", "result", "size", "fileMd5");
    }
}
