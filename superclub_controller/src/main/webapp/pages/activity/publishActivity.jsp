<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>组织活动</title>
<style type="text/css">
.activityBox {
	margin: 20px auto;
	width: 900px;
	height: auto;
}

.activityTitle {
	font-size: 25px;
	text-align: center;
	font-weight: 500;
}
#allmap {
		width:99%;
		height:100%;
		margin:0px auto;
	}
</style>
<link rel="stylesheet"
	href="static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="static/plugins/ueditor/themes/default/css/ueditor.css">
<!-- 加载编辑器的容器 -->
<script type="text/javascript"
	src="static/plugins/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" 
	src="static/plugins/calendar/WdatePicker.js"></script>
<link rel="stylesheet" 
	href="static/plugins/bootstrapvalidator/dist/css/bootstrapValidator.min.css">
<script type="text/javascript" 
	src="static/plugins/bootstrapvalidator/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" 
	src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=kUy5jZSBovGvf3eCxnU5Gd8b5XdOU1Gb"></script>
</head>
<body>

	<div class="activityBox">
		<div class="activityTitle">组织活动</div>
		<form class="was-validated" id="activityForm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="activityTitle">活动标题</label> <input type="text"
					class="form-control" id="activityTitle" name="activityTitle">
			</div>
			<div class="form-group">
				<label for="activityDetail">活动正文</label>
				<script id="container" name="content" type="text/plain">请输入活动详情信息</script>
				<!-- 配置文件 -->
				<script type="text/javascript"
					src="static/plugins/ueditor/ueditor.config.js"></script>
				<!-- 编辑器源码文件 -->
				<script type="text/javascript"
					src="static/plugins/ueditor/ueditor.all.js"></script>
				<!-- 实例化编辑器 -->
				<!-- <script id="editor" type="text/plain"
					style="width: 900px; height: 400px;"></script> -->
				<script type="text/javascript">
					var ue = UE.getEditor('container',{
					toolbars: [
					    [
					        'undo', //撤销
					        'redo', //重做
					        'bold', //加粗
					        'indent', //首行缩进
					        'italic', //斜体
					        'underline', //下划线
					        'strikethrough', //删除线
					        'subscript', //下标
					        'fontborder', //字符边框
					        'superscript', //上标
					        'formatmatch', //格式刷
					        'pasteplain', //纯文本粘贴模式
					        'selectall', //全选
					        'print', //打印
					        'preview', //预览
					        'horizontal', //分隔线
					        'removeformat', //清除格式
					        'insertrow', //前插入行
					        'insertcol', //前插入列
					        'mergeright', //右合并单元格
					        'mergedown', //下合并单元格
					        'deleterow', //删除行
					        'deletecol', //删除列
					        'inserttitle', //插入标题
					        'cleardoc', //清空文档
					        'fontfamily', //字体
					        'fontsize', //字号
					        'paragraph', //段落格式
					        'simpleupload', //单图上传
					        'insertimage', //多图上传
					        'link', //超链接
					        'emotion', //表情
					        'spechars', //特殊字符
					        'insertvideo', //视频
					        'justifyleft', //居左对齐
					        'justifyright', //居右对齐
					        'justifycenter', //居中对齐
					        'justifyjustify', //两端对齐
					        'forecolor', //字体颜色
					        'backcolor', //背景色
					        'insertorderedlist', //有序列表
					        'insertunorderedlist', //无序列表
					        'rowspacingtop', //段前距
					        'rowspacingbottom', //段后距
					        'pagebreak', //分页
					        'attachment', //附件
					        'imagecenter', //居中
					        'wordimage', //图片转存
					        'lineheight', //行间距
					        'edittip ', //编辑提示
					        'touppercase', //字母大写
					        'tolowercase', //字母小写
					        'background', //背景
					        'music', //音乐
					        'drafts', // 从草稿箱加载
					        'charts', // 图表
					    ]
					],
					//focus时自动清空初始化时的内容
					autoClearinitialContent:true,
					autoHeightEnabled:true,
					autoFloatEnabled:true,
					imageScaleEnabled:true,
					//关闭字数统计
					wordCount:false,
					//关闭elementPath
					elementPathEnabled:false,
					//默认的编辑区域高度
					initialFrameHeight:300
					});
					
			       /* UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;

			        UE.Editor.prototype.getActionUrl = function(action) {
			                //这里很重要，很重要，很重要，要和配置中的imageActionName值一样
			                if (action == 'upload/uploadUEditorImage') {
			                	alert(111)
			                //这里调用后端我们写的图片上传接口
			                return 'http://localhost:8080/superclub_controller/upload/uploadUEditorImage';
			            }else{
			                 return this._bkGetActionUrl.call(this, action);
			            } 
			        }*/ 
	
				</script>
			</div>
			<div class="form-group">
				<label for="activityBeginTime">活动开始</label> <input type="text"
					class="form-control" id="activityBeginTime"
					name="activityBeginTime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'});">
			</div>
			<div class="form-group">
				<label for="activityEndTime">活动结束</label> <input type="text"
					class="form-control" id="activityEndTime" 
					name="activityEndTime" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'});">
			</div>
			<div class="form-group">
				<label for="activityLocation">活动地点</label> <input type="text"
					class="form-control" id="activityLocation"
					name="activityLocation" data-toggle="modal" data-target="#baiduMapmodal">
			</div>
			<div class="form-group">
				<label for="exampleFormControlFile1">选择活动封面</label> <input
					type="file" class="form-control-file" id="picture"
					name="picture">
			</div>
			<label class="form-group">活动类型&nbsp;</label>
			<div id="activityTypeBody" class="custom-control custom-radio custom-control-inline">
			</div>
				<br/>
			<label class="form-group">是否收费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="isCharge1" name="isCharge"
					class="custom-control-input" value="0"> <label
					class="custom-control-label" for="isCharge1">免费</label>
			</div>&nbsp;&nbsp;
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="isCharge2" name="isCharge"
					class="custom-control-input" value="1"> <label
					class="custom-control-label" for="isCharge2">收费</label>
			</div><br/>
			
			<label class="form-group">付费方式&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="chargeMode1" name="chargeMode"
					class="custom-control-input" value="微信"> <label
					class="custom-control-label" for="chargeMode1">微信</label>
			</div>&nbsp;&nbsp;
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="chargeMode2" name="chargeMode"
					class="custom-control-input" value="支付宝"> <label
					class="custom-control-label" for="chargeMode2">支付宝</label>
			</div><br/>
			
			<label class="form-group">保  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;险
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="insuranceChannel1" name="insuranceChannel"
					class="custom-control-input" value="无保险要求"> <label
					class="custom-control-label" for="insuranceChannel1">无保险要求</label>
			</div>&nbsp;&nbsp;
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="insuranceChannel2" name="insuranceChannel"
					class="custom-control-input" value="自行购买"> <label
					class="custom-control-label" for="insuranceChannel2">自行购买</label>
			</div>&nbsp;&nbsp;
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="insuranceChannel3" name="insuranceChannel"
					class="custom-control-input" value="主办方统一购买"> <label
					class="custom-control-label" for="insuranceChannel3">主办方统一购买</label>
			</div><br/>
			<div class="form-group">
				<label for="activityLocation">最多参加人数</label> <input type="text"
					class="form-control" id="activityMaxPeople" name="activityMaxPeople">
			</div>
			
			<div class="form-group" style="text-align:center;">
				<input type="button" class="btn btn-primary" id="back" 
				name="back" value="放弃" onClick="backMain()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="btn btn-primary" id="activitySubBtn" 
				name="activitySubBtn" value="发布活动"/>
			</div>
		</form>
	</div>
	
	<div class="modal fade" id="baiduMapmodal" tabindex="-1" role="dialog"
		aria-labelledby="baiduMapModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					id="enter">确定</button>
			</div>
			<div class="modal-content">
				<div style="width:800px;height:800px;">
					<div id="allmap"></div>
						<p>点击地图展示详细地址</p>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function () {
	$.ajax({
		url:'activity/findTypeList',
		method:'post',
		dataType:'json',
		success:function(data){
			console.log(data.result);
			var result = data.result;
			var sr = "";
			for(index in result){
				sr += "<div class='custom-control custom-radio custom-control-inline'>"
				+"<input type='radio' id='activityType"+index+"' name='activityType' value="+result[index].activityTypeId+" class='custom-control-input'>"
				+"<label class='custom-control-label' for='activityType"+index+"'>"+result[index].activityTypeName+"</label></div>";
			}
			$("#activityTypeBody").append(sr);
		},
		error:function(err){
			console.log(err.msg);
		}
	});
    $("#activityForm").bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
        submitButtons: '#activitySubBtn',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
        message: '通用的验证失败消息',//好像从来没出现过
        feedbackIcons: {//根据验证结果显示的各种图标
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	activityTitle: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '文本框必须输入'
                    },
                    stringLength: {//检测长度
                        min: 6,
                        max: 30,
                        message: '长度必须在6-30之间'
                    }
                }
            },
            activityDetail:{
            	validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '文本框必须输入'
                    }                    
                }
            },
            activityBeginTime:{
            	validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '开始时间不能为空'
                    }                    
                }
            },
           	activityEndTime:{
           		validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '结束时间不能为空'
                    }                    
                }
           	},
       		activityLocation:{
       			validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '活动地点不能为空'
                    }                    
                }
       		},
   			activityCover:{
   				validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '活动封面不能为空'
                    }                 
                }
   			},
			activityType:{
				validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '活动类型不能为空'
                    }                    
                }
			},
			isCharge:{
				validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '是否付款不能为空'
                    }                    
                }
			},
			chargeMode:{
				validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '付款方式不能为空'
                    }           
                }
			},
			insuranceChannel:{
				validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '保险购买方式不能为空'
                    }           
                }
			},
			activityMaxPeople:{
				validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '活动最多参加人数不能为空'
                    }           
                }
			}
        }
    });
    
    $("#activitySubBtn").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        $("#activityForm").bootstrapValidator('validate'); //提交验证
        if ($("#activityForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            alert("yes");//验证成功后的操作，如ajax
        }
    });
});
function openBaiduMap(){
	/* window.open('pages/activity/baidumap.jsp',"newwindow",'_blank','top=100px', "height=700px, width=1500px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no"); */
	$.ajax({
	url:'pages/activity/baidumap.jsp',
	method:'post',
	dataType:'html',
	success:function(data){
		console.log(data);
		$("#allmap").html(data);
	}
	});
}
function backMain(){
	window.location.href="pages/main.jsp";
}
//百度地图API功能
var map = new BMap.Map("allmap");
var point = new BMap.Point(116.331398,39.897445);
map.centerAndZoom(point,12);
var geoc = new BMap.Geocoder();    

