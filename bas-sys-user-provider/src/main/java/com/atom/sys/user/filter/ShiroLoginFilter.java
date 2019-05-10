package com.atom.sys.user.filter;

import com.atom.sys.constant.Constant;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class ShiroLoginFilter  extends FormAuthenticationFilter {


    /***
     * 在请求进来之前判断当前请求是否登录
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        // 判断当前请求是否是登录请求
        if (this.isLoginRequest(request,response)){
            // 检测当前请求是否包含登录信息
            if (this.isLoginSubmission(request,response)){
                // 执行登录操作
                AuthenticationToken token = this.createToken(request,response);
                if(token == null){
                    throw new IllegalStateException("Please provide valid identity information");
                }else{
                    try{
                        Subject subject = this.getSubject(request,response);
                        subject.login(token);
                        return true;
                    }catch (AuthenticationException ex){
                        return false;
                    }
                }
            }else{
                return true;
            }
        }else{
            this.saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }


    /**
     * 判断当前请求是否是Ajax
     * @param request
     * @return
     */
    public boolean isAjax(ServletRequest request){
        String ajaxHeander = ((HttpServletRequest) request).getHeader(Constant.ajaxHeader);
        if(Constant.XMLHttpRequest.equals(ajaxHeander)){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }



}
