/*
 * Copyright 2019, AsiaInfo Security, Inc.
 * All rights reserved as an unpublished work.
 */

package test.study.jna.maldium;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

// @Structure.FieldOrder({"acRuleId", "ui8Severity", "ui8Confidence", "ui8Prevalence", "aui8Categories", "sIocVal", "pExtraInfo"})
public class UNIFORM_RESULT_DATA extends Structure {
    public static final int RULE_ID_LEN = 16;
    public static final int CATEGORIES_LEN = 4;

    public byte[] acRuleId = new byte[RULE_ID_LEN + 1];
    public byte ui8Severity;
    public byte ui8Confidence;
    public byte ui8Prevalence;
    public Uint8_t[] aui8Categories = new Uint8_t[CATEGORIES_LEN];
    public MALD_STRING sIocVal;
    public Pointer pExtraInfo;

    /*内部类实现指针类型接口*/
    public static class ByReference extends UNIFORM_RESULT_DATA implements Structure.ByReference{}
    /*内部类实现值类型接口*/
    public static class ByValue extends UNIFORM_RESULT_DATA implements Structure.ByValue{}

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("acRuleId", "ui8Severity", "ui8Confidence", "ui8Prevalence", "aui8Categories", "sIocVal", "pExtraInfo");
    }
}

