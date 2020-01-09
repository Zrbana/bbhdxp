package com.ll.test;

import com.ll.domain.Book;
import com.ll.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testBookDao {


    @Test
    public void run1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        BookService bs = (BookService) ioc.getBean("bookService");
        //List<Book> all = bs.findAll();
        //System.out.println(all);

        Book book = new Book();
        book.setBid(10);
        book.setBookName("java并发编程的艺术");
        book.setCounts(3);
        book.setBookCode("A0003");

        bs.updateBook(book);

    }
}
