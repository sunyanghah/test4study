package test.study.shiro1.config;


import lombok.extern.slf4j.Slf4j;
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
    public ApiResult defaultExceptionHandler(HttpServletRequest req, Exception e) {
    	return ApiResult.fail(403,"没有权限啊");
    }
    
}