$(function(){
	//加载一级菜单下拉框
	loadColumnTitle();
	
	//loadCateedit页面
	loadCateedit();
	
	//modifyCateedit页面
	//监听单击事件
	$("#cateedit_button").click(modifyCateedit);
	
	
});


function loadColumnTitle(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}
		
	$.ajax({
		url:path+"/column/loadColumn.do",
		type:"post",
		data:{},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取oneMenu集合
				var oneMenus=result.data;
					//循环处理
				for(var i=0;i<oneMenus.length;i++){
					//获取id
					var oneMenuId = oneMenus[i].id;
					//获取title
					var oneMenuTitle = oneMenus[i].title;
					//创建option
					createOption(oneMenuId,oneMenuTitle);
				}
				
			}
		},
		error : function() {
			alert("一级菜单内容加载失败!!!");
		}
	});

	
};

function createOption(oneMenuId,oneMenuTitle){
	//创建页面显示字符串
	var soption="";
	soption+="<option value=''>";
	soption+=oneMenuTitle;
	soption+="</option>";
	//将字符串转换成jQuery对象
	var $option=$(soption);
	//将oneMenuId绑定到$option对象中
	$option.data("oneMenuId",oneMenuId);
	//将$option对象添加到select中
	$("#cateedit_oneMenu").append($option);
	
}


function modifyCateedit(){
	//获取cookie中的columnId
	var cateId = getCookie("cateId")
	//判断cookie是否有效
	if(cateId==null){
		alert("修改错误！");
		window.location.href="cate.do";
	}

	// 获取请求参数
	var cateeditId=cateId;
	var cateeditOneMenu = $("#cateedit_oneMenu").find("option:selected").data("oneMenuId");
	var cateeditOneMenuTitle = $("#cateedit_oneMenu").find("option:selected").text();
	var cateeditTitle=$("#cateedit_title").val().trim();
	var cateeditThumb=$("#cateedit_thumb").val().trim();
	var cateeditIntro=$("#cateedit_intro").val().trim();
	var cateeditContent=$("#cateedit_content").val().trim();
	var cateeditSeq=$("#cateedit_seq").val().trim();
	var cateeditIsshow=$("input[name='isshow']:checked").val();

	$.ajax({
		url : path + "/cateedit/modyfiCateedit.do",
		type : "post",
		data : {
			"id" : cateeditId,
			"oneMenuId" : cateeditOneMenu,
			"title" : cateeditTitle,
			"thumb" : cateeditThumb,
			"content" : cateeditContent,
			"seq" : cateeditSeq,
			"isshow" : cateeditIsshow,
			"intro" : cateeditIntro
		},
		dataType : "json",
		success : function(result) {
			if (result.state == 0) {
				
				alert("栏目修改成功");
				window.location.href="cate.do";
			}
		},
		error : function() {
			alert("栏目修改失败!!!");
		}
	});
	
}

function loadCateedit(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}
	//获取cookie中的cateId
	var cateId = getCookie("cateId")
	//判断cookie是否有效
	if(cateId==null){
		window.location.href="cate.do";
	}
	
	//发送ajax
	$.ajax({
		url : path + "/cateedit/loadCateedit.do",
		type : "post",
		data : {"id":cateId},
		dataType : "json",
		success:function(result){
			if (result.state == 0) {
				var twoMenu = result.data;
				//获取各项数值
				var twoMenuId = twoMenu.id;
				var OneMenuId = twoMenu.oneMenuId;
				var twoMenuTitle = twoMenu.title;
				var twoMenuThumb = twoMenu.thumb;
				var twoMenuContent = twoMenu.content;
				var twoMenuSeq = twoMenu.seq;
				var twoMenuIsshow = twoMenu.isshow;
				var twoMenuIntro = twoMenu.intro;
				
				/*----好难，这块-----*/
				/*设置text为pxx的项选中
					$(".selector").find("option[text='pxx']").attr("selected",true);
				 * */
				var $cateeditLength = $("#cateedit_oneMenu option").size();
				for(var i=0;i<$cateeditLength;i++){
					var $option = $("#cateedit_oneMenu").find("option").eq(i);
					/*console.log(OneMenuId,$option.data("oneMenuId"));*/
					if(OneMenuId==$option.data("oneMenuId")){
						var cateeditOneMenu = $option.prop('selected',true);
					}
					/*$("#cateedit_oneMenu").find("option").eq(0).prop("selected",true);*/
				}
/*				var cateeditOneMenu = $("#cateedit_oneMenu").find("option[data="+twoMenuId+"]").attr("selected",true);
*/				/*var cateeditOneMenu = $("#cate_oneMenu").find("option:selected").data("oneMenuId");
				var cateeditOneMenuTitle = $("#cate_oneMenu").find("option:selected").text();*/
				/*$("#selectid option[@value='paraValue']").attr("selected","true")
				$("#cate_oneMenu").find("option").eq(0).prop("selected",true);*/
				//获取各个内容框，绑定他们哟
				var cateeditTitle=$("#cateedit_title").val(twoMenuTitle);
				var cateeditThumb=$("#cateedit_thumb").val(twoMenuThumb);
				var cateeditIntro=$("#cateedit_intro").val(twoMenuIntro);
				var cateeditContent=$("#cateedit_content").val(twoMenuContent);
				var cateeditSeq=$("#cateedit_seq").val(twoMenuSeq);
				
				if(twoMenuIsshow==0){
					$("#cateedit_no").click();
				}else if(twoMenuIsshow==1){
					$("#cateedit_yes").click();
				}
				
			}
		},
		error:function(){
			alert("修改栏目获取信息失败！")
		}
	});
	
}