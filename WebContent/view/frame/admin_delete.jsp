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
<link rel="stylesheet" type="text/css"
	href="<%=path%>/view/frame/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/view/frame/themes/icon.css">
<script type="text/javascript"
	src="<%=path%>/view/frame/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/view/frame/js/jquery.easyui.min.js"></script>
<script>
	function btnFind() {
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
			var admin = '管理员';
			var test = obj.jobInfoId.job;
			if (test != admin) {
				alert("该员工不是管理员，不可删除！")
				$('#btn').attr('disabled', 'disabled');
			} else {
				$('#btn').removeAttr('disabled');
			}
		});
	}

	$(function() {
		var lastIndex;
		$('#tt').datagrid({
			pagination : true,//开启分页工具栏
			pageSize : 3,//默认选中的每页显示条数
			pageList : [ 1, 2, 3, 5 ],//设置可选择的每页条数

			toolbar : [ {
				text : 'append',
				iconCls : 'icon-add',
				handler : function() {
					$('#tt').datagrid('endEdit', lastIndex);
					$('#tt').datagrid('appendRow', {
						itemid : '',
						productid : '',
						listprice : '',
						unitprice : '',
						attr1 : '',
						status : 'P'
					});
					lastIndex = $('#tt').datagrid('getRows').length - 1;
					$('#tt').datagrid('selectRow', lastIndex);
					$('#tt').datagrid('beginEdit', lastIndex);
				}
			}, '-', {
				text : 'delete',
				iconCls : 'icon-remove',
				handler : function() {
					var row = $('#tt').datagrid('getSelected');
					//alert(row.itemid);
					if (row) {
						var index = $('#tt').datagrid('getRowIndex', row);
						$('#tt').datagrid('deleteRow', index);
					}
				}
			}, '-', {
				text : 'accept',
				iconCls : 'icon-save',
				handler : function() {
					$('#tt').datagrid('acceptChanges');
				}
			}, '-', {
				text : 'reject',
				iconCls : 'icon-undo',
				handler : function() {
					$('#tt').datagrid('rejectChanges');
				}
			}, '-', {
				text : 'GetChanges',
				iconCls : 'icon-search',
				handler : function() {
					var rows = $('#tt').datagrid('getChanges');
					alert('changed rows: ' + rows.length + ' lines');
				}
			} ],
			onBeforeLoad : function() {
				$(this).datagrid('rejectChanges');
			},
			onClickRow : function(rowIndex) {
				if (lastIndex != rowIndex) {
					$('#tt').datagrid('endEdit', lastIndex);
					$('#tt').datagrid('beginEdit', rowIndex);
				}
				lastIndex = rowIndex;
			}
		});
	});

	function job(value, row, index) {
		if (row.jobInfoId) {
			return row.jobInfoId.job;
		} else {
			return value;
		}
	}

	function dept(value, row, index) {
		if (row.departmentId) {
			return row.departmentId.dname;
		} else {
			return value;
		}
	}

	function workStatu(value, row, index) {
		if (row.workStatu == 1) {
			return "在职";
		} else {
			return "离职或未激活";
		}
	}

	$(function() {
		$('#tt').datagrid('hideColumn', 'id');
		$('#tt').datagrid('hideColumn', 'username');
		$('#tt').datagrid('hideColumn', 'pass');
		$('#tt').datagrid('hideColumn', 'nickname');
		$('#tt').datagrid('hideColumn', 'realname');
		$('#tt').datagrid('hideColumn', 'jobInfoId.job');
		$('#tt').datagrid('hideColumn', 'departmentId.dname');
		$('#tt').datagrid('hideColumn', 'phoneNo');
		$('#tt').datagrid('hideColumn', 'officeTel');
		$('#tt').datagrid('hideColumn', 'workStatu');
	})
	
	function btnClick() {
		$('#tt').datagrid('showColumn', 'id');
		$('#tt').datagrid('showColumn', 'username');
		$('#tt').datagrid('showColumn', 'pass');
		$('#tt').datagrid('showColumn', 'nickname');
		$('#tt').datagrid('showColumn', 'realname');
		$('#tt').datagrid('showColumn', 'jobInfoId.job');
		$('#tt').datagrid('showColumn', 'departmentId.dname');
		$('#tt').datagrid('showColumn', 'phoneNo');
		$('#tt').datagrid('showColumn', 'officeTel');
		$('#tt').datagrid('showColumn', 'workStatu');
	}
</script>

</head>

<body>
	<form action="<%=basePath%>employee/deleteEmp.do" name="form1"
		onsubmit="return validator(this)" method="post">
		<input type="hidden" value="deleteAdmin" name="op">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入管理员编号或者姓名进行查询：<input
					type="text" maxlength="10" style="width: 145px"
					id="input">&nbsp;&nbsp;<input type="button"
					onclick="btnFind()" value="查询"></td>
			</tr>
			<tr>

				<td bgcolor="#FFFDF0"><div align="center">用户名（邮箱号）：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" readonly="readonly"
					id="username"></td>
				<td bgcolor="#FFFDF0"><div align="center">用户密码：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" id="pass" readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">昵称：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" id="nickname"
					readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">真实姓名：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" id="realname"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">职位：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" id="jobInfoId"
					readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">部门：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="50" style="width: 145px" id="departmentId"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0"><div align="center">手机号：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" id="phoneNo" readonly="readonly"></td>
				<td bgcolor="#FFFDF0"><div align="center">办公电话：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" id="officeTel" readonly="readonly"></td>
			</tr>

		</table>

		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr bgcolor="#ECF3FD">
				<td width="25%"></td>
				<td width="17%"><input type="submit" name="submit" id="btn"
					value="确认删除"></td>
				<td width="4%"><input type="button" name="button"
					onClick="history.back() " value="返回"></td>
				<td width="43%"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td class=editHeaderTd colSpan=7>不记得编号？点击查询全部：&nbsp;&nbsp;<input
				type="button" id="btn" onclick="btnClick()" value="查询全部管理员"></td>
		</tr>
	</table>

	<table id="tt"
		data-options="iconCls:'icon-edit',singleSelect:true,idField:'id',url:'<%=path%>/employee/findEmp.do?jobId=2'">
		<thead>
			<tr>
				<th data-options="field:'id',width:60,editor:'text'">员工编号</th>
				<th data-options="field:'username',width:180,editor:'text'">员工账号（邮箱）</th>
				<th data-options="field:'pass',width:100,editor:'text'">账号密码</th>
				<th data-options="field:'nickname',width:100,editor:'text'">昵称</th>
				<th data-options="field:'realname',width:100,editor:'text'">真实姓名</th>
				<th
					data-options="field:'jobInfoId.job',width:100,editor:'text' ,formatter: job">职位</th>
				<th
					data-options="field:'departmentId.dname',width:100,editor:'text' ,formatter: dept">部门</th>
				<th data-options="field:'phoneNo',width:100,editor:'text'">手机号码</th>
				<th data-options="field:'officeTel',width:100,editor:'text'">固话号码</th>
				<th
					data-options="field:'workStatu',width:100,editor:'text' ,formatter: workStatu">在职状态</th>
			</tr>
		</thead>
	</table>
</body>
</html>

