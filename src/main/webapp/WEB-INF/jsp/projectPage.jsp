<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>项目管理页面</title>
</head>
<body>
<div class="fire_project_container">
    <!-- 导航栏-->
    <%@ include file="./commom/head.jsp"%>
    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="fire_project_body" style="position:relative; top:-15px;">
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>
        <div class="project_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li>部署管理</li>
                        <li class="active">项目管理</li>
                    </ol>
                    <div>
                        <a href="#" class="project_add_btn" data-toggle="modal" data-target=".project-add-modal">新增项目</a>
                    </div>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="project_table">
                    <thead>
                        <th>项目名称</th>
                        <th>项目负责人</th>
                        <th>项目描述</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${projects}" var="proj">
                            <tr>
                                <td style="display:none">${proj.id}</td>
                                <td>${proj.name}</td>
                                <td>${proj.leader}</td>
                                <td>${proj.note}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary project_edit_btn" data-toggle="modal" data-target=".project-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger project_delete_btn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span class="badge">${curPageNo}</span>页，共有<span class="badge">${totalPages}</span>页，总记录数<span class="badge">${totalItems}</span>条。
                    </div>
                        <nav aria-label="Page navigation" class="pull-right">
                            <ul class="pagination">
                                <li><a href="/fire/project/getProjectList?pageNo=1">首页</a></li>
                                <c:if test="${curPageNo==1}">
                                    <li class="disabled">
                                        <a href="#" aria-label="Previous" class="prePage">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${curPageNo!=1}">
                                    <li>
                                        <a href="#" aria-label="Previous" class="prePage">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${totalPages<5?totalPages:5}" step="1" var="itemPage">
                                    <c:if test="${curPageNo == itemPage}">
                                        <li class="active"><a href="/fire/project/getProjectList?pageNo=${itemPage}">${itemPage}</a></li>
                                    </c:if>
                                    <c:if test="${curPageNo != itemPage}">
                                        <li><a href="/fire/project/getProjectList?pageNo=${itemPage}">${itemPage}</a></li>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${curPageNo==totalPages}">
                                    <li class="disabled" class="nextPage">
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${curPageNo!=totalPages}">
                                    <li>
                                        <a href="#" aria-label="Next" class="nextPage">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <li><a href="/fire/project/getProjectList?pageNo=${totalPages}">尾页</a></li>
                            </ul>
                        </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div>
    </div><!-- .fire_project_body -->
    <!-- 尾部 -->
    <%@ include file="./commom/foot.jsp"%>
</div><!-- /.dept_info -->

<%@ include file="projectAdd.jsp"%>
<%@ include file="projectUpdate.jsp"%>

<script type="text/javascript">
    var curPageNo = ${curPageNo};
    var totalPages = ${totalPages};
    //上一页
    $(".prePage").click(function () {
         if (curPageNo > 1){
             var pageNo = curPageNo - 1;
             $(this).attr("href", "/fire/project/getProjectList?pageNo="+pageNo);
         }
    });
    //下一页
    $(".nextPage").click(function () {
        if (curPageNo < totalPages){
            var pageNo = curPageNo + 1;
            $(this).attr("href", "/fire/project/getProjectList?pageNo="+pageNo);
        }
    });


    <!-- ==========================项目删除操作=================================== -->
    $(".project_delete_btn").click(function () {
        var delProjectId = $(this).parent().parent().find("td:eq(0)").text();
        var delProjectName = $(this).parent().parent().find("td:eq(1)").text();
        var curPageNo = ${curPageNo};
        if (confirm("确认删除【"+ delProjectName +"】的信息吗？")){
            $.ajax({
                url:"/fire/project/delProject/"+delProjectId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href = "/fire/project/getProjectList?pageNo="+curPageNo;
                    }else {
                        alert(result.extendInfo.del_proj_error);
                    }
                }
            });
        }
    });
</script>
</body>
</html>
