$(function(){
	//自动加载
	loadAdv_find();
	//增加adv
	$("#adv_button").click(addAdv);
	//监听删除事件
	$("#adv_table").on("click",".delete_button",deleteAdv);
	//监听修改事件
	$("#adv_table").on("click",".modify_button",modifyAdv);
});

function modifyAdv(){
	//获取顶级tr
	var $tr = $(this).parent().parent().parent();
	//获取id
	var homeImgId = $tr.data("homeImgId");
	//绑定cookie
	addCookie("homeImgId",homeImgId,2);
}
function deleteAdv(){
	if(confirm("您确定要删除吗?")){
		//获取顶级tr
		var $tr = $(this).parent().parent().parent();
		//获取id
		var homeImgId = $tr.data("homeImgId");
		/*console.log(oneMenuId);*/
		//发送ajax
		$.ajax({
			url:path+"/adv/delAdv.do",
			type:"post",
			data:{"id":homeImgId},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					$tr.remove();
					alert("删除栏目成功");
				}
			},
			error:function(){
				alert("删除栏目失败");
			}
		});
		
	}
	
}

function addAdv(){
//	var homeImgId = getCookie("homeImgId")
	//获取参数
	var advAddTitle=$("#advAdd_title").val();
	var advAddUrl=$("#advAdd_url").val();
	var advAddLink=$("#advAdd_link").val();
	var advAddContent=$("#advAdd_content").val();
	var advAddSeq=$("#advAdd_seq").val();
	var ok =true;
	if(advAddTitle==""){
//		$("#advAdd_title_span").html("标题为空");
		ok=false;
	}
	if(advAddUrl==""){
//		$("#advAdd_url_span").html("图片地址为空");
		ok=false;
	}
	if(advAddLink==""){
//		$("#advAdd_link_span").html("图片为空");
		ok=false;
	}
	if(advAddContent==""){
//		$("#advAdd_content_span").html("内容为空");
		ok=false;
	}
	if(advAddSeq==""){
//		$("#advAdd_seq_span").html("排序为空");
		ok=false;
	}
	if(ok){
		$.ajax({
			url:path +"/adv/addAdv.do",
			type:"post",
			dataType:"json",
			data:{
			"title":advAddTitle,
			"url":advAddUrl,
			"link":advAddLink,
			"content":advAddContent,
			"seq":advAddSeq
			},
			 success:function(result){
				if(result.state==0){//成功
					alert("添加成功！"); 	
					}
				window.location.href = path +"/adv.do";	
			},
			error:function(){
				alert("添加失败！"); 
			}
		});
	}
			
}

function loadAdv_find(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}
	
/*	//获取顶级tr
	var $tr = $(this).parent().parent().parent();
	//获取id
	var homeImgId = $tr.data("homeImgId");
	//保存cookie
	addCookie("homeImgId",homeImgId,1);*/
	
	$.ajax({
		url:path+"/adv/loadAdv.do",
		type:"post",
		data:{},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取homeImg集合
				var homeImg=result.data;
				/*console.log(homeImg);*/
				//循环处理
				for(var i=0;i<homeImg.length;i++){
					//获取id
					var homeImgId = homeImg[i].id;
					//获取图片地址
					var homeImgUrl = homeImg[i].url;
					//获取标题
					var homeImgTitle = homeImg[i].title;
					//获取描述
					var homeImgContent = homeImg[i].content;
					//获取排序
					var homeImgSeq = homeImg[i].seq;
					
					createAdv(homeImgId,homeImgUrl,homeImgTitle,homeImgContent,homeImgSeq);
				}
				
			}
		},
		error : function() {
			alert("主页内容加载失败!!!");
		}
	});
}

function createAdv(homeImgId,homeImgUrl,homeImgTitle,homeImgContent,homeImgSeq){
	var str="";
	str+='<tr>';
	str+='<td>';
	str+=homeImgId;
	str+='</td>';
	str+='<td>';
	str+=homeImgUrl;
	str+='</td>';
	str+='<td>';
	str+=homeImgTitle;
	str+='</td>';
	str+='<td>';
	str+=homeImgContent;
	str+='</td>';
	str+='<td>';
	str+=homeImgSeq;
	str+='</td>';
	str+='<td><div class="button-group"><a class="button border-main modify_button" href="advpop.do"><span class="icon-edit"></span> 修改</a><a class="button border-red delete_button" href="javascript:void(0)"><span class="icon-trash-o"></span> 删除</a></div></td>';
	str+='</tr>';
	//将字符串转换成jQuery对象
	var $tr=$(str);
	//将homeImgId绑定到tr对象中
	$tr.data("homeImgId",homeImgId);
	//将tr对象添加到table中
	$("#adv_table").append($tr);
}