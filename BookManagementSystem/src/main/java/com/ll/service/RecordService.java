package com.ll.service;

import com.ll.domain.Record;

public interface RecordService {

    public void insertRecord(Record record);

    public void delRecord(Integer bid);
}
