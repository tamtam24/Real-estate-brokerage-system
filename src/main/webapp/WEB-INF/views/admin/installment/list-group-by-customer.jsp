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
<c:url var="installmentListURL" value="admin/installment-group-by-customer-list" />
<c:url var="customerAPI" value="/api/installment"/>
<html>
<head>
    <title>Danh sách trả góp</title>
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
                <li class="active">Danh sách trả góp</li>
            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content">

            <!-- ------------------------------------------------------------------- -->

            <!-- Bảng danh sách | SỬA Ở PHẦN NÀY NÈ ĐỂ ĐỔ DỮ LIỆU LÊN LIST!!!!! -->

            <!-- ------------------------------------------------------------------- -->

            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                                       requestURI="${installmentListURL}" partialList="true" sort="external"
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

                            <!-- ------------------------------------------------------------------- -->

                            <!-- SỬA CÁC COLUMN Ở ĐÂY NÈ -->

                            <!-- ------------------------------------------------------------------- -->

                            <display:column headerClass="text-left" property="customer_id" title="Mã khách hàng"/>
                            <display:column headerClass="text-left" property="customer_name" title="Tên khách hàng"/>
                            <display:column headerClass="text-left" property="customer_phone" title="Số điện thoại"/>
                            <display:column headerClass="text-left" property="customer_email" title="Email"/>
                            <display:column headerClass="text-left" property="total_amount" title="Tổng tiền đã trả góp"/>

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

            &nbsp; &nbsp;

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