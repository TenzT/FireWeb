<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>保养记录新增页面</title>
</head>
<body>
<div class="modal fade maintenance-add-modal" tabindex="-1" role="dialog" aria-labelledby="maintenance-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">保养记录新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_maintenance_form">
                    <div class="form-group">
                        <label for="add_user" class="col-sm-2 control-label">负责人</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="add_user" value="${sessionScope.userName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_deployment" class="col-sm-2 control-label">部署信息</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="deploymentId" id="add_deployment">
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" checked="checked" name="record" id="add_Good" value="G"> 正常
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="record" id="add_Bad" value="B"> 不正常
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add_date" class="col-sm-2 control-label">日期</label>
                        <div class="col-sm-8">
                            <input type="text" name="date" class="form-control" id="add_date">
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
                <button type="button" class="btn btn-primary maintenance_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    <!-------------------------------------保养记录新增操作-------------------------------------->
    //=======0 点击 员工新增按钮，发送AJAX请求查询部门列表信息，弹出模态框，
    // 将查询得到的部门列表信息显示在对应模态框中部门信息处。=============================
    $(".maintenance_add_btn").click(function () {
        //添加时间
        var time = new Date();
        $("#add_date").val(time.getFullYear() + "-" +
            (time.getMonth()+1) + "-" + time.getDate()); //Js的月份从0开始
        $("#add_date").attr("readonly","true");

        //添加保养人
        <%--$("#add_user").val(${sessionScope.userName});--%>
        $("#add_user").attr("readonly","true");

        // $.ajax({
        //     url:"/fire/user/getAllUserName",
        //     type:"GET",
        //     success:function (result) {
        //         if (result.code == 100){
        //             $("#add_user").empty();
        //             $.each(result.extendInfo.users, function () {
        //                 var optionEle = $("<option></option>").append(this.name).attr("value", this.id);
        //                 optionEle.appendTo("#add_user");
        //
        //             });
        //         }
        //     }
        // });

        $.ajax({
            url:"/fire/deployment/getAllDeployment",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#add_deployment").empty();
                    $.each(result.extendInfo.deployments, function () {
                        var optionEle = $("<option></option>").append(this.device.name + ":" + this.place.project.name + this.place.district +
                            "区" + this.place.building + "座" + this.place.floor + "层" + this.spotId +"号").attr("value", this.id);
                        optionEle.appendTo("#add_deployment");

                    });
                }
            }
        });

        //激活模态框
        $('.maintenance-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });

    //3 保存

    $(".maintenance_save_btn").click(function () {

        $.ajax({
            url:"/fire/maintenance/addMaintenance",
            type:"POST",
            data:$(".add_maintenance_form").serialize(),
            success:function (result) {
                if (result.code == 100){
                    alert("保养记录新增成功");
                    $('#maintenance-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"/fire/maintenance/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            var totalPage = result.extendInfo.totalPages;
                            window.location.href="/fire/maintenance/getMaintenanceList?pageNo="+totalPage;
                        }
                    })
                } else {
                    alert("保养记录新增失败！");
                }
            }

        });

    });
</script>
</body>
</html>
