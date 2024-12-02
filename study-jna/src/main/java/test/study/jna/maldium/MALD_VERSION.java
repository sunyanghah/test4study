package test.study.jna.maldium;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class MALD_VERSION extends Structure {
    public int ui32Major;
    public int ui32Minor;
    public int ui32Patch;
    /*内部类实现指针类型接口*/
    public static class ByReference extends MALD_VERSION implements Structure.ByReference{}
    /*内部类实现值类型接口*/
    public static class ByValue extends MALD_VERSION implements Structure.ByValue{}

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(new String[] {"ui32Major", "ui32Minor", "ui32Patch"});
    }

}
