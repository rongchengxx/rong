$(function(){
	//自动加载
	loadCate();
	
	//监听笔记本li单击事件
	$("#column_submit").click(addColum);
	
});

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
/*					console.log(twoMenus);
*/					//循环处理
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
	str+='<td><div class="button-group"> <a class="button border-main" href="cateedit.do"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>';
	str+='</tr>';
	
	//将字符串转换成jQuery对象
	var $tr=$(str);
	//将twoMenuId绑定到tr对象中
	$tr.data("twoMenuId",twoMenuId);
	//将tr对象添加到table中
	$("#cate_table").append($tr);
}