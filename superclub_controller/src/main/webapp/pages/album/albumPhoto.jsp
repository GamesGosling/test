<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<title></title>
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
	href="https://o6fvpth3b.qnssl.com/club/component/mui/2.8.0/css/mui.min.css?vs=200.13">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/club/component/layer/layer.min.css?vs=200.13">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/superclub_base.css_00223.css">
<link rel="stylesheet" type="text/css"
	href="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/css/title.css">
<!--懒加载-->
<script type="text/javascript"
src="https://o6fvpth3b.qnssl.com/club/component/public/iclubjq.min.js?vs=200.13"></script>
<script type="text/javascript" src="static/plugins/jquery/jquery-3.3.1.min.js"></script>
<link type="text/css" rel="styleSheet" id="layermcss">
<link type="text/css" rel="styleSheet" id="layermcss">
<link href="static/bootstrap/css/bootstrap.min.css" rel="styleSheet">
<script type="text/javascript" src="static/bootstrap/js/popper.min.js"></script>
<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
<!-- 滚动加载 -->
<script type="text/javascript" src="static/plugins/endless-scroll/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="static/plugins/endless-scroll/js/jquery.endless-scroll-1.3.js"></script>
<style>
     .fileinput-button {
         position: relative;
         display: inline-block;
         overflow: hidden;
     }

     .fileinput-button input{
         position:absolute;
         right: 0px;
         top: 0px;
         opacity: 0;
         -ms-filter: 'alpha(opacity=0)';
         font-size: 400px;
     }
 </style>

