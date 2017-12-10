<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<h2>员工信息表</h2>
	<table id="tt" data-options="iconCls:'icon-edit',singleSelect:true,idField:'userId',url:'<%=path %>/user/allInfo.do'">
		<thead>
			<tr>
			<th data-options="field:'userId',width:60">员工编号</th>
				<th data-options="field:'userName',width:60">员工姓名</th>
				<th data-options="field:'userMobile',width:80">员工手机</th>
				<th data-options="field:'userTel',width:100">员工固话</th>
				<th data-options="field:'userAddress',width:150">员工住址</th>
				<th data-options="field:'userNum',width:180">员工账号</th>
				<th data-options="field:'userPw',width:180">员工密码</th>
				<th data-options="field:'userEmail',width:180">员工邮箱</th>
				<th data-options="field:'userAddtime',width:180">入职时间</th>
				<th data-options="field:'isMarried',width:180">婚姻状态</th>
			</tr>
		</thead>
	</table>

</body>
</html>