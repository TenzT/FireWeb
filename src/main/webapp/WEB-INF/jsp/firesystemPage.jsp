<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>消防系统管理页面</title>
</head>
<body>
<div class="fire_firesystem_container">
    <!-- 导航栏-->
    <%@ include file="./commom/head.jsp"%>
    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="fire_firesystem_body" style="position:relative; top:-15px;>
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 部门表格内容 -->
        <div class="firesystem_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li>部署管理</li>
                        <li class="active">消防系统管理</li>
                    </ol>
                    <div>
                        <a href="#" class="firesystem_add_btn" data-toggle="modal" data-target=".firesystem-add-modal">新增系统</a>
                    </div>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="firesystem_table">
                    <thead>
                        <th>系统名称</th>
                        <th>系统描述</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${firesystems}" var="sys">
                            <tr>
                                <td style="display:none">${sys.id}</td>
                                <td>${sys.name}</td>
                                <td>${sys.note}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary firesystem_edit_btn" data-toggle="modal" data-target=".firesystem-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger firesystem_delete_btn">删除</a>
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
                            <li><a href="/fire/firesystem/getFiresystemList?pageNo=1">首页</a></li>
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
                                    <li class="active"><a href="/fire/firesystem/getFiresystemList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPageNo != itemPage}">
                                    <li><a href="/fire/firesystem/getFiresystemList?pageNo=${itemPage}">${itemPage}</a></li>
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
                            <li><a href="/fire/firesystem/getFiresystemList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.dept_info -->
    </div><!-- /.hrms_dept_body -->

    <%@ include file="firesystemAdd.jsp"%>
    <%@ include file="firesystemUpdate.jsp"%>

    <!-- 尾部-->
    <%@ include file="./commom/foot.jsp"%>

<script type="text/javascript">
    var curPageNo = ${curPageNo};
    var totalPages = ${totalPages};
    //上一页
    $(".prePage").click(function () {
         if (curPageNo > 1){
             var pageNo = curPageNo - 1;
             $(this).attr("href", "/fire/firesystem/getFiresystemList?pageNo="+pageNo);
         }
    });
    //下一页
    $(".nextPage").click(function () {
        if (curPageNo < totalPages){
            var pageNo = curPageNo + 1;
            $(this).attr("href", "/fire/firesystem/getFiresystemList?pageNo="+pageNo);
        }
    });


    <!-- ==========================系统删除操作=================================== -->
    $(".firesystem_delete_btn").click(function () {
        var delFiresystemId = $(this).parent().parent().find("td:eq(0)").text();
        var delFiresystemName = $(this).parent().parent().find("td:eq(1)").text();
        var curPageNo = ${curPageNo};
        if (confirm("确认删除【"+ delFiresystemName +"】的信息吗？")){
            $.ajax({
                url:"/fire/firesystem/delFireSystem/"+delFiresystemId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href = "/fire/firesystem/getFiresystemList?pageNo="+curPageNo;
                    }else {
                        alert(result.extendInfo.del_sys_error);
                    }
                }
            });
        }
    });
</script>
</body>
</html>
