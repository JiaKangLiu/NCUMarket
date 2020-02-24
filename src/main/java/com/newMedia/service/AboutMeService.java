package com.newMedia.service;

import com.newMedia.dto.AboutMe;

public interface AboutMeService {
    //    1.获取用户信息
    AboutMe getMyInfo(String openId);
}
