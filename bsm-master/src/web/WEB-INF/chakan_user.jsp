<%--
  Created by IntelliJ IDEA.
  User: 16376
  Date: 2020/1/12
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="DataClass.User,DAO.RecordDao,DataClass.Record,java.util.ArrayList,java.util.List" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看所有的用户信息</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>body{
        background-image: url(static/img/olia-gozha-J4kK8b9Fgj8-unsplash.jpg);
        background-size: cover;
        height:100%;
        width: 100%;
        background-repeat: no-repeat;
    }</style>
</head>
<body>
<%
    List<Record>rcd=new ArrayList<Record>();
    RecordDao dao=new RecordDao();
    rcd=dao.FindAll();
%>
<table class="table">
    <caption>用户信息记录</caption>
    <thead>
    <tr>
        <th>用户名</th>
        <th>书名</th>
        <th>ISBN</th>
        <th>借书时间</th>
        <th>还书时间</th>
    </tr>
    </thead>
    <tbody>
    <%for(Record r:rcd){ %>
    <tr class="active">
        <td><%=r.getUser_name() %></td>
        <td><%=r.getBook_name() %></td>
        <td><%=r.getBook_ISBN() %></td>

        <td><%=r.getBorrow_date() %></td>
        <td><%=r.getReturn_date() %></td>


    </tr>
    <% }%>
    </tbody>
</table>
</body>
</html>