<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
        <script src="js/cookie_util.js"></script>
        <script src="js/basevalue.js"></script>
        <script src="js/pub.js"></script>
     
</head>
<body>
	<div class="panel admin-panel margin-top">
	<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改内容</strong></div>
	<div class="body-content">
	<form method="post" class="form-x" action="">   
	  <input type="hidden" name="id"  value="" />  
	  <div class="form-group">
	    <div class="label">
	      <label>栏目名称：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" id="pub_title" name="title" value="" data-validate="required:请输入标题" />         
	      <div class="tips"></div>
	    </div>
	  </div> 
	  <div class="form-group">
	    <div class="label">
	      <label>栏目图片：</label>
	    </div>
	    <div class="field">
	      <input type="text" id="pub_thumb" name="banner" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
	      <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="pub_myfile.click();" style="float: left;">
	        <span class="glyphicon glyphicon-ban-circle"></span>十上传
	      </button>
	      <input type="file" id="pub_myfile" uploader="uploader" nv-file-select="" onchange="input1.value=this.value" style="/* display: block; */" class="file-btn">
	      <div class="tipss">图片尺寸：1920*200</div>
	    </div>
	  </div>
	         
	  <div class="form-group">
	    <div class="label">
	      <label>关键字标题：</label>
	    </div>
	    <div class="field">
	      <input type="text" id="pub_intro" class="input" name="s_title" value="" />         
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <div class="label">
	      <label>关键字描述：</label>
	    </div>
	    <div class="field">
	      <textarea type="text" id="pub_content" class="input" name="s_desc" style="height:100px;" ></textarea>        
	    </div>
	 </div>

	 <div class="form-group">
	    <div class="label">
	      <label>显示：</label>
	    </div>
	    <div class="field">
	      <div class="button-group radio">
	      
	      <label class="button " id="pub_yes">
	     	  <span class="icon icon-check"></span>             
	          <input name="isshow" value="1" type="radio" >是             
	      </label>             
	    
	      <label class="button" id="pub_no"><span class="icon icon-times"></span>          	
	          <input name="isshow" value="0"  type="radio" >否
	      </label>         
	       </div>       
	    </div>
	 </div>
	  <div class="form-group">
	    <div class="label">
	      <label>排序：</label>
	    </div>
	    <div class="field">
	      <input type="text" id="pub_seq" class="input w50" name="sort" value="0"  data-validate="required:,number:排序必须为数字" />
	      <div class="tips"></div>
	    </div>
	  </div>
	 <div class="form-group">
	    <div class="label">
	      <label></label>
	    </div>
	    <div class="field">
	      <button class="button bg-main icon-check-square-o" id="pub_button" type="button"> 提交</button>
	    </div>
	  </div>
	</form>
	</div>
	</div>
</body>
</html>