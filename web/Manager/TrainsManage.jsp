<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.TrainDAO" %>
<%@ page import="po.TrainEntity" %>
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
    <title>Title</title>

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

<div class="login_banner">

    <div id="l_content">
        <table>
            <tr>
                <td>车次</td>
                <td>一等座</td>
                <td>二等座</td>
                <td>商务座</td>
                <td>硬卧</td>
                <td>软卧</td>
                <td>何时到达</td>


            </tr>
            <%for(TrainEntity i:train){%>
                <tr>
                    <td><%=i.getTrainId()%></td>
                    <td><%=i.getFirstClass()%></td>
                    <td><%=i.getSecondClass()%></td>
                    <td><%=i.getStateCabins()%></td>
                    <td><%=i.getHard()%></td>
                    <td><%=i.getSoft()%></td>
                    <td><%=i.getDate()%></td>
                    <td><a href="deletetrainm.action?key=<%=i.getId()%>">删除</a></td>
                </tr>
            <%}%>
        </table>
    </div>

    <div id="content">
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
                    <form action="userServlet" method="post">
                        <input type="button" class="button1" value="新建车次" onclick="window.location.href='../Manager/NewTrains.jsp'" />
                        <br />
                        <br />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
