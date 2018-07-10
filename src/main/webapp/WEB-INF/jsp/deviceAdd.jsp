<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>设备新增页面</title>
</head>
<body>
<div class="modal fade device-add-modal" tabindex="-1" role="dialog" aria-labelledby="device-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">设备新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_device_form">
                    <div class="form-group">
                        <label for="add_deviceName" class="col-sm-2 control-label">设备名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="add_deviceName" placeholder="烟雾探测器">
                            <span id="helpBlock_add_deviceName" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_firesystem" class="col-sm-2 control-label">所属系统</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="firesystemId" id="add_firesystem">
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_note" class="col-sm-2 control-label">设备描述</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="add_note" placeholder="XXX">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_img" class="col-sm-2 control-label">设备缩略图</label>
                        <div class="col-sm-8">
                            <input type="text" name="img" class="form-control" id="add_img" placeholder="XXX">
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
    <!-------------------------------------设备新增操作-------------------------------------->
    //=======0 点击 员工新增按钮，发送AJAX请求查询部门列表信息，弹出模态框，
    // 将查询得到的部门列表信息显示在对应模态框中部门信息处。=============================
    $(".device_add_btn").click(function () {

        $.ajax({
            url:"/fire/firesystem/getAllFiresystem",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#add_firesystem").empty();
                    $.each(result.extendInfo.firesystems, function () {
                        var optionEle = $("<option></option>").append(this.name).attr("value", this.id);
                        optionEle.appendTo("#add_firesystem");

                    });
                }
            }
        });

        //激活模态框
        $('.device-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });

    //=========1 当鼠标从姓名输入框移开的时候，判断姓名输入框内的姓名是否重复 ============
    $("#add_deviceName").change(function () {
        var deviceName = $("#add_deviceName").val();
        $.ajax({
            url:"/fire/device/checkDeviceExists",
            type:"GET",
            data:"deviceName="+deviceName,
            success:function (result) {
                if (result.code == 100){
                    $("#add_deviceName").parent().parent().removeClass("has-error");
                    $("#add_deviceName").parent().parent().addClass("has-success");
                    $("#helpBlock_add_deviceName").text("用户名可用！");
                    $(".device_save_btn").attr("btn_name_exists", "success");
                }else {
                    $("#add_deviceName").parent().parent().removeClass("has-success");
                    $("#add_deviceName").parent().parent().addClass("has-error");
                    $("#helpBlock_add_deviceName").text(result.extendInfo.name_reg_error);
                    $(".device_save_btn").attr("btn_name_exists", "error");
                }
            }
        });
    });

    //3 保存

    $(".device_save_btn").click(function () {

        //1 获取到第3步：$(".emp_save_btn").attr("btn_name_exists", "success");中btn_name_exists的值
        // btn_name_exists = error，就是姓名重复
        if($(".device_save_btn").attr("btn_name_exists") == "error"){
            return false;
        }

        //================2 对输入的姓名和邮箱格式进行验证===============
        var deviceName = $("#add_deviceName").val();
        //验证格式。姓名：2-5位中文或6-16位英文和数字组合；
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u4E00-\u9FA5]{2,20})/;
        if (!regName.test(deviceName)){
            alert("测试：输入姓名格式不正确！");
            //输入框变红
            $("#add_deviceName").parent().parent().addClass("has-error");
            //输入框下面显示红色提示信息
            $("#helpBlock_add_deviceName").text("输入姓名为2-20位中文或6-16位英文和数字组合");
            return false;
        }else {
            //移除格式
            $("#add_deviceName").parent().parent().removeClass("has-error");
            $("#add_deviceName").parent().parent().addClass("has-success");
            $("#helpBlock_add_deviceName").hide();
        }

        $.ajax({
            url:"/fire/device/addDevice",
            type:"POST",
            data:$(".add_device_form").serialize(),
            success:function (result) {
                if (result.code == 100){
                    alert("设备新增成功");
                    $('#device-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"/fire/device/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            var totalPage = result.extendInfo.totalPages;
                            window.location.href="/fire/device/getDeviceList?pageNo="+totalPage;
                        }
                    })
                } else {
                    alert("设备新增失败！");
                }
            }

        });

    });
</script>
</body>
</html>
