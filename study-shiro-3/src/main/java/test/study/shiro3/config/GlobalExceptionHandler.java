package test.study.shiro3.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
class GlobalExceptionHandler {

    @ExceptionHandler(value = {UnauthorizedException.class, AuthorizationException.class})
    @ResponseBody
    public ApiResult authorizationHandler(HttpServletRequest req, Exception e) {
    	return ApiResult.fail(403,"没有权限啊");
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ApiResult authenticationHandler(HttpServletRequest req, Exception e){
        return ApiResult.fail(500,"用户名或密码错误");
    }
    
}