map.addEventListener("click", function(e){        
	var pt = e.point;
	geoc.getLocation(pt, function(rs){
		var addComp = rs.addressComponents;
		alert(addComp.province + "" + addComp.city + "" + addComp.district + "" + addComp.street + "" + addComp.streetNumber);
		$("#activityLocation").val(addComp.province + "" + addComp.city + "" + addComp.district + "" + addComp.street + "" + addComp.streetNumber);
	});        
});
	
	$("#activitySubBtn").on("click",function(){
		var formData = new FormData();
		formData.append("activityTitle", $("#activityTitle").val());
		formData.append("activityDetail", UE.getEditor('container').getContent());
		formData.append("activityBeginTime", $("#activityBeginTime").val());
		formData.append("activityEndTime", $("#activityEndTime").val());
		formData.append("activityLocation", $("#activityLocation").val()); 
		formData.append("picture", $("#picture")[0].files[0]);
		formData.append("activityTypeId", $("input[type=radio][name=activityType]:checked").val());
		formData.append("isCharge", $("input[type=radio][name=isCharge]:checked").val());
		formData.append("chargeMode", $("input[type=radio][name=chargeMode]:checked").val());
		formData.append("insuranceChannel", $("input[type=radio][name=insuranceChannel]:checked").val());
		formData.append("activityMaxPeople", $("#activityMaxPeople").val());   
		$.ajax({
			url:'${pageContext.request.contextPath}/activity/publish?new Date()',
			contentType: false,
           	processData: false,
			method:'post',
			data:formData,
			dataType:'json',
			success:function(data){
				console.log(data);
				alert(data.msg);
				window.location.href="pages/main.jsp";
			},
			error:function(err){
				console.log(err);
			}
		});
	})
	
</script>
</html>