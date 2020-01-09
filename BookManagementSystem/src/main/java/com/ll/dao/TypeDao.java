package com.ll.dao;

import com.ll.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TypeDao {

    @Select("select book_code from book_classification where bid = #{bid}")
    public String findCodeByBid(int bid);

    @Insert("insert into book_classification (bid,cid,book_code) values(#{book1.bid}, #{cid}, #{book1.bookCode})")
    public void insertType(@Param("book1") Book book, @Param("cid") String cid);

    @Update("delete from book_classification where bid = #{bid}")
    public void delType(Integer bid);

    @Update("update book_classification set book_code = #{bookCode} where bid = #{bid}")
    public void updateType(Book book);
}
