
<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2018/1/8
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
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
<div class="login_banner1">
    <div class="t-list" id="t-list" style="display: block;"  text-algin:center>
        <table  CELLSPACING="15" text-algin:center>
            <thead>
            <tr class="th" id="float">
                <th width="90" colspan="1" rowspan="1">车次</th>
                <th width="90" colspan="1" rowspan="1">出发站</th>
                <th width="90" colspan="1" rowspan="1">到达站</th>
                <th width="90" colspan="1" rowspan="1">出发时间</th>
                <th width="90" colspan="1" rowspan="1">到达时间</th>
                <th width="82" colspan="1" rowspan="1">历时</th>
                <th width="49" colspan="1" rowspan="1">二等座</th>
                <th width="49" colspan="1" rowspan="1">一等座</th>
                <th width="49" colspan="1" rowspan="1">特等座</th>
                <th width="49" colspan="1" rowspan="1">软卧</th>
                <th width="49" colspan="1" rowspan="1">硬卧</th>
                <th width="49" colspan="1" rowspan="1">价格</th>
                <th class="last" colspan="1" rowspan="1">到达时间</th>
                <th class="last" colspan="1" rowspan="1">备注</th>
            </tr>
            </thead>
            <tbody id="queryLeftTable">
            <s:iterator value="record">
                <tr id="ticket_k123" class="bgc">
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
