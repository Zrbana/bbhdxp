package com.ll.dao;

import com.ll.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BookDao {


    @Select("select * from book")
    @Results(id = "bookMap", value = {
            @Result(id = true, property = "bid", column = "bid"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "counts", column = "counts"),
            @Result(property = "bookCode", column = "bid", one = @One(select = "com.ll.dao.TypeDao.findCodeByBid"))
    })
    public List<Book> findAll();

    @Update("update book set book_name=#{bookName}, counts=#{counts} where bid = #{bid}")
    public void updateBook(Book book);

    @Update("delete from book where bid = #{bid}")
    public void delBook(Integer bid);

    @Insert("insert into book (book_name,counts) values (#{bookName}, #{counts})")
    @Options(useGeneratedKeys=true, keyProperty="bid", keyColumn="bid")
    public void insertBook(Book book);

    @Select("select * from book where bid = #{bid}")
    @ResultMap(value = "bookMap")
    public Book findBookById(Integer bid);

    public List<Book> findBookByPage(@Param("start") int start, @Param("rows") int rows,@Param("condition") Map<String, String> condition);

    public Integer findTotalCount(@Param("condition") Map<String, String> condition);
}
