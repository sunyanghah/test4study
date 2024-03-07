package test.study.java.mianshiti2023;

import sun.security.util.Cache;

public class Test1121 {

    public static void main(String[] args) {
        Cache<String,String> cache = Cache.newHardMemoryCache(Short.MAX_VALUE);
        cache.setTimeout(100000);
        cache.put("abc","123");

        System.out.println(cache.get("abc"));
    }

}
