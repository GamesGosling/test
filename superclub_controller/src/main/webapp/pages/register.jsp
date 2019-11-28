<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/plugins/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
</head>
<body>

	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">请输入个人信息</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="registerForm"
					action="${pageContext.request.contextPath}/user/register"
					method="post" enctype="multipart/form-data">
					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">昵称 </label> <input type="text"
							name="nickName" class="form-control">
					</div>

					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">性别 </label>
					</div>

					<div class="form-check" style="width: 400px; margin: 0 auto">
						<input class="form-check-input" type="radio" name="sex"
							id="exampleRadios1" value="M"> <label
							class="form-check-label" for="exampleRadios1"> 男 </label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="form-check-input"
							type="radio" name="sex" id="exampleRadios2" value="F"> <label
							class="form-check-label" for="exampleRadios2"> 女 </label>
					</div>


					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">年龄 </label> <input type="text"
							name="age" class="form-control">
					</div>

					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">电话号码 </label> <input type="text"
							name="telephone" placeholder="请输入您的手机号" id ="phone" class="form-control">
					</div>
						
					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">密码 </label> <input type="password"
							name="userPassword" class="form-control">
					</div>
					
					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">确认密码 </label> <input type="password"
							 class="form-control">
					</div>

					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">个性签名 </label> <input type="text"
							name="personalizedSignature" placeholder="请输入您的个性签名" class="form-control">
					</div>

					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">邮编 </label> <input type="text"
							name="post" class="form-control">
					</div>
					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">家乡 </label> <input type="text"
							name="hometown" class="form-control">
					</div>


					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">居住地 </label> <input type="text"
							name="city" class="form-control">
					</div>

					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1">邮箱</label> <input name="email"
							type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp">
					</div>

					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleFormControlTextarea1">爱好</label>
						<textarea name="hobby" class="form-control"
							id="exampleFormControlTextarea1" rows="3">${sessionScope.checkedUser.hobby }</textarea>
					</div>

					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleFormControlFile1">头像</label> <input type="file"
							class="form-control-file" name="upload">
					</div>
					
					
					<br/>
					<div class="form-group" style="width: 400px; margin: 0 auto">
						<label for="exampleInputEmail1" >验证码</label>
						<input type="text" id="code" class="col-sm-3" name="code" >
						<input type="button" class="btn btn-default" id="btn" name="btn" value="发送验证码" onclick="sendMessage()">
					
						</div>
						<br/>
				
						
						
						
					<div class="modal-footer">
						<input class="btn btn-primary" type="reset" value="重置"> <input
							type="submit" class="btn btn-primary" id="submitForm" value="提交" />
					</div>
					
					
				</form>
			</div>

		</div>
	</div>
</body>

<script type="text/javascript">
	var InterValObj; //timer变量，控制时间
	var count = 60; //间隔函数，1秒执行
	var curCount;//当前剩余秒数
	function sendMessage() {
		curCount = count;
		$("#btn").attr("disabled", "true");
		$("#btn").val(curCount + "秒后可重新发送");
		InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次请求后台发送验证码 TODO
	}
	//timer处理函数
	function SetRemainTime() {
		if (curCount == 0) {
			window.clearInterval(InterValObj);//停止计时器
			$("#btn").removeAttr("disabled");//启用按钮
			$("#btn").val("重新发送验证码");
		} else {
			curCount--;
			$("#btn").val(curCount + "秒后可重新发送");
		}
	}
</script>

<script type="text/javascript">
	var sms = "";
	$("#btn").click(function() {
		var phone = $("#phone").val();
		if (phone != "") {
			$.ajax({
				url : "${pageContext.request.contextPath}/captcha/register",  //发送请求 
				type : "post",
				data : {
					"phone" : phone
				},
				success : function(result) {
					alert ("=====>");
					sms = result.result;
					//window.location.href="${pageContext.request.contextPath}/pages/+"sms"+";
				}
			});
		} else {
			alert("请输入手机号");
			return false;
		}
	});
	
	$("#submitForm").click(function() {
		var code = $("#code").val();
		if (code == "") {
			alert("请输入验证码");
		} else {
			if (sms == code) {
				alert("ang ====");
				window.location="${pageContext.request.contextPath}/pages/mian.jsp";
			} else {
				alert("验证码错误");
			}
		}
	});
</script>

</html>