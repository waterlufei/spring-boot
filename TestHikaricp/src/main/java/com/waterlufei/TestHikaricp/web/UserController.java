package com.waterlufei.TestHikaricp.web;

import com.waterlufei.TestHikaricp.service.UserService;
import com.waterlufei.TestHikaricp.vo.UserInfoRequest;
import com.waterlufei.TestHikaricp.vo.UserInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiabin on 2017/6/17.
 */
@Api(description = "用户信息", tags = "UserApi",
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "test")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "selectWater",notes = "查找water表的用户名和密码")
    @RequestMapping(value = "/selectWater", method = {RequestMethod.POST,RequestMethod.PUT})
    public UserInfoResponse selectWater(@RequestBody UserInfoRequest request){
          UserInfoResponse userInfoResponse = new UserInfoResponse();
          userInfoResponse = userService.getUserInfo(request);
          return userInfoResponse;
    }

    @ApiOperation(value = "selectWaterlufei",notes = "查找waterlufei表的用户名和密码")
    @RequestMapping(value = "/selectWaterlufei", method = RequestMethod.POST)
    public UserInfoResponse selectWaterlufei(@RequestBody UserInfoRequest request){
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse = userService.getWaterUserInfo(request);
        return userInfoResponse;
    }

    @ApiOperation(value = "insertUser",notes = "插入water表用户名和密码")
    @RequestMapping(value = "/insertUser", method = {RequestMethod.POST,RequestMethod.PUT})
    public int insertUser(@RequestBody UserInfoRequest request){
        int result;
        result = userService.insertUser(request);
        return result;
    }

    @ApiOperation(value = "insertWaterUser",notes = "插入waterlufei表用户名和密码")
    @RequestMapping(value = "/insertWaterUser", method = RequestMethod.POST)
    public int insertWaterUser(@RequestBody UserInfoRequest request){
        int result;
        result = userService.insertWaterUser(request);
        return result;
    }

    @ApiOperation(value = "hello",notes = "主动抛一个异常")
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

}
