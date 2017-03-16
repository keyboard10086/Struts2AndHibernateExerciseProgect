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
			url:"School_Add",
			dataType:"json",
			data:{
				"name":$("input[name='name']").val(),
				"district":$("input[name='district']").val(),
				"address":$("input[name='address']").val(),
				"email":$("input[name='email']").val()
			}
		}).done(function(data){
			console.log(data);
		}).fail(function(e){
			console.log(e);
		})
	})
	
});