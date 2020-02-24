package com.newMedia.service;

import com.newMedia.dto.WLogin;
import com.newMedia.exception.userException.UserException;

public interface WRegistryService {
    /*
     *开始注册
     */
    WLogin registryNewUser(String code, String nickName, String avatarUrl, int gender, String city) throws UserException, Exception;

}
