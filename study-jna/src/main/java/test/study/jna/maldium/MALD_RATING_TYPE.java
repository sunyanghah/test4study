/*
 * Copyright 2019, AsiaInfo Security, Inc.
 * All rights reserved as an unpublished work.
 */

package test.study.jna.maldium;

public interface MALD_RATING_TYPE {
    public static int MALD_RATING_TYPE_LOCAL_DB = 0x00000001;
    public static int MALD_RATING_TYPE_SERVER = 0x00000002;
    public static int MALD_RATING_TYPE_ALL = MALD_RATING_TYPE_LOCAL_DB | MALD_RATING_TYPE_SERVER;
}
