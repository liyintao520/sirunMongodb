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
	var vin = $("#id_vin").val();
	//var url = "vehiclealert/queryVehicleAlertByVin?vin=" + vin;
	$.ajax({
		url : "vehiclealert/queryVehicleAlert?vin="+ vin +"&currentIndex="+index+"&pageSize=8" ,
		type : "POST",
		success : function(data) {
			$("#t_table tbody").empty();
			var result = data.srresult.vehicleAlerts;
			console.info("result = " + result);
			var str = "";
			if(result!=null){
				for(var i=0;i< result.length;i++){
					str = "<tr class=''><td>"+ result[i].id 
							+"</td><td>"+result[i].alertType
							+"</td><td>"+result[i].alertNo
							+"</td><td>"+result[i].alertValue
							+"</td><td>"+result[i].alertLevel
							+"</td><td>"+result[i].startTime
							+"</td><td>"+i
							+"</td></tr>"
					$("#t_table tbody").append(str);
				}
				var total = data.srresult.totalNum;
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


/*{
    "_id" : ObjectId("58b7e20311fea7509fca3d65"),
    "id" : 5,
    "queryId" : 5,
    "vin" : "MM",
    "alertType" : "电动车通用告警",
    "" : "二",
    "" : "30-60",
    "" : "一级",
    "" : ISODate("2016-12-14T03:13:20.201Z")
}*/
