<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>人员管理页面</title>
</head>
<body>
<div class="fire_user_container">
    <!-- 导航栏-->
    <%@ include file="./commom/head.jsp"%>
    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="fire_user_body" style="position:relative; top:-15px;">
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>
        <div class="user_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li>人员管理</li>
                        <li class="active">人员管理</li>
                    </ol>
                    <div>
                        <a href="#" class="user_add_btn" data-toggle="modal" data-target=".user-add-modal">新增人员</a>
                    </div>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="user_table">
                    <thead>
                        <th>人员姓名</th>
                        <th>描述</th>
                        <th>联系方式</th>
                        <th>权限</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td style="display:none">${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.note}</td>
                                <td>${user.contact}</td>
                                <td>${user.authority}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-danger user_delete_btn">删除</a>
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
                                <li><a href="/fire/user/getUserList?pageNo=1">首页</a></li>
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
                                        <li class="active"><a href="/fire/user/getUserList?pageNo=${itemPage}">${itemPage}</a></li>
                                    </c:if>
                                    <c:if test="${curPageNo != itemPage}">
                                        <li><a href="/fire/user/getUserList?pageNo=${itemPage}">${itemPage}</a></li>
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
                                <li><a href="/fire/user/getUserList?pageNo=${totalPages}">尾页</a></li>
                            </ul>
                        </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div>
    </div><!-- .fire_user_body -->
    <!-- 尾部 -->
    <%@ include file="./commom/foot.jsp"%>
</div><!-- /.dept_info -->

<%@ include file="userAdd.jsp"%>

<script type="text/javascript">
    var curPageNo = ${curPageNo};
    var totalPages = ${totalPages};
    //上一页
    $(".prePage").click(function () {
         if (curPageNo > 1){
             var pageNo = curPageNo - 1;
             $(this).attr("href", "/fire/user/getUserList?pageNo="+pageNo);
         }
    });
    //下一页
    $(".nextPage").click(function () {
        if (curPageNo < totalPages){
            var pageNo = curPageNo + 1;
            $(this).attr("href", "/fire/user/getUserList?pageNo="+pageNo);
        }
    });


    <!-- ==========================用户删除操作=================================== -->
    $(".user_delete_btn").click(function () {
        var deluserId = $(this).parent().parent().find("td:eq(0)").text();
        var deluserName = $(this).parent().parent().find("td:eq(1)").text();
        var curPageNo = ${curPageNo};
        if (confirm("确认删除【"+ deluserName +"】的信息吗？")){
            $.ajax({
                url:"/fire/user/delUser/"+deluserId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href = "/fire/user/getUserList?pageNo="+curPageNo;
                    }else {
                        alert(result.extendInfo.del_user_error);
                    }
                }
            });
        }
    });
</script>
</body>
</html>
