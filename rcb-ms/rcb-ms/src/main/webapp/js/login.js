$(function(){

			//绑定登录单击事件
			$("#login").click(loginAction);
			//失去焦点
			$("#admin_account").blur(function(){
				//清空提示信息
				$("#account_span").html("");
				//获取请求参数
				var name=$("#admin_account").val().trim();
				if(name==""){
					$("#account_span").html("用户名为空");
				}
			});
			$("#admin_password").blur(function(){
				//清空提示信息
				$("#password_span").html("");
				//获取请求参数
				var password=$("#admin_password").val().trim();
				if(password==""){
					$("#password_span").html("密码为空");
				}
			});
	});

function loginAction(){

		//清空提示信息
		$("#account_span").html("");
		$("#password_span").html("");
		//获取请求参数
		var name=$("#admin_account").val().trim();
		var password=$("#admin_password").val().trim();
		var ok=true; //所有参数均有效
		//格式的校验
		if(name==""){
			$("#account_span").html("用户名为空");
			ok=false;
		}
		if(password==""){
			$("#password_span").html("密码为空");
			ok=false;
		}
		
		$("#admin_account").blur('ccc')
		//发送ajax请求
		if(ok){
			$.ajax({
				
				url:path +"/login.do",
				type:"post",
				dataType:"json",
				data:{"name":name,"password":password},
				 success:function(result){
					if(result.state==0){//成功
						var user=result.data;
						addCookie("userId",user.id,2);
						window.location.href=path+"/index.do";
					}else if(result.state==2){//用户名错误
						$("#account_span").html(result.message);
					}else if(result.state==3){//密码错误
						$("#password_span").html(result.message);
					}
				},
				error:function(){
					alert("登录失败"); 
				}
			 });
		}
	
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