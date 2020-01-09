package com.ll.service.impl;

import com.ll.dao.RecordDao;
import com.ll.domain.Record;
import com.ll.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recordService")
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public void insertRecord(Record record) {
        recordDao.insertRecord(record);
    }

    @Override
    public void delRecord(Integer bid) {
        recordDao.delRecord(bid);
    }
}
