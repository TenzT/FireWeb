<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部署管理页面</title>
</head>
<body>
<div class="fire_deployment_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>
    <!-- 中间部分 -->
    <div class="fire_body" style="position:relative; top:-15px;">
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>
        <!-- 中间员工表格信息展示内容 -->
        <div class="deployment_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li>部署管理</li>
                        <li class="active">部署管理</li>
                    </ol>
                    <div>
                        <a href="#" class="deployment_add_btn" data-toggle="modal" data-target=".deployment-add-modal">新增部署</a>
                    </div>
                </div>
                    <!-- Table -->
                    <table class="table table-bordered table-hover" id="deployment_table">
                        <thead>
                        <th>设备名称</th>
                        <th>项目名称</th>
                        <th>部署地点</th>
                        <th>实地编号</th>
                        <%--<th>备注</th>--%>
                        <th>操作</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${deployments}" var="deployment">
                                <tr>
                                    <td style="display:none">${deployment.id}</td>
                                    <td>${deployment.device.name}</td>
                                    <td>${deployment.place.project.name}</td>
                                    <td>${deployment.place.district}区${deployment.place.building}座${deployment.place.floor}层</td>
                                    <td>${deployment.spotId}</td>
                                    <%--<td>${deployment.note}</td>--%>
                                    <td>
                                        <a href="#" role="button" class="btn btn-primary deployment_update_btn" data-toggle="modal" data-target=".deployment-update-modal">编辑</a>
                                        <a href="#" role="button" class="btn btn-danger deployment_delete_btn">删除</a>
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
                            <li><a href="/fire/deployment/getDeploymentList?pageNo=1">首页</a></li>
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
                                    <li class="active"><a href="/fire/deployment/getDeploymentList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPage != itemPage}">
                                    <li><a href="/fire/deployment/getDeploymentList?pageNo=${itemPage}">${itemPage}</a></li>
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
                            <li><a href="/fire/deployment/getDeploymentList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->
    </div><!-- /.hrms_body -->
    <!-- 尾部 -->
    <%@ include file="./commom/foot.jsp"%>
</div><!-- /.container -->
<%@ include file="deploymentAdd.jsp"%>        <!--嵌入部署增加脚本，相当于直接写到本页面上-->
<%@ include file="deploymentUpdate.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPage};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "/fire/deployment/getDeploymentList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "/fire/deployment/getDeploymentList?pageNo="+pageNo);
            }
        });
    })

    <!-- ==========================地点删除操作=================================== -->
    $(".deployment_delete_btn").click(function () {
        var curPage = ${curPage};
        var delDeploymentId = $(this).parent().parent().find("td:eq(0)").text();
        var delDeploymentName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delDeploymentName+ "】的信息吗？")){
            $.ajax({
                url:"/fire/deployment/deleteDeployment/"+delDeploymentId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href="/fire/deployment/getDeploymentList?pageNo="+curPage;
                    }else {
                        alert(result.extendInfo.deployment_del_error);
                    }
                }
            });
        }
    });


</script>
</body>
</html>
