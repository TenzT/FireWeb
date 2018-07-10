<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee update Page</title>
</head>
<body>
<div class="modal fade device-update-modal" tabindex="-1" role="dialog" aria-labelledby="device-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">设备修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_device_form">
                    <div class="form-group">
                        <label for="update_deviceName" class="col-sm-2 control-label">设备名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="update_deviceName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_firesystem" class="col-sm-2 control-label">所属系统</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="firesystemId" id="update_firesystem" >
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_note" class="col-sm-2 control-label">设备描述</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="update_note" placeholder="XXX">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_img" class="col-sm-2 control-label">设备缩略图</label>
                        <div class="col-sm-8">
                            <input type="text" name="img" class="form-control" id="update_img" placeholder="XXX">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary device_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script type="text/javascript">
    <!-- ==========================员工修改操作=================================== -->
    $(".device_update_btn").click(function () {
        //1 获取点击修改设备的id与name;
        var updateDeviceId = $(this).parent().parent().find("td:eq(0)").text();

        //2 根据id或name查询出对应员工信息进行回显；
        $.ajax({
            url:"/fire/device/getDeviceById/"+updateDeviceId,
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    var device = result.extendInfo.device;
                    $("#update_deviceName").val(device.name);
                    $("#update_firesystem").val(device.firesystemId);
                    $("#update_note").val(device.note);
                    $("#update_img").val(device.img);
                }
            }

        });

        //2 部门回显列表；
        $.ajax({
            url:"/fire/firesystem/getAllFiresystem",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#update_firesystem").empty();
                    $.each(result.extendInfo.firesystems, function () {
                        var optEle = $("<option></option>").append(this.name).attr("value", this.id);
                        optEle.appendTo("#update_firesystem");
                    });
                }
            }

        });

        $(".device_save_btn").attr("updateDeviceId", updateDeviceId);
    });


    $(".device_save_btn").click(function () {
        var updateDeviceId = $(this).attr("updateDeviceId");

        //5 点击更新按钮，发送AJAX请求到后台进行保存。
        $.ajax({
            url:"/fire/device/updateDevice/"+updateDeviceId,
            type:"PUT",
            data:$(".update_device_form").serialize(),
            success:function (result) {
                if (result.code==100){
                    alert("设备更改成功！");
                    $(".emp-update-modal").modal("hide");
                    //跳转到当前页
                    var curPage = ${curPage};
                    window.location.href="/fire/device/getDeviceList?pageNo="+curPage;
                }else {
                    alert(result.extendInfo.dev_update_error);
                }
            }
        });

    });
</script>
</body>
</html>
