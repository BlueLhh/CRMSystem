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
					$("#addcus").click();
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
	<h2>客户关怀表<a href="<%=path %>/view/frame/cus_care2.jsp" style="margin-left: 100px" target="_self">→</a></h2>
	<a  href="<%=path %>/view/frame/care_add.jsp" target="_self"><span id='addcus'></span></a>
	<table id="tt" data-options="iconCls:'icon-edit',singleSelect:true,idField:'careId',url:'<%=path %>/customer/allCare.do'">
		<thead>
			<tr>
			<th data-options="field:'careId',width:60">关怀编号</th>
				<th data-options="field:'customerId',width:60">客户编号</th>
				<th data-options="field:'careTheme',width:80">关怀主题</th>
				<th data-options="field:'careWay',width:100">关怀途径</th>
				<th data-options="field:'careTime',width:150">关怀日期</th>
				<th data-options="field:'careRemark',width:180">关怀备注</th>
				<th data-options="field:'careNexttime',width:180">下次关怀时间</th>
				<th data-options="field:'carePeople',width:180">关怀人物</th>
			</tr>
		</thead>
	</table>
	

</body>
</html>