package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/7/25
 */
public class Test0725 {

    public static void main(String[] args) {

        Api0725 api0725 = Api0725.builder("key", "secret");
        String accessToken = api0725.getAccessToken();
        System.out.println(accessToken);

        Api0725 api07252 = Api0725.builder("key", "secret");
        String accessToken2 = api07252.getAccessToken();
        System.out.println(accessToken2);

        Api0725 api07253 = Api0725.builder("key", "secret");
        String accessToken3 = api07253.getAccessToken();
        System.out.println(accessToken3);

    }

}
