package com.ll.test;

import com.ll.domain.Book;
import com.ll.domain.PageBean;
import com.ll.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class testBookService {

    @Test
    public void run1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        BookService bs = (BookService) ioc.getBean("bookService");
        String _currentPage = "1";
        String _rows = "5";
        Map<String, String> condition = new HashMap<>();
        condition.put("bookName","%java%");
        PageBean<Book> userByPage = bs.findBookByPage(_currentPage, _rows, condition);
        System.out.println(userByPage);
    }

}
