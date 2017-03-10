<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage=""%>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<base href="<%=basePath%>">
	<title>MongoDB测试平台</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	
</head>
<body>
	<script type="text/javascript">
		/* function update(){
			var form = document.forms[0];
			form.action = "vehiclealert/update";
			form.method="post";
			form.submit();
		} */
		$.fn.serializeObject = function() {  
	        var o = {};  
	        var a = this.serializeArray();  
	        $.each(a, function() {  
	            if (o[this.name]) {  
	                if (!o[this.name].push) {  
	                    o[this.name] = [ o[this.name] ];  
	                }  
	                o[this.name].push(this.value || '');  
	            } else {  
	                o[this.name] = this.value || '';  
	            }  
	        });  
	        return o;  
	    }  
		function update(){
			var params = $("#myform").serialize(); //将表单序列化为JSON对象   
        
			$.ajax({
				url : "vehiclealert/update",
				type : "POST",
		
				data : params,
				success : function(data){
					
				}, 
				error : function(data) {
					alert('警告',"修改数据失败，请检查网络！", 'error');
				}
			});
		}
	</script>
	<h1>MongoDB测试平台--报警信息-->修改页面</h1>
	<form action="" name="vehiclealertForm" id="myform">
		<h3>长度：${fn:length(list) }</h3>
		<table id="">
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
				</tr>
			</thead>
			<tbody>
                <c:forEach var="list" items="${list }">
                	<tr class="">
	                  <td><input name = "vin" value="${list.vin }" /> </td>
	                  <td><input name = "alerts" value="${list.alerts['0'] }" /></td>
	                  <td><input name = "alerts" value="${list.alerts['1'] }" /></td>
	                  <td><input name = "alerts" value="${list.alerts['2'] }" /></td>
	                  <td><input name = "alerts" value="${list.alerts['3'] }" /></td>
	                  <td><input name = "alerts" value="${list.alerts['4'] }" /></td>
	                  <td><input name = "alerts" value="${list.alerts['5'] }" /></td>
	                  <td><input name = "alerts" value="${list.alerts['6'] }" /></td>
	                </tr>
                </c:forEach>
			</tbody>
		</table>
		<input type="button" value="编辑" onclick="update()"/>
	</form>
</body>