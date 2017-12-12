<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加管理员</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
	rel=stylesheet>
<script type="text/javascript"
	src="<%=basePath%>resource/js/CheckForm.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
<script language="JavaScript" type="text/javascript"
	src="<%=basePath%>resource/js/FormValid.js"></script>


</head>

<body>
	<form action="<%=basePath%>employee/adminAdd.do" name="form1"
		onsubmit="return validator(this)" method="post">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入管理员信息（未存在该员工，此操作为新增一名位置为管理员的员工）</td>
			</tr>
			<tr>

				<td bgcolor="#FFFDF0"><div align="center">用户名（邮箱号）：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" valid="required"
					errmsg="账号不能为空!" name="username"></td>
				<td bgcolor="#FFFDF0"><div align="center">用户密码：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="password"
					maxlength="50" style="width: 145px" name="pass"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">昵称：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" name="nickname"></td>
				<td bgcolor="#FFFDF0"><div align="center">真实姓名：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" name="realname"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">职位：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px"
					readonly="readonly" value="管理员"></td>
				<td bgcolor="#FFFDF0"><div align="center">部门：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px"
					readonly="readonly" value="技术部"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">手机号：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					valid="regexp" regexp="^1[3|4|5|8][0-9]\d{8}$" errmsg="请输入正确的手机号码!"
					style="width: 145px" name="phoneNo"></td>
				<td bgcolor="#FFFDF0"><div align="center">办公电话：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					valid="regexp" regexp="^1[3|4|5|8][0-9]\d{8}$" errmsg="请输入正确的电话号码!"
					style="width: 145px" name="officeTel"></td>
			</tr>

		</table>

		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr bgcolor="#ECF3FD">
				<td width="25%"></td>
				<td width="17%"><input type="submit" name="submit" value="添加"></td>
				<td width="17%"><input type="reset" name="reset" value="重置"></td>
				<td width="4%"><input type="button" name="button"
					onClick="history.back() " value="返回"></td>
				<td width="43%"></td>
			</tr>
		</table>
	</form>
	<form action="<%=basePath%>employee/updateToAdmin.do" name="form1"
		onsubmit="return validator(this)" method="post">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入员工的编号（已存在该员工，此操作为更改员工的部门以及职位信息）</td>
			</tr>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入员工编号进行查询：<input type="text"
					maxlength="10" style="width: 145px" valid="required"
					errmsg="员工编号不能为空!" name="id">&nbsp;&nbsp;<input
					type="button" name="submit" value="查询"></td>
			</tr>
			<tr>

				<td bgcolor="#FFFDF0"><div align="center">用户名（邮箱号）：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" readonly="readonly"
					valid="required" errmsg="!" name="adminName"></td>
				<td bgcolor="#FFFDF0"><div align="center">用户密码：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" name="customerMsn"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">昵称：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" name="customerAddress"
					readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">真实姓名：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" name="customerChangeMan"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">职位：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" valid="required"
					errmsg="创建人不能为空!" name="customerAddMan" readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">部门：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" name="customerBlog"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">手机号：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					valid="regexp" regexp="^1[3|4|5|8][0-9]\d{8}$" errmsg="请输入正确的手机号码!"
					style="width: 145px" name="customerMobile" readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">办公电话：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					valid="isQQ" errmsg="请输入正确的QQ号码!" style="width: 145px"
					name="customerQq" readonly="readonly"></td>
			</tr>

		</table>

		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr bgcolor="#ECF3FD">
				<td width="25%"></td>
				<td width="17%"><input type="submit" name="submit" value="确认添加"></td>
				<td width="4%"><input type="button" name="button"
					onClick="history.back() " value="返回"></td>
				<td width="43%"></td>
			</tr>
		</table>
	</form>
</body>
</html>

