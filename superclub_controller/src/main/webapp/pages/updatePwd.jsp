<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/plugins/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container" >

<form  action ="${pageContext.request.contextPath}/user/updatePwd" method ="post" > 
  
  <input  type="hidden"  value ="${currentUser.userId}" name="userId" >
  <div class="form-group">
    <label for="InputPassword1">密码</label>
    <input type="password" class="form-control col-sm-6 control-label" name ="userPassword" id="InputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="InputPassword2">重复密码</label>
    <input type="password" class="form-control col-sm-6 control-label" id="InputPassword2" placeholder="Password">
  </div>

  <button type="submit" class="btn btn-default">提交</button>
</form>
</div>

</body>
</html>