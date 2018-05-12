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
    <title>新建站点</title>

    <script type="text/javascript">

        function validate_train_id(field) {
            var cc=document.form1.train_id.value;
            if(cc==""){
                document.getElementById("train_id").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("train_id").innerHTML="";
                return true;
            }
        }
        function validate_station_name(field) {
            var zdmc=document.form1.station_name.value;
            if(zdmc==""){
                document.getElementById("station_name").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("station_name").innerHTML="";
                return true;
            }
        }
        function validate_timeofArrival(field) {
            var ddsj=document.form1.timeofArrival.value;
            if(ddsj==""){
                document.getElementById("timeofArrival").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("timeofArrival").innerHTML="";
                return true;
            }
        }
        function validate_timeofStart(field) {
            var cfsj=document.form1.timeofStart.value;
            if(cfsj==""){
                document.getElementById("timeofStart").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("timeofStart").innerHTML="";
                return true;
            }
        }
        function validate_date(field) {
            var date=document.form1._date.value;
            if(date==""){
                document.getElementById("_date").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("_date").innerHTML="";
                return true;
            }
        }
        function validate_cost(field) {
            var cost=document.form1._cost.value;
            if(cost==""){
                document.getElementById("_cost").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("_cost").innerHTML="";
                return true;
            }
        }
        function validateForm(train_id,station_name,timeofArrival,timeofStart,_date,_cost) {
            if(validate_train_id(train_id)&&validate_station_name(station_name)&&validate_timeofArrival(timeofArrival)&&validate_timeofStart(timeofStart)
                &&validate_date(_date)&&validate_cost(_cost)){
                return true;
            }
            else {
                alert("新建失败！");
                return false;
            }

        }
    </script>

    <%--&lt;%&ndash;<style type="text/css">&ndash;%&gt;--%>
        <%--&lt;%&ndash;.login_form{&ndash;%&gt;--%>
            <%--&lt;%&ndash;height:420px;&ndash;%&gt;--%>
            <%--&lt;%&ndash;margin-top: 25px;&ndash;%&gt;--%>
        <%--&lt;%&ndash;}&ndash;%&gt;--%>

    <%--</style>--%>
    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.jpg" >
</div>

<div class="login_banner1">

    <div id="l_content" class="abc">
        <span class="login_word">新建站点</span>
    </div>

    <div id="r_content">
        <div class="login_form1">
            <div class="login_box">
                <div class="tit">
                    <h1>新建站点</h1>
                    <span id="errorSpan" class="errorMsg">${ msg }</span>
                </div>
                <div class="form">
                    <form action="newstationm.action" method="post" name="form1" onsubmit="validateForm(train_id,
                    station_name,timeofArrival,timeofStart,_date,_cost)">
                        <label>车次：</label>
                        <input class="itxt" type="text" placeholder="请输入车次" autocomplete="off"
                               tabindex="1" name="train_id" onblur="validate_train_id(train_id)"
                        /><span class ="error" id="train_id"></span>
                        <br />
                        <br />
                        <label>站点名称：</label>
                        <input class="itxt" type="text" placeholder="请输入站点名称" autocomplete="off"
                               tabindex="1" name="station_name" onblur="validate_station_name(station_name)"
                        /><span class ="error" id="station_name"></span>
                        <br />
                        <br />
                        <label>到达时间：</label>
                        <input class="itxt" type="text" placeholder="请输入到达时间" autocomplete="off"
                               tabindex="1" name="timeofArrival" onblur="validate_timeofArrival(timeofArrival)"
                        /><span class ="error" id="timeofArrival"></span>
                        <br />
                        <br />
                        <label>出发时间：</label>
                        <input class="itxt" type="text" placeholder="请输入出发时间" autocomplete="off"
                               tabindex="1" name="timeofStart" onblur="validate_timeofStart()"
                        /><span class ="error" id="timeofStart"></span>
                        <br />
                        <br />
                        <label>到达日期：</label>
                        <input class="itxt" type="text" placeholder="请输入何时达到" autocomplete="off"
                               tabindex="1" name="_date"onblur="validate_date(_date)"
                        /><span class ="error" id="_date"></span>
                        <br />
                        <br />
                        <label>花费：</label>
                        <input class="itxt" type="text" placeholder="请输入花费" autocomplete="off"
                               tabindex="1" name="_cost" onblur="validate_cost(_cost)"
                        /><span class ="error" id="_cost"></span>
                        <br />
                        <br />

                        <input type="submit" value="新建" id="sub_btn" />
                        <br/>
                        <br/>
                        <input type="button" class="button2" value="返回上一页" onclick="window.location.href='../Manager/StationManage.jsp'">

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
