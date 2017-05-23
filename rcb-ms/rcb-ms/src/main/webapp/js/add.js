$(function(){
	//加载add页面
	loadAdd();
	//绑定oneMenu改变触发loadTwoMenu事件
	$("#add_oneMenu").change(loadTwoMenu);
	//绑定增加单击事件
	$("#add_button").click(addAdd);
});

function addAdd(){
	// 获取请求参数
	var userId = getCookie("userId");
	var addTitle = $("#add_title").val().trim();
	var addThumb = $("#add_thumb").val().trim();
	var addOneMenuTitle = $("#add_oneMenu").find("option:selected").text();
	var addOneMenuID = $("#add_oneMenu").find("option:selected").data("oneMenuId");
	var addTwoMenuTitle = $("#add_twoMenu").find("option:selected").text();
	var addTwoMenuID = $("#add_twoMenu").find("option:selected").data("twoMenuId");
	var addNarration = $("#add_narration").val().trim();
	var addContent = editor.text();
	var addKeyWordTitle = $("#add_keyWord_title").val().trim();
	var addKeyWord = $("#add_keyWord").val().trim();
	var addKeyWordDesc = $("#add_keyWord_desc").val().trim();
	var addSeq = $("#add_seq").val().trim();
	var addCreateTime = $("#add_createTime").val().trim();
	var addAuthor = $("#add_author").val().trim();
	var addClicks = $("#add_clicks").val().trim();
	var addIsshow = $("input[name='isshow']:checked").val();
	
/*	console.log(userId,addTitle,addThumb,addOneMenuTitle,
			addOneMenuID,addTwoMenuTitle,addTwoMenuID,
			addNarration,addContent,addKeyWordTitle,
			addKeyWord,addKeyWordDesc,addSeq,
			addCreateTime,addAuthor,addClicks,addIsshow);*/

	//清空输入框内容
	$("#add_title").val("");
	$("#add_thumb").val("");
	$("#add_oneMenu").find("option").eq(0).prop("selected",true);
	//清空二级菜单
	$("#add_twoMenu").empty();
	//插入请选择分类
	$("#add_twoMenu").append("<option value=''>请选择分类</option>");
	//清空输入框内容
	$("#add_narration").val("");
	$("#add_content").val("");
	$("#add_keyWord_title").val("");
	$("#add_keyWord").val("");
	$("#add_keyWord_desc").val("");
	$("#add_seq").val("0");
	$("#add_createTime").val("");
	$("#add_author").val("");
	$("#add_clicks").val("0");
	$("#add_yes").attr("class","button active");
	$("#add_no").attr("class","button active");
	//清空提示信息
	$("#add_title").next().text("");
	$("#add_oneMenu").next().text("");
	$("#add_narration").next().text("");
	$("#add_content").next().text("");
	$("#add_seq").next().text("");
	$("#add_createTime").next().text("");
	$("#add_no").next().text("");
	// 参数格式校验
	var ok = true;
	//账号不为空
	if (userId == null) {
		window.location.href = "../rcb-ms";
		ok = false;
	}
	//标题不为空
	if (addTitle == "") {
		ok = false;
		$("#add_title").next().text("标题不能为空");
	}
	//一级菜单不为空
	if (addOneMenuTitle == "请选择分类") {
		ok = false;
		$("#add_oneMenu").next().text("一级菜单不能为空");
	}
	
	//描述不为空
	if (addNarration == "") {
		ok = false;
		$("#add_narration").next().text("描述不能为空");
	}
	//内容不为空
	if (addContent == "") {
		ok = false;
		$("#add_content").next().text("内容不能为空");
	}
	//排序不为空
	if (addSeq == "" || addSeq == 0) {
		ok = false;
		$("#add_seq").next().text("请输入排序");
	}
	//发布日期不为空
	if (addCreateTime == ""){
		ok = false;
		$("#add_createTime").next().text("请选择发布日期");
	}
/*	//显示不为空
	if ($("#add_yes").attr("class")=="button active" && $("#add_no").attr("class")=="button active"){
		ok = false;
		$("#add_no").next().text("请选择");
	}*/
	// 发送ajax请求
	if (ok) {
		$.ajax({
			url : path + "/add/addAdd.do",
			type : "post",
			data : {
				"oneMenuId" : addOneMenuID, 
				"twoMenuId" : addTwoMenuID, 
				"title" : addTitle, 
				"picture" : addThumb, 
				"narration" : addNarration, 
				"content" : addContent, 
				"keyWord" : addKeyWord, 
				"keyWordTitle" : addKeyWordTitle, 
				"keyWordDesc" : addKeyWordDesc, 
				"createTime" : addCreateTime,
				"seq" : addSeq, 
				"author" : addAuthor, 
				"clicks" : addClicks, 
				"isshow" : addIsshow
				
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					var singlePage = result.data;
	
					alert("内容添加成功");
				}/*else if(result.state == 5){
					alert(result.message);
				}*/
			},
			error : function() {
				alert("内容添加失败!!!");
			}
		});
	}
	
}

function loadTwoMenu(){
	var addOneMenu = $("#add_oneMenu").find("option:selected").data("oneMenuId");
	//清空二级菜单
	$("#add_twoMenu").empty();
	//插入请选择分类
	$("#add_twoMenu").append("<option value=''>请选择分类</option>");
	//加载二级菜单
	$.ajax({
		url:path+"/cateedit/findTwoMenuByOneMenu.do",
		type:"post",
		data:{"oneMenuId":addOneMenu},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取oneMenu集合
				var twoMenus=result.data;
					//循环处理
				for(var i=0;i<twoMenus.length;i++){
					//获取id
					var twoMenuId = twoMenus[i].id;
					//获取title
					var twoMenuTitle = twoMenus[i].title;
					//创建option
					createTwoMenuOption(twoMenuId,twoMenuTitle);
				}
				
			}
		},
		error : function() {
			alert("一级菜单内容加载失败!!!");
		}
	});
}

function loadAdd(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}
	//加载一级菜单
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
					createOneMenuOption(oneMenuId,oneMenuTitle);
				}
				
			}
		},
		error : function() {
			alert("一级菜单内容加载失败!!!");
		}
	});
	
}

//创建选择optionOneMenu
function createOneMenuOption(oneMenuId,oneMenuTitle){
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
	$("#add_oneMenu").append($option);
	
}
//创建选择optionTwoMenu
function createTwoMenuOption(twoMenuId,twoMenuTitle){
	//创建页面显示字符串
	var soption="";
	soption+="<option value=''>";
	soption+=twoMenuTitle;
	soption+="</option>";
	//将字符串转换成jQuery对象
	var $option=$(soption);
	//将oneMenuId绑定到$option对象中
	$option.data("twoMenuId",twoMenuId);
	//将$option对象添加到select中
	$("#add_twoMenu").append($option);
	
}
