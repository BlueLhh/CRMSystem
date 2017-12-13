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

<title>添加客户信息</title>

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

<!-- <script type="text/javascript">
	function btnClick() {
		var input = $("#input").val();
		$.post("", {
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
		});
	}
</script> -->

</head>

<body>
	<form action="<%=basePath%>custom/addCustom.do" name="form1"
		onsubmit="return validator(this)" method="post">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入客户员信息</td>
			</tr>
			<tr>

				<td bgcolor="#FFFDF0"><div align="center">客户姓名：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" name="name"></td>
				<td bgcolor="#FFFDF0"><div align="center">教育水平：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" name="education"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">手机号：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					valid="regexp" regexp="^1[3|4|5|8][0-9]\d{8}$" errmsg="请输入正确的手机号码!"
					style="width: 145px" name="phoneNo"></td>
				<td bgcolor="#FFFDF0"><div align="center">QQ：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" name="qq"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">邮箱：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" name="email"></td>

				<td bgcolor="#FFFDF0"><div align="center">客户状态：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><select name="customStatu"
					style="width: 145px">
						<option value="0">新增未上门</option>
						<option value="1">新增已上门</option>
						<option value="2">销售跟进中</option>
						<option value="3">咨询跟进中</option>
						<option value="4">死单</option>
						<option value="5">已报名</option>
				</select></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">创建日期：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" readonly="readonly"
					value="系统自动生成"></td>
				<td bgcolor="#FFFDF0"><div align="center">邀请人姓名：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px"
					value="${sessionScope.employee.realname }" name="inviteName"></td>
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
</body>
</html>

