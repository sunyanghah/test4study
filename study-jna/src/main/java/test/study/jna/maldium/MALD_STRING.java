package test.study.jna.maldium;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

// @Structure.FieldOrder({"ui32Size", "pszData"})

public class MALD_STRING extends Structure {
    public int ui32Size;
    public String pszData;
    
    public static class ByReference extends MALD_STRING implements Structure.ByReference {}
    public static class ByValue extends MALD_STRING implements Structure.ByValue {}

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("ui32Size", "pszData");
    }
}
