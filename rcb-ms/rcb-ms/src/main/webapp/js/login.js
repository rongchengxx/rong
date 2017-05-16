function loginAction(){
		
		
		/*if(ok){
			$.ajax({
				url:path+"/login.do",
				type:"post",
				data:{"name":name,"password":password},
				dataType:"json",
				success:function(result){
					if(result.state==0){ //成功
						//将用户信息写入cookie
//						var user=result.data;
//						addCookie("userId",user.id,2);
						//跳转到主页面
						alert("登录成功");
						window.location.href="index.html";
					}else if(result.state==2){
						$("#d1").html(result.message);
					}else if(result.state==3){
						$("#d1").html(result.message);
					}
				},
				error:function(){
					alert("登录失败");
				}
			});
		}*/
	}
function subAction(){/*
	
	var mpass=$("#mpass").val().trim();
	var newpass=$("#newpass").val().trim();
	var renewpass=$("#renewpass").val().trim();
	var ok=true;

	if(mpass==""){
		ok=false;
	}
	if(newpass==""){
		ok=false;
	}
	if(renewpass==""){
		ok=false;
	}
	if(ok){
		$.ajax({
			url:path+"/modify.do",
			type:"post",
			data:{"mpass":mpass,"newpass":newpass,"renewpass":renewpass},
			dataType:"json",
			success:function(result){
				if(result.state==0){ 
					var password=result.data;
					
					window.location.href="/modify.do";
				}else if(result.state==2||result.state==3){
					$("#c1").html(result.message);
				}
			},
			error:function(){
				alert("修改密码失败");
			}
		});
	}
*/}