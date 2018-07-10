<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>项目新增页面</title>
</head>
<body>
<div class="modal fade project-add-modal" tabindex="-1" role="dialog" aria-labelledby="project-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">项目新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_project_form">
                    <div class="form-group">
                        <label for="add_projectName" class="col-sm-2 control-label">项目名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="add_projectName" placeholder="星巴克">
                            <span id="helpBlock_add_projectName" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_projectLeader" class="col-sm-2 control-label">项目负责人</label>
                        <div class="col-sm-8">
                            <input type="text" name="leader" class="form-control" id="add_projectLeader" placeholder="牛大春">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_projectNote" class="col-sm-2 control-label">项目备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="add_projectNote" placeholder="无">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary project_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    <!-- ==========================项目新增操作=================================== -->
    // 为简单操作，省去了输入名称的验证、错误信息提示等操作
    //1 点击部门新增按钮，弹出模态框；
    //2 输入新增部门信息，点击保存按钮，发送AJAX请求到后台进行保存；
    //3 保存成功跳转最后一页
    $(".project_add_btn").click(function () {
        $('.project-add-modal').modal({
            backdrop:static,
            keyboard:true
        });

    });

    $(".project_save_btn").click(function () {
        var projectName = $("#add_projectName").val();
        var projectLeader = $("#add_projectNote").val();
        //验证省略...
        $.ajax({
            url:"/fire/project/addProject",
            type:"PUT",
            data:$(".add_project_form").serialize(),
            success:function (result) {
                if(result.code == 100){
                    alert("新增成功");
                    $('.project-add-modal').modal("hide");
                    $.ajax({
                        url:"/fire/project/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            if (result.code == 100){
                                var totalPage = result.extendInfo.totalPages;
                                window.location.href="/fire/project/getProjectList?pageNo="+totalPage;
                            }
                        }
                    });
                }else {
                    alert(result.extendInfo.add_proj_error);
                }
            }
        });
    });

    $("#add_projectName").change(function () {
        var projectName = $("#add_projectName").val();
        $.ajax({
            url:"/fire/project/checkFireystemExists",
            type:"GET",
            data:"projectName="+projectName,
            success:function (result) {
                if (result.code == 100){
                    $("#add_projectName").parent().parent().removeClass("has-error");
                    $("#add_projectName").parent().parent().addClass("has-success");
                    $("#helpBlock_add_projectName").text("项目名可用！");
                    $(".project_save_btn").attr("btn_name_exists", "success");
                }else {
                    $("#add_projectName").parent().parent().removeClass("has-success");
                    $("#add_projectName").parent().parent().addClass("has-error");
                    $("#helpBlock_add_projectName").text(result.extendInfo.name_reg_error);
                    $(".project_save_btn").attr("btn_name_exists", "error");
                }
            }
        });
    });
</script>
</body>
</html>
