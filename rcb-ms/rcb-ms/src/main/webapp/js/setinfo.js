$(function(){
	$("#set_info").click(set_infoAction);
});
function set_infoAction(){
	var title=$("#title").val().trim();
	var logo=$("#logo").val().trim();
	var uri=$("#uri").val().trim();
	var key_word=$("#key_word").val().trim();
	var account=$("#account").val().trim();
	var contacts=$("#contacts").val().trim();
	var tel=$("#tel").val().trim();
	var phone=$("#phone").val().trim();
	var fax=$("#fax").val().trim();
	var qq=$("#qq").val().trim();
	var email=$("#email").val().trim();
	var site=$("#site").val().trim();
	var content=$("#content").val().trim();
			$.ajax({
				
				url:path +"/info/addsettings.do",
				type:"post",
				dataType:"json",
				data:{title:"title",logo:"logo",uri:"uri",
					key_word:"key_word",contacts:"contacts",tel:"tel",phone:"phone",
					fax:"fax",qq:"qq",email:"email",site:"site",content:"content"},
				 success:function(result){
					 console.log("111111");
					if(result.state==0){//成功
//						var user=result.data;
//						
//						addCookie("userId",user.id,2);
//						addCookie("userAccount",user.account,2);
//						window.location.href=path+"/index.do";
//					}else if(result.state==2){//用户名错误
//						$("#account_span").html(result.message);
//					}else if(result.state==3){//密码错误
//						$("#password_span").html(result.message);
//					}
						alert("设置成功！"); 	}
				},
				error:function(){
					alert("设置失败！"); 
				}
			 });
		}
	
	
