<%--
  Created by IntelliJ IDEA.
  User: 16376
  Date: 2020/1/11
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>
</head>
<body>
<img id="identcode" src="identcode">
<a id="refesh" href="">看不清，换一张</a>
<script>
    window.onload = function () {
        //点击图片时
        var img = document.getElementById("identcode");
        img.onclick = function (){
            refesh();
        }
        //点击连接时
        var a = document.getElementById("refesh");
        a.onclick = function (){
            refesh();
            //返回false防止a标签默认href行为
            return false;
        }
        function refesh() {
            /**
             * 由于路径相同时浏览器会自动调用缓存中的图片
             * 所以在连接后加时间戳解决此问题
             */
            var date = new Date().getTime();
            img.src = "identcode?" + date;
        }
    }
</script>
</body>
</html>
