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
        function validate_first_class(field) {
            var ydz=document.form1.first_class.value;
            if(ydz==""){
                document.getElementById("first_class").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("first_class").innerHTML="";
                return true;
            }
        }
        function validate_second_class(field) {
            var edz=document.form1.second_class.value;
            if(edz==""){
                document.getElementById("second_class").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("second_class").innerHTML="";
                return true;
            }
        }
        function validate_state_cabins(field) {
            var tdz=document.form1.state_cabins.value;
            if(tdz==""){
                document.getElementById("state_cabins").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("state_cabins").innerHTML="";
                return true;
            }
        }
        function validate_hard(field) {
            var hd=document.form1.hard.value;
            if(hd==""){
                document.getElementById("hard").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("hard").innerHTML="";
                return true;
            }
        }
        function validate_soft(field) {
            var st=document.form1.soft.value;
            if(st==""){
                document.getElementById("soft").innerHTML="不能为空";
                return false;
            }
            else{
                document.getElementById("soft").innerHTML="";
                return true;
            }
        }
        function validateForm(train_id,first_class,second_class,state_cabins,hard,soft,_date) {
            if(validate_train_id(train_id)&&validate_first_class(first_class)&&validate_second_class(second_class)&&validate_state_cabins(state_cabins)
                &&validate_hard(hard)&&validate_hard(soft)&&validate_hard(_date)){
                return true;
            }
            else {
                alert("新建失败！");
                return false;
            }

        }
    </script>


    <style type="text/css">
        .login_form{
            height:600px;
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
                    <h1>新建车次</h1>
                    <span id="errorSpan" class="errorMsg">${ msg }</span>
                </div>
                <div class="form">
                    <form action="newtrainm.action" method="post"
                          name="form1" onsubmit="return validateForm(train_id,first_class,second_class,state_cabins,hard.soft)"
                          onblur="validate_train_id(train_id)">
                        <label>车次：</label>
                        <input class="itxt" type="text" placeholder="请输入车次" autocomplete="off"
                               tabindex="1" name="train_id" onblur="validate_train_id(train_id)"
                               value="${ param.username }"
                        /><span class ="error" id="train_id"></span>
                        <br />
                        <br />
                        <label>一等座：</label>
                        <input class="itxt" type="text" placeholder="请输入一等座数量" autocomplete="off"
                               tabindex="1" name="first_class" id="first_class" onblur="validate_first_class(first_class)"/><span class ="error" id="first_class"></span>
                        <br />
                        <br />
                        <label>二等座：</label>
                        <input class="itxt" type="text" placeholder="请输入二等座数量" autocomplete="off"
                               tabindex="1" name="second_class" onblur="validate_second_class(second_class)"/><span class ="error" id="second_class"></span>
                        <br />
                        <br />
                        <label>商务座：</label>
                        <input class="itxt" type="text" placeholder="请输入商务座数量" autocomplete="off"
                               tabindex="1" name="state_cabins" onblur="validate_state_cabins(state_cabins)"/><span class ="error" id="state_cabins"></span>
                        <br />
                        <br />
                        <label>硬卧：</label>
                        <input class="itxt" type="text" placeholder="请输入硬卧数量" autocomplete="off"
                               tabindex="1" name="hard" onblur="validate_hard(hard)"/><span class ="error" id="hard"></span>
                        <br />
                        <br />
                        <label>软卧：</label>
                        <input class="itxt" type="text" placeholder="请输入软卧数量" autocomplete="off"
                               tabindex="1" name="soft" onblur="validate_soft(soft)"/><span class ="error" id=soft"></span>
                        <br />
                        <br />
                        <label>何时到达：</label>
                        <input class="itxt" type="text" placeholder="请输入何时到达" autocomplete="off"
                               tabindex="1" name="_date" id="_date" />
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
