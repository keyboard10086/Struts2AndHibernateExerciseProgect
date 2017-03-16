/**
 * javascript for Login.jsp
 */
$(function(){
	$("#registerDiv").css("display","none");
	$("#register").on("click",function(){
		$("#registerDiv").css("display","block");
		$("#loginDiv").css("display","none");
	})
	$("#backtologin").on("click",function(){
		$("#loginDiv").css("display","block");
		$("#registerDiv").css("display","none");
	})
});

