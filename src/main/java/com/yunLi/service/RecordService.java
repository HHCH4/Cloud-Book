package com.yunLi.service;

import com.yunLi.domain.Record;
import com.yunLi.domain.User;
import com.yunLi.entity.PageResult;

/**
 * 借阅记录接口
 */
public interface RecordService {
    //新增借阅记录
    Integer addRecord(Record record);
//查询借阅记录
PageResult searchRecords(Record record, User user, Integer pageNum, Integer pageSize);
}
