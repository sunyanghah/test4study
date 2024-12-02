/*
 * Copyright 2019, AsiaInfo Security, Inc.
 * All rights reserved as an unpublished work.
 */

package test.study.jna.maldium;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public interface MaldiumLibrary extends Library {
    public static final String WINDOWS_LIBRARY_NAME = "aismmeng";
    public static final String LINUX_LIBRARY_NAME = "mmeng";
    MaldiumLibrary INSTANCE = (MaldiumLibrary) Native.load(System.getProperty("os.name").toLowerCase().indexOf("windows") >= 0 ? WINDOWS_LIBRARY_NAME : LINUX_LIBRARY_NAME, MaldiumLibrary.class);

    /**
     * init MALD_OPTIONS
     *
     * @param ppOpts
     * @return
     */
    int MALD_initOpts(PointerByReference ppOpts);

    /**
     * uninit MALD_OPTIONS
     *
     * @param ppOpts
     * @return
     */
    int MALD_uninitOpts(PointerByReference ppOpts);

    /**
     * setup options
     *
     * @param pOpts
     * @param eOpt  use MALD_OPT
     * @param value
     * @return
     */
    int MALD_setOpt(Pointer pOpts, int eOpt, Pointer value);

    /**
     * init MALD_ENG
     *
     * @param pOpts
     * @param ppEngine
     * @return
     */
    int MALD_initEngine(Pointer pOpts, PointerByReference ppEngine);

     int MALD_initLog(int bEnableLog, MALD_LOG_CALLBACK pfLogCallback);
    /**
     * get engine and pattern info
     *
     * @param pEngine
     * @param eType
     * @param pEngineVer
     * @param pFullPtnVer
     * @return
     */
    // int MALD_getVersion(Pointer pEngine, MALD_VERSION engineVer, MALD_VERSION fullPtnVer, MALD_VERSION deltaPtnVer);

    int MALD_uniformGetVersion(Pointer pEngine, int eType, MALD_VERSION.ByReference pEngineVer, MALD_VERSION.ByReference pFullPtnVer, MALD_VERSION.ByReference pDeltaPtnVer);

    // int MALD_uniformGetVersion(Pointer pEngine, int eType, MALD_VERSION engineVer, MALD_VERSION fullPtnVer, MALD_VERSION deltaPtnVer);
    /**
     * get engine and pattern external info
     *
     * @param pEngine
     * @param engineVer
     * @param fullPtnExternalVer
     * @param deltaPtnVer
     * @return
     */
    // int MALD_getVersion2(Pointer pEngine, MALD_VERSION engineVer, MALD_VERSION fullPtnExternalVer, MALD_VERSION deltaPtnExternalVer);

    /**
     * lookup system IoC
     *
     * @param pEngine
     * @param eType   use PTN_DATA_TYPE
     * @param eDataType
     * @param sData
     * @param pResult
     * @return
     */
    // int MALD_lookup(Pointer pEngine, int eType, String data, RESULT_DATA result);

    // int MALD_uniformLookup(Pointer pEngine, int eType, int eDataType, MALD_STRING sData, UNIFORM_RESULT_DATA pResult);
    int MALD_uniformLookup(Pointer pEngine, int eType, int eDataType, MALD_STRING.ByValue sData, UNIFORM_RESULT_DATA.ByReference pResult);

    /**
     * remote server lookup only in realtime
     *
     * @param pEngine
     * @param eType   use PTN_DATA_TYPE
     * @param data
     * @param result
     * @return
     */
    // int MALD_rlookup(Pointer pEngine, int eType, String data, RESULT_DATA result);

    /**
     * get IoC extra resource detail
     *
     * @param pEngine
     * @param ui32Id
     * @param resource should be released by MALD_resetExtraRes
     * @return
     */
    int MALD_getDetail(Pointer pEngine, Uint32_t ui32Id, MALD_EXTRA_RES resource);

    /**
     * reset MALD_EXTRA_RES, release internal resource
     *
     * @param resource
     * @return
     */
    int MALD_resetExtraRes(MALD_EXTRA_RES resource);

    /**
     * dump internal cache to local file
     *
     * @param pEngine
     * @param cachePath
     * @return
     * @since 1.3.0
     */
    int MALD_dumpCache(Pointer pEngine, String cachePath);

    /**
     * load internal cache from local file
     *
     * @param pEngine
     * @param sCachePath
     * @return
     * @since 1.3.0
     */
    // int MALD_loadCache(Pointer pEngine, String cachePath);
    int MALD_uniformLoadCache(Pointer pEngine, MALD_STRING sCachePath);

    /**
     * uninit MALD_ENG
     *
     * @param ppEngine
     * @return
     */
    int MALD_uninitEngine(PointerByReference ppEngine);
}
