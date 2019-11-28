<%@ page language="java" import="com.xtkj.utils.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="keywords" content="超级俱乐部,超级俱乐部,户外活动,微聚,俱乐部">

<meta name="description" content="超级俱乐部是一款基于户外活动的社交应用">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">

<meta itemprop="name" content="自强不息！全民健身为七一献礼">
<meta itemprop="image"
	content="https://cdn2.51julebu.com/club/img/190621/79ee9a9ce7a54ea9b17ed5927208c2dc.jpg_60x60.jpeg">

<title></title>
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/club/component/mui/2.8.0/css/mui.min.css">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/club/component/layer/layer.min.css">
<link rel="stylesheet"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/actdetail/css/base.css_00100.js">
<link rel="stylesheet"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/actdetail/css/detail.css_00100.js">
<script src="//hm.baidu.com/hm.js?bf0fe262e26a6d19efeec76b5edd8d9e"></script>
<script src="static/plugins/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/mui/2.8.0/js/clubmui.min.js"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/public/json2.min.js"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/layer/layer.min.js"></script>
<link type="text/css" rel="styleSheet" id="layermcss">

<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/public/iwejuba_app.js_00100.js"></script>
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/public/superclub_app.js_00100.js"></script>
<!--    <script src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/pages/detail/detail.js_00100.js"></script>-->
<script type="text/javascript"
	src="https://o6fvpth3b.qnssl.com/club/component/baidu/baidu.stat.min.js"></script>
<style>
p {
	font-size: 16px;
	margin-top: 0;
	margin-bottom: 10px;
	color: #000;
}

.mui-slider .mui-slider-group .mui-slider-item {
	width: 100% ! important;
}

#loadAfter {
	width: 100%;
	height: 100%;
	position: fixed;
	z-index: 9999;
	background-color: #f0f0f0;
}

#loadAfter p {
	width: 38px;
	height: 38px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -16px;
	text-align: center;
	margin-bottom: 0px
}

#loadAfter p img {
	width: 38px;
	height: 38px;
}

#loadAfter.anima {
	animation: twinkling 1s;
	-webkit-animation: twinkling 1s;
}

#ad1 {
	display: block;
	width: 100%;
	max-width: 640px;
	height: 15.6vw;
	max-height: 100px;
}

