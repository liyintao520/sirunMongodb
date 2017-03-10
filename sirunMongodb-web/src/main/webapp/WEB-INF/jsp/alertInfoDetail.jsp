<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage=""%>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";
%>
<head>
<base href="<%=basePath%>">
<title>MongoDB测试平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/pagination.css" />
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script src="js/jquery.pagination.js"></script>
<script src="js/common.js"></script>
</head>
<body>
	<h1>MongoDB测试平台--报警信息</h1>
	<table id="t_table" class="table">
		<thead>
			<tr>
				<th>序号</th>
				<th>报警类型</th>
				<th>报警等级</th>
				<th>正常范围</th>
				<th>报警值</th>
				<th>报警时间</th>
				<th>报警地点</th>
			</tr>
		</thead>
		<tbody id="">
			<!-- <tr class="">
					<td>1</td>
					<td>电池单体一致性差报警</td>
					<td>二</td>
					f`	
					<td>30-50</td>
					<td>60</td>
					<td>2016-12-13 15:00</td>
					<td>北京市丰台区南四环西路</td>
				</tr> -->
		</tbody>
	</table>
	<div id="Pagination" style="float: right;"></div>
	<input type="hidden" id="id_vin" value="${vin }"/>
	<script type="text/javascript" src="js/sirunMongodb/alertInfoDetail.js"></script>
</body>