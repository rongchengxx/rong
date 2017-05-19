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
	var password=$("#password").val();
	//新密码
	var newPassword=$("#newPassword").val();
	//确认新密码
	var renewpass=$("#renewpass").val();
	var ok=true;

	if(password==""){
		ok=false;
	}
	if(newPassword==""){
		ok=false;
	}
	if(renewpass==""){
		ok=false;
	}
	//从cookie中获取id
	var userId = getCookie('userId');
	if(ok){
		$.ajax({
			url:path+"/pass/modify.do",
			type:"post",
			dataType:"json",
			data:{"userId":userId,
				"password":password,
				"newPassword":newPassword},
				success:function(result){
				if(result.state==0){
					var user=result.data;
					console.log(user);

					
					alert("修改密码成功！");
				}
					
			},
			error:function(){
				alert("修改密码失败");
			}
		});
	}
}