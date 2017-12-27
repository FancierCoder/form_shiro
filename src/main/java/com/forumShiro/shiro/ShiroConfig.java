package com.forumShiro.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置文件
 */
@Configuration
public class ShiroConfig {

    @Bean("sessionManager")
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }


    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login.html");
        shiroFilter.setUnauthorizedUrl("/");

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/common/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/index.jsp", "anon");
        filterMap.put("/Index", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/login2.html", "anon");
        filterMap.put("/register.html", "anon");
        filterMap.put("/404.html", "anon");
        filterMap.put("/500.html", "anon");
        filterMap.put("/user/checkLogin", "anon");
        filterMap.put("/user/sendyzm2", "anon");
        filterMap.put("/user/sendyzm3", "anon");
        filterMap.put("/user/forgetpassword", "anon");
        filterMap.put("/user/checkRegister", "anon");
        filterMap.put("/section/**", "anon");
        filterMap.put("/sockjs/**", "anon");
        filterMap.put("/show/**", "anon");
        filterMap.put("/msgCountSocket", "anon");
        filterMap.put("/forgetPass", "anon");
        filterMap.put("/captcha.jpg", "anon");
        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);


        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
