<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>人员新增页面</title>
</head>
<body>
<div class="modal fade user-add-modal" tabindex="-1" role="dialog" aria-labelledby="user-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">人员新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_user_form">
                    <div class="form-group">
                        <label for="add_userName" class="col-sm-2 control-label">人员姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="add_userName" placeholder="王阳明">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_userNote" class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-8">
                            <input type="text" name="note" class="form-control" id="add_userNote" placeholder="XXX">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_userContact" class="col-sm-2 control-label">联系方式</label>
                        <div class="col-sm-8">
                            <input type="text" name="contact" class="form-control" id="add_userContact" placeholder="XXX">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_userAuthority" class="col-sm-2 control-label">用户权限</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="authority" id="add_userAuthority">
                                    <option value="管理员">admin</option>
                                    <option value="员工">clerk</option>
                                    <option value="合作单位">partner</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add_userUsername" class="col-sm-2 control-label">登陆用户名</label>
                        <div class="col-sm-8">
                            <input type="text" name="username" class="form-control" id="add_userUsername" placeholder="wangyangming">
                            <span id="helpBlock_add_userUsername" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_userPassword" class="col-sm-2 control-label">登陆密码</label>
                        <div class="col-sm-8">
                            <input type="" name="password" class="form-control" id="add_userPassword" value="0000">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary user_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    $(".user_add_btn").click(function () {
        //激活模态框
        $('.user-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });

    //=========1 当鼠标从姓名输入框移开的时候，判断姓名输入框内的姓名是否重复 ============
    $("#add_userUsername").change(function () {
        var userUsername = $("#add_userUsername").val();
        $.ajax({
            url:"/fire/user/checkUsernameExists",
            type:"GET",
            data:"userUsername="+userUsername,
            success:function (result) {
                if (result.code == 100){
                    $("#add_userUsername").parent().parent().removeClass("has-error");
                    $("#add_userUsername").parent().parent().addClass("has-success");
                    $("#helpBlock_add_userUsername").text("用户名可用！");
                    $(".user_save_btn").attr("btn_username_exists", "success");
                }else {
                    $("#add_userUserName").parent().parent().removeClass("has-success");
                    $("#add_userUserName").parent().parent().addClass("has-error");
                    $("#helpBlock_add_userUsername").text(result.extendInfo.name_reg_error);
                    $(".user_save_btn").attr("btn_username_exists", "error");
                }
            }
        });
    });

    //3 保存

    $(".user_save_btn").click(function () {

        var userUsername = $("#add_userUsername").val();
        //验证格式。姓名：2-5位中文或6-16位英文和数字组合；
        var regName = /(^[a-zA-Z_]{4,16}$)/;
        if (!regName.test(userUsername)){
            alert("测试：输入用户名格式不正确！");
            //输入框变红
            $("#add_userUsername").parent().parent().addClass("has-error");
            //输入框下面显示红色提示信息
            $("#helpBlock_add_userUsername").text("4-16位英文和数字组合");
            return false;
        }else {
            //移除格式
            $("#add_userUserName").parent().parent().removeClass("has-error");
            $("#add_userUserName").parent().parent().addClass("has-success");
            $("#helpBlock_add_userUsername").hide();
        }

        $.ajax({
            url:"/fire/user/addUser",
            type:"POST",
            data:$(".add_user_form").serialize(),
            success:function (result) {
                if (result.code == 100){
                    alert("人员新增成功");
                    $('#user-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"/fire/user/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            var totalPage = result.extendInfo.totalPages;
                            window.location.href="/fire/user/getUserList?pageNo="+totalPage;
                        }
                    })
                } else {
                    alert("人员新增失败！");
                }
            }
        });
    });
</script>
</body>
</html>
