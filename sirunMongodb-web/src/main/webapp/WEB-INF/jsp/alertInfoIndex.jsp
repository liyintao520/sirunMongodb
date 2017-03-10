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
	<table id="t_table">
		<thead>
			<tr>
				<th>车辆VIN</th>
				<th>车辆品牌</th>
				<th>车辆型号</th>
				<th>SOC报警</th>
				<th>单体电池欠压报警</th>
				<th>单体电池过压报警</th>
				<th>SOC低报警</th>
				<th>电池高温报警</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="t_data"></tbody>
	</table>
	<div id="Pagination" style="float: right;"></div>

	<script type="text/javascript" src="js/sirunMongodb/alertInfoIndex.js"></script>
</body>