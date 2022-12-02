package test.study.java.mianshiti2022;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author sunYang
 * @date 2022/7/20 15:36
 */
public class Test0720 {

    public static void main(String[] args) {
        DelayQueue<TokenExpiry> delayeds = new DelayQueue<>();

    }

    private static class TokenExpiry implements Delayed {

        private final long expiry;

        private final String value;

        public TokenExpiry(String value, Date date) {
            this.value = value;
            this.expiry = date.getTime();
        }

        public int compareTo(Delayed other) {
            if (this == other) {
                return 0;
            }
            long diff = getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS);
            return (diff == 0 ? 0 : ((diff < 0) ? -1 : 1));
        }

        public long getDelay(TimeUnit unit) {
            return expiry - System.currentTimeMillis();
        }

        public String getValue() {
            return value;
        }

    }

}
