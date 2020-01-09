package com.ll.service.impl;

import com.ll.dao.BookDao;
import com.ll.dao.TypeDao;
import com.ll.domain.Book;
import com.ll.domain.PageBean;
import com.ll.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private TypeDao typeDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
        typeDao.updateType(book);
    }

    @Override
    public void delBook(Integer bid) {
        typeDao.delType(bid);
        bookDao.delBook(bid);
    }

    @Override
    public void insertBook(Book book) {
        bookDao.insertBook(book);
        typeDao.insertType(book, book.getBookCode().charAt(0) + "");
    }

    @Override
    public Book findBookById(Integer bid) {
        return bookDao.findBookById(bid);
    }

    public PageBean<Book> findBookByPage(String _currentPage, String _rows, Map<String, String> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        PageBean<Book> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount = bookDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<Book> books = bookDao.findBookByPage(start, rows, condition);
        pb.setList(books);
        int totalPage = totalCount % rows  == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void delSelectedBook(String[] bids) {
        if(bids != null || bids.length > 0) {
            for (String bid : bids) {
                Integer _bid = Integer.parseInt(bid);
                typeDao.delType(_bid);
                bookDao.delBook(_bid);
            }
        }
    }
}
