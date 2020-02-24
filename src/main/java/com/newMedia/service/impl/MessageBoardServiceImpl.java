package com.newMedia.service.impl;

import com.newMedia.Utils.FormatUtil;
import com.newMedia.Utils.SendWXMessage;
import com.newMedia.dao.MessageBoardDao;
import com.newMedia.dao.ProductDao;
import com.newMedia.dao.WAppFormDao;
import com.newMedia.dao.WUserDao;
import com.newMedia.entity.MessageBoard;
import com.newMedia.entity.Product;
import com.newMedia.entity.WAppForm;
import com.newMedia.entity.WUser;
import com.newMedia.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    private static final String CommentTempID = "BluYkRE398soH-kcpXJDsMUpya8cx9sQD4Dw6Jk4o-Y";
    @Autowired
    private MessageBoardDao messageBoardDao;
    @Autowired
    private WAppFormDao wAppFormDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private WUserDao wUserDao;

    public List<MessageBoard> createMessage(String passengerId, int productId, String message, Date nowTime, String formId, String respondentId) {
        messageBoardDao.addMessage(passengerId, productId, message);
        WAppForm wAppForm = new WAppForm(passengerId, formId);
        int changeCounts = wAppFormDao.CreateNewForm(wAppForm);
        if (changeCounts == 0) {
            return null;
        }

        List<MessageBoard> messageBoards = messageBoardDao.getMessagesByProductIdandTime(productId, nowTime);
        Product product = productDao.getProductByPId(productId);
        String sellerOpenid = product.getSellerOpenid();
        WUser user = wUserDao.getUserInfo(passengerId);

        if (respondentId.equals("") && !passengerId.equals(sellerOpenid)) {
            respondentId = sellerOpenid;
        }

        if (!respondentId.equals("") && !respondentId.equals(passengerId)) {
            String fId = wAppFormDao.GetFormIdByOpenId(respondentId);
            SendWXMessage.sendWMessage(CommentTempID,
                    productId,
                    respondentId,
                    fId,
                    product.getProductTittle(),
                    FormatUtil.formatTime(new Date()),
                    message,
                    user.getNickName()
            );
            wAppFormDao.UpdateFormState(fId);
        }

        return messageBoards;
    }
}
