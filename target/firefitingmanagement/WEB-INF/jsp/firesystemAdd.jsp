<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>系统新增页面</title>
</head>
<body>
<div class="modal fade firesystem-add-modal" tabindex="-1" role="dialog" aria-labelledby="firesystem-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">系统新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_firesystem_form">
                    <div class="form-group">
                        <label for="add_firesystemName" class="col-sm-2 control-label">系统名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="add_firesystemName" placeholder="消防供电配电">
                            <span id="helpBlock_add_firesystemName" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_firesystemNote" class="col-sm-2 control-label">系统备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="add_firesystemNote" placeholder="无">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary firesystem_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    <!-- ==========================部门新增操作=================================== -->
    // 为简单操作，省去了输入名称的验证、错误信息提示等操作
    //1 点击部门新增按钮，弹出模态框；
    //2 输入新增部门信息，点击保存按钮，发送AJAX请求到后台进行保存；
    //3 保存成功跳转最后一页
    $(".firesystem_add_btn").click(function () {
        $('.firesystem-add-modal').modal({
            backdrop:static,
            keyboard:true
        });

    });

    $(".firesystem_save_btn").click(function () {
        var firesystemName = $("#add_firesystemName").val();
        var firesystemLeader = $("#add_firesystemNote").val();
        //验证省略...
        $.ajax({
            url:"/fire/firesystem/addFiresystem",
            type:"PUT",
            data:$(".add_firesystem_form").serialize(),
            success:function (result) {
                if(result.code == 100){
                    alert("新增成功");
                    $('.firesystem-add-modal').modal("hide");
                    $.ajax({
                        url:"/fire/firesystem/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            if (result.code == 100){
                                var totalPage = result.extendInfo.totalPages;
                                window.location.href="/fire/firesystem/getFiresystemList?pageNo="+totalPage;
                            }
                        }
                    });
                }else {
                    alert(result.extendInfo.add_system_error);
                }
            }
        });
    });

    $("#add_firesystemName").change(function () {
        var firesystemName = $("#add_firesystemName").val();
        $.ajax({
            url:"/fire/firesystem/checkFireystemExists",
            type:"GET",
            data:"firesystemName="+firesystemName,
            success:function (result) {
                if (result.code == 100){
                    $("#add_firesystemName").parent().parent().removeClass("has-error");
                    $("#add_firesystemName").parent().parent().addClass("has-success");
                    $("#helpBlock_add_firesystemName").text("用户名可用！");
                    $(".firesystem_save_btn").attr("btn_name_exists", "success");
                }else {
                    $("#add_firesystemName").parent().parent().removeClass("has-success");
                    $("#add_firesystemName").parent().parent().addClass("has-error");
                    $("#helpBlock_add_firesystemName").text(result.extendInfo.name_reg_error);
                    $(".firesystem_save_btn").attr("btn_name_exists", "error");
                }
            }
        });
    });
</script>
</body>
</html>
