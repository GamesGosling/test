<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>
<html>
<head>
<title>超级俱乐部</title>
<meta charset="UTF-8" />
<meta name="keywords" content="超级俱乐部,超级俱乐部,户外活动,微聚,俱乐部" />
<meta name="description" content="超级俱乐部是一款基于户外活动的社交应用" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Cache" content="no-cache" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap/js/popper.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/plugins/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
<link rel="icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon32.png?vs=200.13">
<link rel="shortcut icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon32.png?vs=200.13">
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/baidu/baidu.stat.min.js?vs=200.13"></script>
<!--字体图标文件引入-->
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/ueditor/third-party/fontawesome/css/font-awesome-ie7.min.css?" />
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/ueditor/third-party/fontawesome/css/font-awesome.css?vs=200.13" />
<link rel="stylesheet"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/fontawesome/css/font-awesome.min.css?vs=200.13" />
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/club/component/layer/layer.min.css?vs=200.13" />
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/superclub_base.css_00223.css" />
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/title.css" />
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=kUy5jZSBovGvf3eCxnU5Gd8b5XdOU1Gb"></script>
</head>

<body>
	<div class="top">
		<div class="top_middle">超级俱乐部，你的活动组织工具</div>
		<div class="top_rigth">&nbsp;</div>
		<c:if test="${not empty currentUser}">

			<div id="dropdown" class="dropdown">
				<button type="button" style="margin-left:10px;margin-top: 5px; width: 160px;background-color:#3ED1A5;border-color:#3ED1A5;"
					class="btn btn-info dropdown-toggle" data-toggle="dropdown">设置</button>

				<div class="dropdown-menu" style="text-align:center;">
					<a class="dropdown-item" data-toggle="modal"
						data-target="#updateModal">编辑</a> <a class="dropdown-item"
						data-toggle="modal" data-target="#userAdvice">意见反馈</a> <a
						class="dropdown-item" data-toggle="modal"
						data-target="#updatePwdModal">修改密码</a> <a id="loginOut"
						class="dropdown-item" data-toggle="modal" data-target="#loginOut">退出</a>
				</div>

			</div>
		</c:if>

	</div>
	<div class="main">

		<!--  未登录  -->
		<div id="login_no">
			<div class="no_login" style="margin: 0 auto; text-align: center;">
				<div style="">
					<img id="headPhoto" style="width: 95px; margin: 15px 0;"
						src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/login_no-1.png?vs=200.13" />
				</div>
				<span data-toggle="modal" data-target="#myModal2" id="login"
					style="display: inline-block; font-size: 16px; border-radius: 40px; color: #fff; height: 40px; line-height: 40px; width: 180px; background: #10be4a; cursor: pointer;">
					一键登录 </span>
			</div>
			<br />
			<div style="margin: 0 auto; text-align: center;">
				没有账号,<a
					href="${pageContext.request.contextPath }/pages/register.jsp">去注册></a>
			</div>

		</div>
		<!-- 已登录 -->
		<div id="login_yes" class="login_yes" style="display: none">
			<div>
				<img id="myImg" onclick="_login._showLogoutDiv()" width="100"
					height="100" class="pointer"
					src="http://120.79.191.71/${currentUser.headPortrait}" />
			</div>
			<p>
				<span id="nickname">${currentUser.nickName}</span>
			</p>
		</div>

		<ul style="height: 105px; margin-bottom: 7px; margin-top: 25px;">
			<li class="act">
				<!--组织活动  -->
				<div id="activity_publish" class="act-classify organizeAct pointer">
					<div class="organizeActIMG">
						<img src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/organization@3x.png?vs=200.13"/>
					</div>
					<a class="organizeActTitle">组织活动</a>
					<div class="draftShow" style="display: none;">
						<a class="draft">[草稿]</a>
					</div>
				</div> <!-- 管理活动 -->
				<div id="manager_publish" class="act-classify manageAct pointer">
					<div class="organizeActIMG">
						<img
							src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/manage@3x.png?vs=200.13" />
					</div>
					<a class="organizeActTitle">管理活动</a>
				</div> <!-- 我的游记 -->
				<div id="manager_artpublish" class="act-classify manageAct pointer">
					<div class="organizeActIMG">
						<img
							src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/myTravels.png?vs=200.13" />
					</div>
					<a class="organizeActTitle">我的游记</a>
					<div class="artDraftShow" style="display: none;">
						<a class="draft">[草稿]</a>
					</div>
				</div> <!-- 管理相册 -->
				<div id="manager_album" class="act-classify manageAct pointer">
					<div class="organizeActIMG">
						<img
							src="https://cdn2.51julebu.com/club/img/160531093852/49d66b879cbd43d99e94b3026043d0c8.png" />
					</div>
					<a class="organizeActTitle text-black">相册</a>
				</div>
			</li>
		</ul>

		<!-- 热门活动 -->
		<div class="activity" style="overflow: hidden;">
			<div class="titleArea ">
				<span class="title left"><img
					src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/hotAct.png?vs=200.13" />热门活动</span>
				<span id="hotActMore" class="more right pointer">更多 ></span>
			</div>

			<div id='hotActivity'>
				<div id="hotActivityArea">
					
				</div>
			</div>
		</div>

		<!-- 同城活动 -->
		<div class="activity" style="overflow: hidden;">
			<div class="titleArea ">
				<span class="title left"><img
					src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/hotAct.png?vs=200.13" />同城活动</span>
				<span id="sameCityActMore" class="more right pointer">更多 ></span>
			</div>

			<div id='sameCityActivity'>
				<div id="sameCityActivityArea"></div>
			</div>
		</div>

		<!-- 热门游记开始 -->
		<div class="activity" style="overflow: hidden;">
			<div class="titleArea">
				<span class="title left"><img
					src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/hotArt.png?vs=200.13" />热门游记</span>
				<span id="hotArtMore" class="more right pointer">更多 ></span>
			</div>
			<div id='hotArt'>
				<div id="hotArticleArea"></div>
			</div>

		</div>
		<!-- 最新活动 -->
		<div class="activity" style="overflow: hidden;">
			<div class="titleArea">
				<span class="title left"><img
					src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/newAct.png?vs=200.13" />最新活动</span>
				<span id="newActMore" class="more right pointer">更多 ></span>
			</div>
			<div id='newActivity'>
				<div id="newActivityArea"></div>
			</div>
		</div>

		<ul class="bottomArea">
			<!-- <li id="oldUrl">旧版入口(老用户可点击此入口，查询活动历史记录)>></li> -->

			<li>版权所有&nbsp;&nbsp;盗版必究</li>
		</ul>
	</div>


	<!-- 登录模态框 -->
	<!-- Modal -->
	<!-- <div class="modal fade" id="login_modal" tabindex="-1" role="dialog"
		aria-labelledby="loginLeModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginLeModalLabel">请输入登录信息</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					账号：<input type="text" id="telephone"><br> <br>密码：
					<input type="password" id="passWord">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="enter">登录</button>
				</div>
			</div>
		</div>
	</div> -->

	<!-- 登录模态框 -->
	<!-- Modal2 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">	
				<div class="modal-header">
					<div style="width: 100%;text-align: center;">
							<font size="6" style="margin-top: 10px;font-family: '宋体' ">用户登录</font>
					</div>	
				</div>				
				<div class="modal-body">
					<form class="form-horizontal">
						
							<div class="row form-group">								
								<div class="col-lg-1 col-md-1">	
											
								</div>
								<div class="col-lg-10 col-md-10 input-group">
									<span style="margin-top:10px;margin-right:10px;font-family: '楷体' ;font-size: 15px;">用户名:</span>
									<input class="form-control" style="border-radius: 5px;" placeholder="请输入用户名" type="text" id="telephone">
								</div>
			
							</div>
							<div class="row form-group">	
								<div class="col-lg-1 col-md-1">									
								</div>
								<div class="col-lg-10 col-md-10 input-group">
									<span style="margin-top:10px;margin-right:10px;font-family: '楷体' ;font-size: 15px;letter-spacing:0.35em;">密码:</span>
									<input class="form-control" placeholder="请输入密码" style="border-radius: 5px;" type="password" id="passWord">
								</div>
							</div>
						
					</form>
				</div>
				
				<div class="modal-footer">
					<div class="col-md-8">					
						<button type="button" class="btn btn-info" style="margin-right: 10px;" data-dismiss="modal">关闭</button>
						<button type="button" id="enter" class="btn btn-primary"
							data-dismiss="modal" style="margin-left: 10px;">确认</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 修改模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="updatModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="updatModalLabel">请输入修改信息</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="updateForm" method="post" enctype="multipart/form-data">
						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">昵称 </label> <input type="text"
								name="nickName" class="form-control"
								value="${sessionScope.currentUser.nickName }">
						</div>
						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">性别 </label>
						</div>

						<div class="form-check" style="width: 400px; margin: 0 auto">
							<input class="form-check-input" type="radio" name="sex"
								id="exampleRadios1" value="M"
								<c:if test="${sessionScope.currentUser.sex eq 'M' }">checked</c:if>>
							<label class="form-check-label" for="exampleRadios1"> 男 </label>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="form-check-input"
								type="radio" name="sex" id="exampleRadios2" value="F"
								<c:if test="${sessionScope.currentUser.sex eq 'F' }">checked</c:if>>
							<label class="form-check-label" for="exampleRadios2"> 女 </label>
						</div>


						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">年龄 </label> <input type="text"
								name="age" class="form-control"
								value="${sessionScope.currentUser.age }">
						</div>

						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">电话号码 </label> <input type="text"
								name="telephone" class="form-control"
								value="${sessionScope.currentUser.telephone }">
						</div>

						<div class="form-group" style="width: 400px; margin: 0 auto">
							<input type="hidden" name="userId" class="form-control"
								value="${sessionScope.currentUser.userId }">
						</div>

						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">个性签名 </label> <input type="text"
								name="personalizedSignature" class="form-control"
								value="${sessionScope.currentUser.personalizedSignature }">
						</div>

						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">邮编 </label> <input type="text"
								name="post" class="form-control"
								value="${sessionScope.currentUser.post }">
						</div>
						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">家乡 </label> <input type="text"
								name="hometown" class="form-control"
								value="${sessionScope.currentUser.hometown }">
						</div>


						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">居住地 </label> <input type="text"
								name="city" class="form-control"
								value="${sessionScope.currentUser.city }">
						</div>

						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">邮箱</label> <input name="email"
								type="email" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp"
								value="${sessionScope.currentUser.email }">
						</div>

						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleFormControlTextarea1">爱好</label>
							<textarea name="hobby" class="form-control"
								id="exampleFormControlTextarea1" rows="3">${sessionScope.currentUser.hobby }</textarea>
						</div>

						<div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleFormControlFile1">头像</label> <input
								type="file" class="form-control-file"
								id="exampleFormControlFile1" name="upload">
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="doupdate">提交</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 修改密码模态框 -->
	<div class="modal fade" id="updatePwdModal" tabindex="-1" role="dialog"
		aria-labelledby="updatPwdModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="updatModalLabel">身份验证</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<%-- <div class="form-group" style="width: 400px; margin: 0 auto">
							<label for="exampleInputEmail1">昵称 </label> <input type="text"
								name="nickName" class="form-control"
								value="${sessionScope.currentUser.nickName }">
						</div> --%>

					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-sm-6 control-label">手机号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="phone"
									name="telephone" value="${sessionScope.currentUser.telephone }"
									placeholder="请输入您的手机号" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">验证码</label>
							<div class="col-sm-3">
								<input style="float: left" type="text" class="form-control"
									id="code" name="code" placeholder="验证码" required>
							</div>
							<div style="float: right; margin-right: 150px" class="col-sm-3">
								<input class="btn" id="btn" name="btn" value="发送验证码"
									onclick="sendMessage()" />
							</div>
						</div>
						<div style="margin-top: 75px" class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-success" id="next">下一步</button>
							</div>
						</div>
					</form>

				</div>

			</div>
		</div>
	</div>


	<!-- 意见反馈模态框 -->
	<div class="modal fade" id="userAdvice" tabindex="-1" role="dialog"
		aria-labelledby="#userAdviceModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginLeModalLabel">请输入反馈信息</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="adviceForm">
					<div class="modal-body">

						<label for="exampleFormControlTextarea2">联系方式:</label> <input
							type="text" name="contactWay" id="contactWay"
							value="${sessionScope.currentUser.telephone}"><br /> <label
							for="exampleFormControlTextarea2">意见:</label>
						<textarea name="advice" class="form-control"
							id="exampleFormControlTextarea2" rows="3">${sessionScope.currentUser.hobby}</textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="adviceSubmit">提交</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$("#enter").click(function() {
			$.ajax({
				url : '${pageContext.request.contextPath}/user/login',
				type : 'post',
				dataType : 'json',
				data : {
					telephone : $("#telephone").val(),
					userPassword : $("#passWord").val()
				},
				success : function(suc) {
					if (suc.code != 200) {
						alert(suc.msg)
					}
					$("#headPhoto").attr("src", suc.result.headPortrait);
					window.location.reload();
				},
				error : function(eor) {
					console.log(eor)
				}
			})
		});

		/* 判断并弹出信息 */
		$(function() {
			<c:if test="${not empty requestScope.msg}">
			alert("${requestScope.msg}");
			</c:if>
		});

		$("#doupdate").click(function() {
			var formdata = new FormData($("#updateForm")[0]);
			$.ajax({
				url : '${pageContext.request.contextPath}/user/update',
				type : 'post',
				dataType : 'json',
				contentType : false, //不设置内容类型
				processData : false, //不处理数据
				data : formdata,
				success : function(suc) {
					console.log(suc);
					alert(suc.msg);
					window.location.reload();
				},
				error : function(eor) {
					console.log(eor)
				}
			})
		});
		$(function() {
			<c:if test="${not empty currentUser}">
			$("#login_no").css("display", "none");
			$("#login_yes").css("display", "block");
			</c:if>

		});

		$("#loginOut")
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath}/user/loginOut";
						});
	</script>

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
		$("#btn")
				.click(
						function() {
							var phone = $("#phone").val();
							if (phone != "") {
								$
										.ajax({
											url : "${pageContext.request.contextPath}/captcha/updatePwd", //发送请求 
											type : "post",
											data : {
												"phone" : phone
											},
											success : function(result) {
												sms = result.result;
											}
										});
							} else {
								alert("请输入手机号");
								return false;
							}
						});
		$("#next").click(function() {
			var code = $("#code").val();
			if (code == "") {
				alert("请输入验证码");
			} else {
				if (sms == code) {
					window.location.href = "updatePwd.jsp";
				} else {
					alert("验证码错误");
				}
				;
			}
			;
		});
	</script>


	<script type="text/javascript">
		$("#adviceSubmit").click(function() {
			alert('111')
			$.ajax({
				url : "${pageContext.request.contextPath}/user/userAdvice", //发送请求 
				type : "post",
				data : $("#adviceForm").serialize()
			});

		});
		
	</script>
	<div id="allmap" hidden="hidden"></div>
	<script type="text/javascript">
		// 百度地图API功能
		var map = new BMap.Map("allmap");
		var point = new BMap.Point(116.331398, 39.897445);
		map.centerAndZoom(point, 12);

		function myFun(result) {
			var cityName = result.name;
			map.setCenter(cityName);
			$
					.ajax({
						url : '${pageContext.request.contextPath}/activity/findSameCityList?new Date()',
						method : 'post',
						dataType : 'json',
						data : {
							location : cityName
						},
						success : function(data) {
							console.log(data.result);
							var result = data.result;
							var ss = "";
								ss = ss
										+ "<div class='activityArea-cell' data-index='0'"
										+ "style='width: 640px; left: 0px; transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);'>";
							for (index in result) {
								ss = ss
										+ "<a href='${pageContext.request.contextPath}/activity/activityDetail?activityId="+result[index].id+"'>"
										+ "<img style='width: 288px; height: 164.57142857142858px' src='"+result[index].activityCover+"'>"
										+ "<span>"+result[index].activityTitle+"</span></a>";
							}
										ss = ss
										+ "</div>";
							$("#sameCityActivityArea").append(ss);
						},
						error : function(err) {
							console.log(err);
						}
					});
		}
		var myCity = new BMap.LocalCity();
		myCity.get(myFun);
	</script>
	<script type="text/javascript">
		$
				.ajax({
					url : '${pageContext.request.contextPath}/activity/findHotList?new Date()',
					method : 'post',
					dataType : 'json',
					success : function(data) {
						console.log(data.result);
						var result = data.result;
						var ss = "";
							ss = ss
									+ "<div class='activityArea-cell' data-index='0'"
									+ "style='width: 640px; left: 0px; transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);'>";
						for (index in result) {
							ss = ss
									+ "<a href='${pageContext.request.contextPath}/activity/activityDetail?activityId="+result[index].id+"'>"
									+ "<img style='width: 288px; height: 164.57142857142858px' src='"+result[index].activityCover+"'>"
									+ "<span>"+result[index].activityTitle+"</span></a>";
						}
									ss = ss
									+ "</div>";
						$("#hotActivityArea").append(ss);
					},
					error : function(err) {
						console.log(err);
					}
				});
	</script>
	<!-- 最新活动 -->
