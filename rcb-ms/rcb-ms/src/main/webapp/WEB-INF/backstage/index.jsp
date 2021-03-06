<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/cookie_util.js"></script>
    <script type="text/javascript">
    $(function(){
    	// 获取参数userId
		var userId=getCookie("userId");
		//判断userId是否有效
		if(userId==null){
			window.location.href="/rcb-ms";
		}
    });
    </script>
</head>
<body style="background-color:#f2f9fd;">
  <div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
      <h1>
        <img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />
        后台管理中心
      </h1>
    </div>
    <div class="head-l">
      <a class="button button-little bg-green" href="" target="_blank">
        <span class="icon-home"></span> 
        前台首页
      </a> &nbsp;&nbsp;
      <a href="##" class="button button-little bg-blue">
        <span class="icon-wrench"></span> 
        清除缓存
      </a> &nbsp;&nbsp;
      <a class="button button-little bg-red" href="login.html">
        <span class="icon-power-off"></span>
        退出登录
      </a> 
    </div>
  </div>
<div class="leftnav">
  <div class="leftnav-title">
    <strong>
      <span class="icon-list"></span>
      菜单列表
    </strong>
  </div>
  <h2>
    <span class="icon-user"></span>
    基本设置
  </h2>
  <ul style="display:block">
    <li>
      <a href="info.do" target="right">
        <span class="icon-caret-right"></span>
        网站设置
      </a>
    </li>
    <li>
      <a href="pass.do" target="right">
        <span class="icon-caret-right"></span>
        修改密码
      </a>
    </li>
    <li>
      <a href="adv.do" target="right">
        <span class="icon-caret-right"></span>
        首页轮播
      </a>
    </li>   
    <li>
      <a href="book.do" target="right">
        <span class="icon-caret-right"></span>
        留言管理
      </a>
    </li>     
  </ul>   
  <h2>
    <span class="icon-pencil-square-o"></span>
    内容管理
  </h2>
  <ul>
  	<li>
      <a href="column.do" target="right">
        <span class="icon-caret-right"></span>
        一级菜单
      </a>
    </li>
    <li>
      <a href="cate.do" target="right">
        <span class="icon-caret-right"></span>
        二级菜单
      </a>
    </li>
    <li>
      <a href="add.do" target="right">
        <span class="icon-caret-right"></span>
        添加内容
      </a>
    </li>
    <li>
      <a href="list.do" target="right">
        <span class="icon-caret-right"></span>
        内容管理
      </a>
    </li>
  </ul>
</div>
<ul class="bread">
  <li>
    <a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a>
  </li>
  <li>
    <a href="##" id="a_leader_txt">网站信息</a>
  </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info.do" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
  <p>来源:
    <a href="http://down.admin5.com/" target="_blank">A5源码</a>
  </p>
</div>
</body>
</html>