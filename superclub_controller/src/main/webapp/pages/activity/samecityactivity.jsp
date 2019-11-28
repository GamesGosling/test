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

<link rel="icon"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/img/icon32.png?vs=200.13">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/superclub_base.css_00223.css">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/title.css">

<script src="//hm.baidu.com/hm.js?bf0fe262e26a6d19efeec76b5edd8d9e"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/baidu/baidu.stat.min.js"></script>
<script type="text/javascript" src="static/plugins/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=kUy5jZSBovGvf3eCxnU5Gd8b5XdOU1Gb"></script>
</head>

<body>
	<div class="top">
		<div class="top_left">
			<a href="javascript:window.location.href='pages/main.jsp'" class="goback">首页</a>
		</div>
		<div class="top_middle">热门活动</div>
		<div class="top_rigth">&nbsp;</div>
	</div>

	<div id="sameCityActList" class="main actImg">
		
	</div>

	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/club/component/public/iclubjq.min.js"></script>
	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/club/component/public/json2.min.js"></script>

	<div class="loadingDiv"
		style="left: 900px; top: 356px; z-index: 10000; display: none;">
		<p class="pImg" style="margin: 0px;">
			<img
				src="https://cdn2.51julebu.com/club/img/161220143720/77e404dcbef146289132d23b35472817.gif">
		</p>
		<p class="pTxt" style="margin: 0px; color: #fff;">请稍候...</p>
	</div>
	<div id="cover2"
		style="position: fixed; width: 100%; height: 100%; display: none;"></div>
	<div id="allmap" style="display:none;"></div>
	<script type="text/javascript">
		// 百度地图API功能
		var map = new BMap.Map("allmap");
		var point = new BMap.Point(116.331398, 39.897445);
		map.centerAndZoom(point, 12);

		function myFun(result) {
			var cityName = result.name;
			map.setCenter(cityName);
			$.ajax({
				url:'activity/findMoreSameCityList?new Date()',
				method:'post',
				dataType:'json',
				data : {
					location : cityName
				},
				success:function(data){
					console.log(data);
					var result = data.result;
					var ss = "";
					for(index in result){
						var charge ;
						if(result[index].isCharge==0){
							charge = "免费";
						}else{
							charge = "收费";
						}
						var unixTimestamp = new Date(result[index].activityBeginTime);
						var date =  unixTimestamp.getFullYear() + "年" + (unixTimestamp.getMonth() + 1) + "月" + unixTimestamp.getDate()+"号  " +unixTimestamp.getHours() +":" + unixTimestamp.getMinutes();
						ss = ss + "<div class='actDetails'>"
						+ "<a href='activity/activityDetail?activityId="+result[index].id+"'>"
						+ "<i class='act-Mask'></i>"
						+ "<img src='"+result[index].activityCover+"'>"
						+ "<div class='Details'>"
						+ "<b>"+result[index].activityTitle+"</b>"
						+ "<div><span class='tANDp'>"+date+"</span>"
						+ "<span style='position: absolute; right: 15px; border: 1px solid #fff; border-radius: 5px; padding: 0 5px; font-size: 13px; background: rgba(0, 0, 0, 0.3);'>"+charge+"</span>"
						+ "</div></div></a></div>";
					}
					$("#sameCityActList").append(ss);
				},
				error:function(err){
					console.log(err);
				}
			})
		}
		var myCity = new BMap.LocalCity();
		myCity.get(myFun);
	</script>
</body>
</html>