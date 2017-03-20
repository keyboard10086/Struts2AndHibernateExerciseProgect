/**
 * javascript for LoginSuccess.html
 */
$(function(){
	var col;
	$('#searchbox').searchbox({
	    searcher:function(value,name){
	        alert(value + "," + name)
	    },
	    menu:'#searchboxMenu',
	    prompt:'Please Input Value'
	});
	
	$("#addSchool").on("click",function(){
		var tableString = "<table class='addSchool'><tbody>";
		for(col=0;col<4;col++){
			tableString += "<tr><td id='row"+(col+1)+"' class='row'></td><td class='column'></td></tr>"
		}
		tableString+= "</tbody></table>";
		$("#addStudentDiv1").css("display","block");
		$("#addSchoolButton").css("display","block");
		$("#addStudentDiv").html(tableString);
		$("#row1").text("name");
		$("#row2").text("district");
		$("#row3").text("address");
		$("#row4").text("email");
		col=0;
		$("table.addSchool td.column").each(function(){
			$(this).html("<input type='text' name='"+$("table.addSchool td#row"+(col+1)).text()+"' />");
			col++;
		});
	})
	
	$("#addSchoolButton").on("click",function(){
		$.ajax({
			url:"tmp1_Add",
			dataType:"json",
			data:{
				"name":$("input[name='name']").val(),
				"district":$("input[name='district']").val(),
				"address":$("input[name='address']").val(),
				"email":$("input[name='email']").val()
			}
		}).done(function(data){
			$("#addContentResultDiv").css("display","block");
			var tmp = [],tmpColumn = [];
			for(var i=0;i<data.schools.length;i++){
				tmpColumn = [];
				tmpColumn.push(data.schools[i].id);
				tmpColumn.push(data.schools[i].name);
				tmpColumn.push(data.schools[i].district);
				tmpColumn.push(data.schools[i].address);
				tmpColumn.push(data.schools[i].email);
				tmp.push(tmpColumn);
			}
			$("#addContentResultTable").DataTable({
				data: tmp,
		        columns: [
		            { title: "Id" },
		            { title: "Name" },
		            { title: "District" },
		            { title: "Address" },
		            { title: "Email" }
		        ]
			});
			console.log(data.schools);
		}).fail(function(e){
			console.log(e);
		})
	})
	
	
	
});