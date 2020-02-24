package com.newMedia.dao;

import org.apache.ibatis.annotations.Param;

public interface SessionDao {
    //    1.创建session
    int createJSession(@Param("jsessionid") String jsessionid, @Param("sessionId") String sessionId, @Param("openId") String openId);

    //    2.查询session
    int isJsSession(String jsessionid);
}
