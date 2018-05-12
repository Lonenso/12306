<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2018/1/8
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>简单查询</title>

    <link type="text/css" rel="stylesheet" href="../../static/css/query_style.css" >
    <script type="text/javascript" src="../../static/script/Station.js">
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../static/images" >
</div>

<div class="login_banner1">

    <div id="l_content">
        <span class="login_word">用户查询</span>
    </div>

    <div id="content">
        <div class="login_form ">
            <div class="login_box">
                <div class="tit">
                    <h1>查询选择</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${ empty msg ? "请选择你要操作的内容" : msg }</span>
                </div>
                <div class="form">
                    <form action="" method="post" name="queryForm">
                        <%--<input type="hidden" name="action" value="login"/>--%>
                        <label>出发地：</label>
                        <select name = "province" id="province_from" ></select>
                        <select name = "src" id="city_from"></select>
                        <br/>
                        <br/>
                        <label>目的地：</label>
                        <select name = "province" id="province_to" ></select>
                        <select name = "dst" id="city_to"></select>
                        <br/>
                        <br/>
                        <label>出发日：</label>
                        <select name="year" id="year" onchange="isToday()"></select>
                        <select name="month" id="month" onchange="changeDate()"></select>
                        <select name="day" id="date" ></select>
                        <br/>
                        <br/>
                        <input type="button" value="简单查询" id="sub_btn" onclick="queryForm.action='normalfind.action';queryForm.submit();"/>
                        <br/>
                        <br/>
                        <input type="button" value="深度查询" id="sub_btn1" onclick="queryForm.action='advancedfind.action';queryForm.submit();"/>
                        <br/>
                        <br/>
                        <input type="button" value="返回登陆界面" id="sub_btn1" onclick="window.location.href='../User/login.jsp'"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
