package test.socket.web;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import test.socket.config.FilePathUtil;
import test.socket.config.RP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunyang
 * @date 2023-11-16
 * @desc
 */
@Slf4j
@RestController
@RequestMapping("/api/{version}")
public class Test20231116Controller {

    @GetMapping("/test")
    public RP testConnect(){
        return RP.buildSuccess("接口可以访问通","接口可以访问通");
    }

    @PostMapping("/login_type")
    public RP login_type(@RequestBody Map param){

        log.info("接口: login_type"+"入参:"+ JSON.toJSONString(param));

        Map map = new HashMap();
        map.put("login_type", Arrays.asList("user"));
        return RP.buildSuccess("Login type API.",map);
    }

    @PostMapping("/login")
    public RP login(@RequestBody Map<String,String> param){

        log.info("接口: login"+"入参:"+ JSON.toJSONString(param));

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

        File file = new File(FilePathUtil.getFilePath()+"/user.json");

        if (!file.exists()){
            return RP.buildFail("文件不存在");
        }

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bytes);
            bufferedInputStream.close();
            inputStream.close();
            String jsonStr = new String(bytes);
            Map<String,String> userMap = JSON.parseObject(jsonStr, Map.class);


            String paramToken = param.get("token");
            if (paramToken != null && !"".equals(paramToken.trim())){
                return this.handleByToken(userMap, token, paramToken);
            }


            String username = param.get("username");
            String password = param.get("password");

            if (username == null || "".equals(username.trim())
                    || password == null || "".equals(username.trim())){
                return RP.buildFail("账号密码不能为空");
            }

            if (!userMap.containsKey(username) || !userMap.get(username).equals(password)){
                return RP.buildFail("账号或密码错误");
            }

            Map map = new HashMap();
            map.put("token",token+username);
            map.put("user_id",username+"123456");
            map.put("user_name",username);
            map.put("icon_url","https://test.com/icon.png");

            return RP.buildSuccess("User logged in successfully.",map);
        } catch (Exception e) {
            e.printStackTrace();
            return RP.buildFail("文件读取失败");
        }

    }


    private RP handleByToken(Map<String,String> userMap,String token,String paramToken){


        if (!paramToken.startsWith(token)){
            return RP.buildFail("错误的token");
        }

        String username = paramToken.replace(token, "");

        if (!userMap.containsKey(username)){
            return RP.buildFail("错误的token");
        }

        Map map = new HashMap();
        map.put("token",token+username);
        map.put("user_id",username+"123456");
        map.put("user_name",username);
        map.put("icon_url","https://test.com/icon.png");

        return RP.buildSuccess("User logged in successfully.",map);
    }


    @PostMapping("/config")
    public RP config(@RequestBody Map param){

        log.info("接口: config"+"入参:"+ JSON.toJSONString(param));

        Map configMap = new HashMap();
        configMap.put("HomepageLocation","https://www.chromium.org");
        configMap.put("ShowHomeButton",true);

        Map settingMap = new HashMap();
        settingMap.put("disable",Arrays.asList("so.com"));
        settingMap.put("enable",Arrays.asList("pan.baidu.com", "yunpan.com", "gmail.com", "docs.google.com"));
        settingMap.put("minimum_data_size",10);

        configMap.put("CopyPreventionSettings",settingMap);

        Map map = new HashMap();
        map.put("config", configMap);
        return RP.buildSuccess("CONFIG API.",map);
    }

    @PostMapping("/update_config")
    public RP update_config(@RequestBody Map param){

        log.info("接口: update_config"+"入参:"+ JSON.toJSONString(param));

        File file = new File(FilePathUtil.getFilePath()+"/version.json");

        if (!file.exists()){
            return RP.buildFail("文件不存在");
        }

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bytes);
            bufferedInputStream.close();
            inputStream.close();
            String jsonStr = new String(bytes);
            Map<String,String> map = JSON.parseObject(jsonStr, Map.class);
            map.put("new_version", map.get("new_version"));
            map.put("download_url", "http://10.21.16.153:8006/staticResource/"+map.get("download_url"));
            map.put("sha256_hash", map.get("sha256_hash"));
            return RP.buildSuccess(null,map);
        } catch (Exception e) {
            e.printStackTrace();
            return RP.buildFail("文件读取失败");
        }

    }

}
