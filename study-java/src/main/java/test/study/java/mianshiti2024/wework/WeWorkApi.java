package test.study.java.mianshiti2024.wework;

import com.alibaba.fastjson.JSON;
import com.lark.oapi.core.cache.LocalCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.study.java.mianshiti2024.wework.WeWorkConstant.CACHE_ACCESS_TOKEN_KEY;
import static test.study.java.mianshiti2024.wework.WeWorkConstant.WE_WORK_URL;

/**
 * @author sun yang
 * @date 2024/7/25
 */
public class WeWorkApi {

    private final String key;

    private final String secret;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final LocalCache LOCAL_CACHE = LocalCache.getInstance();

    public static WeWorkApi builder(String key, String secret) {
        return new WeWorkApi(key,secret);
    }

    public WeWorkApi(String key, String secret){
        this.key = key;
        this.secret = secret;
    }

    /**
     * 获取企业微信access_token
     * @return
     */
    public String getAccessToken(){

        if (StringUtils.isNotBlank(LOCAL_CACHE.get(CACHE_ACCESS_TOKEN_KEY))){
            return LOCAL_CACHE.get(CACHE_ACCESS_TOKEN_KEY);
        }

        ResponseEntity<WeWorkTokenDto> response = restTemplate.getForEntity(WE_WORK_URL+"/gettoken?corpid="+key+"&corpsecret="+secret, WeWorkTokenDto.class);
        if (response.getStatusCodeValue() != HttpStatus.OK.value() || response.getBody() == null){
            throw new RuntimeException("获取企业微信access_token失败"+ JSON.toJSONString(response.getBody()));
        }
        WeWorkTokenDto tokenDto = response.getBody();
        if (!tokenDto.isSuccess()){
            throw new RuntimeException("获取企业微信access_token失败"+ tokenDto.getErrmsg());
        }
        LOCAL_CACHE.set(CACHE_ACCESS_TOKEN_KEY,tokenDto.getAccess_token(),tokenDto.getExpires_in()-10, TimeUnit.SECONDS);
        return tokenDto.getAccess_token();
    }

    public WeWorkDepartment getDepartment(Long departmentId){
        String accessToken = getAccessToken();
        ResponseEntity<WeWorkDepartmentSingleDto> response = restTemplate.getForEntity(WE_WORK_URL+"/department/get?access_token="+accessToken+"&id="+departmentId, WeWorkDepartmentSingleDto.class);
        if (response.getStatusCodeValue() != HttpStatus.OK.value() || response.getBody() == null){
            throw new RuntimeException("查询企业微信部门失败"+ JSON.toJSONString(response.getBody()));
        }
        WeWorkDepartmentSingleDto departmentDto = response.getBody();
        if (!departmentDto.isSuccess()){
            throw new RuntimeException("查询企业微信部门失败"+ departmentDto.getErrmsg());
        }
        return departmentDto.getDepartment();
    }

    /**
     * 查询企业微信部门
     * @param parentDepartmentId
     * @return
     */
    public List<WeWorkDepartment> queryDepartment(Long parentDepartmentId){
        String accessToken = getAccessToken();
        ResponseEntity<WeWorkDepartmentListDto> response = restTemplate.getForEntity(WE_WORK_URL+"/department/list?access_token="+accessToken+"&id="+parentDepartmentId, WeWorkDepartmentListDto.class);
        if (response.getStatusCodeValue() != HttpStatus.OK.value() || response.getBody() == null){
            throw new RuntimeException("查询企业微信部门失败"+ JSON.toJSONString(response.getBody()));
        }
        WeWorkDepartmentListDto departmentDto = response.getBody();
        if (!departmentDto.isSuccess()){
            throw new RuntimeException("查询企业微信部门失败"+ departmentDto.getErrmsg());
        }
        return departmentDto.getDepartment();
    }

    /**
     * 查询企业微信用户
     * @param departmentId
     * @return
     */
    public List<WeWorkUser> queryUser(Long departmentId){
        String accessToken = getAccessToken();
        ResponseEntity<WeWorkUserDto> response = restTemplate.getForEntity(WE_WORK_URL+"/user/list?access_token="+accessToken+"&department_id="+departmentId, WeWorkUserDto.class);
        if (response.getStatusCodeValue() != HttpStatus.OK.value() || response.getBody() == null){
            throw new RuntimeException("查询企业微信用户失败"+ JSON.toJSONString(response.getBody()));
        }
        WeWorkUserDto userDto = response.getBody();
        if (!userDto.isSuccess()){
            throw new RuntimeException("查询企业微信用户失败"+ userDto.getErrmsg());
        }
        return userDto.getUserlist();
    }

}
