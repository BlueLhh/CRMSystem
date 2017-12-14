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

<title>重置密码</title>

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
<script type="text/javascript"
	src="<%=path%>/view/frame/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	function btnClick() {
		var input = $("#input").val();
		$.post("employee/findEmployeeByAjax.do", {
			name : input
		}, function(data) {
			var obj = JSON.parse(data);
			$("#username").val(obj.username);
			$("#pass").val(obj.pass);
			$("#nickname").val(obj.nickname);
			$("#realname").val(obj.realname);
			$("#jobInfoId").val(obj.jobInfoId.job);
			$("#departmentId").val(obj.departmentId.dname);
			$("#phoneNo").val(obj.phoneNo);
			$("#officeTel").val(obj.officeTel);
			$("#workStatu").val(obj.workStatu);
			var dept = '技术部';
			var test = obj.departmentId.dname;
			if (test == dept) {
				alert("该员工为管理员/超级管理员，当前权限不可重置！")
				$('#btn').attr('disabled', 'disabled');
			} else {
				$('#btn').removeAttr('disabled');
			}
		});
	}
</script>

</head>

<body>
	<form action="<%=basePath%>employee/updateEmp.do" name="form2"
		onsubmit="return validator(this)" method="post">
		<input type="hidden" value="resetPass" name="op">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>重置密码</td>
			</tr>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入信息查询（真实姓名或者编号）：<input
					type="text" maxlength="10" style="width: 145px" id="input">&nbsp;&nbsp;<input
					type="button" onclick="btnClick()" value="查询"></td>
			</tr>
			<tr>

				<td bgcolor="#FFFDF0"><div align="center">用户名（邮箱号）：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" readonly="readonly"
					name="username" id="username"></td>
				<td bgcolor="#FFFDF0"><div align="center">用户密码：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" name="pass" id="pass"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">昵称：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" name="nickname" id="nickname"
					readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">真实姓名：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" name="realname" id="realname"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">职位：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" id="jobInfoId"
					readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">部门：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" id="departmentId"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">手机号：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" name="phoneNo" id="phoneNo"
					readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">办公电话：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" name="officeTel" id="officeTel"
					readonly="readonly"></td>
			</tr>

		</table>

		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr bgcolor="#ECF3FD">
				<td width="25%"></td>
				<td width="17%"><input type="submit" name="submit" id="btn" value="确认修改"></td>
				<td width="4%"><input type="button" name="button"
					onClick="history.back() " value="返回"></td>
				<td width="43%"></td>
			</tr>
		</table>
	</form>
</body>
</html>

