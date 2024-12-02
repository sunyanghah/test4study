package test.study.jna.su;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 * @author sun yang
 * @date 2024/9/6
 */
public interface SuLibrary extends Library {

    SuLibrary INSTANCE = Native.load("aissueng", SuLibrary.class);

    int SUESetConfig(Pointer sue, int config, Pointer value);

    int SUEGetConfig(Pointer sue, int config, Pointer value);

    int SUECtxInit(PointerByReference sue, String work_dir);

    int SUEUpdate(Pointer sue, SUEItemInfo.ByReference items, int item_count);

    int SUEGetLatestVersion(Pointer sue, SUEOptResult.ByReference optRet);

    int SUEClone(Pointer sue, SUEOptResult.ByReference optRet);

    int SUEQuit(Pointer sue);
}
