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
	<h2>查询所有咨询员工</h2>
	<table id="tt"
		data-options="iconCls:'icon-edit',singleSelect:true,idField:'id',url:'<%=path%>/employee/findEmp.do?jobId=3'">
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