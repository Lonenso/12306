<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2018/1/7
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新建用户</title>

    <script type="text/javascript">
        function validate_username(field) {
            var re=/^[a-zA-z]\w{5,9}$/;
            if(!(re.test(field.value))){
                document.getElementById("username").innerHTML="用户名错误";
                return false;

            }
            else {
                document.getElementById("username").innerHTML="";
                return true;
            }
        }
        function validate_password(field) {
            var re=/^[A-Za-z]+[0-9]+[A-Za-z0-9]*|[0-9]+[A-Za-z]+[A-Za-z0-9]*$/g;
            if(!(re.test(field.value))){
                document.getElementById("password").innerHTML="密码必须由6-16个英文字母和数字的字符串组成！";
                return false;
            }
            else {
                document.getElementById("password").innerHTML="";
                return true;
            }

        }
        function validateForm(username,password) {
            if(validate_username(username)&&validate_password(password)){
                return true;
            }
            else {
                alert("新建失败！");
                return false;
            }

        }
    </script>

    <%--<style type="text/css">--%>
        <%--.login_form{--%>
            <%--height:420px;--%>
            <%--margin-top: 25px;--%>
        <%--}--%>

    <%--</style>--%>
    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.jpg" >
</div>

<div class="login_banner1">

    <div id="l_content"  class="abc">
        <span class="login_word" >新建用户</span>
    </div>

    <div id="r_content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>新建用户</h1>
                    <span id="errorSpan" class="errorMsg">${ msg }</span>
                </div>
                <div class="form">
                    <form action="newuserm.action" method="post" name="form1" onsubmit="return validateForm(username,password)">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                               tabindex="1" name="username" onblur="validate_username(username)"
                               value="${ param.username }"
                        /><span class ="error" id="username"></span>
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                               tabindex="1" name="password" onblur="validate_password(password)" /><span class="error" id="password"></span>
                        <br />
                        <br />
                        <label>用户身份：</label>
                        <input type="radio" name="radio" value="1" checked>普通用户
                        <input type="radio" name="radio" value="2">管理员用户
                        <br />
                        <br />


                        <input type="submit" value="新建" id="sub_btn" />
                        <br/>
                        <br/>
                        <input type="button" class="button2" value="返回上一页" onclick="window.location.href='../Manager/UserManage.jsp'">

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
