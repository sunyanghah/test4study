package test.study.java.mianshiti2024;

import com.lark.oapi.core.cache.LocalCache;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author sun yang
 * @date 2024/7/25
 */
public class Api0725 {

    private String key;

    private String secret;

    public Api0725(String key, String secret){
        this.key = key;
        this.secret = secret;
    }

    public static Api0725 builder(String key, String secret) {
        Api0725 api0725 = new Api0725(key,secret);
        return api0725;
    }

    private static final LocalCache localCache = LocalCache.getInstance();

    public String getAccessToken() {
        if (StringUtils.isNotBlank(localCache.get("CACHE_ACCESS_TOKEN_KEY"))) {
            return localCache.get("CACHE_ACCESS_TOKEN_KEY");
        }
        localCache.set("CACHE_ACCESS_TOKEN_KEY","thisisvalue",100, TimeUnit.SECONDS);
        return "thisisvalue";
    }

}
