<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>部署新增页面</title>
</head>
<body>
<div class="modal fade deployment-add-modal" tabindex="-1" role="dialog" aria-labelledby="deployment-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">部署新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_deployment_form">
                    <div class="form-group">
                        <label for="add_device" class="col-sm-2 control-label">设备</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="deviceId" id="add_device">
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_place" class="col-sm-2 control-label">地点</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="placeId" id="add_place">
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_deploymentName" class="col-sm-2 control-label">实地编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="spotId" class="form-control" id="add_deploymentName" placeholder="1">
                            <span id="helpBlock_add_deploymentName" class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add_note" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="add_note" placeholder="XXX">
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
    <!-------------------------------------部署新增操作-------------------------------------->
    //=======0 点击 员工新增按钮，发送AJAX请求查询部门列表信息，弹出模态框，
    // 将查询得到的部门列表信息显示在对应模态框中部门信息处。=============================
    $(".deployment_add_btn").click(function () {

        $.ajax({
            url:"/fire/device/getAllDevice",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#add_device").empty();
                    $.each(result.extendInfo.devices, function () {
                        var optionEle = $("<option></option>").append(this.name).attr("value", this.id);
                        optionEle.appendTo("#add_device");

                    });
                }
            }
        });

        $.ajax({
            url:"/fire/place/getAllPlace",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#add_place").empty();
                    $.each(result.extendInfo.places, function () {
                        var optionEle = $("<option></option>").append(this.project.name + this.district +
                            "区" + this.building + "座" + this.floor + "层").attr("value", this.id);
                        optionEle.appendTo("#add_place");

                    });
                }
            }
        });

        //激活模态框
        $('.deployment-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });

    //3 保存

    $(".deployment_save_btn").click(function () {

        $.ajax({
            url:"/fire/deployment/addDeployment",
            type:"POST",
            data:$(".add_deployment_form").serialize(),
            success:function (result) {
                if (result.code == 100){
                    alert("部署新增成功");
                    $('#deployment-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"/fire/deployment/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            var totalPage = result.extendInfo.totalPages;
                            window.location.href="/fire/deployment/getDeploymentList?pageNo="+totalPage;
                        }
                    })
                } else {
                    alert("部署新增失败！");
                }
            }

        });

    });
</script>
</body>
</html>
