<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/29/2024
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file= "/common/taglib.jsp" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<c:url var="buildingListURL" value="/admin/building-list" />
<c:url var="buildingAPI" value="/api/building"/>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="<c:url value="/admin/home"/>">
                        Trang chủ
                    </a>
                </li>
                <li class="active">Danh sách người dùng</li>
            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content">





            <div class="row">
                <div class="col-xs-12 ">
                    <div class="widget-box ui-sortable-handle">
                        <div class="widget-header">
                            <h5 class="widget-title">Tìm kiếm</h5>

                            <div class="widget-toolbar">




                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>


                            </div>
                        </div>

                        <div class="widget-body" style="font-family: 'Times New Roman', Times, serif;">
                            <div class="widget-main">
                                <form:form id="listForm" modelAttribute="modelSearch" action="${buildingListURL}"  method="GET">
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="col-xs-12 ">
                                                <div class="col-xs-6">
                                                    <label class="name">Tên tòa nhà</label>
                                                        <%--<input type="text" class="form-control" name="name" value="${modelSearch.name}">--%>
                                                    <form:input path="name"  type="text" class="form-control" name="name" />
                                                </div>
                                                <div class="col-xs-6">
                                                    <label class="name">Diện tích sàn</label>
                                                    <input type="number" class="form-control" name="floorArea" value="`${modelSearch.floorArea}">
                                                </div>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <div class="col-xs-12 ">
                                                <div class="col-xs-2">
                                                    <label class="name">Quận</label>
                                                    <form:select class="form-control" name="district" path="district">
                                                        <form:option value="">---Chọn Quận---</form:option>
                                                        <form:options items="${districts}"></form:options>

                                                    </form:select>
                                                </div>
                                                <div class="col-xs-5">
                                                    <label class="name">Phường</label>
                                                    <input type="text" class="form-control" name="ward" value="">
                                                </div>
                                                <div class="col-xs-5">
                                                    <label class="name">Đường</label>
                                                    <input type="text" class="form-control" name="street" value="">
                                                </div>

                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-xs-12 ">
                                                <div class="col-xs-4">
                                                    <label class="name">Số tầng hầm</label>
                                                    <input type="number"class="form-control" name="numberofBasement" value="">
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Hướng</label>
                                                    <input type="text" class="form-control" name="direction" value="">
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Hạng</label>
                                                    <input type="text" class="form-control" name="level" value="">
                                                </div>

                                            </div>
                                        </div>
                                        <div class="col-xs-12 ">
                                            <div class="col-xs-3">
                                                <label class="name">Diện tích từ</label>
                                                <input type="number"class="form-control" name="areaFrom" value="">
                                            </div>
                                            <div class="col-xs-3">
                                                <label class="name">Diện tích đến</label>
                                                <input type="number" class="form-control" name="areaTo" value="">
                                            </div>
                                            <div class="col-xs-3">
                                                <label class="name">Giá thuê từ</label>
                                                <input type="number" class="form-control" name="rentPriceFrom" value="">
                                            </div>
                                            <div class="col-xs-3">
                                                <label class="name">Giá thuê đến</label>
                                                <input type="number" class="form-control" name="rentPriceTo" value="">
                                            </div>

                                        </div>
                                        <div class="col-xs-12 ">

                                            <div class="col-xs-5">
                                                <label class="name">Tên quản lý</label>
                                                <input type="text" class="form-control" name="managerName" value="">
                                            </div>
                                            <div class="col-xs-5">
                                                <label class="name">SĐT quản lý</label>
                                                <input type="text" class="form-control" name="managerPhone" value="">
                                            </div>
                                                <%--<div class="col-xs-2">--%>
                                                <%--<label class="name">Nhân viên</label>--%>
                                                <%--<select class="form-control">--%>
                                                <%--<option value="">---Chọn Nhân Viên---</option>--%>
                                                <%--<option value="2">Nguyễn Văn A</option>--%>
                                                <%--<option value="3">Trần Xuân B</option>--%>

                                                <%--</select>--%>
                                                <%--</div>--%>
                                            <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-xs-2">
                                                    <label class="name">Nhân viên</label>
                                                    <form:select class="form-control"  path="staffId">
                                                        <form:option value="">---Chọn Nhân Viên---</form:option>
                                                        <form:options  items="${ListStaffs}"/>


                                                    </form:select>
                                                </div>
                                            </security:authorize>


                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <form:checkboxes path="typeCode" items="${typeCodes}"/>

                                            </div>

                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <button type="button" class="btn btn-xs btn-danger" id="btnSearchBuilding">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"></path>
                                                    </svg>
                                                    Tìm kiếm
                                                </button>

                                            </div>
                                        </div>
                                    </div>

                                </form:form>




                            </div>

                        </div>


                    </div>
                    <div class="pull-right">
                        <a href="/admin/building-edit" >
                            <button class="btn btn-info" title="Thêm tòa nhà">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"></path>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"></path>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"></path>
                                </svg>

                            </button>
                        </a>
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-danger" title="Xóa tòa nhà"id="btnDeleteBuilding">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"></path>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"></path>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"></path>
                                </svg>
                            </button>
                        </security:authorize>


                    </div>
                </div>



            </div>
            <!-- Bảng danh sách -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                                       requestURI="${buildingListURL}" partialList="true" sort="external"
                                       size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                                       id="tableList" pagesize="${model.maxPageItems}"
                                       export="false"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;">
                            <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                            headerClass="center select-cell">
                                <fieldset>
                                    <input type="checkbox" name="checkList" value="${tableList.id}"
                                           id="checkbox_${tableList.id}" class="check-box-element"/>
                                </fieldset>
                            </display:column>
                            <display:column headerClass="text-left" property="name" title="Tên tòa nhà"/>
                            <display:column headerClass="text-left" property="address" title="Địa chỉ"/>
                            <display:column headerClass="text-left" property="numberOfBasement" title="Số tầng hầm"/>
                            <display:column headerClass="text-left" property="managerName" title="Tên quản lý"/>
                            <display:column headerClass="text-left" property="managerPhone" title="Số điện thoại"/>
                            <display:column headerClass="text-left" property="floorArea" title="Diện tích sàn"/>
                            <display:column headerClass="text-left" property="emptyArea" title="Diện tích trống"/>
                            <display:column headerClass="text-left" property="rentArea" title="Diện tích thuê"/>
                            <display:column headerClass="text-left" property="brokerageFee" title="Phí môi giới"/>
                            <display:column headerClass="col-actions" title="Thao tác">
                                <security:authorize access="hasRole('MANAGER')">
                                    <button class="btn btn-xs btn-success" title="Giao tòa nhà" onclick="assignmentBuilding(${tableList.id})">
                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                    </button>
                                </security:authorize>

                                <a class="btn btn-xs btn-info" title="Sửa tòa nhà" href="/admin/building-edit-${tableList.id}" >
                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                </a>

                                <security:authorize access="hasRole('MANAGER')">
                                    <button class="btn btn-xs btn-danger" title="Xóa tòa nhà" onclick="deleteBuilding(${tableList.id})">
                                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                    </button>
                                </security:authorize>


                            </display:column>
                        </display:table>
                    </div>
                    <%--<display:table id="tableList" style="margin: 3em 0 0em;" class="table table-striped table-bordered table-hover">--%>
                    <%--<thead>--%>
                    <%--<tr>--%>
                    <%--<th class="center">--%>
                    <%--<label class="pos-rel">--%>
                    <%--<input type="checkbox" class="ace">--%>
                    <%--<span class="lbl"></span>--%>
                    <%--</label>--%>
                    <%--</th>--%>
                    <%--<th>Tên tòa nhà</th>--%>
                    <%--<th>Địa chỉ</th>--%>
                    <%--<th>Số tầng hầm</th>--%>
                    <%--<th>Tên quản lý</th>--%>
                    <%--<th>Số điện thoại quản lí</th>--%>
                    <%--<th>D.tích sàn</th>--%>
                    <%--<th>D.tích trống</th>--%>
                    <%--<th>D.tích thuê</th>--%>
                    <%--<th>Phí môi giới</th>--%>
                    <%--<th>Thao tác</th>--%>




                    <%--</tr>--%>
                    <%--</thead>--%>

                    <%--<tbody>--%>
                    <%--<c:forEach var="item" items="${buildingList}">--%>
                    <%--<tr>--%>
                    <%--<td class="center">--%>
                    <%--<label class="pos-rel">--%>
                    <%--<input type="checkbox" name="checkList" value="${item.id}" class="ace">--%>
                    <%--<span class="lbl"></span>--%>
                    <%--</label>--%>
                    <%--</td>--%>

                    <%--<td>--%>
                    <%--${item.name}--%>
                    <%--</td>--%>
                    <%--<td>${item.address}</td>--%>
                    <%--<td>${item.numberOfBasement}</td>--%>
                    <%--<td>${item.managerName}</td>--%>
                    <%--<td>${item.managerPhone}</td>--%>
                    <%--<td>${item.floorArea}</td>--%>
                    <%--<td>null</td>--%>
                    <%--<td>${item.rentArea}</td>--%>
                    <%--<td>${item.brokerageFee}</td>--%>
                    <%--&lt;%&ndash;<td>${item.id}</td>&ndash;%&gt;--%>

                    <%--<td>--%>
                    <%--<div class="hidden-sm hidden-xs btn-group">--%>
                    <%--<button class="btn btn-xs btn-success" title="Giao tòa nhà" onclick="assignmentBuilding(${item.id})">--%>
                    <%--<i class="ace-icon glyphicon glyphicon-list"></i>--%>
                    <%--</button>--%>

                    <%--<a class="btn btn-xs btn-info" title="Sửa tòa nhà" href="/admin/building-edit-${item.id}" >--%>
                    <%--<i class="ace-icon fa fa-pencil bigger-120"></i>--%>
                    <%--</a>--%>

                    <%--<button class="btn btn-xs btn-danger" title="Xóa tòa nhà" onclick="deleteBuilding(${item.id})">--%>
                    <%--<i class="ace-icon fa fa-trash-o bigger-120"></i>--%>
                    <%--</button>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                    <%--</tr>--%>

                    <%--</c:forEach>--%>





                    <%--</tbody>--%>
                    <%--</display:table>--%>
                </div><!-- /.span -->
            </div>


        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->

