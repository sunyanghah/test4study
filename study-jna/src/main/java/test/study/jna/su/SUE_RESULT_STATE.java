package test.study.jna.su;

/**
 * @author sun yang
 * @date 2024/9/6
 */
public interface SUE_RESULT_STATE {

    /* no need update */
    int SUE_NO_NEED_UPDATE = 2;

    /* partial success */
    int SUE_PARTIAL_SUCCESS = 1;

    /* success */
    int SUE_SUCCESS = 0;

    /* fail */
    int SUE_EFAIL = -1;

    /* null arg */
    int SUE_ENULLARG = -2;

    /* error arg */
    int SUE_EARG = -3;

    /* file open fail */
    int SUE_EOPEN = -4;

    /* memory alloc error */
    int SUE_EMEM = -5;

    /* cache invalid */
    int SUE_ENO_CACHE_FILE = -6;

    /* configure not complete */
    int SUE_ECONFIG_INCOMPLETE = -7;

    /* create dir fail */
    int SUE_ECREATEDIR_FAIL = -8;

    /* server ini parser error */
    int SUE_ESERVER_INI = -9;

    /* *.md5 download failed */
    int SUE_EDOWNLOAD_MD5_FAILED = -10;

    /* file download failed */
    int SUE_EDOWNLOAD_FILE_FAILED = -11;

    int SUE_ECACHE_NO_MATCH = -12;

    int SUE_ECACHE_ERROR = -13;

    int SUE_EUNZIP_FAIL = -14;

    int SUE_EBACKUP_LOG = -15;

    int SUE_ECHECK_MD5_FIAL = -16;

}
