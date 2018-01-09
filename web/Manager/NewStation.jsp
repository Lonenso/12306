<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2018/1/7
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript">
        // 页面加载完成之后
        $(function(){


            // 获取用户名
            var idValue = this.value;
            //判断用户名不能为空
            if (idValue == "") {
                $("#errorSpan").html("站点不能为空！");
                return;
            }

            // 给注册按钮添加事件
            $("#sub_btn").click(function() {

                if(document.myform.id.value="")
                {
                    alert("输入不能为空");
                    document.myform.id.focus();
                    return false;
                }

                if(document.myform.train_id.value="")
                {
                    alert("输入不能为空");
                    document.myform.train_id.focus();
                    return false;
                }

                if(document.myform.station_name.value="")
                {
                    alert("输入不能为空");
                    document.myform.station_name.focus();
                    return false;
                }

                if(document.myform.timeofArrival.value="")
                {
                    alert("输入不能为空");
                    document.myform.timeofArrival.focus();
                    return false;
                }
                if(document.myform.timeofStart.value="")
                {
                    alert("输入不能为空");
                    document.myform.timeofStart.focus();
                    return false;
                }

                if(document.myform._date.value="")
                {
                    alert("输入不能为空");
                    document.myform._date.focus();
                    return false;
                }
                if(document.myform._cost.value="")
                {
                    alert("输入不能为空");
                    document.myform._cost.focus();
                    return false;
                }


                return true;
            });

        });

    </script>

    <style type="text/css">
        .login_form{
            height:420px;
            margin-top: 25px;
        }

    </style>
    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.jpg" >
</div>

<div class="login_banner1">

    <div id="l_content">
        <span class="login_word">新建用户</span>
    </div>

    <div id="content">
        <div class="login_form1">
            <div class="login_box">
                <div class="tit">
                    <h1>新建站点</h1>
                    <span id="errorSpan" class="errorMsg">${ msg }</span>
                </div>
                <div class="form">
                    <form action="newstationm.action" method="post" name="myform" id="myform">
                        <label>车次：</label>
                        <input class="itxt" type="text" placeholder="请输入一等座数量" autocomplete="off"
                               tabindex="1" name="train_id" id="train_id" />
                        <br />
                        <br />
                        <label>站点名称：</label>
                        <input class="itxt" type="text" placeholder="请输入二等座数量" autocomplete="off"
                               tabindex="1" name="station_name" id="station_name" />
                        <br />
                        <br />
                        <label>到达时间：</label>
                        <input class="itxt" type="text" placeholder="请输入商务座数量" autocomplete="off"
                               tabindex="1" name="timeofArrival" id="timeofArrival" />
                        <br />
                        <br />
                        <label>出发时间：</label>
                        <input class="itxt" type="text" placeholder="请输入硬卧数量" autocomplete="off"
                               tabindex="1" name="timeofStart" id="timeofStrat" />
                        <br />
                        <br />
                        <label>到达日期：</label>
                        <input class="itxt" type="text" placeholder="请输入软卧数量" autocomplete="off"
                               tabindex="1" name="_date" id="_date" />
                        <br />
                        <br />
                        <label>花费：</label>
                        <input class="itxt" type="text" placeholder="请输入何时到达" autocomplete="off"
                               tabindex="1" name="_cost" id="_cost" />
                        <br />
                        <br />

                        <input type="submit" value="新建" id="sub_btn" />

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
