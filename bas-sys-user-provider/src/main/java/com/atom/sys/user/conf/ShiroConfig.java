package com.atom.sys.user.conf;

import cn.hutool.json.JSONObject;
import com.atom.sys.user.credentials.RetryLimitHashedCredentialsMatcher;
import com.atom.sys.user.realm.UserRealm;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /***
     * 凭证管理器
     * @return
     */
    @Bean
    public RetryLimitHashedCredentialsMatcher credentialsMatcher(){
        RetryLimitHashedCredentialsMatcher matcher = new RetryLimitHashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(2);
        matcher.setStoredCredentialsHexEncoded(Boolean.TRUE);
        return matcher;
    }

    /***
     * 自定义Realm
     * @param matcher
     * @return
     */
    @Bean
    public UserRealm userRealm(RetryLimitHashedCredentialsMatcher matcher){
        return new UserRealm(matcher);
    }

    @Bean
    public SecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);




        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/logout", "logout");

        filterChainDefinitionMap.put("/**", "authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");

        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        Map<String,Filter> filters = shiroFilterFactoryBean.getFilters();

        JSONObject json = new JSONObject(filters);

        System.out.println(" ------------------------> " + json.toString());

        return shiroFilterFactoryBean;
    }











}
