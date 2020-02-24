package com.newMedia.dao;

import com.newMedia.entity.WUser;
import org.apache.ibatis.annotations.Param;

public interface WUserDao {
    //1.添加用户
    int addUser(@Param("openId") String openId, @Param("nickName") String nickName, @Param("avatarUrl") String avatarUrl, @Param("gender") int gender, @Param("city") String city);

    //2.修改用户状态
    int changeUserState(@Param("openId") String openId, @Param("state") int state);

    // 3.  查找用户是否存在
    int isWUser(String openId);

    // 4.  获取用户信息
    WUser getUserInfo(String openId);
}
