package com.wuxiaotian.login.controller;

import com.wuxiaotian.login.jwtconfig.JwtTokenUtils;
import com.wuxiaotian.login.jwtconfig.TokenValue;
import com.wuxiaotian.login.service.ISysUserService;
import com.wuxiaotian.user.model.UserModel;
import com.wuxiaotian.util.JsonResult;
import com.wuxiaotian.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/3/29 9:17
 * @Modified By：
 */
@RestController
@RequestMapping("/api/login/")
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @RequestMapping(value = "verify",method = RequestMethod.POST)
    public JsonResult login(@RequestBody UserModel userModel){
        JsonResult jsonResult = new JsonResult(ResponseCode.SUCCESS);
        String jwtToken = sysUserService.JwtToken(userModel);
        TokenValue tokenValue = TokenValue.builder()
                .header(jwtTokenUtils.getTokenHeader())
                .value(jwtToken)
                .prefix(jwtTokenUtils.getTokenHead())
                .expiration(jwtTokenUtils.getExpiration())
                .build();
        jsonResult.setData(tokenValue);
        return jsonResult;
    }
}
