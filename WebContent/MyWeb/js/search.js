
$(document).ready(function(){
	$("#btnQuery").click(function(){
		getData();		
	});
	
});

function getData() {

	var sendData=new Array();
	var type=$("#type").val();
	var builder=$("#builder").val();
	var price=$("#price").val();
	var model=$("#model").val();
	
	$("mytbody").remove();
	
	if (type!==""){
		sendData.push({"type":"%"+type+"%"});
	}
	if(builder!==""){
		sendData.push({"builder":"%"+builder+"%"});
	}	
	if(price!==""){
		sendData.push({"price":"%"+price+"%"});
	}
	if(model!==""){
		sendData.push({"model":"%"+model+"%"});
	}
	
		$.post("../../searchGuitar",{"sendData":JSON.stringify(sendData)},function(data){
			$("table tr:gt(0)").remove();
			var html="";
			for( i=0;i<data.rows.length;i++){
				var r = data.rows[i];	
				html += "<tr align='center'><td>"+r.serialNumber+"</td>";
				html += "<td>" + r.price + "</td>";
				html += "<td>" + r.builder + "</td>";
				html += "<td>" + r.model + "</td>";
				html += "<td>" + r.type + "</td>";
				html += "<td>" + r.backWood + "</td>";
				html += "<td>" + r.topWood + "</td></tr>";
				
			};
				$("#mytbody").append(html);
		});
 }

