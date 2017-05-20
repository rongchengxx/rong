$(function(){
	$("#setinfo_button").click(set_infoAction);
});
function set_infoAction(){
	
	var infoTitle=$("#info_title").val().trim();
	var infoLogo=$("#info_thumb").val().trim();
	var infoUri=$("#info_uri").val().trim();
	var infoKey_word=$("#info_key_word").val().trim();
	var infoContacts=$("#info_contacts").val().trim();
	var infoTel=$("#info_tel").val().trim();
	var infoPhone=$("#info_phone").val().trim();
	var infoFax=$("#info_fax").val().trim();
	var infoQq=$("#info_qq").val().trim();
	var infoEmail=$("#info_email").val().trim();
	var infoSite=$("#info_site").val().trim();
	var infoContent=$("#info_content").val().trim();
			$.ajax({
				url:path +"/info/modify.do",
				type:"post",
				dataType:"json",
				data:{
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
						alert("设置成功！"); 	}
				},
				error:function(){
					alert("设置失败！"); 
				}
			 });
		}
	
	
