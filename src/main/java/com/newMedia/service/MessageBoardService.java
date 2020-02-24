package com.newMedia.service;

import com.newMedia.entity.MessageBoard;

import java.util.Date;
import java.util.List;


public interface MessageBoardService {
    //    创建message并返回最新messages
    List<MessageBoard> createMessage(String passengerId, int productId, String message, Date nowTime, String formId, String respondentId);

}
