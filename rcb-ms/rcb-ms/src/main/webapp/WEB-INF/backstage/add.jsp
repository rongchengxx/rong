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
<style>
    form {
      margin: 0;
    }
    textarea {
      display: block;
    }
  </style>
  <link rel="stylesheet" href="editor/themes/default/default.css" />
  <script charset="utf-8" src="editor/kindeditor-min.js"></script>
  <script charset="utf-8" src="editor/lang/zh_CN.js"></script>

<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
    <script src="js/cookie_util.js"></script>
    <script src="js/basevalue.js"></script>
    <script src="js/add.js"></script>
    
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">  
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" id="add_title" class="input w50" value="" name="title" />
          <div class="tips" style="padding-left: 240px;
	height: 40px;
	line-height: 35px;
	color: #f00;"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <input type="text" id="add_thumb"  name="img" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image="" />
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="add_myfile.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <input type="file" id="add_myfile" uploader="uploader" nv-file-select="" onchange="input1.value=this.value" style="/* display: block; */" class="file-btn">
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>     
      
   
      <div class="form-group">
        <div class="label">
          <label>一级菜单：</label>
        </div>
        <div class="field">
          <select name="cid" class="input w50" id="add_oneMenu">
            <option value="">请选择分类</option>
            <!-- 内容 -->
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>二级菜单：</label>
        </div>
        <div class="field">
          <select name="cid" class="input w50" id="add_twoMenu">
            <option value="">请选择分类</option>
            <!-- 内容 -->
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
      
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea class="input" id="add_narration" name="note" style=" height:90px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容：</label>
        </div>
        <div class="field">
          	
		  <textarea name="content" id="add_content" class="input"  style="padding: 0;"></textarea>
		  <div class="tips"></div>
		  <script>
		    var editor;
		    KindEditor.ready(function(K) {
		      editor = K.create('textarea[name="content"]', {
		        allowFileManager : true
		      });
		    });
		  </script>
        </div>
      </div>
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>关键字标题：</label>
        </div>
        <div class="field">
          <input type="text" id="add_keyWord_title" class="input" name="s_title" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>内容关键字：</label>
        </div>
        <div class="field">
          <input type="text" id="add_keyWord" class="input" name="s_keywords" value=""/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>关键字描述：</label>
        </div>
        <div class="field">
          <textarea type="text" id="add_keyWord_desc" class="input" name="s_desc" style="height:80px;"></textarea>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" id="add_seq" class="input w50" name="sort" value="0"  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>发布时间：</label>
        </div>
        <div class="field"> 
          <script src="js/laydate/laydate.js"></script>
          <input type="text" id="add_createTime" class="laydate-icon input w50" name="datetime" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="" style="padding:10px!important; height:auto!important;border:1px solid #ddd!important;" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>作者：</label>
        </div>
        <div class="field">
          <input type="text" id="add_author" class="input w50" name="authour" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>点击次数：</label>
        </div>
        <div class="field">
          <input type="text" id="add_clicks" class="input w50" name="views" value="0" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>显示：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
          
          <label class="button active" id="add_yes">
         	  <span class="icon icon-check"></span>             
              <input name="isshow" value="1" type="radio" checked="checked">是             
          </label>             
        
          <label class="button active" id="add_no">
              <span class="icon icon-times"></span>          	
              <input name="isshow" value="0"  type="radio" checked="checked">否
          </label>
           <div class="tips"></div>   
           </div>       
        </div>
     </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" id="add_button"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
</html>