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
<script type="text/javascript"
	src="<%=path%>/view/frame/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/view/frame/js/jquery.easyui.min.js"></script>
<script>

	function pidName(value, row, index) {
		if (row.pid) {
			return row.pid.rightName;
		} else {
			return value;
		}
	}

	function rightType(value, row, index) {
		if (row.rightType == 1) {
			return "一级权限";
		} else {
			return "二级权限";
		}
	}

	$(function() {
		var lastIndex;
		/* datagrid方法是设置table的属性，和在html标签上直接设置效果一致 */
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
						realname : '55555',
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
			},
			onLoadSuccess : function(data) {

			}
		});
	});
</script>
</head>
<body>
	<h2>删除权限</h2>
	<table id="tt"
		data-options="iconCls:'icon-edit',singleSelect:true,idField:'rid',url:'<%=path%>'/rights/allInfo.do">
		<thead>
			<tr>
				<th data-options="field:'rid',width:60,editor:'text'">权限编号</th>
				<th data-options="field:'rightName',width:180,editor:'text'">权限名称</th>
				<th
					data-options="field:'rightType',width:100,editor:'text',formatter:rightType">权限级别</th>
				<th data-options="field:'url',width:100,editor:'text'">选项卡url值</th>
				<th data-options="field:'pid.rightName',width:100,editor:'text'">类别名称</th>
			</tr>
		</thead>
	</table>
</body>
</html>