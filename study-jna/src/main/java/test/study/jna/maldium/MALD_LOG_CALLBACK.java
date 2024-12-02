package test.study.jna.maldium;

// public class MALD_LOG {
//     typedef int(*MALD_LOG_CALLBACK) (MALD_LOG_LEVEL eLevel, const char* cszFilename, int nLine, const char* cszMessage);
// }

public interface MALD_LOG_CALLBACK {
    int onLogCallback(int eLevel, String filename, int nLine, String message);
}

