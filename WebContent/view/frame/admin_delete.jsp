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
<script type="text/javascript" src="<%=path%>/view/frame/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/view/frame/js/jquery.easyui.min.js"></script>
<script>
	
	$(function() {
		var lastIndex;
		$('#tt').datagrid({
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
</script>

</head>

<body>
	<form action="<%=basePath%>customer/cusAdd.do" name="form1"
		onsubmit="return validator(this)" method="post">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请输入管理员编号进行查询：<input
					type="text" maxlength="10" style="width: 145px" valid="required"
					errmsg="员工编号不能为空!" name="adminName">&nbsp;&nbsp;<input
					type="button" name="submit" value="查询"></td>
			</tr>
			<tr>

				<td bgcolor="#FFFDF0"><div align="center">用户名（邮箱号）：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					maxlength="10" style="width: 145px" readonly="readonly"
					valid="required" errmsg="客户姓名不能为空!" name="adminName"></td>
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
				<td width="17%"><input type="submit" name="submit" value="确认删除"></td>
				<td width="4%"><input type="button" name="button"
					onClick="history.back() " value="返回"></td>
				<td width="43%"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td class=editHeaderTd colSpan=7>不记得编号？点击查询全部：&nbsp;&nbsp;<input
				type="button" name="submit" value="查询全部管理员"></td>
		</tr>
	</table>
	<table id="tt"
		data-options="iconCls:'icon-edit',singleSelect:true,idField:'userId',url:'<%=path%>/user/allInfo.do'">
		<thead>
			<tr>
				<th data-options="field:'userId',width:60">员工编号</th>
				<th data-options="field:'userEmail',width:180">员工账号（邮箱）</th>
				<th data-options="field:'userPw',width:100">账号密码</th>
				<th data-options="field:'userNick',width:100">昵称</th>
				<th data-options="field:'userName',width:100">真实姓名</th>
				<th data-options="field:'userJob',width:100">职位</th>
				<th data-options="field:'userDep',width:100">部门</th>
				<th data-options="field:'userMobile',width:100">手机号码</th>
				<th data-options="field:'userTel',width:100">固话号码</th>
				<th data-options="field:'userStuts',width:100">在职状态</th>
			</tr>
		</thead>
	</table>
</body>
</html>

