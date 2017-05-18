<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>系统信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/tips.css">
</head>
<body class="no-skin">
<div class="error-container"> 
    <h1> 后台管理系统-信息提示 </h1>   
    <div class="errorcon">     
        <i class="icon-smile-o"></i>操作成功        
        <span style="display:none;">
            <i class="icon-frown-o"></i>操作失败!
        </span>
    </div>
    <h4 class="smaller">页面自动 
        <a id="href" href="javascript:;">跳转</a> 等待时间： 
        <b id="wait">5</b>秒
    </h4> 
   
</div>

<script type="text/javascript">
(function(){
var wait = document.getElementById('wait'),href = document.getElementById('href').href;
var interval = setInterval(function(){
	var time = --wait.innerHTML;
	if(time <= 0) {
		location.href = href;
		clearInterval(interval);
	};
}, 1000);
})();
</script>
</body>
</html>
