/*
 * Copyright 2019, AsiaInfo Security, Inc.
 * All rights reserved as an unpublished work.
 */

package test.study.jna.maldium;

import com.sun.jna.Structure;

@Structure.FieldOrder({"ui8Severity", "ui8Confidence", "ui8Activity", "ui8Flags", "aui8Categories", "aui32ExtraInfoId"})
public class MALD_BASIC_INFO extends Structure {
    public static int MAX_MALD_CATEGORY_SIZE = 4;
    public static int MAX_MALD_EXTRAINFO_SIZE = 4;

    public byte ui8Severity;
    public byte ui8Confidence;
    public byte ui8Activity;
    public byte ui8Flags;
    public Uint8_t[] aui8Categories = new Uint8_t[MAX_MALD_CATEGORY_SIZE];
    public Uint32_t[] aui32ExtraInfoId = new Uint32_t[MAX_MALD_EXTRAINFO_SIZE];
    public MALD_BASIC_INFO() {
        super(ALIGN_NONE);
    }
}
