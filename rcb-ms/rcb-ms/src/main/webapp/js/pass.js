$(function(){
	loadPass();
	
	$("#pass_submit").click(subAction);
});
//载pass
function loadPass(){
	var userAccount=getCookie("userAccount");
	$("#pass_account_span").html(userAccount);
}

function subAction(){
	//原始密码
	var password=$("#mpass").val();
	//新密码
	var newpass=$("#newpass").val();
	//确认新密码
	var newPassword=$("#renewpass").val();
	var ok=true;

	if(password==""){
		ok=false;
	}
	if(newPassword==""){
		ok=false;
	}
	if(newpass==""){
		ok=false;
	}
	//从cookie中获取id
	var userId = getCookie('userId');
	if(ok){
		$.ajax({
			url:path+"/pass/modify.do",
			type:"post",
			data:{"userId":userId,
				"password":password,
				"newPassword":newPassword},
			dataType:"json",
			
			success:function(){
					alert("修改密码成功！");
			},
			error:function(){
				alert("修改密码失败");
			}
		});
	}
}