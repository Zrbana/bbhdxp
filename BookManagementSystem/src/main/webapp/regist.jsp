<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>

    <script>
        $(function () {
            var flag = false;
            function checkUsernameExist() {
                var username = $(this).val();
                $.ajax({url:"user/findUser",
                        type:"POST",
                        data:{"username":username},
                        success:function (data) {
                            var $div = $("#errorMsg");
                            if(data.userExist) {
                                $div.css("color", "red");
                                $div.html(data.msg);
                                flag = false;
                            } else {
                                $div.css("color", "green");
                                $div.html(data.msg);
                                flag = true;
                            }
                        },
                        dataType:"json"
                    });
            }
            $("#username").blur(checkUsernameExist);
            $("#registerForm").submit(function () {
                return flag;
            });
        });
    </script>
</head>
<body>
<!--引入头部-->
<div id="header"></div>
<!-- 头部 end -->
<div class="rg_layout">
    <div class="rg_form clearfix">
        <div class="rg_form_left">
            <p>新用户注册</p>
            <p>USER REGISTER</p>
        </div>
        <div class="rg_form_center">

            <div id="errorMsg" style="color: red; text-align: center"></div>
            <!--注册表单-->
            <form id="registerForm" action="${pageContext.request.contextPath}/user/regist">
                <!--提交处理请求的标识符-->
                <input type="hidden" name="action" value="register">
                <table style="margin-top: 25px;">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="password" name="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="submit" class="submit" value="注册">
                            <span id="msg" style="color: red;"></span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="rg_form_right">
            <p>
                已有账号？
                <a href="${pageContext.request.contextPath}/login.jsp">立即登录</a>
            </p>
        </div>
    </div>
</div>


</body>
</html>
