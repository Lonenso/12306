<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.TrainDAO" %>
<%@ page import="model.TrainEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2018/1/7
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>车次管理页面</title>

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
        TrainDAO dao=(TrainDAO)ac.getBean("trainDAO");
        List<TrainEntity> train=dao.findAll();
    %>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../static/images" >
</div>

<div class="login_banner1">

    <div id="l_content" class="abc">
        <table class="manage" CELLSPACING="20">
            <tr>
                <td style="color: black">车次</td>
                <td style="color: black">一等座</td>
                <td style="color: black">二等座</td>
                <td style="color: black">商务座</td>
                <td style="color: black">硬卧</td>
                <td style="color: black">软卧</td>
                <td style="color: black">何时到达</td>


            </tr>
            <%for(TrainEntity i:train){%>
                <tr>
                    <td style="color: black"><%=i.getTrainId()%></td>
                    <td style="color: black"><%=i.getFirstClass()%></td>
                    <td style="color: black"><%=i.getSecondClass()%></td>
                    <td style="color: black"><%=i.getStateCabins()%></td>
                    <td style="color: black"><%=i.getHard()%></td>
                    <td style="color: black"><%=i.getSoft()%></td>
                    <td style="color: black"><%=i.getDate()%></td>
                    <td><a href="deletetrainm.action?key=<%=i.getId()%>">删除</a></td>
                </tr>
            <%}%>
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
                <div class="form ">
                    <form action="userServlet" method="post">
                        <input type="button" class="button1" value="新建车次" onclick="window.location.href='../Manager/NewTrains.jsp'" />
                        <br />
                        <br />
                        <input type="button" class="button2" value="返回上一页" onclick="window.location.href='../Manager/manage.jsp'">
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
