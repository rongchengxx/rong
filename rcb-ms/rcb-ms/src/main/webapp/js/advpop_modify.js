	$(function(){
		$("#modify_button").click(modifyAction);
//		alert(111111);
	});

	function modifyAction(){
		var advpop_title=$("#advpop_title").val();
		var advpop_url=$("#advpop_url").val();
		var advpop_link=$("#advpop_link").val();
		var advpop_content=$("#advpop_content").val();
		var advpop_seq=$("#advpop_seq").val();
			$.ajax({
					url:path +"/advpop/modify.do",
					type:"post",
					dataType:"json",
					data:{
					"title":advpop_title,
					"url":advpop_url,
					"link":advpop_link,
					"content":advpop_content,
					"seq":advpop_seq
					},
					 success:function(result){
						if(result.state==0){//成功
							alert("修改成功！"); 	}
					},
					error:function(){
						alert("修改失败！"); 
					}
				});
}