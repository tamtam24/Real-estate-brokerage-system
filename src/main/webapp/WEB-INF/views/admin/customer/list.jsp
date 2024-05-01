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
<c:url var="customerListURL" value="/admin/customer-list" />
<c:url var="customerAPI" value="/api/customer"/>
<html>
<head>
    <title>Danh sách khách hàng</title>
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
                <li class="active">Danh sách khách hàng</li>
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
                                <form:form id="listForm" action="${customerListURL}"  method="GET" modelAttribute="modelSearch">
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="col-xs-12 ">
                                                <div class="col-xs-4">
                                                    <label class="name">Tên khách hàng</label>
                                                        <%--<input type="text" class="form-control" name="name" value="${modelSearch.name}">--%>
                                                    <form:input path="name"  type="text" class="form-control" name="name" />
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Số điện thoại</label>
                                                    <form:input path="phone" cssClass="form-control"/>
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Email</label>
                                                        <%--<input type="text" class="form-control" name="name" value="${modelSearch.name}">--%>
                                                    <form:input path="email"  cssClass="form-control"/>
                                                </div>
                                            </div>

                                        </div>

                                        <security:authorize access="hasRole('MANAGER')">
                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-4">
                                                        <label class="name">Chọn nhân viên</label>
                                                        <form:select class="form-control" path ="staffid">
                                                            <form:option value="">---Chọn nhân viên---</form:option>
                                                            <form:options items="${ListStaffs}" />

                                                        </form:select>
                                                    </div>


                                                </div>
                                            </div>

                                        </security:authorize>




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
                        <a href="/admin/customer-edit" >
                            <button class="btn btn-info" title="Thêm khách hàng">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill-add" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"></path>
                                    <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"></path>
                                </svg>

                            </button>
                        </a>
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-danger" title="Xóa khách hàng"id="btnDeleteCustomer">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1m0-7a3 3 0 1 1-6 0 3 3 0 0 1 6 0"></path>
                                    <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"></path>
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
                                       requestURI="${customerListURL}" partialList="true" sort="external"
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
                            <display:column headerClass="text-left" property="fullname" title="Tên khách hàng"/>
                            <display:column headerClass="text-left" property="phone" title="Di động"/>
                            <display:column headerClass="text-left" property="email" title="Email"/>
                            <display:column headerClass="text-left" property="demand" title="Nhu cầu"/>
                            <display:column headerClass="text-left" property="createdBy" title="Người thêm"/>
                            <display:column headerClass="text-left" property="createdDate" title="Ngày thêm"/>
                            <display:column headerClass="text-left" property="status" title="Tình trạng"/>
                            <display:column headerClass="col-actions" title="Thao tác">
                                <security:authorize access="hasRole('MANAGER')">
                                    <button class="btn btn-xs btn-success" title="Giao khách hàng" onclick="assignmentCustomer(${tableList.id})">
                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                    </button>
                                </security:authorize>

                                <a class="btn btn-xs btn-info" title="Sửa thông tin" href="/admin/customer-edit-${tableList.id}" >
                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                </a>
                                <security:authorize access="hasRole('MANAGER')">
                                    <button class="btn btn-xs btn-danger" title="Xóa khách hàng" onclick="deleteCustomer(${tableList.id})">
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
<div class="modal fade" id="assignmentCustomerModal" role="dialog" style="font-family: 'Times New Roman', Times, serif;">
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
                <input type="hidden" id="customerId" name="customerId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnassignmentCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>

    </div>
</div>

<script>
    function assignmentCustomer(customerId){
        $('#assignmentCustomerModal').modal();
        loadStaff(customerId);
        $('#customerId').val(customerId);

    }

    function loadStaff(buildingId){
        $.ajax({
            type: "GET",
            url: "${customerAPI}/"+ buildingId +'/staffs',
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
                window.location.href= "<c:url value="/admin/customer-list?message=erro"/> ";
                console.log(response);
            }
        });
    }

    $('#btnassignmentCustomer').click(function(e){
        e.preventDefault();
        var data ={};
        data['customerId']  = $('#customerId').val();
        var staffs = $('#staffList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();

        }).get();
        data["staffs"]=staffs;
        if(data['staffs'] != ''){
            assignment(data);

        }
        console.log("oke");


    })

    function assignment(data){
        $.ajax({

            url: "${customerAPI}/" + 'assignment',
            type: "POST",
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType: 'json',
            success: function (response) {

                console.info("Success");
                alert("Giao khách hàng thành công");
                window.location.href= "<c:url value="/admin/customer-list?message=success"/> ";


            },
            error: function(response){
                console.info("Giao Không Thành Công");
                window.location.href= "<c:url value="/admin/customer-list?message=erro"/> ";
                console.log(response);
            }
        });
    }

    $('#btnSearchBuilding').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();

    });


    function deleteCustomer(data){
        var buildingId=[data];
        deleteCustomers(buildingId)
    }

    $('#btnDeleteCustomer').click(function(e){
        e.preventDefault();

        var buildingIds = $('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();

        }).get();

        deleteCustomers(buildingIds);
    });


    function deleteCustomers(data) {
        $.ajax({
            type: "Delete",
            url: "${customerAPI}/"+ data,
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType: "JSON",
            success: function (respond) {
                console.log("Success");
                alert("Xóa thành công");
                window.location.href= "<c:url value="/admin/customer-list?message=success"/> ";
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