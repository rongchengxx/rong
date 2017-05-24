$(function(){
	//加载setinfo.do页面
	loadSetinfo();
	//绑定修改单击事件
	$("#setinfo_button").click(set_infoAction);
	
	$("#info_title").blur(function(){
		//清空提示信息
		$("#infoTitle_span").html("");
		//获取请求参数
		var title=$("#info_title").val().trim();
		if(title==""){
			$("#infoTitle_span").html("标题为空");
		}
	});
	$("#info_thumb").blur(function(){
		//清空提示信息
		$("#infoLogo_span").html("");
		//获取请求参数
		var logo=$("#info_thumb").val().trim();
		if(logo==""){
			$("#infoLogo_span").html("logo为空");
		}
	});
	$("#info_uri").blur(function(){
		//清空提示信息
		$("#infoUri_span").html("");
		//获取请求参数
		var uri=$("#info_uri").val().trim();
		if(uri==""){
			$("#infoUri_span").html("域名为空");
		}
	});
	$("#info_key_word").blur(function(){
		//清空提示信息
		$("#infoKey_word_span").html("");
		//获取请求参数
		var key_word=$("#info_key_word").val().trim();
		if(key_word==""){
			$("#infoKey_word_span").html("关键字为空");
		}
	});
	$("#info_contacts").blur(function(){
		//清空提示信息
		$("#infoContacts_span").html("");
		//获取请求参数
		var contacts=$("#info_contacts").val().trim();
		if(contacts==""){
			$("#infoContacts_span").html("联系人为空");
		}
	});
	$("#info_tel").blur(function(){
		//清空提示信息
		$("#infoTel_span").html("");
		//获取请求参数
		var tel=$("#info_tel").val().trim();
		if(tel==""){
			$("#infoTel_span").html("电话为空");
		}
	});
	$("#info_phone").blur(function(){
		//清空提示信息
		$("#infoPhone_span").html("");
		//获取请求参数
		var phone=$("#info_phone").val().trim();
		if(phone==""){
			$("#infoPhone_span").html("手机为空");
		}
	});
	$("#info_fax").blur(function(){
		//清空提示信息
		$("#infoFax_span").html("");
		//获取请求参数
		var fax=$("#info_fax").val().trim();
		if(fax==""){
			$("#infoFax_span").html("传真为空");
		}
	});
	$("#info_qq").blur(function(){
		//清空提示信息
		$("#infoQq_span").html("");
		//获取请求参数
		var qq=$("#info_qq").val().trim();
		if(qq==""){
			$("#infoQq_span").html("QQ为空");
		}
	});
	$("#info_email").blur(function(){
		//清空提示信息
		$("#infoEmail_span").html("");
		//获取请求参数
		var email=$("#info_email").val().trim();
		if(email==""){
			$("#infoEmail_span").html("Email为空");
		}
	});
	$("#info_site").blur(function(){
		//清空提示信息
		$("#infoSite_span").html("");
		//获取请求参数
		var site=$("#info_site").val().trim();
		if(site==""){
			$("#infoSite_span").html("地址为空");
		}
	});
	$("#info_content").blur(function(){
		//清空提示信息
		$("#infoContent_span").html("");
		//获取请求参数
		var content=$("#info_content").val().trim();
		if(content==""){
			$("#infoContent_span").html("内容为空");
		}
	});
});


