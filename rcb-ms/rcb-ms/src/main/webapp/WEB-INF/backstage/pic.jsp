<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>请选择图片</title>
</head>
<body>
   <form action="uploadServlet"enctype="multipart/form-data" method="POST" >
     
      请选择图片: <input type="file"name="myfile"/><br>
      <input type="submit"value="upload"/>
   </form>
</body>
</html>