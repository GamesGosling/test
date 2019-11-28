<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
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
	src="${pageContext.request.contextPath}/static/plugins/jquery/jquery-3.3.1.min.js"></script>
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
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/superclub_base.css_00223.css" />
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/title.css" />
	

</head>

<body>
	<div class="top">
		<div class="top_left">
			<a href="${pageContext.request.contextPath }/pages/main.jsp"
				class="goback">首页</a>
		</div>
		<div class="top_middle">我的游记</div>
		<div class="top_rigth">&nbsp;</div>
	</div>
	<div class="main">
		<div class="Travels" style="cursor: pointer;">
			发布游记 <span class="isShowDraft"
				style="color: #FFDD48; font-size: 12px; display: none;">[草稿]</span>
		</div>
		<div class="myTravels mainBody">
			<ul class="myTravelsShow">
				<li style="border-bottom: none;"
					onclick="_myTravels._gotoArtDetail(147941)"><div
						class="myTravels_details" style="height: 70px;">
						<div class="myTravels_IMg" style="margin-right: 10px;">
							<img style="border-radius: 5px;"
								src="https://cdn2.51julebu.com/club/img/190627/a645c5587c4e4bf19d8356e893fd8413.jpg_40x40.jpeg_70x70.jpeg">
						</div>
						<div class="myTravels_details-title">test</div>
						<div class="myTravels_details-timeAND">
							<span class="time-info">06-27 10:51</span><span>47阅读 0分享</span>
						</div>
					</div>
					
					</li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
</body>

<script type="text/javascript">

$(function(){
	
	$.ajax({
		url : "${pageContext.request.contextPath}/travel/list",  //发送请求 
		type : "post",
		success : function(re) {
			alert("success");
			console.log(re.result);
		}
	});
	
	
});
</script>

</html>
<script type="text/javascript" src="../js/config.js?vs=200.13"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/lib/json2.js?vs=200.13"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/public/iclubjq.min.js?vs=200.13"></script>
<script type="text/javascript"
	src="../js/public/iwejuba_common.js?vs=300.13"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/pages/myTravels.js?vs=200.13"></script>
<script type="text/javascript">
	_myTravels._init();
</script>