</head>
<body>
	<div class="top">
		<div class="top_left">
			<a href="javascript:window.location.href='pages/album/personalAlbum.jsp'" class="goback">返回</a>
		</div>
		<div class="top_middle" id="albumTitle" data="${param.albumName }">${param.albumName }</div>
		<div class="dropdown show" id="control" style="float:right;margin-top:5px;margin-right:10px;">
				<a class="btn btn-secondary dropdown-toggle" style="width:160px;background-color: #3ED1A5;border-color: #3ED1A5;" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    	管&nbsp;&nbsp;理
			  </a>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuLink" style="text-align: center;">
			    <a class="dropdown-item" href="javaScript::0;" data-toggle="modal" data-target="#modifyAlbumNameModel">编辑相册名称</a>
			    <a class="dropdown-item" onclick='delImg()' align="center" href="javaScript::0;">删除照片</a>
			    <a class="dropdown-item" href="javaScript::0;" id="deleteAlbum">删除相册</a>
			  </div>
		</div>
	</div>

	<div class="main" style="padding-bottom:200px; text-align:center;">
		<div id="personalTopTips" style="display:none;">
			<input id="albumId" type="text" hidden="hidden" data="${param.albumId }">
			<input id="activityId" type="text" hidden="hidden" data="${param.activityId }">
			<img src="https://cdn2.51julebu.com/club/img/160601163552/da51dc40f5494c38979683ea3d380aa3.png">
			<div class="f14 text-gray">相册空空如也，快去上传照片吧</div>
		</div>
		<span>
			<div id="uploadPhoto" class="upLoadPho f14">
				<form id="uploadForm" method="post" enctype="multipart/form-data">
	    			<!-- <input class="btn btn-default" style="width:150px;height:45px;text-align:center;" id="files" name="files" multiple="multiple" type="file"/> -->
   					<span class="btn btn-primary fileinput-button">
		            	<span>选择文件</span>
		            	<input type="file" id="files" name="files" multiple="multiple">
		       		 </span>
	   				<input id="btnImportOK" type="button" value="上传文件"
	   				style="width: 90px;height: 40px;position: relative;text-align: center;background:#007BFF;color: #fff;border-radius: 5px;cursor: pointer; margin-top:5px;"/>
				</form>
			</div>
		</span>
		
		<div id="albumPhotos">
						
		</div>
	</div>
	<div class="bg-opacity"></div>
	<!--编辑相册名字-->
	<div class="newBuildDIV EditAlbumName">
		<div class="newBuild f15">编辑相册名字</div>
		<div class="writeName f12">请输入编辑相册的名字：</div>
		<input class="outDoorAct" placeholder="户外活动">
		<ul class="sureOrNot">
			<li class="left" id="qxiao" style="cursor: pointer;">取消</li>
			<li class="right" id="sure" style="cursor: pointer;">确定</li>
		</ul>
	</div>
	<!--删除照片提醒-->
	<div class="deletePhones f16 pointer">
		<div class="bg-fff cansel" style="color: #ff534a;">删除123张照片？</div>
		<div class="bg-fff cansel blueA" style="margin: 15px auto;">取消</div>
	</div>
	<!--管理相册-->
	<div class="manageAlbum f16 pointer">
		<ul>
			<li style="" class="editName">编辑相册名字</li>
			<li style="" onclick="_AlbumDetail._moveButton(1);"
				class="moveToAlbum">移动到我的相册</li>
			<li style="" class="delete">批量删除</li>
			<li style="" class="deleteIcon_Album">删除相册</li>
		</ul>
		<div class="bg-fff cansel"
			style="margin-top: 15px; border-radius: 10px; padding: 10px 0;">取消</div>
	</div>

	<!--删除相册-->
	<div class="managePhotos f16 pointer">
		<ul>
			<li class="delPhotos">删除n张照片</li>
		</ul>
		<div class="bg-fff" id="delqx"
			style="margin-top: 15px; border-radius: 10px; padding: 10px 0;">取消</div>
	</div>
	<!--移动至我的相册-->
	<div class="allAlbums bg-fff displayNone"></div>
	<!--请先报名参加活动-->
	<div class="attention_enroll bg-fff">
		<ul class="f16">
			<li>确定删除该相册？</li>
			<li id="undo" class="justfy left blueA pointer">取消</li>
			<li id="delsure" class="justfy right blueA pointer">确定</li>
		</ul>
	</div>
	
	<!-- 修改相册名称模态框 -->
	<div class="modal fade" id="modifyAlbumNameModel" tabindex="-1" role="dialog"
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
								<span style="margin-top:10px;margin-right:10px;font-family: '楷体' ;font-size: 15px;">相册名称:</span>
								<input class="form-control" style="border-radius: 5px;" type="text" id="albumNameInput" value="${param.albumName }">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="col-md-8">	
						<button type="button" class="btn btn-info" style="margin-right: 10px;" data-dismiss="modal">关闭</button>
						<button type="button" id="modifyAlbumBtn" class="btn btn-primary"
							data-dismiss="modal" style="margin-left: 10px;">确认</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script
		src="https://o6fvpth3b.qnssl.com/club/component/layer/layer.min.js?vs=200.13"></script>
	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/club/component/public/iclubjq.min.js?vs=200.13"></script>
	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/lib/json2.js?vs=200.13"></script>
	<script type="text/javascript"
		src="https://o6fvpth3b.qnssl.com/web_static/iclub-web/resource/js/webuploader/webuploader.js?vs=200.13"></script>
	<script
		src="https://o6fvpth3b.qnssl.com/club/component/layer/layer.min.js?vs=200.13"></script>
	<script
		src="https://o6fvpth3b.qnssl.com/club/component/mui/2.8.0/js/clubmui.min.js?vs=200.13"></script>
	<script>
		mui.previewImage();
	</script>
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

	<div class="loadingDiv"
		style="left: 889.5px; top: 103.5px; z-index: 10000; display: none;">
		<p class="pImg" style="margin: 0px;">
			<img
				src="https://cdn2.51julebu.com/club/img/161220143720/77e404dcbef146289132d23b35472817.gif">
		</p>
		<p class="pTxt" style="margin: 0px; color: #fff;">正在加载中</p>
	</div>
	<div id="cover2"
		style="position: fixed; width: 100%; height: 100%; display: none;"></div>
	<div id="toast" class="toast"
		style="bottom: 20px; left: 881px; display: none;">数据加载完毕...</div>
