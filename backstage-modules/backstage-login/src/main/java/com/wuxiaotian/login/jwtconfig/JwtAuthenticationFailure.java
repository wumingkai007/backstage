package com.wuxiaotian.login.jwtconfig;

import com.alibaba.fastjson.JSONObject;
import com.wuxiaotian.util.JsonResult;
import com.wuxiaotian.util.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/4/6 22:03
 * @Modified By：
 */
@Slf4j
@Component
public class JwtAuthenticationFailure implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        /**身份认证未通过*/
        JsonResult jr = new JsonResult(ResponseCode.ERROR);
        jr.setMsg(authException.getMessage());
        response.getWriter().write(JSONObject.toJSONString(jr));
    }
}
