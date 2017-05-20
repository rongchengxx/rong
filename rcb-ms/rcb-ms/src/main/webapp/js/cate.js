$(function(){
	//自动加载
	loadCate();
	
	//加载一级菜单下拉框
	loadColumnTitle();
	
	//绑定单击事件
	$("#cate_button").click(addCate);
	
	//监听删除事件
	$("#cate_table").on("click",".delete_button",deleteCate);
	
	//监听修改事件
	$("#cate_table").on("click",".modify_button",modifyCate);
});

function modifyCate(){
	//获取顶级tr
	var $tr = $(this).parent().parent().parent();
	//获取id
	var twoMenuId = $tr.data("twoMenuId");
	//保存cookie
	addCookie("cateId",twoMenuId,2);

	/*alert(getCookie("cateId"));*/
}

function deleteCate(){
	if(confirm("您确定要删除吗?")){
		//获取顶级tr
		var $tr = $(this).parent().parent().parent();
		//获取id
		var twoMenuId = $tr.data("twoMenuId");
		/*console.log(twoMenuId);*/
		//发送ajax
		$.ajax({
			url:path+"/cate/delCate.do",
			type:"post",
			data:{"id":twoMenuId},
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

function addCate(){
	// 获取请求参数
	var userId=getCookie("userId");
	var cateOneMenu = $("#cate_oneMenu").find("option:selected").data("oneMenuId");
	var cateOneMenuTitle = $("#cate_oneMenu").find("option:selected").text();
	var cateTitle=$("#cate_title").val().trim();
	var cateThumb=$("#cate_thumb").val().trim();
	var cateIntro=$("#cate_intro").val().trim();
	var cateContent=$("#cate_content").val().trim();
	var cateIsshow=$("input[name='isshow']:checked").val();
	var cateSeq=$("#cate_seq").val().trim();
	
	//清空输入框内容
	$("#cate_oneMenu").find("option").eq(0).prop("selected",true);
	$("#cate_title").val("");
	$("#cate_thumb").val("");
	$("#cate_intro").val("");
	$("#cate_content").val("");
	$("#cate_seq").val("0");
	$("#cate_yes").attr("class","button active");
	$("#cate_no").attr("class","button active");
	
	// 参数格式校验
	var ok = true;
	if (userId == null) {
		window.location.href = "../rcb-ms";
		ok = false;
	}
	if (cateOneMenu == "") {
		ok = false;
		/*------------请选择分类--------------*/	
	}
	if (cateTitle == "") {
		ok = false;
		/*------------请输入标题--------------*/	
	}
	// 发送ajax请求
	if (ok) {
		$.ajax({
			url : path + "/cate/addCate.do",
			type : "post",
			data : {
				"oneMenuId" : cateOneMenu,
				"title" : cateTitle,
				"thumb" : cateThumb,
				"content" : cateContent,
				"seq" : cateSeq,
				"isshow" : cateIsshow,
				"intro" : cateIntro
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					var twoMenu = result.data;
					
					var twoMenuId = twoMenu.id;
					var twoMenuTitle = twoMenu.title+"("+cateOneMenuTitle+")";
					var twoMenuSeq = twoMenu.seq;
					
					// 创建column
					createCate(twoMenuId,twoMenuTitle,twoMenuSeq);
								
					alert("栏目添加成功");
				}
			},
			error : function() {
				alert("栏目添加失败!!!");
			}
		});
	}
 }

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
	$("#cate_oneMenu").append($option);
	
}


function loadCate(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}else{
		$.ajax({
			url:path+"/cate/loadCate.do",
			type:"post",
			data:{},
			dataType:"json",
			success : function(result) {
				if (result.state == 0){
					//获取twoMenu集合
					var twoMenus=result.data;
					//循环处理
					for(var i=0;i<twoMenus.length;i++){
						//获取id
						var twoMenuId = twoMenus[i].id;
						//获取title
						var twoMenuTitle = twoMenus[i].title;
						//获取seq
						var twoMenuSeq = twoMenus[i].seq;
						
						// 创建Cate
						createCate(twoMenuId,twoMenuTitle,twoMenuSeq);
					}
					
				}
			},
			error : function() {
				alert("二级菜单内容加载失败!!!");
			}
		});
			
	}
		
}

function createCate(twoMenuId,twoMenuTitle,twoMenuSeq){
	var str="";
	str+='<tr>';
	str+='<td>';
	str+=twoMenuId;
	str+='</td>';
	str+='<td>';
	str+=twoMenuTitle;
	str+='</td>';
	str+='<td>';
	str+=twoMenuSeq;
	str+='</td>';
	str+='<td><div class="button-group"> <a class="button border-main modify_button" href="cateedit.do"><span class="icon-edit"></span> 修改</a> <a class="button border-red delete_button" href="javascript:void(0)"><span class="icon-trash-o"></span> 删除</a> </div></td>';
	str+='</tr>';
	
	//将字符串转换成jQuery对象
	var $tr=$(str);
	//将twoMenuId绑定到tr对象中
	$tr.data("twoMenuId",twoMenuId);
	//将tr对象添加到table中
	$("#cate_table").append($tr);
}