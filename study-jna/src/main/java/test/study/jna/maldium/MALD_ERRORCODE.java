package test.study.jna.maldium;

public interface MALD_ERRORCODE {

    int MALD_SUCCESS                = 200;
    int MALD_NO_MATCH               = 201;
    int MALD_LOCAL_PTN_MATCHED      = 202;
    int MALD_REMOTE_CACHE_MATCHED   = 203;
    int MALD_REMOTE_SERVER_MATCHED  = 204;
    int MALD_INACTIVE_RULE_MATCHED  = 205;
    int MALD_WHITE_LIST_MATCHED     = 206;
    int MALD_RECORD_ACCEPTED        = 251;
    int MALD_RECORD_CREATED         = 252;
    int MALD_RECORD_NOT_FOUND       = 253;
    int MALD_RECORD_EXPIRED         = 254;
    int MALD_IN_MISSED_CACHE        = 255;
    int MALD_ERROR                  = 400;
    int MALD_ILLEGAL_ARGUMENTS      = 401;
    int MALD_FILE_NOT_EXIST         = 402;
    int MALD_DIRECTORY_NOT_EXIST    = 403;
    int MALD_FILE_MALFORMED         = 404;
    int MALD_PTN_IS_EMPTY           = 405;
    int MALD_UNSUPPORT_ENG_OPT      = 406;
    int MALD_QUERY_PRIVATE_IP       = 451;
    int MALD_DUPLICATE_HASH_KEY     = 461;
    int MALD_MALLOC_FAILURE         = 501;
    int MALD_FILE_DUMP_FAILURE      = 502;
    int MALD_FILE_LOAD_FAILURE      = 503;
    int MALD_DELETE_FAILURE         = 504;
    int MALD_FILE_OPEN_FAILURE      = 505;
    int MALD_DIRECTORY_OPEN_FAILURE = 506;
    int MALD_QUEUE_FULL             = 551;
    int MALD_CURL_ERROR             = 552;
    int MALD_IOC_NUMS_NOT_EQUAL     = 553;
}