<div class="footer">
    <div class="footer-inner">
        <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>

            &nbsp; &nbsp;
            <span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
        </div>
    </div>
</div>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
</div><!-- /.main-container -->
<div class="modal fade" id="assignmentBuildingModal" role="dialog" style="font-family: 'Times New Roman', Times, serif;">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table   class="table table-striped table-bordered table-hover"  id="staffList">
                    <thead>
                    <tr>
                        <th >Chọn</th>

                        <th>Tên nhân viên</th>

                    </tr>
                    </thead>

                    <tbody>

                    </tbody>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnassignmentBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>

    </div>
</div>

<script>
    function assignmentBuilding(buildingId){
        $('#assignmentBuildingModal').modal();
        loadStaff(buildingId);
        $('#buildingId').val(buildingId);

    }

    function loadStaff(buildingId){
        $.ajax({
            type: "GET",
            url: "${buildingAPI}/"+ buildingId +'/staffs',
            // data: JSON.stringify(data),
            // contentType:"application/json",
            dataType: "json",
            success: function (response) {
                var row = '';
                $.each(response.data,function (index,item){
                    row+='<tr>';
                    row+= '<td class="text-center"><input type="checkbox" value= ' + item.staffId + ' id=checkbox_' + item.staffId + '" class ="check-box-element "'  + item.checked + '/></td>';
                    row+='<td class="text-center">' +item.fullName + '</td>';
                    row+= '</tr>';
                });
                $('#staffList tbody').html(row);
                console.info("Success");
            },
            error: function(response){
                console.log("Failed");
                window.location.href= "<c:url value="/admin/building-list?message=erro"/> ";
                console.log(response);
            }
        });
    }

    $('#btnassignmentBuilding').click(function(e){
        e.preventDefault();
        var data ={};
        data['buildingId']  = $('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();

        }).get();
        data["staffs"]=staffs;
        if(data['staffs'] != ''){
            assingment(data);

        }
        console.log("oke");


    })

    function assingment(data){
        $.ajax({

            url: "${buildingAPI}/" + 'assignment',
            type: "POST",
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType: 'json',
            success: function (response) {

                console.info("Success");
                alert("Giao tòa nhà thành công");
                window.location.href= "<c:url value="/admin/building-list?message=success"/> ";


            },
            error: function(response){
                console.info("Giao Không Thành Công");
                window.location.href= "<c:url value="/admin/building-list?message=erro"/> ";
                console.log(response);
            }
        });
    }

    $('#btnSearchBuilding').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();

    });


    function deleteBuilding(data){
        var buildingId=[data];
        deleteBuildings(buildingId)
    }

    $('#btnDeleteBuilding').click(function(e){
        e.preventDefault();

        var buildingIds = $('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();

        }).get();

        deleteBuildings(buildingIds);
    });


    function deleteBuildings(data) {
        $.ajax({
            type: "Delete",
            url: "${buildingAPI}/"+ data,
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType: "JSON",
            success: function (respond) {
                console.log("Success");
                alert("Xóa thành công");
                window.location.href= "<c:url value="/admin/building-list?message=success"/> ";
            },
            error: function(respond){
                console.log("Failed");
                console.log(respond);
            }
        });


    }


</script>



</body>
</html>