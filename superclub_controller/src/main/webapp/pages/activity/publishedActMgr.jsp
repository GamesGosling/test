<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>超级俱乐部</title>
<meta charset="UTF-8">
<meta name="keywords" content="超级俱乐部,超级俱乐部,户外活动,微聚,俱乐部">
<meta name="description" content="超级俱乐部是一款基于户外活动的社交应用">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control"
	content="no-cache, no-store, must-revalidate">
<meta http-equiv="Cache" content="no-cache">
<link rel="icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon32.png?vs=200.13">
<link rel="shortcut icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon32.png?vs=200.13">
<link rel="apple-touch-icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon57.png?vs=200.13"
	sizes="57x57">
<link rel="apple-touch-icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon114.png?vs=200.13"
	sizes="114x114">
<link rel="apple-touch-icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon72.png?vs=200.13"
	sizes="72x72">
<link rel="apple-touch-icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon80.png?vs=200.13"
	sizes="80x80">
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/baidu/baidu.stat.min.js?vs=200.13"></script>

<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/iwejuba_common.css?vs=200.13">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/title.css">

</head>
<body>

	<div class="top">
		<div class="top_left">
			<a href="javascript:window.location.href='pages/main.jsp'" class="goback">首页</a>
		</div>
		<div class="top_middle">活动管理</div>
		<div class="top_rigth">&nbsp;</div>
	</div>

	<div class="con_div" style="margin-bottom: 20px;">
		<div class="bmgl_nav">
			<ul>
				<li class="nav_zhong"><a class="fabu"
					href="javascript:void(0);">我管理的</a></li>
				<li><a class="baoming" href="javascript:void(0);">我报名的</a></li>
				<div class="border_03" style="clear: both;"></div>
			</ul>
		</div>
		<div class="bmgl_con" id="applyActInfo">
			<div class="bmgl_lie" id="apply_349052" style="position: relative;">
				<h2>湖南暑假度假旅游开始啦</h2>
				<div class="bmgl_bm">
					<div class="left">
						<span class="bm_yjs">已结束</span><strong>报名 : <span>0</span>人
						</strong>
					</div>
					<div class="right">
						<p>
							<span>5</span>看过
						</p>
					</div>
				</div>
			</div>
			<div class="bmgl_lie" id="apply_348436" style="position: relative;">
				<h2>湖北科技学院第二十八届篮球赛开始报名啦</h2>
				<div class="bmgl_bm">
					<div class="left">
						<span class="bm_yjs">已结束</span><strong>报名 : <span>0</span>人
						</strong>
					</div>
					<div class="right">
						<p>
							<span>16</span>看过
						</p>
					</div>
				</div>
			</div>
			<div class="bmgl_lie" id="apply_348299" style="position: relative;">
				<h2>武汉第二十八届龙舟大赛报名开始啦</h2>
				<div class="bmgl_bm">
					<div class="left">
						<span>报名中</span><strong>报名 : <span>0</span>人
						</strong>
					</div>
					<div class="right">
						<p>
							<span>19</span>看过
						</p>
					</div>
				</div>
			</div>
			<div class="bmgl_lie" id="apply_348033" style="position: relative;">
				<h2>咸宁温泉马拉松第二十八届开跑啦</h2>
				<div class="bmgl_bm">
					<div class="left">
						<span class="bm_yjs">已结束</span><strong>报名 : <span>0</span>人
						</strong>
					</div>
					<div class="right">
						<p>
							<span>18</span>看过
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/club/component/public/iclubjq.min.js?vs=200.13"></script>
	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/lib/json2.js?vs=200.13"></script>
	<script type="text/javascript">
		
	</script>
	<div class="loadingDiv"
		style="left: 900px; top: 356px; z-index: 10000; display: none;">
		<p class="pImg" style="margin: 0px;">
			<img
				src="https://cdn2.51julebu.com/club/img/161220143720/77e404dcbef146289132d23b35472817.gif">
		</p>
		<p class="pTxt" style="margin: 0px; color: #fff;">请稍候...</p>
	</div>
	<div id="cover2"
		style="display: none; position: fixed; width: 100%; height: 100%;"></div>
</body>
</html>