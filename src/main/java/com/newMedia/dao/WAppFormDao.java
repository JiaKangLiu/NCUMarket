package com.newMedia.dao;

import com.newMedia.entity.WAppForm;
import org.apache.ibatis.annotations.Param;

public interface WAppFormDao {
    //  1.GetFormByOpenId
    String GetFormIdByOpenId(String openId);

    //  2.Create a new form
    int CreateNewForm(@Param("form") WAppForm form);

    //  3.UpdateFormState
    int UpdateFormState(String formId);
}
