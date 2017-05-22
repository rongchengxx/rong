$(function(){
	//加载setinfo.do页面
	loadSetinfo();
	//绑定修改单击事件
	$("#setinfo_button").click(set_infoAction);
});

function loadSetinfo(){
//	var SettingsId = SetCookie("SettingsId",5);
	
	
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="/rcb-ms";
	}
	/*//获取cookie中的SettingsId
	var SettingsId = getCookie("SettingsId");
	//判断cookie是否有效
	if(SettingsId==null){
		window.location.href=path+"/info.do";
	}*/
	
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
//				var infoId = info.id;
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
	/*if(infoLogo==""){
		$("#infoLogo_span").html("logo为空");
		ok=false;
	}*/
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
		$("#infoSite_span").html("网站为空");
		ok=false;
	}
	if(infoContent==""){
		$("#infoContent_span").html("联系人为空");
		ok=false;
	}
	alert("2222222222");
	console.log(userId,infoTitle,infoLogo,infoUri,infoKey_word,infoContacts,infoTel,
			infoPhone,infoFax,infoQq,infoEmail,infoSite,infoContent);
	
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
	
	
