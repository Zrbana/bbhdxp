<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改图书</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改图书</h3>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bid" value="${book.bid}">
        <div class="form-group">
            <label>图书名称：</label>
            <input type="text" class="form-control" id="bookName" name="bookName" value="${book.bookName}">
        </div>

        <div class="form-group">
            <label>图书编号：</label>
            <input type="text" class="form-control" id="bookCode" name="bookCode" value="${book.bookCode}">
        </div>

        <div class="form-group">
            <label>图书数量：</label>
            <input type="text" class="form-control" id="counts" name="counts" value="${book.counts}">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" onclick="history.go(-1)" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>

