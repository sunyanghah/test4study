package test.study.shiro3.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
public class ShiroConfig {

    /**
     * 交由 Spring 来自动地管理 Shiro-Bean 的生命周期
     */
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 为 Spring-Bean 开启对 Shiro 注解的支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator app = new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }

    /////////////////////////////


    @Bean
    public RedisSessionDAO redisSessionDAO(RedisTemplate<String,Object> redisTemplate) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO(redisTemplate);
        return redisSessionDAO;
    }
    /**
     * shiro session的管理
     */
    @Bean
    public DefaultWebSessionManager redisSessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }

//    @Bean
//    public RedisCacheManager redisCacheManager(RedisTemplate<String,Object> redisTemplate) {
//        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
//        return redisCacheManager;
//    }


    /**
     * 配置访问资源需要的权限
     */
    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,RedisTemplate<String,Object> redisTemplate) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();

        // 2、将自定义过滤器放入map中，如果实现了自定义授权过滤器，那就必须在这里注册，否则Shiro不会使用自定义的授权过滤器
        filters.put("authc", new MyAuthenticationFilter(redisTemplate));

        // 3、将过滤器Ma绑定到shiroFilterFactoryBean上
        shiroFilterFactoryBean.setFilters(filters);

        shiroFilterFactoryBean.setSuccessUrl("/authorized");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/login", "anon"); // 可匿名访问
        filterChainDefinitionMap.put("/logout", "logout"); // 退出登录
        filterChainDefinitionMap.put("/**", "authc"); // 需登录才能访问
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    //将自己的验证方式加入容器
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }


    /**
     * 配置 SecurityManager
     */
    @Bean
    public SecurityManager securityManager(DefaultWebSessionManager redisSessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // Realm
        List<Realm> realms = new ArrayList<Realm>(16);
        realms.add(shiroRealm());
        securityManager.setRealms(realms);

        securityManager.setSessionManager(redisSessionManager);
//        securityManager.setCacheManager(redisCacheManager);

        return securityManager;
    }



}