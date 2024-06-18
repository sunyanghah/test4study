package test.study.java.mianshiti2024;

import java.io.IOException;
import java.net.*;

/**
 * @author sun yang
 * @date 2024/4/23
 */
public class Test0423 {

    public static boolean isURLReachable(String urlString) {
        try {

            if (!urlString.startsWith("http")){
                urlString = "http://"+urlString;
            }

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置一个较短的超时时间
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);

            // 发送一个HEAD请求来检查URL是否可达
            connection.getResponseCode();
            return true;
        } catch (Exception e) {
            if (e instanceof SocketException || e instanceof SocketTimeoutException) {
                return false;
            }
           return true;
        }
    }

        public static void main(String[] args) {
            String hostName = "http://10.21.20.208:65200";

            boolean reachable = isURLReachable(hostName);
            System.out.println("Host " + hostName + " is " + (reachable ? "reachable" : "not reachable"));
        }

}
