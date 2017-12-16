package com.waterlufei.TestHikaricp.service;

import com.waterlufei.TestHikaricp.mapper.UserMapper;
import com.waterlufei.TestHikaricp.vo.UserInfoRequest;
import com.waterlufei.TestHikaricp.vo.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by xiabin on 2017/9/21.
 * User的服务层
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserInfoResponse getUserInfo(@RequestBody UserInfoRequest request){
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse = userMapper.getUserInfo(request);
        return userInfoResponse;
    }

    public UserInfoResponse getWaterUserInfo(@RequestBody UserInfoRequest request){
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse = userMapper.getWaterUserInfo(request);
        return userInfoResponse;
    }

    public int insertUser(@RequestBody UserInfoRequest request){
        int result;
        result = userMapper.insertUser(request);
        return result;
    }

    public int insertWaterUser(@RequestBody UserInfoRequest request){
        int result;
        result = userMapper.insertWaterUser(request);
        return result;
    }

}
