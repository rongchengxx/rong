$(function(){
	//自动加载
	loadColumn();
	
	//监听笔记本li单击事件
	$("#column_submit").click(addColum);
	
});

function addColum(){

	/*var formData = new FormData($( "#form1" )[0]);
	$.ajax({
		url:path+"/sub.do",
		type:"post",
		data:formData,
		dataType:"json",
		success : function(result) {
			alert("上传成功");
		},
		error : function() {
			alert("上传失败!!!");
		}
	});
	alert(123);*/

	/*alert(123);*/

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
					console.log(oneMenus);
					//循环处理
					for(var i=0;i<oneMenus.length;i++){
						//获取id
						var oneMenuId = oneMenus[i].id;
						//获取title
						var oneMenuTitle = oneMenus[i].title;
						//获取seq
						var oneMenuSeq = oneMenus[i].seq;
						
						// 创建笔记本li
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
	//将userId绑定到li对象中
	$tr.data("oneMenuId",oneMenuId);
	//将tr对象添加到table中
	$("#column_table").append($tr);
}