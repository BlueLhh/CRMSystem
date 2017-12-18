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
	function formattime(val) {
		var getTime = new Date(val);
		var year = parseInt(getTime.getYear()) + 1900;
		var month = (parseInt(getTime.getMonth()) + 1);
		month = month > 9 ? month : ('0' + month);
		var date = parseInt(getTime.getDate());
		date = date > 9 ? date : ('0' + date);
		var hours = parseInt(getTime.getHours());
		hours = hours > 9 ? hours : ('0' + hours);
		var minutes = parseInt(getTime.getMinutes());
		minutes = minutes > 9 ? minutes : ('0' + minutes);
		var seconds = parseInt(getTime.getSeconds());
		seconds = seconds > 9 ? seconds : ('0' + seconds);
		var time = year + '-' + month + '-' + date + '  ' + hours + ':'
				+ minutes + ':' + seconds;
		return time;
	}

	var conditions = [ {
		conditionId : '0',
		name : '新增未上门'
	}, {
		conditionId : '1',
		name : '新增已上门'
	}, {
		conditionId : '2',
		name : '销售跟进中'
	}, {
		conditionId : '3',
		name : '咨询跟进中'
	}, {
		conditionId : '4',
		name : '死单'
	}, {
		conditionId : '5',
		name : '已报名'
	} ];
	function conditionFormatter(value) {
		for (var i = 0; i < conditions.length; i++) {
			if (conditions[i].conditionId == value)
				return conditions[i].name;
		}
		return value;
	}
	$(function() {
		var lastIndex;
		$('#tt').datagrid({

			pagination : true,//开启分页工具栏
			pageSize : 3,//默认选中的每页显示条数
			pageList : [ 1, 2, 3, 5 ],//设置可选择的每页条数

			toolbar : [ {
				text : 'excel导出',
				iconCls : 'icon-folder',
				handler : function() {
					$('#expInfo').click();
					var grid = $('#tt');//表格的ID
					var options = grid.datagrid('getPager').data("pagination").options;
					var page = options.pageNumber;//当前页数
					var rows = options.pageSize;//每页的记录数（行数）
					var url = '<%=path%>/custom/exportToExcel.do?rows='+rows+'&page='+page;
					window.location.href=url;
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
	<h2>客户信息导出</h2>
	<a href="<%=path%>/customer/exportCusInfo.do" target="_self"><span
		id='expInfo'></span></a>
	<table id="tt"
		data-options="iconCls:'icon-edit',singleSelect:false,rownumbers:true,selectOnCheck:true,checkOnSelect:false,idField:'id',url:'<%=path%>/custom/allInfo.do'">
		<thead>
			<tr>
				<!-- <th data-options="field:'ck',checkbox:true"></th> -->
				<th data-options="field:'id',width:60">客户编号</th>
				<th data-options="field:'name',width:60, editor:'text'">客户姓名</th>
				<th data-options="field:'education',width:100, editor:'text'">教育水平</th>
				<th data-options="field:'phoneNo',width:100, editor:'text'">手机号</th>
				<th data-options="field:'qq',width:100, editor:'text'">QQ</th>
				<th data-options="field:'email',width:150, editor:'text'">邮箱</th>
				<th
					data-options="field:'customStatu',width:120,formatter:conditionFormatter,editor:{
							type:'combobox',
							options:{
								valueField:'conditionId',
								textField:'name',
								data:conditions,
								required:true
							}
						}">客户状态</th>
				<th
					data-options="field:'createDate',width:180, editor:'text', formatter:function(val)  
                { 
                    return formattime(val);  
                }  ">创建日期</th>
				<th data-options="field:'inviteName',width:180, editor:'text'">邀请人姓名</th>
			</tr>
		</thead>
	</table>

</body>
</html>