function loadSetinfo(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="/rcb-ms";
	}
	//发送ajax
	$.ajax({
		url : path + "/info/findInfo.do",
		type : "post",
		data : {"userId":userId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var Settings = result.data;
				//获取各项数值
				var SettingsTitle = Settings.title;
				var SettingsLogo = Settings.logo;
				var SettingsUri = Settings.uri;
				var SettingsKey_word = Settings.key_word;
				var SettingsContacts = Settings.contacts;
				var SettingsTel = Settings.tel;
				var SettingsPhone = Settings.phone;
				var SettingsFax = Settings.fax;
				var SettingsQq = Settings.qq;
				var SettingsEmail = Settings.email;
				var SettingsSite = Settings.site;
				var SettingsContent = Settings.content;
				
				//获取各个内容框，绑定他们哟
				var infoTitle=$("#info_title").val(SettingsTitle);
				var infoLogo=$("#info_thumb").val(SettingsLogo);
				var infoUri=$("#info_uri").val(SettingsUri);
				var infoKey_word=$("#info_key_word").val(SettingsKey_word);
				var infoContacts=$("#info_contacts").val(SettingsContacts);
				var infoTel=$("#info_tel").val(SettingsTel);
				var infoPhone=$("#info_phone").val(SettingsPhone);
				var infoFax=$("#info_fax").val(SettingsFax);
				var infoQq=$("#info_qq").val(SettingsQq);
				var infoEmail=$("#info_email").val(SettingsEmail);
				var infoSite=$("#info_site").val(SettingsSite);
				var infoContent=$("#info_content").val(SettingsContent);
			}
		},
		error:function(){
			alert("修改栏目获取信息失败！")
		}
	});
}

function set_infoAction(){
	//获取cookie
	var userId=getCookie("userId");
	var SettingsId=userId;
	//获取参数
	var infoTitle=$("#info_title").val();
	var infoLogo=$("#info_thumb").val();
	var infoUri=$("#info_uri").val();
	var infoKey_word=$("#info_key_word").val();
	var infoContacts=$("#info_contacts").val();
	var infoTel=$("#info_tel").val();
	var infoPhone=$("#info_phone").val();
	var infoFax=$("#info_fax").val();
	var infoQq=$("#info_qq").val();
	var infoEmail=$("#info_email").val();
	var infoSite=$("#info_site").val();
	var infoContent=$("#info_content").val();
	 
	var ok=true;	
	
	if(infoTitle==""){
		$("#infoTitle_span").html("标题为空");
		ok=false;
	}
	if(infoLogo==""){
		$("#infoLogo_span").html("logo为空");
		ok=false;
	}
	if(infoUri==""){
		$("#infoUri_span").html("域名为空");
		ok=false;
	}
	if(infoKey_word==""){
		$("#infoKey_word_span").html("关键字为空");
		ok=false;
	}
	if(infoContacts==""){
		$("#infoContacts_span").html("联系人为空");
		ok=false;
	}
	if(infoTel==""){
		$("#infoTel_span").html("电话为空");
		ok=false;
	}
	if(infoPhone==""){
		$("#infoPhone_span").html("手机为空");
		ok=false;
	}
	if(infoFax==""){
		$("#infoFax_span").html("传真为空");
		ok=false;
	}
	if(infoQq==""){
		$("#infoQq_span").html("QQ为空");
		ok=false;
	}
	if(infoEmail==""){
		$("#infoEmail_span").html("Email为空");
		ok=false;
	}
	if(infoSite==""){
		$("#infoSite_span").html("地址为空");
		ok=false;
	}
	if(infoContent==""){
		$("#infoContent_span").html("网站描述为空");
		ok=false;
	}
	/*console.log(userId,infoTitle,infoLogo,infoUri,infoKey_word,infoContacts,infoTel,
			infoPhone,infoFax,infoQq,infoEmail,infoSite,infoContent);*/
	
	if(ok){
		$.ajax({
			url:path +"/info/modifyInfo.do",
			type:"post",
			dataType:"json",
			data:{
			"id":SettingsId,
			"userId":userId,
			"title":infoTitle,
			"logo":infoLogo,
			"uri":infoUri,
			"key_word":infoKey_word,
			"contacts":infoContacts,
			"tel":infoTel,
			"phone":infoPhone,
			"fax":infoFax,
			"qq":infoQq,
			"email":infoEmail,
			"site":infoSite,
			"content":infoContent
			},
			 success:function(result){
				if(result.state==0){//成功
					alert("设置成功！"); 	
					window.location.href=path+"/info.do";	
				}
			},
			error:function(){
				alert("设置失败！"); 
			}
		 });
	}
}
	
	
