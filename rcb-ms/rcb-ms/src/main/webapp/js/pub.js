$(function(){
	
	//loadPub页面
	loadPub();
	
	//modifyPub页面
	//监听单击事件
	$("#pub_button").click(modifyPub);
	
});

function modifyPub(){
	//获取cookie中的columnId
	var columnId = getCookie("columnId")
	//判断cookie是否有效
	if(columnId==null){
		window.location.href="column.do";
	}

	// 获取请求参数
	var pubId=columnId;
	var pubTitle=$("#pub_title").val().trim();
	var pubThumb=$("#pub_thumb").val().trim();
	var pubIntro=$("#pub_intro").val().trim();
	var pubContent=$("#pub_content").val().trim();
	var pubSeq=$("#pub_seq").val().trim();
	var pubIsshow=$("input[name='isshow']:checked").val();
	/*console.log(pubId,pubTitle,pubThumb,pubIntro,pubContent,pubSeq,"isshow"+pubIsshow);*/

	$.ajax({
		url : path + "/pub/modyfiPub.do",
		type : "post",
		data : {
			"id" : pubId,
			"title" : pubTitle,
			"thumb" : pubThumb,
			"content" : pubContent,
			"seq" : pubSeq,
			"isshow" : pubIsshow,
			"intro" : pubIntro
		},
		dataType : "json",
		success : function(result) {
			if (result.state == 0) {
				
				alert("栏目修改成功");
				window.location.href="column.do";
			}
		},
		error : function() {
			alert("栏目修改失败!!!");
		}
	});
	
}

function loadPub(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}
	//获取cookie中的columnId
	var columnId = getCookie("columnId")
	//判断cookie是否有效
	if(columnId==null){
		window.location.href="column.do";
	}
	
	//发送ajax
	$.ajax({
		url : path + "/pub/loadPub.do",
		type : "post",
		data : {"id":columnId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var oneMenu = result.data;
				/*console.log(oneMenu);*/
				//获取各项数值
				var oneMenuId = oneMenu.id;
				var oneMenuTitle = oneMenu.title;
				var oneMenuThumb = oneMenu.thumb;
				var oneMenuContent = oneMenu.content;
				var oneMenuSeq = oneMenu.seq;
				var oneMenuIsshow = oneMenu.isshow;
				var oneMenuIntro = oneMenu.intro;
				//获取各个内容框，绑定他们哟
				var pubTitle=$("#pub_title").val(oneMenuTitle);
				var pubThumb=$("#pub_thumb").val(oneMenuThumb);
				var pubIntro=$("#pub_intro").val(oneMenuIntro);
				var pubContent=$("#pub_content").val(oneMenuContent);
				var pubSeq=$("#pub_seq").val(oneMenuSeq);
				
				/*var pubIsshow=$("input[name='isshow']:checked").val(oneMenuIsshow);	active*/
				if(oneMenuIsshow==0){
					$("#pub_no").click();
				}else if(oneMenuIsshow==1){
					$("#pub_yes").click();
				}
				
			}
		},
		error:function(){
			alert("修改栏目获取信息失败！")
		}
	});
	
}