package test.study.java.mianshiti2024;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sun yang
 * @date 2024/3/14
 */
public class Test0314 {

    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Local IP Address: " + addr.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error getting local IP address: " + e.getMessage());
        }
    }

}
