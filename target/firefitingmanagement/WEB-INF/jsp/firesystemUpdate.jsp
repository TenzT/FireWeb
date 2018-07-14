<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>系统更改页面</title>
</head>
<body>
<div class="modal fade firesystem-update-modal" tabindex="-1" role="dialog" aria-labelledby="firesystem-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">系统更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_firesystem_form">
                    <div class="form-group">
                        <label for="update_firesystemName" class="col-sm-2 control-label">系统名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="update_firesystemName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_firesystemNote" class="col-sm-2 control-label">系统备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="update_firesystemNote">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary firesystem_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
    <!-- ==========================部门新增操作=================================== -->
    //1 点击编辑按钮，发送AJAX请求查询对应id的部门信息，进行回显；
    //2 进行修改，点击更新按钮发送AJAX请求，将更改后的信息保存到数据库中；
    //3 跳转到当前更改页；
    var edit_firesystemId = 0;
    var curPageNo = ${curPageNo};

    $(".firesystem_edit_btn").click(function () {
        edit_firesystemId = $(this).parent().parent().find("td:eq(0)").text();
        $.ajax({
            url:"/fire/firesystem/getFiresystemById/"+edit_firesystemId,
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    var firesystemData = result.extendInfo.firesystem;
                    //回显
                    $("#update_firesystemName").val(firesystemData.name);
                    $("#update_firesystemNote").val(firesystemData.note);
                }else {
                    alert(result.extendInfo.get_firesystem_error);
                }
            }
        });
    });

    $(".firesystem_update_btn").click(function () {
        $.ajax({
            url:"/fire/firesystem/updateFiresystem/"+edit_firesystemId,
            type:"PUT",
            data:$(".update_firesystem_form").serialize(),
            success:function (result) {
                if(result.code == 100){
                    alert("更新成功！");
                    window.location.href = "/fire/firesystem/getFiresystemList?pageNo="+curPageNo;
                } else {
                    alert(result.extendInfo.update_firesystem_error);
                }
            }

        });
    });


</script>
</body>
</html>
