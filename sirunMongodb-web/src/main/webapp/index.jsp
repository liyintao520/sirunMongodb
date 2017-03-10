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
</head>
<body>
	<h1>MongoDB测试平台</h1>
	<h1>框架已经搭好，请主人开始业务逻辑。。。。。。</h1>
	<%-- 因为我配置了这个 <base href="<%=basePath%>"> 所以全局都不用配置路径了 --%>
	<a href="web/alertInfoIndex">报警信息</a><br />
	<a href="web/stuIndex">学生信息表</a>
</body>