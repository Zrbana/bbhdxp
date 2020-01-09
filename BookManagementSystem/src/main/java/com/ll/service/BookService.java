package com.ll.service;

import com.ll.domain.Book;
import com.ll.domain.PageBean;

import java.util.List;
import java.util.Map;

public interface BookService {


    public List<Book> findAll();

    public void updateBook(Book book);

    public void delBook(Integer bid);

    public void insertBook(Book book);

    public PageBean<Book> findBookByPage(String _currentPage, String _rows, Map<String, String> condition);

    public Book findBookById(Integer bid);

    public void delSelectedBook(String[] bids);
}
