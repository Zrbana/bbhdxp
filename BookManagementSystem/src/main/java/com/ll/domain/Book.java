package com.ll.domain;

import java.io.Serializable;

/**
 * 书籍信息
 */
public class Book implements Serializable {

    private Integer bid;
    private String bookName;
    private Integer counts;
    private String bookCode;

    public Integer getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bookName='" + bookName + '\'' +
                ", counts=" + counts +
                ", bookCode='" + bookCode + '\'' +
                '}';
    }
}
