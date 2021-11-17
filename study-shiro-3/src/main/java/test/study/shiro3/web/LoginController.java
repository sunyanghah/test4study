package test.study.shiro3.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.shiro3.config.ApiResult;
import test.study.shiro3.dto.LoginDto;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    /**
     * 登录
     * @Author Sans
     * @CreateTime 2019/6/20 9:21
     */
    @PostMapping("/login")
    public ApiResult login(@RequestBody LoginDto loginDto){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getUsername(), loginDto.getPassword());//验证成功进行登录操作
        subject.login(token);

        return ApiResult.success(SecurityUtils.getSubject().getSession().getId().toString());
    }

    /**
     * 未登录
     * @Author Sans
     * @CreateTime 2019/6/20 9:22
     */@RequestMapping("/unauth")
    public Map unauth(){
        Map map = new HashMap<>();
        map.put("code",500);
        map.put("msg","未登录");return map;
    }


}
