package com.ll.controller;


import com.ll.domain.Book;
import com.ll.domain.PageBean;
import com.ll.domain.Record;
import com.ll.domain.User;
import com.ll.service.BookService;
import com.ll.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Book表现层
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bs;
    @Autowired
    private RecordService rs;

    /**
     * 添加图书
     * @param book
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(@ModelAttribute("book")Book book) {
        bs.insertBook(book);
        return "success";
    }

    /**
     * 归还图书
     * @param bid
     * @return
     */
    @RequestMapping("/returnBook")
    public String returnBook(String bid) {
        int _bid = Integer.parseInt(bid);
        Book book = bs.findBookById(_bid);
        book.setCounts(book.getCounts() + 1);
        bs.updateBook(book);
        rs.delRecord(Integer.parseInt(bid));
        return "success";
    }

    /**
     * 通过bid查询书的全部信息
     * @param bid
     * @param request
     * @return
     */
    @RequestMapping("/findBook")
    public String findBookById(@RequestParam("bid") String bid, HttpServletRequest request) {
        Book book = bs.findBookById(Integer.parseInt(bid));
        request.setAttribute("book", book);
        return "update";
    }

    /**
     * 根据bid删除图书
     * @param bid
     * @return
     */
    @RequestMapping("/delBook")
    public String delBook(@RequestParam("bid") String bid) {
        bs.delBook(Integer.parseInt(bid));
        return "success";
    }

    /**
     * 更新图书信息
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(@ModelAttribute("book")Book book) {
        bs.updateBook(book);
        return "success";
    }

    /**
     * 借书
     * @param bid
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/borrowBook")
    public void borrowBook(@RequestParam("bid") String bid,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = bs.findBookById(Integer.parseInt(bid));
        Integer counts = book.getCounts();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String errorMsg = "借阅失败,库存不足";
        if (counts <= 0) {
            session.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher( "/fail.jsp").forward(request, response);
        }else {
            List<Record> records = user.getRecords();
            boolean isBorrowed = false;
            for (Record record : records) {
                if (bid.equals(record.getBid() + "")) {
                    //要借的书已经在借阅列表中存在
                    isBorrowed = true;
                    break;
                }
            }
            if (!isBorrowed) {
                counts--;
                book.setCounts(counts);
                bs.updateBook(book);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String borrowingDate = format.format(date);
                Calendar rightNow = Calendar.getInstance();
                //设置最晚还书时间
                rightNow.add(Calendar.DATE,30);
                String returnDate = format.format(rightNow.getTime());
                Record record = new Record();
                record.setBid(book.getBid());
                record.setRid(user.getRid());
                record.setBorrowingDate(borrowingDate);
                record.setReturnDate(returnDate);
                rs.insertRecord(record);
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }else {
                errorMsg = "您已借过此书";
                session.setAttribute("errorMsg", errorMsg);
                request.getRequestDispatcher( "/fail.jsp").forward(request, response);
            }

        }
    }

    /**
     * 删除管理员所选中的所有图书
     * @param request
     * @return
     */
    @RequestMapping("/delSelectedBook")
    public String delSelectedBook(HttpServletRequest request) {
        String[] bids = request.getParameterValues("bid");
        bs.delSelectedBook(bids);
        return "success";
    }

    /**
     * 将查询结果分页显示
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/findBookByPage")
    public String findBookByPage(HttpServletRequest request) throws Exception {
        Map<String, String[]> condition = request.getParameterMap();
        String currentPage = condition.getOrDefault("currentPage", new String[]{""})[0];
        String rows = condition.getOrDefault("rows", new String[]{""})[0];
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        Map<String, String> map = new HashMap<>();
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            if("currentPage".equals(key) || "rows".equals(key)) {
                //不是查询条件
                continue;
            }
            String value = condition.get(key)[0];
            if (!"".equals(value)) {
                //为了模糊查询在值前后加%
                map.put(key ,"%" + value + "%");
            }
        }
        PageBean<Book> pb = bs.findBookByPage(currentPage, rows, map);
        request.setAttribute("pb", pb);
        request.setAttribute("condition", condition);
        User user = (User)request.getSession().getAttribute("user");
        if ("admin".equals(user.getRights())) {
            return "list";
        }else {
            return "readerlist";
        }

    }

}