<!-- 图片展示 -->
<script type="text/javascript">
	var albumId = $("#albumId").attr("data");
	var activityId = $("#activityId").attr("data");
	var albumName = $("#albumTitle").attr("data");
	$(function(){
		//展示图片
		$.ajax({
			url:'${pageContext.request.contextPath}/album/getTimes?new Date()',
			method:'post',
			dataType:'json',
			data:"albumId="+albumId+"",
			success:function(data){
				console.log(data);
				var result = data.result;
				if(result.length == 0){
					$("#personalTopTips").show();
				}
				var ss = "";
				for(index in result){
					ss = ss
					+ "<ul class='albums dateAlbum'>"
					+ "<li class='date f16'>"+result[index]+"<span name='choose' onclick='_AlbumDetail._allChoose(this);' style='display:none;' class='right chioce'>全选</span></li>";
					var unixTimestamp = new Date(result[index]);
					var date =unixTimestamp.getFullYear()+ "-" + (unixTimestamp.getMonth() + 1) + "-" + unixTimestamp.getDate();
					console.log(date);
					$.ajax({
						url:'${pageContext.request.contextPath}/album/getPhotosByTime?new Date()',
						method:'post',
						dataType:'json',
						async:false,
						data:{
							albumId:albumId,
							dateString:date
						},
						success:function(data){
							console.log(data);
							var photos = data.result;
							for(index in photos){
								ss =ss
								+ "<li class='left'>"
								+ "<img id='"+photos[index].id+"' src='"+photos[index].photoUrl+"' data='false'  onclick='photoStyle(this)'  data-preview-group='1'>"
								+ "<div class='selectIcion'><span id='"+photos[index].id+"' class='fa fa-circle-o right f15'></span></div></li>";
							}
						},
						error:function(err){
							console.log(err);
						}
					});
					ss = ss
					+ "</ul>"
					+ "<div style='clear: both;'></div>";
				}
				$("#albumPhotos").after(ss);
			},
			error:function(err){
				console.log(err);
			}
		});
	//上传图片
	$("#btnImportOK").on("click",function(){
		
		var form=document.getElementById("uploadForm");
		var formData = new FormData();
		formData.append("albumId", albumId);
		formData.append("activityId", activityId);
		var files=$("#files")[0].files
		for(var i=0;i<files.length;i++){
			formData.append("files", files[i]);
		}
		
		$.ajax({
			url:'album/uploadPhotos',
			type:'post',
			dataType:'json',
			processData: false,
			contentType : false,
			data:formData,
			success:function(data){
				console.log(data);
				location.reload();
			},
			error:function(err){
				console.log(err);
			},
			beforeSend:function(xhr){
				if($("#files").val()==""){
					alert("请选择相片");
					return;
				}
				$("#files").val("");	
			}
		});
	})
	});
</script>
<script type="text/javascript">
	function photoStyle(data){
		var img=$(data);
		var index=img.attr("data")
		if(index=='false'){
			img.attr("style","border-color:red")
			img.attr("data","true")
		}else{
			img.removeAttr("style")
			img.attr("data","false")
		}
		
			
	}
	//删除图片
	function delImg(){
		var imgs=$("img[style]");
		if(imgs.length==0){
			alert("请选择要删除的图片！");
			return;
		}
		var config = confirm("你确定要删除吗？");
		if(config){
			var photoIdArray = [];
			var photoUrlArray = [];
			for(var i=0;i<imgs.length;i++){
				console.log($(imgs[i]).attr("id"));
				var photoId = $(imgs[i]).attr("id");
				var photoUrl = $(imgs[i]).attr("src");
				var url = photoUrl.substring(21);
				photoIdArray.push(photoId);
				photoUrlArray.push(url);
				
			} 	
			var idString = JSON.stringify(photoIdArray);
			var urlString = JSON.stringify(photoUrlArray);
			$.ajax({
				url:'album/deletePhotos',
				type:'post',
				dataType:'json',
				data:"idString="+idString+"&urlString="+urlString+"",
				success:function(data){
					console.log(data);
					location.reload();
				},
				error:function(err){
					console.log(err);
				}
			})
		}else{
			location.reload();
		}
	}
	//编辑相册名称
	$("#modifyAlbumBtn").on("click",function(){
		var modifyName = $("#albumNameInput").val();
		if(modifyName == null || modifyName == ""){
			alert("请输入相册名称");
			return;
		}else{
			$.ajax({
				url:'album/modifyAlbum',
				type:'post',
				dataType:'json',
				data:{
					albumName:modifyName,
					id:albumId
				},
				success:function(data){
					console.log(data);
					alert(data.msg);
					window.location.href="pages/album/personalAlbum.jsp";
				},
				error:function(err){
					console.log(err);
				}
			});
		}
	})
	//删除相册
	$("#deleteAlbum").on("click",function(){
		if(albumId == null || albumId == ""){
			window.location.href="pages/main.jsp";
		}else{
			var config = confirm("你确定要删除吗？");
			if(config){
				$.ajax({
					url:'album/deleteAlbum',
					type:'post',
					dataType:'json',
					data:{
						photoAlbumId:albumId,
						activityId:activityId
					},
					success:function(data){
						console.log(data);
						alert(data.msg);
						window.location.href="pages/album/personalAlbum.jsp";
					},
					error:function(err){
						console.log(err);
					}
				});
			}else{
				return;
			}
		}
	})
</script>
</body>
</html>