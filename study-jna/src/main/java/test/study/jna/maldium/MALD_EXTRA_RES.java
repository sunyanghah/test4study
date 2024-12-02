/*
 * Copyright 2019, AsiaInfo Security, Inc.
 * All rights reserved as an unpublished work.
 */

package test.study.jna.maldium;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"ui32Type", "ui32Size", "pvAddr"})
public class MALD_EXTRA_RES extends Structure {
    public int ui32Type;
    public Uint32_t ui32Size;
    public Pointer pvAddr;
}
