<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>新增页面</title>
</head>
<body>
<div class="modal fade place-add-modal" tabindex="-1" role="dialog" aria-labelledby="place-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">地点新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_place_form">
                    <div class="form-group">
                        <label for="add_project" class="col-sm-2 control-label">所属项目</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="projectId" id="add_project">
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_district" class="col-sm-2 control-label">区</label>
                        <div class="col-sm-2">
                            <input type="text" name="district" class="form-control" id="add_district" placeholder="A">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_building" class="col-sm-2 control-label">座</label>
                        <div class="col-sm-2" >
                            <input type="text" name="building" class="form-control" id="add_building" placeholder="1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_floor" class="col-sm-2 control-label">层</label>
                        <div class="col-sm-2" id="place">
                            <input type="text" name="floor" class="form-control" id="add_floor" placeholder="1">
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
                <button type="button" class="btn btn-primary place_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    <!-------------------------------------地点新增操作-------------------------------------->
    //=======0 点击 员工新增按钮，发送AJAX请求查询部门列表信息，弹出模态框，
    // 将查询得到的部门列表信息显示在对应模态框中部门信息处。=============================
    $(".place_add_btn").click(function () {

        $.ajax({
            url:"/fire/project/getAllProject",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#add_project").empty();
                    $.each(result.extendInfo.projects, function () {
                        var optionEle = $("<option></option>").append(this.name).attr("value", this.id);
                        optionEle.appendTo("#add_project");

                    });
                }
            }
        });

        //激活模态框
        $('.place-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });


    //3 保存

    $(".place_save_btn").click(function () {

        $.ajax({
            url:"/fire/place/addPlace",
            type:"POST",
            data:$(".add_place_form").serialize(),
            success:function (result) {
                if (result.code == 100){
                    alert("地点新增成功");
                    $('#place-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"/fire/place/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            var totalPage = result.extendInfo.totalPages;
                            window.location.href="/fire/place/getPlaceList?pageNo="+totalPage;
                        }
                    })
                } else {
                    alert("地点新增失败！");
                }
            }

        });

    });
</script>
</body>
</html>
