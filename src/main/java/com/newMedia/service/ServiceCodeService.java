package com.newMedia.service;

public interface ServiceCodeService {
    //创建一个servicecode
    String createServiceCode(int userId);

    //查询servicecode状态
    Boolean isServiceCreateable(int userId, String commitCode);
//改states
}
