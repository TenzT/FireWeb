<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <%--<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->--%>
    <%--<title>leftsidebar</title>--%>
    <%--<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <%--<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>
    <%--<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>--%>
    <%--<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>
</head>
<body>
<div class="panel-group col-sm-2" id="fire_sidebar_left" role="tablist" aria-multiselectable="true">
    <ul class="nav nav-pills nav-stacked work_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_work">
                <span class="glyphicon glyphicon-cog" aria-hidden="true">工作</span>
            </a>
            <!--<span class="glyphicon glyphicon-cog" aria-hidden="true">工作</span>-->
            <ul class="nav nav-pills nav-stacked" id="collapse_work">
                <li role="presentation"><a href="#" class="work_mode">工作模式</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked maintenance_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_maintenance">
                <span class="glyphicon glyphicon-folder-open" aria-hidden="true">保养记录</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_maintenance">
                <li role="presentation"><a href="#" class="maintenance_record">所有记录</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked maintenance_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_deployment">
                <span class="glyphicon glyphicon-briefcase" aria-hidden="true">部署管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_deployment">
                <li role="presentation"><a href="#" class="device_management">设备管理</a></li>
                <li role="presentation"><a href="#" class="system_management">消防系统管理</a></li>
                <li role="presentation"><a href="#" class="project_management">项目管理</a></li>
                <li role="presentation"><a href="#" class="deployment_management">部署管理</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked user_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_user">
                <span class="glyphicon glyphicon-user" aria-hidden="true">人员管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_user">
                <li role="presentation"><a href="#" class="user_management">人员管理</a></li>
            </ul>
        </li>
    </ul>
</div>
<script type="text/javascript">
    //CSS的写法：根据 class 选择元素，并用.click(function)来监听
    //跳转到工作页面
    $(".work_mode").click(function () {
        $(this).attr("href", "/fire/emp/getEmpList");
    });
    //跳转到设备页面
    $(".device_management").click(function () {
        $(this).attr("href", "/fire/device/getDeviceList");
    });
    //跳转到系统页面
    $(".system_management").click(function () {
        $(this).attr("href", "/fire/firesystem/getFiresystemList");
    });
    //部门清零这个功能暂未实现
    $(".project_management").click(function () {
        $(this).attr("href", "/fire/project/getProjectList");
    });

    //人员管理这个功能暂未实现
    $(".user_management").click(function () {
        $(this).attr("href", "/fire/user/getUserList");
    });
</script>
</body>
</html>
