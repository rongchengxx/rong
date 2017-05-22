<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit"></meta>
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
    <script src="js/cookie_util.js"></script>
    <script src="js/book.js"></script>
</head>
<body>
<form id = "fm1">
	<input type="hidden" name="now_page" /> 
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall" onclick="checkAll()"><span class="icon-check"></span>  反选</button>
          <button type="button"  class="button border-red" onclick="DelSelect()"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center" id = "booktable">
      <%-- <tr>
        <th width="120">ID</th>
        <th>姓名</th>       
        <th>电话</th>
        <th>邮箱</th>
        <th>其他</th>
        <th width="25%">内容</th>
         <th width="120">留言时间</th>
        <th>操作</th>       
      </tr>
        <tr>
          <td><input type="checkbox" name="id" value="1" />1</td>
          <td>神夜</td>
          <td>13420925611</td>
          <td>564379992@qq.com</td>  
           <td>深圳市民治街道</td>         
          <td>这是一套后台UI，喜欢的朋友请多多支持谢谢。</td>
          <td>2016-07-01</td>
          <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
        <tr>
          <td><input type="checkbox" name="id" value="2" />2</td>
          <td>神夜</td>
          <td>13420925611</td>
          <td>564379992@qq.com</td>  
           <td>深圳市民治街道</td>         
          <td>这是一套后台UI，喜欢的朋友请多多支持谢谢。</td>
          <td>2016-07-01</td>
          <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
        
      <tr id = "page_tr">
        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a onclick="loadBook(2)">2</a><a onclick="loadBook(1)">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr> --%>
    </table>
  </div>
</form>

</body></html>