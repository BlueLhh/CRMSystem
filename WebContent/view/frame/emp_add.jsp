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
<script type="text/javascript"
	src="<%=path%>/view/frame/js/jquery-1.7.2.min.js"></script>


<script type="text/javascript">
	/* 通过职位ID查询部门信息，并传值回来  */
	/* function changeJob() {
		var jobId = $("#job").val();
		$.post("jobInfo/dept.do", {
			name : jobId
		}, function(data) {
			alert("+++++++++职位")
			alert(data.departmentId.dname + "+++++++++职位")
			var obj = JSON.parse(data);
			$("#dept").val(obj.departmentId.dname);
			alert(obj.departmentId.dname + "+++++++++职位")
		});
	} */

	/* 通过部门ID查询职位信息，并传值回来 */
	/* function changeDetp() {
		var deptId = $("#dept").val();
		$.post("jobInfo/job.do", {
			name : deptId
		}, function(data) {
			var obj = JSON.parse(data);
			$("#job").val(obj.job);
			alert(obj.job + "+++++++++部门")
		});
	} */

	function changeDetp() {
		var deptId = $("#dept").val();
		var jobSelect = $("#job");
		$.post("jobInfo/job.do", {
			name : deptId
		}, function(data) {
			// 清空下拉框
			jobSelect.empty();
			$.each(data, function(index, jobInfo) {
				var option = $("<option>" + jobInfo.job + "</option>");
				jobSelect.append(option);
			});
		});
	}
</script>

</head>



<body>
	<form action="<%=basePath%>employee/empAdd.do" name="form1"
		onsubmit="return validator(this)" method="post">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入员工信息</td>
			</tr>
			<tr>

				<td bgcolor="#FFFDF0"><div align="center">用户名（邮箱号）：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" valid="required"
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
				<td bgcolor="#FFFDF0"><div align="center">部门：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><select id="dept" name="dept"
					style="width: 145px" onchange="changeDetp()">
						<c:forEach var="department" items="${sessionScope.department }">
							<c:if test="${department.id != 1}">
								<option value="${department.id }" label="">${department.dname }</option>
							</c:if>
						</c:forEach>
				</select></td>
				<td bgcolor="#FFFDF0"><div align="center">职位：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><select id="job" name="job"
					style="width: 145px">
						<%-- <c:forEach var="jobInfo" items="${sessionScope.jobInfo }">
							<c:if test="${jobInfo.id != 1 && jobInfo.id != 2 }">
								<option value="${jobInfo.id }" label="">${jobInfo.job }</option>
							</c:if>
						</c:forEach> --%>
				</select></td>
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
</body>
</html>

