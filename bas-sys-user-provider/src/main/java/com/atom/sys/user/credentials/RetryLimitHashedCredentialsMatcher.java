package com.atom.sys.user.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;


/***
 * 自定义实现凭证匹配器
 *
 * 可以新增如限制登录次数功能
 *
 *
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();

        boolean matches = super.doCredentialsMatch(token, info);

        return matches;
    }







}