#ad2 {
	display: block;
	width: 100%;
	max-width: 640px;
	height: 47vw;
	max-height: 300px;
}
</style>
</head>
<body>

	<div id="loadAfter" class="anima" style="display: none;">
		<p>
			<img
				src="https://cdn2.51julebu.com/club/img/170918/6cd462da68854391bed0da5e7fca0e11.gif">
		</p>
	</div>

	<div class="main" style="display: block;">

		<div id="otherShow" class="phone-head" style="display: none;">
			<div class="back goback" style="top: 15vw;">
				<img
					src="https://cdn2.51julebu.com/club/img/170609/478b2eaaf5e64a30b5e9e29efbf1ae84.png">
			</div>
		</div>


		<div class="top">
			<div class="top_left">
				<a href="javascript:window.location.href='pages/main.jsp'" class="goback">首页</a>
			</div>
			<div class="top_middle">详情</div>
		</div>


		<div class="wrap" style="padding-top: 47px;">
			<!--顶部广告-->
			<div id="ad1" style="display: none;">
				<a
					href="https://im.51julebu.com/resource/pages/actdetail.html?staticVersion=82.16&amp;id=348335&amp;clubId=5">
					<img style="width: 100%; height: 100%;"
					src="https://cdn.51julebu.com/club/img/190625/e74eeecf5f7b4f5dbcd398fb34f48ce0.jpg">
				</a>
			</div>

			<img class="detail-cover" id="actCover"
				src="${activity.activityCover }"
				onerror="this.src='https://cdn2.51julebu.com/club/img/170605/6390fbd5e401440381e8762a89ae62c3.jpg'">

			<div class="commonAct"  id="activity_detail" data="${activity.id}">
				<div class="detail-message"
					style="padding-bottom: 15px;; padding-top: 19px">
					<p class="detail-theme title">
						<span>${activity.activityTitle }</span>
					</p>
					<div>
						<span class="detail-theme-alpha nickName">${activity.user.nickName }</span> <span
							class="detail-theme-beta shareNum">分享 <span>78</span></span> <span
							class="detail-theme-beta readNum">阅读 <span>${activity.activityViewCount }</span></span>
					</div>
				</div>
				<div class="blank"></div>
				<div class="detail-message">
					<div class="detail-message-content actAddress"
						style="display: none;">
						<div class="detail-message-first">地点</div>

						<div class="detail-message-beta Map" id="jwd">
							<div class="detail-address-alpha txt-hidden address"
								style="padding-right: 42px; width: 58%;"></div>
							<div class="detail-address-beta">
								<a style="display: inline-block;"><img
									class="detail-address-icon"
									src="https://cdn2.51julebu.com/xiaochengxu/image/map.png"></a>
							</div>
						</div>
					</div>
					<div class="content-line actAddress" style="display: none;"></div>
					<div class="detail-message-content">
						<div class="detail-message-first">时间</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha actTime">
							<fmt:formatDate value="${activity.activityBeginTime }" pattern="yyyy年MM月dd HH:mm:ss"/>
							 至
							<fmt:formatDate value="${activity.activityEndTime }" pattern="yyyy年MM月dd HH:mm:ss"/></div>
						</div>
					</div>
					<div class="content-line actFeeTxt" style="display: block;"></div>
					<div class="detail-message-content actFeeTxt"
						style="display: block;">
						<div class="detail-message-first">是否收费</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha feetxt" style="color: #3DD1A4;">
								<c:if test="${activity.isCharge==0 }">免费</c:if>
								<c:if test="${activity.isCharge==1 }">收费</c:if>
							</div>
						</div>
					</div>
					<div class="content-line actFeeTxt" style="display: block"></div>
					<div class="detail-message-content actFeeTxt"
						style="display: block">
						<div class="detail-message-first">保险</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha feetxt" style="color: #3DD1A4;">
								${activity.insuranceChannel }
							</div>
						</div>
					</div>
					<div class="content-line actzhuban"></div>
					<div class="detail-message-content actzhuban">
						<div class="detail-message-first">主办方</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha" style="width: 73%;">
								<img class="detail-host actzhubanlogo"
									src="https://o42nhyss1.qnssl.com/g3/M00/4F/6A/wKgBEFX9E1uANcPtAAA1Sfpcky82854.wj_60x60.jpeg">
								<div class="club-name txt-hidden actzhubantxt">${activity.user.nickName }</div>
							</div>
						</div>
						<img class="right-arrow"
							src="https://cdn2.51julebu.com/xiaochengxu/image/black-errow@2x.png">
					</div>
					<div class="content-line actxiebanfan" style="display: none"></div>
					<div class="detail-message-content actxiebanfan"
						style="display: none">
						<div class="detail-message-first">协办方</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha actxietxt"></div>
						</div>
					</div>
					<div class="content-line"></div>


					<div class="detail-message-content detail-qun-content">
						<div class="detail-message-first">已报名</div>
						<div class="detail-address-alpha txt-hidden"
							style="padding-right: 42px; width: 58%;">
							<span class="haveApply">26队/${activity.activityMaxPeople }</span>&nbsp;&nbsp;&nbsp; <span
								id="lineStart"></span>
						</div>
						<div class="detail-qun groupChat" onclick="_actdetail._goGroup();"
							style="display: none;">
							<div class="detail-qun-line"></div>
							<div class="qun-msg mui-badge count" style="display: none;"></div>
							<img class="detail-qun-icon"
								src="https://cdn2.51julebu.com/club/img/170605/ea273eeb274c438aaa20a8edc7d09746.png">
							<span>活动群</span>
						</div>
					</div>



					<div class="agentAct" style="padding: 8px 0px 20px; display: none;">
						<div class="agentAct detail-agent" id="agent"
							onclick="_actdetail._getAgent();" style="display: none;">代理活动</div>
						<div class="agentAct detail-agent" id="cancelAgent"
							style="display: none;">已代理，邀请会员参加</div>
					</div>
				</div>
			</div>

			<div class="lineAct" style="display: none;">
				<div class="detail-message"
					style="padding-bottom: 15px; margin-bottom: 5px; padding-top: 19px">
					<p class="detail-theme title">
						<span>自强不息！全民健身为七一献礼</span>
					</p>
					<div>
						<span class="detail-theme-alpha nickName">小超</span> <span
							class="detail-theme-beta shareNum">分享 <span>78</span></span> <span
							class="detail-theme-beta readNum">阅读 <span>13979</span></span>
					</div>
					<div class="leadInfo" style="padding-top: 15px"></div>
				</div>
				<div class="detail-gotime gtime">
					<div class="detail-gotime-title">出发时间</div>

					<div class="mui-slider" data-slider="1">
						<div class="mui-slider-group" id="lineStartActs"
							style="transform: translate3d(0px, 0px, 0px) translateZ(0px);">
							<div class="mui-slider-item mui-slider-item-duplicate"></div>
						</div>
					</div>
				</div>
				<div class="detail-message" style="padding-top: 4px;">
					<div class="detail-message-content atime">
						<div class="detail-message-first">时间</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha actTime">07-01 00:00 至
								07-14 23:59</div>
						</div>
					</div>
					<div class="content-line atime"></div>

					<div id="startAdress"></div>

					<div class="detail-message-content actFeeTxt"
						style="display: block;">
						<div class="detail-message-first">费用</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha feetxt" style="color: #3DD1A4;">￥29.8</div>
						</div>
					</div>
					<div class="content-line actFeeTxt" style="display: block;"></div>
					<div class="detail-message-content actzhuban">
						<div class="detail-message-first">主办方</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha" style="width: 73%;">
								<img class="detail-host actzhubanlogo"
									src="https://o42nhyss1.qnssl.com/g3/M00/4F/6A/wKgBEFX9E1uANcPtAAA1Sfpcky82854.wj_60x60.jpeg">
								<div class="club-name txt-hidden actzhubantxt">超级俱乐部-官方活动中心</div>
							</div>
						</div>
						<img class="right-arrow"
							src="https://cdn2.51julebu.com/xiaochengxu/image/black-errow@2x.png">
					</div>
					<div class="content-line actxiebanfan" style="display: none"></div>
					<div class="detail-message-content actxiebanfan"
						style="display: none">
						<div class="detail-message-first">协办方</div>
						<div class="detail-message-beta">
							<div class="detail-address-alpha actxietxt"></div>
						</div>
					</div>
					<div class="content-line"></div>


					<div class="detail-message-content detail-qun-content">
						<div class="detail-message-first">已报名</div>
						<div class="detail-address-alpha txt-hidden"
							style="padding-right: 42px; width: 58%;">
							<span class="haveApply">26队/不限</span>&nbsp;&nbsp;&nbsp; <span
								id="linestatus"></span>
						</div>
						<div class="detail-qun groupChat" onclick="_actdetail._goGroup();"
							style="display: none;">
							<div class="detail-qun-line"></div>
							<div class="qun-msg mui-badge count" style="display: none;"></div>
							<img class="detail-qun-icon"
								src="https://cdn2.51julebu.com/club/img/170605/ea273eeb274c438aaa20a8edc7d09746.png">
							<span>活动群</span>
						</div>
					</div>
				</div>
			</div>
			<div class="blank" style="height: 8px"></div>
			<ul class="detail-tarbar actNav">
				<li class="detail-tarbar-item infoNav" style="width: 25%;">详情</li>
				<li class="detail-tarbar-item guideNav" style="width: 25%;">报名须知</li>
				<li class="detail-tarbar-item PhotoAlbum" style="width: 25%;">相册</li>
				<li class="detail-tarbar-item costNav" style="width: 25%;">费用</li>
			</ul>
			<ul class="line-box actNav">
				<li class="detail-tarbar-line infoNav" style="width: 25%;">
					<div class="tarbar-line" style="display: block;"></div>
				</li>
				<li class="detail-tarbar-line guideNav" style="width: 25%;">
					<div class="tarbar-line" style="width: 56px;"></div>
				</li>
				<li class="detail-tarbar-line PhotoAlbum" style="width: 25%;">
					<div class="tarbar-line"></div>
				</li>
				<li class="detail-tarbar-line costNav" style="width: 25%;">
					<div class="tarbar-line"></div>
				</li>
			</ul>
			<div class="content-line-alpah"></div>
			<ul class="detail-content">
				<li class="detail-content-item"
					style="display: block; padding-top: 10px;">
					<div
						style="padding: 0 15px 3px; display: none; position: relative;"
						class="shareInfo">
						<img class="comment-list-img" id="recomClubPhoto"
							src="https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png_60x60.jpeg">
						<div class="comment-list-message"
							style="border-bottom: 0px; margin-left: 35px;">
							<p class="comment-list-host" id="recomClubNick">1100用户54</p>
							<p class="comment-list-content" id="recomInfo"></p>
						</div>
						<img class="sem-photo-left"
							src="https://cdn2.51julebu.com/club/img/170523/435bfc5d7ea642089d0e6054bada38d5.png_13x13.jpeg">
						<img class="sem-photo-right"
							src="https://cdn2.51julebu.com/club/img/170523/7e70a40352c145499a923ca29e12de9a.png_13x13.jpeg">
					</div> <!-- <div class="content-line-alpah shareInfo" style="display: none;margin: 0px 15px 15px;"></div> -->
					<div style="padding: 0 15px 15px;" class="actDetail"
						id="actContent">
						<div style="line-height: 25px; font-size: 16px; word-break: break-all; word-wrap: break-word; text-align: justify; text-justify: inter-ideograph;">
							${activity.activityDetail }
						</div>
					</div>
					<div class="apply-list-end">
						<span id="deadlineTime">报名截止：<fmt:formatDate value="${activity.activityEndTime }" pattern="yyyy年MM月dd HH:mm:ss"/></span>
					</div>
					 <!--<div style="padding: 0 15px 15px; font-size: 15px; " >
						<span id="">温馨提示：打开超级俱乐部APP报名活动，可免费申请价值6万元户外运动险
							<a style="color: #267ca9;" href="insur_detail_six.html" style="text-decoration: underline;"> 申请规则</a>
						</span>
               		 </div>--> 
                	<!--底部广告-->
					<div id="ad2" style="display: none;">
						<a
							href="https://im.51julebu.com/resource/pages/actdetail.html?staticVersion=82.16&amp;id=348335&amp;clubId=5">
							<img style="width: 100%; height: 100%;"
							src="https://cdn.51julebu.com/club/img/190621/79ee9a9ce7a54ea9b17ed5927208c2dc.jpg">
						</a>
					</div>

					<div class="blank"></div>


					<div class="detail-apply">
						点赞(<span id="num">0</span>)
						<div class="detail-comment-beta" id="okNum">
							<img style="width: 15px; height: 13px" class="dzan_quxiao"
								src="https://cdn2.51julebu.com/club/img/170413/884fba3f40d44369a594507fefa906b1.png">
							赞
						</div>
					</div>
					<p class="detail-laud" style="display: none;" id="nonePraise">点赞吧</p>
					<div class="detail-laud-box"
						style="padding-right: 5px; height: auto; min-height: 30px">
						<div class="detail-laud-alpha zanimg" style="padding-right:5px;" id="yesPraise">
							<!-- 点赞图片列表 -->
							<div style="display: inline-block;" userid="2253820">
								<img class="detail-laud-photo"
									src="https://cdn2.51julebu.com/club/img/170213/d50a76da5465469f976d8692f622d857.jpg_60x60.jpeg"
									onerror="this.src='https://o6fvpth3b.qnssl.com/club/images/public/default2.PNG'">
							</div>
													
						</div>
					</div>
					<div class="blank"></div>
					<div class="detail-apply registered" style="padding-bottom: 8px">
						已报名<span id="actApplyNum">(26个队伍)</span>
						<div class="detail-apply-amount" id="applyNum">
							<span>队伍名额不限</span>
						</div>
					</div>
					<div class="actApplyList">
						<div class="apply-list" groupnum="T091">
							<img class="apply-list-photo"
								src="https://o42nhyss1.qnssl.com/club/img/160315150641/676d9ea8432d4f55b9b667d5e1a6454d.jpeg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T091&nbsp;&nbsp;定兴美利达&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">6分钟前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T088">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com//club/img/190623/74c69cfe676540ed83b2fdbad190c633.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T088&nbsp;&nbsp;速度70迈（贵州跑友）&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">2小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T087">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com//club/img/190626/cb2eb774b8e849e1b526b153c964abae.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T087&nbsp;&nbsp;红花会&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">2小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T085">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com//club/img/180831/09f532b843804c78976b31c9b7cb3ca1.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T085&nbsp;&nbsp;勇往直前&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">4小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T079">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com/club/img/180712/c42f99e215394ec49a4223c2d68db293.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T079&nbsp;&nbsp;山东扬帆户外俱乐部&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">6小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T081">
							<img class="apply-list-photo"
								src="https://o42nhyss1.qnssl.com/club/img/160311122228/f0099448620c4282af8018c128d08d72.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T081&nbsp;&nbsp;迷昜山水徒步运动协会&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">7小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T074">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com/club/img/181218/dc780cc0e155425aba771ca7ebac86bb.jpeg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T074&nbsp;&nbsp;福清市自行车运动协会&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">7小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T072">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com/club/img/171019/d6e0ef6bc4ce453a8afbfd8ef5846d5e.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T072&nbsp;&nbsp;新泰捷安特&nbsp;&nbsp;3/不限</span>
								<div class="apply-list-beta">8小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T068">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com//club/img/190119/bcdc498c8e584aa1aa735c7b9b10fc91.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T068&nbsp;&nbsp;山途7.1健走团&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">16小时前</div>
							</div>
						</div>
						<div class="apply-list" groupnum="T060">
							<img class="apply-list-photo"
								src="https://cdn2.51julebu.com/club/img/170717/055f0390ea954784921ca47d899bccce.jpg"
								onerror="this.src='https://cdn2.51julebu.com/club/img/170511/4849c55d499e43e89a1394706643557c.png'">
							<div class="apply-list-desc" style="margin-top: -28px">
								<span class="apply-list-alpha">T060&nbsp;&nbsp;山后骑行联盟&nbsp;&nbsp;1/不限</span>
								<div class="apply-list-beta">昨天 21:56</div>
							</div>
						</div>
					</div>
					<div class="applyLoadMore"
						style="padding-left: 15px; padding-right: 15px;">
						<div class="apply-list-more" style="border-top: 1px solid #e6e6e6">加载更多</div>
					</div>
					<div class="blank"></div>
					
					
					
					
					<!-- 评论按钮 -->
					<div class="detail-apply">
						评论(<span id="actCommentNum">1</span>条)
						<div class="detail-comment-beta actComment" id="detail-apply-comment">我要评论</div>
					</div>
					
					<ul class="actCommentList" id="actCommentLists">
						<li class="comment-list"><img class="comment-list-img" src="https://cdn2.51julebu.com/club/img/161002122245/326a3fc90ec44c129a1059b36cf62070.jpeg_60x60.jpeg">
							<div class="comment-list-message" onclick="showCommentBox('1000600','小凤凤','483406',false)">
								<p class="comment-list-host">小凤凤<span class="comment-list-beta">06-25 17:55</span></p>
								<p class="comment-list-content">跑起来，动起来！我们不是东亚病夫！</p>
							</div>
						</li>
						<div class="comment-line"></div>
					
						
					</ul>
					<div class="comment-line" style="margin-left: 0px;"></div>
					<div class="apply-list-more commentLoadMore" style="display: none;">加载更多</div>
					<div class="blank"></div>
					<div class="activity-list-box ohter">
						<div class="activity-list-title">
							<span class="line-item"></span><span class="activity-list-txt">俱乐部其他活动</span><span
								class="line-item"></span>
						</div>
						<ul id="clubOhterActs">
							<li class="activity-list-item"
								onclick="_actdetail._goDetail(348932)"><img
								class="activity-list-alpha"
								src="https://cdn2.51julebu.com/club/img/190625/8ed6797a524940db955925f07eb587e2.png">
							<div class="activity-list-beta">
									<p class="activity-list-theme two-line-hidden">领队，快收下这份价值200万的赔偿金！</p>
									<p class="activity-txt">时间 06-26-07-24</p>
									<p class="activity-txt">
										<span>报名 250</span><span class="activity-txt-beta"
											style="color: #3DD1A5; font-size: 15px;">免费</span>
									</p>
								</div></li>
							<li class="activity-list-item"
								onclick="_actdetail._goDetail(348057)"><img
								class="activity-list-alpha"
								src="https://cdn2.51julebu.com/club/img/190620/9fda80ea21744eb6b23a3136d8b86349.png">
							<div class="activity-list-beta">
									<p class="activity-list-theme two-line-hidden">带队出行，可领取千元礼包</p>
									<p class="activity-txt">时间 06-22-07-22</p>
									<p class="activity-txt">
										<span>报名 115</span><span class="activity-txt-beta"
											style="color: #3DD1A5; font-size: 15px;">免费</span>
									</p>
								</div></li>
							<li class="" onclick="_actdetail._goDetail(344109)"><img
								class="activity-list-alpha"
								src="https://cdn2.51julebu.com/club/img/190528/42556cd65dad47019ab87721633cbcbd.jpg">
							<div class="activity-list-beta">
									<p class="activity-list-theme two-line-hidden">分享有礼，一起记录身边的小美好！</p>
									<p class="activity-txt">时间 05-27-06-30</p>
									<p class="activity-txt">
										<span>报名 747</span><span class="activity-txt-beta"
											style="color: #3DD1A5; font-size: 15px;">免费</span>
									</p>
								</div></li>
						</ul>
						<div class="content-line-alpah" style="margin-top: 25px"></div>
						<div class="activity-list-more" id="clubOtherMore">查看全部301场活动</div>
					</div>
					<div style="height: 25px; background: #F5F5F5;"></div>
				</li>
				<li class="detail-content-item" style="padding-top: 10px;">
					<div class="apply-know" id="actGuide">挑战时间：7月1日00:00:00-7月14日23:59:59挑战项目：骑行71KM、跑步/徒步7.1KM挑战地点：位置不限，全国均可</div>
				</li>
				<li class="detail-content-item">
					<!--有照片-->
					<div class="clubAlbum" style="display: none;">
						<ul class="detail-album-list demo-gallery">

						</ul>
						<div class="detail-album-more loadMore"
							onclick="_actdetail._tipDown();">
							查看全部<span class="row">78</span>张照片
						</div>
					</div> <!--无照片-->
					<div style="" class="emptyAlbum">
						<img class="album-none-img"
							src="https://cdn2.51julebu.com/club/img/170413/baddcb1c2f094f04b97113c81d533e0d.png_w.jpeg_640.jpeg">
						<p class="album-none-txt">相册还是空的！</p>
						<a class="album-upload" onclick="_actdetail._tipDown();">上传第一张照片</a>
					</div>
				</li>
				<li class="detail-content-item">
					<div class="cost-content">
						<div class="cost-content-title">
							<div class="title-line"></div>
							<span class="pd-left">费用</span>
						</div>
						<div class="cost-ticket-box" id="tickets">
							<div class="cost-ticket">
								<div class="cost-ticket-line"></div>
								<div class="cost-ticket-item">
									<div class="cost-ticket-alpha">
										<span class="cost-ticket-title">报名费</span><span
											class="cost-ticket-txt">名额 不限</span>
									</div>
									<div class="cost-ticket-beta">￥29.8</div>
								</div>
							</div>
						</div>

						<div class="cost-content-title refund">
							<div class="title-line refund"></div>
							<span class="pd-left refund">退款说明</span>
						</div>
						<p class="cost-ticket-content refundtxt refund">报名成功后不支持退款</p>
						<div class="cost-content-title">
							<div class="title-line"></div>
							<span class="pd-left">费用说明</span>
						</div>
						<p class="cost-ticket-content noFree">
							费用包含:报名费、奖牌；<br>挑战时间：7月1日00:00:00-7月14日23:59:59<br>挑战项目：骑行71KM、跑步/徒步7.1KM<br>挑战地点：位置不限，全国均可
						</p>
					</div>
				</li>
			</ul>
		</div>
		<!--不能报名-->
		<div class="detail-footer button-top-line" id="canNoApply"
			style="display: none;">
			<p class="detail-footer-alpha ticktcosts" style="font-size: 20px">￥29.8</p>
			<div id="canNoApplystus" class="detail-footer-beta footer-base">报名已关闭</div>
		</div>
		<!--报名之前-->
		<div class="detail-footer button-top-line" id="beforeApply" style="">
			<p class="detail-footer-alpha ticktcosts" style="font-size: 20px">￥29.8</p>
			<div id="beforeApplystus" class="detail-footer-beta footer-base"
				style="background: rgb(61, 209, 164);">我要报名</div>
		</div>
		<!--报名之后-->
		<div class="detail-footer button-top-line" id="afterApply"
			style="display: none;">
			<p class="detail-apply-alpha" id="afterApplyMange">报名管理</p>
			<div class="detail-footer-beta footer-beta" id="afterApplystus">帮人报名</div>
		</div>
	</div>

	<div class="noMain" style="height: 950px; display: none;">
		<div class="act-delete">
			<div>
				<img
					src="https://o6fvpth3b.qnssl.com/club/images/public/actdel.png?vs=200.13">
			</div>
			<span>活动已删除或不存在</span>
		</div>
	</div>












	<div id="commentBox" style="display:none">
		<div id="commentBox_main">
			<div id="commentBox_input">
				<input type="hidden" id="commentBox_Ref_userId"> <input
					type="text" placeholder="评论：" style="margin-bottom: 0px;"
					id="commentBox_form_content" class="input" oncopy="return false" oncut="return false" maxlength="200">
			</div>
			<div id="commentBox_button">
				<button id="commentBox_form_post" data="0" onclick="commentBox_form_post()">发送</button>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div id="commentBoxDel" style="display: none;">
		<div
			style="max-width: 640px; margin: 0 auto; font-size: 20px; background: #E6E6E6;">
			<input type="hidden" id="commentBoxDel_commentId">
			<div onclick="commentcancle()" class="pointer"
				style="margin: 0 auto; height: 44px; line-height: 44px; background: white; color: black; border-radius: 0px; margin-bottom: 7px;">删除</div>
			<div onclick="commenthideCommentBoxDel()" class="pointer"
				style="margin: 0 auto; height: 44px; line-height: 44px; background: white; color: black; border-radius: 0px;">取消</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!--悬浮广告-->
	<div style="position: fixed; top: 55vh; right: 0; z-index: 9">
		<a id="xuanfu" href="http://u.iweju.cn/bianxianmao2018"> <img
			id="xuanfuImg" style="width: 60px;"
			src="https://cdn2.51julebu.com/club/img/180117/038891e89aed464abef7378e52efd6cb.gif"></a>
	</div>

	<div id="__MUI_PREVIEWIMAGE"
		class="mui-slider mui-preview-image mui-fullscreen">
		<div class="mui-preview-header">
			<span class="mui-preview-indicator"></span>
		</div>
		<div class="mui-slider-group"></div>
		<div class="mui-preview-footer mui-hidden"></div>
		<div class="mui-preview-loading">
			<span class="mui-spinner mui-spinner-white"></span>
		</div>
	</div>

	<div class="dt_div">
		<iframe src="" width="100%" height="100%" frameborder="no" border="0"
			id="iframe1"></iframe>
	</div>
	<div id="cover" style="display: none;"></div>
	<input type="hidden" id="currentUser" userId="${currentUser.userId}" userName='${currentUser.nickName}' userImg="${currentUser.headPortrait}"/>
