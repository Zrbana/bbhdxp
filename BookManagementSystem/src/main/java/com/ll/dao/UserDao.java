package com.ll.dao;

import com.ll.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface UserDao {

    @Select("select * from reader where username = #{username} and password = #{password}")
    @Results(id = "userMap", value = {
            @Result(id = true, property = "rid", column = "rid"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "rights", column = "rights"),
            @Result(property = "records", column = "rid", many = @Many(select = "com.ll.dao.RecordDao.findRecordsByRid",fetchType = FetchType.LAZY))
    })
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Insert("insert into reader (username, password) values (#{username}, #{password})")
    public void insertUser(@Param("username") String username, @Param("password") String password);

    @Select("select * from reader where username = #{username}")
    public User findByUsername(String username);
}
