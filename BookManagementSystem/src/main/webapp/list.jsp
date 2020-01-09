<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图书管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteBook(bid) {
            if (confirm("您确定要删除吗")){
            location.href = "${pageContext.request.contextPath}/book/delBook?bid=" + bid;
            }
        }
        window.onload = function () {
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除吗")) {
                    var cbs = document.getElementsByName("bid");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked) {
                            document.getElementById("form").submit();
                        }
                    }

                }
            };
            document.getElementById("firstCb").onclick = function () {
                var cbs = document.getElementsByName("bid");
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }

            };
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">图书信息列表</h3>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加图书</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>

    </div>

    <div style="float: left;">
        <form action="${pageContext.request.contextPath}/book/findBookByPage" class="form-inline" method="post">
            <div class="form-group">
                <label for="exampleInputName2">图书名称</label>
                <input type="text" name="bookName" class="form-control" value="${condition.bookName[0]}" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">图书编号</label>
                <input type="text" name="bookCode" class="form-control" value="${condition.bookCode[0]}" id="exampleInputName3">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/book/delSelectedBook" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>图书名称</th>
            <th>图书编码</th>
            <th>剩余数量</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pb.list}" var="book" varStatus="s">
            <tr>
                <td><input type="checkbox" name="bid" value="${book.bid}"></td>
                <td>${s.count}</td>
                <td>${book.bookName}</td>
                <td>${book.bookCode}</td>
                <td>${book.counts}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/book/findBook?bid=${book.bid}">修改</a>
                    &nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteBook(${book.bid});">删除</a></td>

            </tr>

        </c:forEach>


    </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/book/findBookByPage?currentPage=${pb.currentPage - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${i == pb.currentPage}">
                        <li class="active" ><a href="${pageContext.request.contextPath}/book/findBookByPage?currentPage=${i}&rows=5&bookName=${condition.bookName[0]}&bookCode=${condition.bookCode[0]}" >${i}</a> </li>
                    </c:if>
                    <c:if test="${i != pb.currentPage}">
                        <li><a href="${pageContext.request.contextPath}/book/findBookByPage?currentPage=${i}&rows=5&bookName=${condition.bookName[0]}&bookCode=${condition.bookCode[0]}">${i}</a> </li>
                    </c:if>
                </c:forEach>
                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if><c:if test="${pb.currentPage != pb.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/book/findBookByPage?currentPage=${pb.currentPage + 1}&rows=5&bookName=${condition.bookName[0]}&bookCode=${condition.bookCode[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <span style="font-size: 25px; margin-left: 5px;" >
                    共${pb.totalCount}条记录,共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>


</div>


</body>
</html>