</body>

<script type="text/javascript">
	<!-- 点赞功能  -->
	// 1,当页面加载完成，通过活动id查询出该活动被点赞的所有用户 
	// 2,将用户追加单指定地方,并显示是否该用户点过该活动
	
	//转换json时间
	function toDate(value) {
		var unixTimestamp = new Date(value);
		return unixTimestamp.getFullYear() + "-"
				+ (unixTimestamp.getMonth() + 1)
				+ "-" + unixTimestamp.getDate()+" "+unixTimestamp.getHours()+":"+unixTimestamp.getMinutes()+":"+unixTimestamp.getSeconds();
	}
	
	 $(function(){
		//拿到活动id
		 var activity_id=$("#activity_detail").attr("data");
			$.ajax({
				url:"${pageContext.request.contextPath}/friendCircle/fabulous?id="+activity_id+"",
				type:'post',
				dataType:'json'
			}).done(function(data){
				
				if(data.code==200){
					$("#num").html(""+data.result.nums+"")				
				}else if(data.code==300){
					alert("请重新登录");
					window.location="${pageContext.request.contextPath}/pages/"+data.result+"";
					return;
				}
				//如果nums不为0，则表示有人点赞,然后在遍历所有用户
				if(data.result.nums!=0){
					var yesPraise=$("#yesPraise")
					var datas=data.result;
					$.each(datas,function(key,vals){	
						
						if(key=='nums' || key=='index'){							
						}else{
						
							var json=JSON.parse(vals)
							var $div=$("<div style='display: inline-block;' userid='"+key+"'><img class='detail-laud-photo' src='http://120.79.191.71/"+json.headPortrait+"' onerror='this.src='https://o6fvpth3b.qnssl.com/club/images/public/default2.PNG''></div>")
							yesPraise.append($div)
						}
						
						if(key=='index' && vals=='false'){
							$($("#okNum img")[0]).attr("src","https://cdn2.51julebu.com/club/img/170413/884fba3f40d44369a594507fefa906b1.png");	
						}else{
							$($("#okNum img")[0]).attr("src","https://cdn2.51julebu.com/club/img/170413/a4b63e6fca3a4779b851eccad7e54be7.png_60x60.jpeg");	
						}
						
					})				
				}						
			})
			
			
			
		//评论的功能	
		//评论的用户		
		$.ajax({
			url:"${pageContext.request.contextPath}/friendsCommentController/listComments",
			type:'post',
			data:"activityId="+activity_id+"",
			dataType:'json'
		}).done(function(data){
			console.log(data);	
			var ul=$("#actCommentLists")
			var j=0;
			for(var i in data.result){
				
				var jsonuser=data.result[i].userId
				
				var comment
				if(data.result[i].replyUserId==null){
					comment=$("<li class='comment-list'><img class='comment-list-img' src='"+jsonuser.headPortrait+"'><div class='comment-list-message' onclick=\"showCommentBox('"+data.result[i].userId.userId+"','"+jsonuser.nickName+"','"+activity_id+"',false,this)\"><p class='comment-list-host'>"+jsonuser.nickName+"<span class='comment-list-beta'>"+toDate(data.result[i].createTime)+"</span></p><p class='comment-list-content'>"+data.result[i].commitContext+"</p></div></li><div class='comment-line'></div>")
				}else{					
					comment=$("<li class='comment-list'><img class='comment-list-img' src='"+jsonuser.headPortrait+"'><div class='comment-list-message' onclick=\"showCommentBox('"+data.result[i].userId.userId+"','"+jsonuser.nickName+"','"+activity_id+"',false,this)\"><p class='comment-list-host'>"+jsonuser.nickName+"<font color='gray'> 回复 </font>"+data.result[i].replyUserId.nickName+"<span class='comment-list-beta'>"+toDate(data.result[i].createTime)+"</span></p><p class='comment-list-content'>"+data.result[i].commitContext+"</p></div></li><div class='comment-line'></div>")				
				}
				j=1+Number(i);
				ul.prepend(comment);
			}
			j=Number(j)
			 var commentNum=Number($("#actCommentNum").html())+Number(j)
			 $("#actCommentNum").html(commentNum);
			 
		})
					
	}) 
	
	
	
	$("#okNum").click(function(){
		var activity_id=$("#activity_detail").attr("data");

		$.ajax({
			url:"${pageContext.request.contextPath}/friendCircle/getAddAndDelfabulous?id="+activity_id+"",
			type:'post',
			dataType:'json'
		}).done(function(data){
			if(data.code==200){
				if(data.result.index=='false'){
					$($("#okNum img")[0]).attr("src","https://cdn2.51julebu.com/club/img/170413/a4b63e6fca3a4779b851eccad7e54be7.png_60x60.jpeg");
					var nums= Number($("#num").html())+1
					$("#num").html(""+nums+"")
					
					var $div="<div style='display: inline-block;' userid='"+data.result.user.userId+"'><img class='detail-laud-photo' src='http://120.79.191.71/"+data.result.user.headPortrait+"' onerror='this.src='https://o6fvpth3b.qnssl.com/club/images/public/default2.PNG''></div>"
					$("#yesPraise").prepend($div)
				}else{
					$($("#okNum img")[0]).attr("src","https://cdn2.51julebu.com/club/img/170413/884fba3f40d44369a594507fefa906b1.png");
					var nums=Number($("#num").html())-1	
					
					$("#num").html(""+nums+"")
					$("div[userid='"+data.result.user.userId+"']").remove();
				}		
			}else if(data.code==300){
				alert("请重新登录");
				window.location="${pageContext.request.contextPath}/pages/"+data.result+"";
				return;
			}
					
		})
	})
	
	//底部输入框
	function inputText(){
		 $("html").attr("style","overflow: hidden;");	
			$("#cover").attr("style","display: block; position: fixed; width: 100%; height: 100%;");
			$("#commentBox").attr("style","bottom: 0px; display: block;");
	 }
	//隐藏输入框
	function inputHdden(){
		$("html").removeAttr("style");
		$("#cover").attr("style","display: none;");
		$("#commentBox").attr("style","bottom: 0px; display: none;");
	}
	
	//显示删除框
	function delInput(){
		$("html").attr("style","overflow: hidden;");	
		$("#cover").attr("style","display: block; position: fixed; width: 100%; height: 100%;");
		$("#commentBoxDel").attr("style","bottom: 0px; display: block;");
	}
	//隐藏删除框
	function delInputHdden(){
		$("html").removeAttr("style");
		$("#cover").attr("style","display: none;");
		$("#commentBoxDel").attr("style","bottom: 0px; display: none;");
	}
	 
	//评论的功能
	$("#detail-apply-comment").click(function(){
		inputText();
	})
		
	$("#cover").click(function(){
		inputHdden()
		
		if($("div[preDel='true']")){
			$("div[preDel='true']").removeAttr("preDel")
		}
		if($("#commentBox_form_content")){
			$("#commentBox_form_content").attr("placeholder","评论:");
			
		}
		$("#commentBox_form_post").attr("data","0");
		delInputHdden()
	})	
	//删除评论
	function commentcancle(){
		var check=confirm('你确定要删除吗？')
		if(check){
			$("div[preDel='true']").parent().remove();
			var commentNum=Number($("#actCommentNum").html())-1
			$("#actCommentNum").html(commentNum);
		}else{
			$("div[preDel='true']").removeAttr("preDel")
		}
		
		delInputHdden()
	}
	//取消
	function commenthideCommentBoxDel(){
		$("div[preDel='true']").removeAttr("preDel")
		delInputHdden()
		
	}
	
	//点击发送按钮,用户评论活动
	function commentBox_form_post(){
		
		var activity_id=$("#activity_detail").attr("data");

		//首先拿到input的值如果为空则提示
		var inputVal=$("#commentBox_form_content").val();
		if(inputVal==null || inputVal=='' ){
			return;
		}
		var chose=$("#commentBox_form_post").attr("data");
		//拿到当前用户信息
		var ul=$("#actCommentLists");
		var id=$("#currentUser").attr("userId");
		var name=$("#currentUser").attr("userName");
		var img=$("#currentUser").attr("userImg");
		if(chose==0){
			//写入数据库

			//给活动评论
			var comment=$("<li class='comment-list'><img class='comment-list-img' src='http://120.79.191.71/"+img+"'><div class='comment-list-message' onclick=\"showCommentBox('"+id+"','"+name+"','"+activity_id+"',false,this)\"><p class='comment-list-host'>"+name+"<span class='comment-list-beta'>"+new Date()+"</span></p><p class='comment-list-content'>"+inputVal+"</p></div></li><div class='comment-line'></div>")
			ul.prepend(comment);
			inputHdden();
			var commentNum=Number($("#actCommentNum").html())+1
			 $("#actCommentNum").html(commentNum);
			var inputVal=$("#commentBox_form_content").val("");	
			
		}else if(chose==1){
			
			//给用户评论
			var place=$("#commentBox_form_content").attr("placeholder");
			var placeHode= place.substring(2);
			var comment=$("<li class='comment-list'><img class='comment-list-img' src='http://120.79.191.71/"+img+"'><div class='comment-list-message' onclick=\"showCommentBox('"+id+"','"+name+"','"+activity_id+"',false,this)\"><p class='comment-list-host'>"+name+"<font color='gray'>&nbsp;回复&nbsp;</font>"+placeHode+"<span class='comment-list-beta'>"+new Date()+"</span></p><p class='comment-list-content'>"+inputVal+"</p></div></li><div class='comment-line'></div>")
			ul.prepend(comment);
			inputHdden();
			var commentNum=Number($("#actCommentNum").html())+1
			 $("#actCommentNum").html(commentNum);
			var inputVal=$("#commentBox_form_content").val("");
		}
		
		$("#commentBox_form_content").attr("placeholder","评论:");
		$("#commentBox_form_post").attr("data","0");
	}
	
		
	function showCommentBox(id,name,activityId,index,val){
		
		var currentUserId=$("#currentUser").attr("userId");
		if(id!=currentUserId){
			inputText();
			
			var activity_id=$("#activity_detail").attr("data")
			$("#commentBox_form_content").attr("placeholder","回复"+name+"");
			var inputVal=$("#commentBox_form_content").val();
			$("#commentBox_form_post").attr("data","1");
		}else{
			delInput();
			$(val).attr("preDel","true");
		}
	}
				
</script>
</html>
















