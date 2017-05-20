	$(function(){
		$("#adv_button").click(addAction);
	});

	function addAction(){
		var advAdd_title=$("#advAdd_title").val();
		var advAdd_url=$("#advAdd_url").val();
		var advAdd_link=$("#advAdd_link").val();
		var advAdd_content=$("#advAdd_content").val();
		var advAdd_seq=$("#advAdd_seq").val();
				$.ajax({
					url:path +"/adv/add.do",
					type:"post",
					dataType:"json",
					data:{
					"title":advAdd_title,
					"url":advAdd_url,
					"link":advAdd_link,
					"content":advAdd_content,
					"seq":advAdd_seq
					},
					 success:function(result){
						if(result.state==0){//成功
							alert("添加成功！"); 	}
					},
					error:function(){
						alert("添加失败！"); 
					}
				});
}