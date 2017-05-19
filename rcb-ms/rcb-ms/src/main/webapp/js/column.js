$(function(){
	//自动加载
	loadColumn();
	
	//监听单击事件
	$("#column_submit").click(addColum);
	
});

function addColum(){
	// 获取请求参数
	var userId=getCookie("userId");
	var columnTitle=$("#column_title").val().trim();
	var columnThumb=$("#column_thumb").val().trim();
	var columnIntro=$("#column_intro").val().trim();
	var columnContent=$("#column_content").val().trim();
	var columnIsshow=$("input[name='isshow']:checked").val();
	var columnSeq=$("#column_seq").val().trim();

/*	console.log("columnTitle="+columnTitle,
			"columnThumb="+columnThumb,
			"columnIntro="+columnIntro,
			"columnContent="+columnContent,
			"columnIsshow="+columnIsshow,
			"columnSeq="+columnSeq);*/
	
	// 参数格式校验
	var ok = true;
	if (userId == null) {
		window.location.href = "../rcb-ms";
		ok = false;
	}
	if (columnTitle == "") {
		ok = false;
	}
	// 发送ajax请求
	if (ok) {
		$.ajax({
			url : path + "/column/add.do",
			type : "post",
			data : {
				"title" : columnTitle,
				"thumb" : columnThumb,
				"content" : columnContent,
				"seq" : columnSeq,
				"isshow" : columnIsshow,
				"intro" : columnIntro
			},
			dataType : "json",
			success : function(result) {
				if (result.state == 0) {
					var oneMenu = result.data;
					//未完成
					var id = book.id;
					var name = book.name;
					// 关闭对话框
					closeAlertWindow();
					// 创建笔记本li
					createBookLi(id, name);
					alert("笔记本创建成功");
				}
			},
			error : function() {
				alert("笔记本创建失败!!!");
			}
		});
	}
	
};

function loadColumn(){
	// 获取参数userId
	var userId=getCookie("userId");
	//判断userId是否有效
	if(userId==null){
		window.location.href="../rcb-ms";
	}else{
		
		$.ajax({
			url:path+"/column/loadColumn.do",
			type:"post",
			data:{},
			dataType:"json",
			success : function(result) {
				if (result.state == 0){
					//获取oneMenu集合
					var oneMenus=result.data;
/*					console.log(oneMenus);
*/					//循环处理
					for(var i=0;i<oneMenus.length;i++){
						//获取id
						var oneMenuId = oneMenus[i].id;
						//获取title
						var oneMenuTitle = oneMenus[i].title;
						//获取seq
						var oneMenuSeq = oneMenus[i].seq;
						
						// 创建Column
						createColumn(oneMenuId,oneMenuTitle,oneMenuSeq);
					}
					
				}
			},
			error : function() {
				alert("一级菜单内容加载失败!!!");
			}
		});
	}
	
};

function createColumn(oneMenuId,oneMenuTitle,oneMenuSeq){
	var str="";
	str+='<tr>';
	str+='<td>';
	str+=oneMenuId;
	str+='</td>';    
	str+='<td>';
	str+=oneMenuTitle;
	str+='</td>';  
	str+='<td>';
	str+=oneMenuSeq;
	str+='</td>';      
	str+='<td>';
	str+='<div class="button-group">';
	str+='<a type="button" class="button border-main" href="pub.do"><span class="icon-edit"></span>修改</a>';
	str+='<a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>';
	str+='</div>';
	str+='</td>';
	str+='</tr>';
	
	//将字符串转换成jQuery对象
	var $tr=$(str);
	//将oneMenuId绑定到tr对象中
	$tr.data("oneMenuId",oneMenuId);
	//将tr对象添加到table中
	$("#column_table").append($tr);
}