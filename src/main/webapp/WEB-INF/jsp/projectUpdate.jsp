<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>项目更改页面</title>
</head>
<body>
<div class="modal fade project-update-modal" tabindex="-1" role="dialog" aria-labelledby="project-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">项目更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_project_form">
                    <div class="form-group">
                        <label for="update_projectName" class="col-sm-2 control-label">项目名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="update_projectName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_projectLeader" class="col-sm-2 control-label">项目负责人</label>
                        <div class="col-sm-8">
                            <input type="text" name="leader" class="form-control" id="update_projectLeader">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_projectNote" class="col-sm-2 control-label">项目备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="update_projectNote">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary project_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
    <!-- ==========================部门新增操作=================================== -->
    //1 点击编辑按钮，发送AJAX请求查询对应id的部门信息，进行回显；
    //2 进行修改，点击更新按钮发送AJAX请求，将更改后的信息保存到数据库中；
    //3 跳转到当前更改页；
    var edit_projectId = 0;
    var curPageNo = ${curPageNo};

    $(".project_edit_btn").click(function () {
        edit_projectId = $(this).parent().parent().find("td:eq(0)").text();
        $.ajax({
            url:"/fire/project/getProjectById/"+edit_projectId,
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    var projectData = result.extendInfo.project;
                    //回显
                    $("#update_projectName").val(projectData.name);
                    $("#update_projectLeader").val(projectData.leader);
                    $("#update_projectNote").val(projectData.note);
                }else {
                    alert(result.extendInfo.get_proj_error);
                }
            }
        });
    });

    $(".project_update_btn").click(function () {
        $.ajax({
            url:"/fire/project/updateProject/"+edit_projectId,
            type:"PUT",
            data:$(".update_project_form").serialize(),
            success:function (result) {
                if(result.code == 100){
                    alert("更新成功！");
                    window.location.href = "/fire/project/getProjectList?pageNo="+curPageNo;
                } else {
                    alert(result.extendInfo.update_proj_error);
                }
            }

        });
    });


</script>
</body>
</html>
