$(function(){
	//自动加载
	loadadv_find();
	
	//监听单击事件
//	$("#cate_submit").click(addCate);
	
});

function loadadv_find(){
	$.ajax({
		url:path+"/adv/loadAdv.do",
		type:"post",
		data:{},
		dataType:"json",
		success : function(result) {
			if (result.state == 0){
				//获取twoMenu集合
				var homeImg=result.data;
				console.log(homeImg);
				alert(111111);
				//循环处理
				for(var i=0;i<homeImg.length;i++){
					var homeImgId = homeImg[i].id;
					//获取
					var homeImgTitle = homeImg[i].title;
					//获取
					var homeImgUrl = homeImg[i].url;
					//获取
					var homeImgLink = homeImg[i].link;
					//获取
					var homeImgContent = homeImg[i].content;
					//获取
					var homeImgSeq = homeImg[i].seq;
					
					createAdv(homeImgId,homeImgTitle,homeImgUrl,homeImgLink,homeImgContent,homeImgSeq);
				}
				
			}
		},
		error : function() {
			alert("主页内容加载失败!!!");
		}
	});
}

function createAdv(homeImgId,homeImgTitle,homeImgUrl,homeImgLink,homeImgContent,homeImgSeq){
	var str="";
	str+='<tr>';
	str+='<td>';
	str+=homeImgTitle;
	str+='</td>';
	str+='<td>';
	str+=homeImgUrl;
	str+='</td>';
	str+='<td>';
	str+=homeImgLink;
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