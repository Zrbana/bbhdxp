package com.ll.dao;

import com.ll.domain.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecordDao {

    @Select("select * from borrowing_info where rid = #{rid}")
    @Results(value = {
            @Result(id = true, property = "rid", column = "rid"),
            @Result(id = true, property = "bid", column = "bid"),
            @Result(property = "borrowingDate", column = "borrowing_date"),
            @Result(property = "returnDate", column = "return_date"),
            @Result(property = "book", column = "bid", one = @One(select = "com.ll.dao.BookDao.findBookById"))
    })
    public List<Record> findRecordsByRid(Integer rid);

    @Insert("insert into borrowing_info values(#{bid}, #{rid}, #{borrowingDate}, #{returnDate})")
    public void insertRecord(Record record);

    @Delete("delete from borrowing_info where bid = #{bid}")
    public void delRecord(Integer bid);
}
