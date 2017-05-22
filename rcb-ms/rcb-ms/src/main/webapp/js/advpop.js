$(function(){
	//加载advpop页面
	loadAdvpop();
	//修改确定按钮的单击事件
	$("#advpop_button").click(modifyAdvpop);


});


function modifyAdvpop(){
	var homeImgId = getCookie("homeImgId")
	//判断cookie是否有效
	if(homeImgId==null){
		window.location.href="advpop.do";	
	}
	var advpop_title=$("#advpop_title").val();
	var advpop_url=$("#advpop_url").val();
	var advpop_link=$("#advpop_link").val();
	var advpop_content=$("#advpop_content").val();
	var advpop_seq=$("#advpop_seq").val();
	var ok = true;
	
	if(advpop_title==""){
		$("#advpop_title_span").html("标题为空");
		ok=false;
	}
	if(advpop_url==""){
		$("#advpop_url_span").html("域名为空");
		ok=false;
	}
	if(advpop_link==""){
		$("#advpop_link_span").html("图片为空");
		ok=false;
	}
	if(advpop_content==""){
		$("#advpop_content_span").html("内容为空");
		ok=false;
	}
	if(advpop_seq==""){
		$("#advpop_seq_span").html("排序为空");
		ok=false;
	}
	console.log(advpop_title,advpop_url,advpop_link,advpop_content,advpop_seq);
	if(ok){
		$.ajax({
			url:path +"/advpop/modifyAdvpop.do",
			type:"post",
			dataType:"json",
			data:{
			"id":homeImgId,	
			"title":advpop_title,
			"url":advpop_url,
			"link":advpop_link,
			"content":advpop_content,
			"seq":advpop_seq
			},
			 success:function(result){
				if(result.state==0){//成功
					alert("修改成功！"); 	
					window.location.href = path +"/adv.do";	
				}
			},
			error:function(){
				alert("修改失败！"); 
			}
		});
	}

		
}


function loadAdvpop(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}
	
	//获取cookie中的HomeImgId
	var homeImgId = getCookie("homeImgId");
	//判断cookie是否有效
	if(homeImgId==null){
		window.location.href=path+"/adv.do";
	}
		
	//发送ajax
	$.ajax({
		url : path + "/advpop/loadAdvpop.do",
		type : "post",
		data : {"id":homeImgId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var HomeImg = result.data;
/*				console.log(HomeImg);
*/				//获取各项数值
//				var homeImgId = HomeImg.id;
				var HomeImgTitle = HomeImg.title;
				var HomeImgUrl = HomeImg.url;
//				var HomeImgLink = HomeImg.link;
				var HomeImgContent = HomeImg.content;
				var HomeImgSeq = HomeImg.seq;
				
				//获取各个内容框，绑定他们哟
				var advpop_title=$("#advpop_title").val(HomeImgTitle);
				var advpop_url=$("#advpop_url").val(HomeImgUrl);
//				var advpop_link=$("#advpop_link").val(HomeImgLink);
				var advpop_content=$("#advpop_content").val(HomeImgContent);
				var advpop_seq=$("#advpop_seq").val(HomeImgSeq);
			}
		},
		error:function(){
			alert("修改栏目获取信息失败！")
		}
	});
}
