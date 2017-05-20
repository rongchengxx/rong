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
     <script src="js/basevalue.js"></script>
    <script src="js/pintuer.js"></script> 
<<<<<<< HEAD
=======
     <script src="js/setinfo.js"></script>
>>>>>>> 292a367fef6fc1e8cde90a9b3acf922e9b1fd47e
    <script src="js/cookie_util.js"></script>
    <script type="text/javascript">
    $(function(){
    	var SettingsId = SetCookie("SettingsId",5);
    	
    	
    	// 获取参数userId
		var userId=getCookie("userId");
		//判断userId是否有效
		if(userId==null){
			window.location.href="/rcb-ms";
		}
    });
    </script> 
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 网站信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label>网站标题：</label>
        </div>
        <div class="field">
<<<<<<< HEAD
          <input type="text" class="input" name="stitle" value="" />
=======
          <input type="text" class="input" id="info_title" name="stitle" value="" />
>>>>>>> 292a367fef6fc1e8cde90a9b3acf922e9b1fd47e
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>网站LOGO：</label>
        </div>
        <div class="field">
          <input type="text" id="info_thumb" name="img" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image="" />
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="info_myfile.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" id="info_myfile" uploader="uploader" nv-file-select="" onchange="input1.value=this.value" style="/* display: block; */" class="file-btn">
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>
     
      <div class="form-group">
        <div class="label">
          <label>网站域名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_uri"  name="surl" value="" />
        </div>
      </div>
      <div class="form-group" style="display:none">
        <div class="label">
          <label>副加标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="sentitle" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>网站关键字：</label>
        </div>
        <div class="field">
          <textarea class="input" id="info_key_word" name="skeywords" style="height:80px"></textarea>
          <div class="tips"></div>
        </div>
      </div>
    
      <div class="form-group">
        <div class="label">
          <label>联系人：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_contacts" name="s_name" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>手机：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_tel" name="s_phone" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_phone" name="s_tel" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group" style="display:none;">
        <div class="label">
          <label>400电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="s_400" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>传真：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_fax" name="s_fax" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>QQ：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_qq" name="s_qq" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group" style="display:none">
        <div class="label">
          <label>QQ群：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="s_qqu" value="" />
          <div class="tips"></div>
        </div>
      </div>
     
      <div class="form-group">
        <div class="label">
          <label>Email：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_email" name="s_email" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="info_site" name="s_address" value="" />
          <div class="tips"></div>
        </div>
      </div>  
        <div class="form-group">
        <div class="label">
          <label>网站描述：</label>
        </div>
        <div class="field">
          <textarea class="input" id="info_content" name="sdescription"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" id="setinfo_button"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>