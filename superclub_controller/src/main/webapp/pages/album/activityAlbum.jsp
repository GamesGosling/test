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
<title>相册</title>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/fontawesome/css/font-awesome.css?vs=200.13">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/superclub_base.css_00223.css">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/title.css">
<!--懒加载-->
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/public/iclubjq.min.js?vs=200.13"></script>
<style type="text/css">
a.b-nav__item.act>span {
	color: #ff4c48;
	border-bottom: 4px solid #ff4c48;
}

a.b-nav__item>span {
	display: inline-block;
	padding: 0 4px;
	height: 31.5px;
	border-bottom: 4px solid #fff;
}
</style>
<link type="text/css" rel="styleSheet" id="layermcss">
</head>
<body style="background: #ebebeb">
	<div class="top">
		<div class="top_left">
			<a href="javascript:window.location.href='pages/main.jsp'" style="cursor: pointer;" class="goback">首页</a>
		</div>
		<!-- 	<div class="top_middle">
			<a id="myalbumNav" class="pointer"><span id="albumName">我的相册</span>
				<span class="fa fa-angle-down"></span>
				<ul id="clubAlbum" class="album_select">
					<li class="album_select_active">我的相册<span class="fa fa-check-circle-o right"></span></li>
					<a class="text-black" href="album_details.html"><li>我的相册俱乐部（125）</li></a>
			<a class="text-black" href="album_details.html"><li>我的相册俱乐部（125）</li></a>
			<a class="text-black" href="album_details.html"><li>我的相册俱乐部（125）</li></a>
			<a class="text-black" href="album_details.html"><li>我的相册俱乐部（125）</li></a>
				</ul> </a>
		</div> -->
		<div class="top_rigth">&nbsp;</div>
	</div>

	<div class="main bg-fff"
		style="padding-bottom: 200px; background: #ebebeb; margin-top: -40px;">
		<div
			style="width: 100%; height: 90px; position: relative; background-color: #fff; text-align: center;"
			class="b-content g-bgc">
			<div style="width: 100%; height: 55px;" class="b-fixedMask"></div>
			<div class="b-nav g-bgc_white l-tac g-fs_12">
				<a
					style="display: block; width: 50%; height: 100%; float: left; color: #a9a8a8;"
					href="javascript:void(0)" onclick="_AlbumDetail._titleClick(1);"
					class="b-nav__item" id="actInfo"><span>我的相册</span></a> <a
					style="display: block; width: 50%; height: 100%; float: left; color: #a9a8a8;"
					href="javascript:void(0)" onclick="_AlbumDetail._titleClick(0);"
					class="b-nav__item act" id="applyInfo"><span>活动相册</span></a>
			</div>
			<!-- .b-nav -->

			<input type="hidden" id="data" datas="">

			<div
				style="content: ''; display: block; width: 0; height: 24px; border-right: 1px solid #dedede; position: absolute; left: 50%; top: 50%; margin-top: 12px;"
				class="b-getPerson g-fs_13"></div>
			<!-- .b-getPerson__body -->
		</div>
		<ul class="albums" id="activityAlbums">
			
		</ul>
		<div style="clear: both;"></div>
	</div>
	<div class="bg-opacity"></div>
	<!--新建相册-->
	<div class="newBuildDIV">
		<div class="newBuild f15">新建相册</div>
		<div class="writeName f12">请输入相册名字：</div>
		<input class="outDoorAct" placeholder="户外活动">
		<ul class="sureOrNot">
			<li class="left" style="cursor: pointer;" id="quxiao">取消</li>
			<li class="right" style="cursor: pointer;" id="sure">确定</li>
		</ul>
	</div>
	<script
		src="https://o6fvpth3b.qnssl.com/club/component/layer/layer.min.js?vs=200.13"></script>
	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/club/component/public/iclubjq.min.js?vs=200.13"></script>
	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/lib/json2.js?vs=200.13"></script>

	<div class="loadingDiv"
		style="left: 889.5px; top: 356px; z-index: 10000; display: none;">
		<p class="pImg" style="margin: 0px;">
			<img
				src="https://cdn2.51julebu.com/club/img/161220143720/77e404dcbef146289132d23b35472817.gif">
		</p>
		<p class="pTxt" style="margin: 0px; color: #fff;">正在加载中</p>
	</div>
	<div id="cover2"
		style="position: fixed; width: 100%; height: 100%; display: none;"></div>
<script type="text/javascript">
	//活动相册展示
	$.ajax({
		url:'${pageContext.request.contextPath}/album/getActivityAlbums?new Date()',
		method:'post',
		dataType:'json',
		success:function(data){
			console.log(data);
			var result = data.result;
			var ss = "";
			for(index in result){
				var photoCnt;
				var albumId = result[index].id;
				var activityId = result[index].activityId;
				var direction;
				if(index % 2 == 0){
					direction = "left";
				}else{
					direction = "right";
				}
				$.ajax({
					url:'${pageContext.request.contextPath}/album/getPersonalAlbumPhotoCnt?new Date()',
					method:'post',
					dataType:'json',
					async : false,
					data:{
						albumId:albumId
					},
					success:function(suc){
						console.log(suc);
						photoCnt = suc.result;
					},
					error:function(){
						console.log(err);
					}
				})
				ss = ss
				+ "<li class="+direction+" data='"+albumId+"' albumName='"+result[index].albumName+"' activityId='"+activityId+"' onclick='getAlbumPhotos(this)'>"
				+ "<img src='"+result[index].albumDefaultPicture+"'>"
				+ "<div class='albums_details'><div class='albums_details_div'>"
				+ "<div class='albums_details_title f14 text-fff'>"+result[index].albumName+"</div>"
				+ "<div class='albums_details_num f10 text-fff'>"+photoCnt+"</div>"
				+ "</div></div></li>";
			}
			$("#activityAlbums").append(ss);
		},
		error:function(err){
			console.log(err);
		}
	});
//跳到相片展示页面
function getAlbumPhotos(album){
	var albumId=$(album).attr("data");
	var activityId = $(album).attr("activityId");
	var albumName = $(album).attr("albumName");
	window.location.href="pages/album/albumPhoto.jsp?albumId="+albumId+"&activityId="+activityId+"&albumName="+albumName+"";
}
//个人相册链接
$("#actInfo").on("click",function(){
	window.location.href="pages/album/personalAlbum.jsp";
});
</script>
</body>
</html>