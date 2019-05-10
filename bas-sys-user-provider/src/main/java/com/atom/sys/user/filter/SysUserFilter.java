package com.atom.sys.user.filter;

import com.alibaba.druid.util.FnvHash;
import com.atom.sys.user.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private SysUserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(String.valueOf(FnvHash.Constants.CURRENT_USER), userService.selectByUserName(username));
        return super.onPreHandle(request, response, mappedValue);
    }



}
