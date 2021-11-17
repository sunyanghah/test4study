package test.study.shiro1.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.shiro1.dto.LoginDto;

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
    public Map login(@RequestBody LoginDto loginDto){
        Map map = new HashMap<>();//进行身份验证try{//验证身份和登录
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getUsername(), loginDto.getPassword());//验证成功进行登录操作
            subject.login(token);
        }catch (IncorrectCredentialsException e) {
            map.put("code",500);
            map.put("msg","用户不存在或者密码错误");return map;
        } catch (LockedAccountException e) {
            map.put("code",500);
            map.put("msg","登录失败，该用户已被冻结");return map;
        } catch (AuthenticationException e) {
            map.put("code",500);
            map.put("msg","该用户不存在");return map;
        } catch (Exception e) {
            map.put("code",500);
            map.put("msg","未知异常");return map;
        }
        map.put("code",0);
        map.put("msg","登录成功");
        map.put("token",SecurityUtils.getSubject().getSession().getId().toString());

        return map;
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
