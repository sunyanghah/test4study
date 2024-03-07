package study.ldap.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * @Description:
 * @author: liu.hy
 * @dateTime: 2023-04-03 14:12
 */
public class DummyTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] cert, String authType) {
        return;
    }

    @Override
    public void checkServerTrusted(X509Certificate[] cert, String authType) {
        return;
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

}
