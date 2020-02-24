package com.newMedia.dao;

import org.apache.ibatis.annotations.Param;

public interface NCUAdminDao {
    //    查看是否是管理员
    int isAdmin(int adminNum);

    //    查看密码是否正确
    int isPwdCorrect(@Param("adminNum") int adminNum, @Param("password") String password);
}
