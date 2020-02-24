package com.newMedia.dao;

import com.newMedia.entity.MessageBoard;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MessageBoardDao {
    //    获取message
    List<MessageBoard> getMessagesByProductId(int productId);

    //    添加message
    int addMessage(@Param("passengerId") String passengerId, @Param("productId") int productId, @Param("message") String message);

    //    通过时间获取message
    List<MessageBoard> getMessagesByProductIdandTime(@Param("productId") int productId, @Param("nowTime") Date nowTime);
}
