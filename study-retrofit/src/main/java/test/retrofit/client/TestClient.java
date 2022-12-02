package test.retrofit.client;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import test.retrofit.config.RP;

import java.util.Map;

/**
 * @author sunYang
 * @date 2022/7/22 16:39
 */
@RetrofitClient(baseUrl = "http://10.100.32.63:8850/")
public interface TestClient {

    @GET("/manager/component/type")
    RP getComponentType(@Header("token")String token);

    @POST("/manager/user/login")
    RP<String> login(@Body Map<String,String> map);

}
