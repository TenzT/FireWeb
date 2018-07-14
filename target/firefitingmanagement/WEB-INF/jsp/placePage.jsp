<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>地点管理页面</title>
</head>
<body>
<div class="fire_place_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>
    <!-- 中间部分 -->
    <div class="fire_body" style="position:relative; top:-15px;">
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>
        <!-- 中间员工表格信息展示内容 -->
        <div class="place_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li>部署管理</li>
                        <li class="active">地点管理</li>
                    </ol>
                    <div>
                        <a href="#" class="place_add_btn" data-toggle="modal" data-target=".place-add-modal">新增地点</a>
                    </div>
                </div>
                    <!-- Table -->
                    <table class="table table-bordered table-hover" id="place_table">
                        <thead>
                        <th>项目名称</th>
                        <th>地点</th>
                        <th>备注</th>
                        <th>操作</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${places}" var="place">
                                <tr>
                                    <td style="display:none">${place.id}</td>
                                    <td>${place.project.name}</td>
                                    <td>${place.district}区${place.building}座${place.floor}层</td>
                                    <td>${place.note}</td>
                                    <td>
                                        <a href="#" role="button" class="btn btn-primary place_update_btn" data-toggle="modal" data-target=".place-update-modal">编辑</a>
                                        <a href="#" role="button" class="btn btn-danger place_delete_btn">删除</a>
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
                            <li><a href="/fire/place/getPlaceList?pageNo=1">首页</a></li>
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
                                    <li class="active"><a href="/fire/place/getPlaceList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPage != itemPage}">
                                    <li><a href="/fire/place/getPlaceList?pageNo=${itemPage}">${itemPage}</a></li>
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
                            <li><a href="/fire/place/getPlaceList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->
    </div><!-- /.hrms_body -->
    <!-- 尾部 -->
    <%@ include file="./commom/foot.jsp"%>
</div><!-- /.container -->
<%@ include file="placeAdd.jsp"%>        <!--嵌入地点增加脚本，相当于直接写到本页面上-->
<%@ include file="placeUpdate.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPage};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "/fire/place/getPlaceList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "/fire/place/getPlaceList?pageNo="+pageNo);
            }
        });
    })

    <!-- ==========================员工删除操作=================================== -->
    $(".place_delete_btn").click(function () {
        var curPage = ${curPage};
        var delPlaceId = $(this).parent().parent().find("td:eq(0)").text();
        var delPlaceName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delPlaceName+ "】的信息吗？")){
            $.ajax({
                url:"/fire/place/deletePlace/"+delPlaceId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href="/fire/place/getPlaceList?pageNo="+curPage;
                    }else {
                        alert(result.extendInfo.place_del_error);
                    }
                }
            });
        }
    });


</script>
</body>
</html>
