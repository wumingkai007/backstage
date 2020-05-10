package com.wuxiaotian.user.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wuxiaotian.user.model.UserPageModel;
import com.wuxiaotian.user.service.UserService;
import com.wuxiaotian.util.JsonResult;
import com.wuxiaotian.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wumingkai
 * @since 2020-04-06
 */
@RestController
@RequestMapping("/sys/user/")
public class SysUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "selectListUser",method = RequestMethod.GET)
    public JsonResult selectListUser(){
        JsonResult  jsonResult = new JsonResult(ResponseCode.SUCCESS);
        List<UserPageModel> list = userService.selectListUser();
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public JsonResult saveUser(@RequestBody UserPageModel userPageModel){
        JsonResult  jsonResult = new JsonResult(ResponseCode.SUCCESS);
        userService.saveUser(userPageModel);
        return jsonResult;
    }

    @RequestMapping(value = "deleetListUser",method = RequestMethod.POST)
    public JsonResult deleetListUser(@RequestBody String userstr){
        JsonResult  jsonResult = new JsonResult(ResponseCode.SUCCESS);
        List<Integer> integerList = JSONArray.parseArray(userstr,Integer.class);
      //  userService.deleteUser(list);
        return jsonResult;
    }

}