<script type="text/javascript">
		$.ajax({
					url : '${pageContext.request.contextPath}/activity/findLatestList?new Date()',
					method : 'post',
					dataType : 'json',
					success : function(data) {
						console.log(data.result);
						var result = data.result;
						var ss = "";
							ss = ss
									+ "<div class='activityArea-cell' data-index='0'"
									+ "style='width: 640px; left: 0px; transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);'>";
						for (index in result) {
							ss = ss
									+ "<a href='${pageContext.request.contextPath}/activity/activityDetail?activityId="+result[index].id+"'>"
									+ "<img style='width: 288px; height: 164.57142857142858px' src='"+result[index].activityCover+"'>"
									+ "<span>"+result[index].activityTitle+"</span></a>";
						}
									ss = ss
									+ "</div>";
						$("#newActivityArea").append(ss);
					},
					error : function(err) {
						console.log(err);
					}
				});
</script>
<script type="text/javascript">
	$("#hotActMore").on("click",function(){
		window.location.href='${pageContext.request.contextPath}/pages/activity/hotactivity.jsp';
	})
	$("#sameCityActMore").on("click",function(){
		window.location.href='${pageContext.request.contextPath}/pages/activity/samecityactivity.jsp';
	})
	$("#newActMore").on("click",function(){
		window.location.href='${pageContext.request.contextPath}/pages/activity/latestactivity.jsp';
	})
	$("#activity_publish").on("click",function(){
		window.location.href = "activity/publishActivity.jsp";
	})
	$("#manager_album").on("click",function(){
		window.location.href = "album/personalAlbum.jsp";
	})
</script>
</body>
</html>