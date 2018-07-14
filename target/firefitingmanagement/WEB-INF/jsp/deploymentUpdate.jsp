<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee update Page</title>
</head>
<body>
<div class="modal fade deployment-update-modal" tabindex="-1" role="dialog" aria-labelledby="deployment-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">部署修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_deployment_form">
                    <div class="form-group">
                        <label for="update_device" class="col-sm-2 control-label">设备</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="deviceId" id="update_device">
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_place" class="col-sm-2 control-label">地点</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="placeId" id="update_place">
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_spotId" class="col-sm-2 control-label">实地编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="spotId" class="form-control" id="update_spotId" placeholder="1">
                            <span id="helpBlock_update_deploymentName" class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="update_note" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="update_note" placeholder="XXX">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary deployment_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script type="text/javascript">
    <!-- ==========================员工修改操作=================================== -->
    $(".deployment_update_btn").click(function () {
        //1 获取点击修改部署的id与name;
        var updateDeploymentId = $(this).parent().parent().find("td:eq(0)").text();

        //2 根据id或name查询出对应员工信息进行回显；
        $.ajax({
            url:"/fire/deployment/getDeploymentById/"+updateDeploymentId,
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    var deployment = result.extendInfo.deployment;
                    $("#update_device").val(deployment.deviceId);
                    $("#update_place").val(deployment.placeId);
                    $("#update_spotId").val(deployment.spotId);
                    $("#update_note").val(deployment.note);
                }
            }

        });

        //2 地点回显列表；
        $.ajax({
            url:"/fire/place/getAllPlace",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#update_place").empty();
                    $.each(result.extendInfo.places, function () {
                        var optionEle = $("<option></option>").append(this.project.name + this.district +
                            "区" + this.building + "座" + this.floor + "层").attr("value", this.id);
                        optionEle.appendTo("#update_place");

                    });
                }
            }
        });
        //3 设备回显列表；
        $.ajax({
            url:"/fire/device/getAllDevice",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#update_device").empty();
                    $.each(result.extendInfo.devices, function () {
                        var optionEle = $("<option></option>").append(this.name).attr("value", this.id);
                        optionEle.appendTo("#update_device");

                    });
                }
            }
        });
        $(".deployment_save_btn").attr("updateDeploymentId", updateDeploymentId);
    });


    $(".deployment_save_btn").click(function () {
        var updateDeploymentId = $(this).attr("updateDeploymentId");

        //5 点击更新按钮，发送AJAX请求到后台进行保存。
        $.ajax({
            url:"/fire/deployment/updateDeployment/"+updateDeploymentId,
            type:"PUT",
            data:$(".update_deployment_form").serialize(),
            success:function (result) {
                if (result.code==100){
                    alert("部署更改成功！");
                    $(".emp-update-modal").modal("hide");
                    //跳转到当前页
                    var curPage = ${curPage};
                    window.location.href="/fire/deployment/getDeploymentList?pageNo="+curPage;
                }else {
                    alert(result.extendInfo.dev_update_error);
                }
            }
        });

    });
</script>
</body>
</html>
