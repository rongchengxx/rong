	$(function(){
		$("#adv_button").click(addAction);
	});

	function addAction(){
		var advAddTitle=$("#advAdd_title").val();
		var advAddUrl=$("#advAdd_url").val();
		var advAddLink=$("#advAdd_link").val();
		var advAddContent=$("#advAdd_content").val();
		var advAddSeq=$("#advAdd_seq").val();
				$.ajax({
					url:path +"/adv/add.do",
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