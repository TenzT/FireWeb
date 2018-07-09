<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>设备管理页面</title>
</head>
<body>
<div class="fire_device_container">
    <!-- 导航条 -->
    <%@ include file="commom/head.jsp"%>
    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="fire_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="commom/leftsidebar.jsp"%>

        <!-- 中间员工表格信息展示内容 -->
        <div class="device_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li>部署管理</li>
                        <li class="active">设备管理</li>
                    </ol>
                    <div>
                        <a href="#" class="device_add_btn" data-toggle="modal" data-target=".firesystem-add-modal">新增设备</a>
                    </div>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="device_table">
                    <thead>
                    <th>设备名称</th>
                    <th>所属系统</th>
                    <th>设备描述</th>
                    <th>设备缩略图</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${devices}" var="dev">
                            <tr>
                                <td style="display:none">${dev.id}</td>
                                <td>${dev.name}</td>
                                <td>${dev.firesystem.name}</td>
                                <td>${dev.note}</td>
                                <%--<td><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531137103362&di=c99b45077d8e7ffee8f34d8ffda91707&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2F7_WMXFDu7XSaytAXfzbyqw%3D%3D%2F6597926286215066591.jpg"></td>--%>
                                <td>${dev.img}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary device_edit_btn" data-toggle="modal" data-target=".device-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger device_delete_btn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span class="badge">${curPage}</span>页，共有<span class="badge">${totalPages}</span>页，总记录数<span class="badge">${totalItems}</span>条。
                    </div>
                    <nav aria-label="Page navigation" class="pull-right">
                        <ul class="pagination">
                            <li><a href="/fire/device/getDeviceList?pageNo=1">首页</a></li>
                            <c:if test="${curPage==1}">
                                <li class="disabled">
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPage!=1}">
                                <li>
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${totalPages<5?totalPages:5}" step="1" var="itemPage">
                                <c:if test="${curPage == itemPage}">
                                    <li class="active"><a href="/fire/device/getDeviceList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPage != itemPage}">
                                    <li><a href="/fire/device/getDeviceList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${curPage==totalPages}">
                                <li class="disabled" class="nextPage">
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPage!=totalPages}">
                                <li>
                                    <a href="#" aria-label="Next" class="nextPage">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="/fire/device/getDeviceList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="commom/foot.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="employeeAdd.jsp"%>        <!--嵌入员工增加脚本，相当于直接写到本页面上-->
<%@ include file="employeeUpdate.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPage};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "/fire/device/getDeviceList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "/fire/device/getDeviceList?pageNo="+pageNo);
            }
        });
    })

    <!-- ==========================员工删除操作=================================== -->
    $(".device_delete_btn").click(function () {
        var curPage = ${curPage};
        var delDeviceId = $(this).parent().parent().find("td:eq(0)").text();
        var delDeviceName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delDeviceName+ "】的信息吗？")){
            $.ajax({
                url:"/fire/device/deleteDevice/"+delDeviceId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href="/fire/device/getDeviceList?pageNo="+curPage;
                    }else {
                        alert(result.extendInfo.dev_del_error);
                    }
                }
            });
        }
    });


</script>
</body>
</html>
