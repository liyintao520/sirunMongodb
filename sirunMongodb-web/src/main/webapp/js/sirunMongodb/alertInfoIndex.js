var flag;//是否初始化分页插件
var homePage = 0;//默认显示第一页
$(document).ready(function() {
	flag = true;
	findAll(homePage);
});
//分页callback
function PageCallback(index, jq) {
  	flag = false;
  	findAll(index);
	return false;
}
//分页切换
function onPageChange(totalNum) {
	if (totalNum > 0) {
		$("#Pagination").show();//显示分页div
		page('Pagination', totalNum, homePage, 8);//分页
	} else {
		$("#Pagination").hide();//隐藏分页div
	}
}   
function findAll(index){
	$.ajax({
		url : "vehiclealert/getAllVehicleAlert",
		type : "POST",
		async : true,
		data: '{"currentIndex":'+index+',"pageSize":8}',
		dataType : "json",
		success : function(data) {
			$("#t_table tbody").empty();
			var result = data.srresult.alarmInfo;
			var str = "";
			if(result!=null){
				for(var i=0;i< result.length;i++){
					str = "<tr class=''><td>" + result[i].vin + 
									"</td><td>"+result[i].alerts["0"]+
									"</td><td>"+result[i].alerts["1"]+
									"</td><td>"+result[i].alerts["2"]+
									"</td><td>"+result[i].alerts["3"]+
									"</td><td>"+result[i].alerts["4"]+
									"</td><td>"+result[i].alerts["5"]+
									"</td><td>"+result[i].alerts["6"]+
									"</td><td><a href='web/alertInfoDetail?vin="+result[i].vin+"'>详情</a></td>" +
									"<td><a href='vehiclealert/toUpdate/"+result[i].vin+"'>修改</a></td>" +
									"<td><a href='vehiclealert/"+result[i].vin+"'>删除</a></td></tr>";
					$("#t_table tbody").append(str);
				}
				var total = data.srresult.alarmCount;
				  if(total==0){
					  $("#Pagination").hide();
					  return;
				  }
				  $("#Pagination").show();
				  if(flag){
					  onPageChange(parseInt(total)); 
				  }
			}
		},
		error : function(request, textStatus, errorThrown) {
			$.dialog.alert("查询失败");
		},
		headers:{
		  "Content-Type":"application/json"
		}
	});
}