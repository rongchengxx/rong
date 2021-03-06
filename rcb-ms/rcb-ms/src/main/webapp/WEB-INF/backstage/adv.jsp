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
<script src="js/basevalue.js"></script>
<script src="js/adv.js"></script>
<script src="js/cookie_util.js"></script>
    
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <table class="table table-hover text-center" id="adv_table">
    <tr>
      <th width="10%">ID</th>
      <th width="20%">URL</th>
      <th width="15%">名称</th>
      <th width="20%">描述</th>
      <th width="10%">排序</th>
      <th width="15%">操作</th>
    </tr>
    
  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){
	
	}
}
</script>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">    
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" id="advAdd_title" name="title" data-validate="required:请输入标题"/>
          <span id="advAdd_title_span" style="color:red;"></span>	
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>URL：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="advAdd_url" name="url" value="" data-validate="required:请输入URL" />
          <span id="advAdd_url_span" style="color:red;"></span>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <input type="text" id="adv_thumb" id="advAdd_link" name="img" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
          <button type="button" class="btn btn-warning btn-s file-button" id="btn1" onclick="adv_myfile.click();" style="float: left;">
            <span class="glyphicon glyphicon-ban-circle"></span>十上传
          </button>
          <span id="advAdd_link_span" style="color:red;"></span>
          <input type="file" id="adv_myfile" uploader="uploader" nv-file-select="" onchange="input1.value=this.value" style="/* display: block; */" class="file-btn">
          <div class="tipss">图片尺寸：1920*500</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" id="advAdd_content" name="note" style="height:120px;" value="" data-validate="required:请输入描述内容"></textarea>
          <span id="advAdd_content_span" style="color:red;"></span>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="advAdd_seq" name="sort" value="0"  data-validate="required:,number:排序必须为数字" />
          <span id="advAdd_seq_span" style="color:red;"></span>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" id="adv_button"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>