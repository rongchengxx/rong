<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    
    <title>登录</title>  
    
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/login.js"></script>
    <script src="js/cookie_util.js"></script>
    <script src="js/basevalue.js"></script>
    
<script type="text/javascript">
	$(function() {
		flushValidateCode();//进入页面就刷新生成验证码
	});
	/* 刷新生成验证码 */
	function flushValidateCode() {
		var validateImgObject = document.getElementById("codeValidateImg");
		validateImgObject.src = "${pageContext.request.contextPath}/getSysManageLoginCode.do?time="
				+ new Date();
	}
	
	/*校验验证码输入是否正确*/
	function checkImg(code){
	    var url = "${pageContext.request.contextPath}/checkimagecode.do";
	    $.get(url,{"validateCode":code},function(data){
	         if(data=="ok"){
	        	 $("#code_img").html("验证码正确");
	        }if(data=="empty"){  
	        	$("#code_img").html("验证码为空");
	        }if(data=="error"){
				$("#code_img").html("验证码错误");
				 window.location.href=path+"/admin.do"; 
	          	 flushValidateCode();
	        }
	    });
	}
</script>
    
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
<!--            <form action="login.do" method="post">  
 -->            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div>
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" id="admin_account" name="account" placeholder="登录账号" />
                            <span class="icon icon-user margin-small" style=""></span>
                            
                        </div>
                    </div>
                    <span style="color:red;display:block;height:20px;" id="account_span"></span>
                    <div>
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" id="admin_password" name="password" placeholder="登录密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <span style="color:red;display:block;height:20px;" id="password_span"></span>
                   <div>
							<div class="field">
									<input type="text" class="input input-big" name="validateCode" onblur="checkImg(this.value)"
									id="ImgCode" placeholder="填写右侧的验证码" /> 
									<img id="codeValidateImg" onClick="javascript:flushValidateCode();"
									width="100" height="32" class="passcode"
									style="height: 43px; cursor: pointer;" />
							</div>
						</div>
						 <span style="color: red; display: block;" id="code_img"></span> 
                </div> 
                <div style="padding:30px;"><input type="submit" id="login" class="button button-block bg-main text-big input-big" value="登录">
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>