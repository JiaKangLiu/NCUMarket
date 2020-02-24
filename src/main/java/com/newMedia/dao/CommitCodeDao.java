package com.newMedia.dao;

import org.apache.ibatis.annotations.Param;

public interface CommitCodeDao {
    //    根据userid,time查询时候存在
    Boolean queryCodeByuserId(@Param("jsessionid") int jsessionid, @Param("commitCode") String commitCode);

    //生成
    boolean createCommitCode(@Param("jsessionid") String jsessionid, @Param("commitCode") String commitCode);

    //    改变code状态为不可提交
    int changeStates(@Param("jsessionid") String jsessionid, @Param("commitCode") String commitCode, @Param("commitState") Boolean commitState);
}
