package com.waterlufei.TestHikaricp.mapper;

import com.waterlufei.TestHikaricp.vo.UserInfoRequest;
import com.waterlufei.TestHikaricp.vo.UserInfoResponse;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xiabin on 2017/6/17.
 */
@Mapper
public interface UserMapper {

    UserInfoResponse getUserInfo(UserInfoRequest request);

    UserInfoResponse getWaterUserInfo(UserInfoRequest request);

    int insertUser(UserInfoRequest request);

    int insertWaterUser(UserInfoRequest request);
}
