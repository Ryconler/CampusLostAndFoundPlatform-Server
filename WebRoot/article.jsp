<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>所有失物</title>
</head>


<body>
<s:form>
<table border="1">
<tr>
<td>失物id</td>
<td>发布人id</td>
<td>状态(0:未找回,1:已找回)</td>
<td>类型(0:失物招领,1:寻物启事）</td>
<td>标题</td>
<td>失物类型</td>
<td>学校</td>
<td>地址</td>
<td>联系人姓名</td>
<td>联系人电话</td>
<td>联系人QQ</td>
<td>日期</td>
<td>具体细节</td>
<td>酬金</td>
</tr>
<s:iterator value="list">
<tr> 
<td><s:property value="aid"/></td>
<td><s:property value="user.uid"/></td>
<td><s:property value="state"/></td>
<td><s:property value="type"/></td>
<td><s:property value="title"/></td>
<td><s:property value="articleType"/></td>
<td><s:property value="school"/></td>
<td><s:property value="address"/></td>
<td><s:property value="contactName"/></td>
<td><s:property value="contactTel"/></td>
<td><s:property value="contactQq"/></td>
<td><s:property value="date"/></td>
<td><s:property value="detail"/></td>
<td><s:property value="money"/></td>
</tr>
</s:iterator>
</table>

</s:form>
</body>
</html>