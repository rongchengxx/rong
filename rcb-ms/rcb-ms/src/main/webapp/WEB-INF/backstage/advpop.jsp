<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
    <script src="js/cookie_util.js"></script>
    <script type="text/javascript">
    $(function(){
    	// 获取参数userId
		var userId=getCookie("userId");
		//判断userId是否有效
		if(userId==null){
			window.location.href="../rcb-ms";
		}
    });
    </script> 
</head>
<body>
	<div class="panel admin-panel margin-top" id="add">
	  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 修改内容</strong></div>
	  <div class="body-content">
	    <form method="post" class="form-x" action="">    
	      <div class="form-group">
	        <div class="label">
	          <label>标题：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50" value="" name="title" data-validate="required:请输入标题" />
	          <div class="tips"></div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="label">
	          <label>URL：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50" name="url" value=""  />
	          <div class="tips"></div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="label">
	          <label>图片：</label>
	        </div>
	        <div class="field">
	          <input type="text" id="url1" name="img" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
	          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="myfile.click();" style="float: left;">
	            <span class="glyphicon glyphicon-ban-circle"></span>十上传
	          </button>
	          <input type="file" id="myfile" uploader="uploader" nv-file-select="" onchange="input1.value=this.value" style="/* display: block; */" class="file-btn">
	          <div class="tipss">图片尺寸：1920*500</div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="label">
	          <label>描述：</label>
	        </div>
	        <div class="field">
	          <textarea type="text" class="input" name="note" style="height:120px;" value=""></textarea>
	          <div class="tips"></div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="label">
	          <label>排序：</label>
	        </div>
	        <div class="field">
	          <input type="text" class="input w50" name="sort" value="0"  data-validate="required:,number:排序必须为数字" />
	          <div class="tips"></div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="label">
	          <label></label>
	        </div>
	        <div class="field">
	          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
	        </div>
	      </div>
	    </form>
	  </div>
	</div>
</body>
</html>