package com.xiabin.TestDruid.mapper;

import com.xiabin.TestDruid.vo.UserInfoRequest;
import com.xiabin.TestDruid.vo.UserInfoResponse;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xiabin on 2017/6/17.
 */
@Mapper
public interface UserMapper {

    UserInfoResponse getUserInfo(UserInfoRequest request);
}
