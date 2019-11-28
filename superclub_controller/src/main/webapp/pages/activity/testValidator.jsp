<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="static/plugins/bootstrapvalidator/dist/css/bootstrapValidator.min.css">
<script type="text/javascript" src="static/plugins/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="static/plugins/bootstrapvalidator/dist/js/bootstrapValidator.min.js"></script>
</head>
<body>
<form id="defaultForm" method="post" class="form-horizontal" action="target.php"> 
    <div class="form-group"> 
        <label class="col-lg-3 control-label">用户名</label> 
        <div class="col-lg-5"> 
            <input type="text" class="form-control" name="username" /> 
        </div> 
    </div> 
    <div class="form-group"> 
        <label class="col-lg-3 control-label">邮箱</label> 
        <div class="col-lg-5"> 
            <input type="text" class="form-control" name="email" /> 
        </div> 
    </div> 
 
    <div class="form-group"> 
        <label class="col-lg-3 control-label">生日</label> 
        <div class="col-lg-5"> 
            <input type="text" class="form-control" name="birthday" /> (YYYY-MM-DD) 
        </div> 
    </div> 
 
    <div class="form-group"> 
        <div class="col-lg-9 col-lg-offset-3"> 
            <button type="button" class="btn btn-info" id="validateBtn">自动验证</button> 
        </div> 
    </div> 
</form>
</body>
<script type="text/javascript">
$('#defaultForm').bootstrapValidator({ 
	live:'enabled';
    message: '值无效', 
    feedbackIcons: { 
        valid: 'glyphicon glyphicon-ok', 
        invalid: 'glyphicon glyphicon-remove', 
        validating: 'glyphicon glyphicon-refresh' 
    }, 
    fields: { 
        username: { 
            message: '用户名无效', 
            validators: { 
                notEmpty: { 
                    message: '用户名不能为空' 
                }, 
                stringLength: { 
                    min: 6, 
                    max: 30, 
                    message: '用户名长度必须在6到30位之间' 
                }, 
                regexp: { 
                    regexp: /^[a-zA-Z0-9_\.]+$/, 
                    message: '用户名只能由字母、数字、点和下划线组成'
                }, 
                remote: { 
                    url: 'remote.php',
                    message: '用户名不可用'
                }, 
                different: { 
                    field: 'password', 
                    message: '用户名和密码不能相同'
                } 
            } 
        }, 
        email: { 
            validators: { 
                emailAddress: { 
                    message: '输入的不是一个有效的电子邮件地址' 
                },
                stringLength: { 
                    min: 6, 
                    max: 30, 
                    message: '邮箱长度必须在6到30位之间' 
                }, 
                regexp:{ 
                    regexp: /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/, 
                    message: '邮箱格式不对' 
                }
            } 
        }, 
        birthday: { 
            validators: { 
                message: '输入的不是一个有效的电子邮件地址',
                stringLength: { 
                    min: 6, 
                    max: 30, 
                    message: '邮箱长度必须在6到30位之间' 
                }, 
                date: {//验证指定的日期格式
                    format: 'YYYY-MM-DD',
                    message: '日期格式不正确'
                }
            } 
        }
    } 
});
function showToast(msg,shortCutFunction)
{
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "progressBar": true,
        "positionClass": "toast-bottom-right",
        "onclick": null,
        "showDuration": "400",
        "hideDuration": "1000",
        "timeOut": "7000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    toastr[shortCutFunction](msg,"提示");
}

$("#validateBtn").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
    $("#defaultForm").bootstrapValidator('validate');//提交验证
    if ($("#defaultForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
    	showToast("2345678","error");
        alert("yes"); //验证成功后的操作，如ajax
    }
});
</script>
</html>