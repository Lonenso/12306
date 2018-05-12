<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="model.UserEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2018/1/7
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理页面</title>

    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >

    <script type="text/javascript">
        $(function(){
            $(".deleteBookClass").click(function(){
                return confirm("你确定要删除吗？");
            });
        });
    </script>
    <%
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        UserDAO dao=(UserDAO)ac.getBean("userDAO");
        List<UserEntity> usr=dao.findAll();
    %>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../static/images" >
</div>

<div class="login_banner1">

    <div id="l_content"  class="abc">
        <table  class="manage" CELLSPACING="30">
            <tr>
                <td style="color: black">用户名</td>
                <td style="color: black">密码</td>
                <td style="color: black">身份</td>

            </tr>
            <% for(UserEntity i :usr){  %>
                <tr>
                    <td style="color: black"><%=i.getUsername()%></td>
                    <td style="color: black"><%=i.getPassword()%></td>
                    <td style="color: black"><%=i.getPermission()%></td>
                    <td><a href="deleteuserm.action?key=<%=i.getUsername()%>">删除</a></td>
                </tr>
            <%} %>
        </table>
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
                        <br />
                        <br />
                        <input type="button" class="button1" value="新建用户" onclick="window.location.href='../Manager/NewUser.jsp'" />
                        <br/>
                        <br/>
                        <input type="button" class="button2" value="返回上一页" onclick="window.location.href='../Manager/manage.jsp'">
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
