<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2018/1/7
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员管理页面</title>

    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../static/images" >
</div>

<div class="login_banner1">

    <div id="l_content" class="abc">
        <span class="login_word">管理</span>
    </div>

    <div id="r_content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>管理选择</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${ empty msg ? "请选择你要操作的内容" : msg }</span>
                </div>
                <div class="form">
                    <form method="post">
                        <input type="button" class="button1" value="站点管理" onclick="window.location.href='../Manager/StationManage.jsp'" />
                        <br />
                        <br />
                        <input type="button" class="button2" value="车次管理" onclick="window.location.href='../Manager/TrainsManage.jsp'" />
                        <br />
                        <br />
                        <input type="button" class="button3" value="用户管理" onclick="window.location.href='../Manager/UserManage.jsp'" />
                        <br/>
                        <br/>
                        <input type="button" class="button2" value="返回上一页" onclick="window.location.href='../User/login.jsp'">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
