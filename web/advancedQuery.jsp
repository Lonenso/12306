<%--
  Created by IntelliJ IDEA.
  User: 5498374
  Date: 2018/1/9
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高级查询</title>
</head>
<body>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户查询页面</title>

    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../static/images" >
</div>
<div class="login_banner">
    <div class="t-list" id="t-list" style="display: block;"  text-align:center>
        <table>
            <thead>
            <tr class="th" id="float">
                <th width="90" colspan="1" rowspan="1">车次</th>
                <th width="100" colspan="1" rowspan="1">"出发站"<br clear="none">"到达站" </th>
                <th width="82" colspan="1" rowspan="1" id="startendtime">
                    <span class="b1" id="s_time" style="cursor: pointer;">出发时间</span>
                    <br>
                    <span class="b2" id="r_time" style="cursor: pointer;">到达时间</span>
                </th>
                <th width="82" colspan="1" rowspan="1"><span class="b3" id="l_s">历时</span>
                </th>

                <th width="49" colspan="1" rowspan="1">二等座</th>
                <th width="49" colspan="1" rowspan="1">一等座</th>
                <th width="49" colspan="1" rowspan="1">特等座</th>
                <th width="49" colspan="1" rowspan="1">软卧</th>
                <th width="49" colspan="1" rowspan="1">硬卧</th>

                <th class="last" colspan="1" rowspan="1">备注</th>
            </tr>
            </thead>
            <tbody id="queryLeftTable">
            <s:iterator value = "advancedRec">
                <tr id="ticket_k123" class="bgc">
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="srcRec.train_id"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="srcRec.src"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="dst"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="startT"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="endT"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="time"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="secondClass"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="firstClass"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="stateCabins"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="soft"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="hard"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="cost"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="delta"></s:property></td>
                    <td align="center" width="80" class="no-br">
                        <a href="javascript:" class="btn_yd" onclick="">预定</a>
                    </td>
                </tr><tr id="ticket_k124" class="bgd">
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="train_id"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="src"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="dst"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="startT"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="endT"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="time"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="secondClass"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="firstClass"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="stateCabins"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="soft"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="hard"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="cost"></s:property></td>
                    <td width="46" align="center" style="cursor:pointer;"><s:property value="delta"></s:property></td>
                    <td align="center" width="80" class="no-br">
                        <a href="javascript:" class="btn_yd" onclick="">预定</a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
</body>
</html>
<%--TODO:！！！接收advanceRec--%>
<%--TODO:！！排版--%>
<%--TODO:美化--%>
<%--TODO:拼写错误--%>