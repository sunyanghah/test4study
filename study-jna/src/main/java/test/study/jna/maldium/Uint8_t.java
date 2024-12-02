/*
 * Copyright 2019, AsiaInfo Security, Inc.
 * All rights reserved as an unpublished work.
 */

package test.study.jna.maldium;

import com.sun.jna.IntegerType;

public class Uint8_t extends IntegerType {
    public Uint8_t() {
        this(0);
    }

    public Uint8_t(int value) {
        super(1, value, true);
    }
}
