<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee update Page</title>
</head>
<body>
<div class="modal fade place-update-modal" tabindex="-1" role="dialog" aria-labelledby="place-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">地点修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_place_form">
                    <div class="form-group">
                        <label for="update_project" class="col-sm-2 control-label">所属项目</label>
                        <div class="col-sm-8">
                            <div class="checkbox">
                                <select class="form-control" name="projectId" id="update_project" >
                                    <%-- <option value="1">CEO</option>--%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_placeDistrict" class="col-sm-2 control-label">区</label>
                        <div class="col-sm-8">
                            <input type="text" name="district" class="form-control" id="update_placeDistrict">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_placeBuilding" class="col-sm-2 control-label">座</label>
                        <div class="col-sm-8">
                            <input type="text" name="building" class="form-control" id="update_placeBuilding" placeholder="XXX">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_placeFloor" class="col-sm-2 control-label">层</label>
                        <div class="col-sm-8">
                            <input type="text" name="floor" class="form-control" id="update_placeFloor" placeholder="XXX">
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
                <button type="button" class="btn btn-primary place_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script type="text/javascript">
    <!-- ==========================员工修改操作=================================== -->
    $(".place_update_btn").click(function () {
        //1 获取点击修改地点的id与name;
        var updatePlaceId = $(this).parent().parent().find("td:eq(0)").text();

        //2 根据id或name查询出对应员工信息进行回显；
        $.ajax({
            url:"/fire/place/getPlaceById/"+updatePlaceId,
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    var place = result.extendInfo.place;
                    $("#update_project").val(place.projectId);
                    $("#update_placeDistrict").val(place.district);
                    $("#update_placeBuilding").val(place.building);
                    $("#update_placeFloor").val(place.floor);
                    $("#update_note").val(place.note);
                }
            }

        });

        //2 部门回显列表；
        $.ajax({
            url:"/fire/project/getAllProject",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $("#update_project").empty();
                    $.each(result.extendInfo.projects, function () {
                        var optEle = $("<option></option>").append(this.name).attr("value", this.id);
                        optEle.appendTo("#update_project");
                    });
                }
            }

        });

        $(".place_save_btn").attr("updatePlaceId", updatePlaceId);
    });


    $(".place_save_btn").click(function () {
        var updatePlaceId = $(this).attr("updatePlaceId");

        //5 点击更新按钮，发送AJAX请求到后台进行保存。
        $.ajax({
            url:"/fire/place/updatePlace/"+updatePlaceId,
            type:"PUT",
            data:$(".update_place_form").serialize(),
            success:function (result) {
                if (result.code==100){
                    alert("地点更改成功！");
                    $(".emp-update-modal").modal("hide");
                    //跳转到当前页
                    var curPage = ${curPage};
                    window.location.href="/fire/place/getPlaceList?pageNo="+curPage;
                }else {
                    alert(result.extendInfo.dev_update_error);
                }
            }
        });

    });
</script>
</body>
</html>
