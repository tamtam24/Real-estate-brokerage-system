<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/29/2024
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file= "/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api/building"/>
<c:url var="installmentAPI" value="/api/installment"/>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<html>
<head>
    <title>Chỉnh sửa thông tin</title>
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
                    <a href="#">Trang chủ</a>
                </li>
                <c:if test= "${not empty installmentEdit.id}">
                    <li class="active">Chỉnh sửa trả góp</li>
                </c:if>
                <c:if test= "${empty installmentEdit.id}">
                    <li class="active">Thêm trả góp</li>
                </c:if>

            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content">


            <div class="page-header">
                <h1>
                    Thông tin trả góp
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <div class="row">
                <div class="col-xs-12">

                </div>

            </div>


            <!-- Bảng danh sách -->
            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <form:form modelAttribute="installmentEdit" id="listForm" method="GET" >
                    <div class="col-xs-12">
                        <form class="form-horizontal" role="form" id="form-edit">
                            <div class="form-group">
                                <label class="col-xs-3">Mã trả góp</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="code" name="code" value=""/>
                                </div>

                            </div>

                            <div class="form-group">
                                <label class="col-xs-3">Ghi chú</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="note" name="note" value=""/>
                                </div>

                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Số tiền</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path="amount" name="amount" value=""/>
                                </div>

                            </div>

                            <div class="form-group">
                                <label class="col-xs-3">Tình trạng</label>
                                <div class="col-xs-9">
                                    <form:select class="form-control" name="status" path="status">
                                        <form:option value="">---Chọn tình trạng---</form:option>
                                        <form:options items="${statuss}"></form:options>

                                    </form:select>
                                </div>


                            </div>
                            <div class="form-group">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${not empty installmentEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateInstallment">Cập nhật thông tin</button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác</button>
                                    </c:if>
                                    <c:if test="${empty installmentEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateInstallment">Thêm trả góp</button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác</button>
                                    </c:if>

                                </div>
                            </div>
                            <form:hidden path="id" id="installmentId"/>
                        </form>



                    </div>

                </form:form>


            </div>



        </div><!-- /.page-content -->


        <c:forEach var="item" items="${transactionType}">
            <div class="col-xs-12">
                <div class="col-sm-12">
                    <h3 class="header smaller lighter blue">${item.value}</h3>
                    <button class="btn btn-lg btn-primary" onclick="transactionType('${item.key}',${installmentEdit.id})">
                        <i class="orange ace-icon fa fa-location-arrow bigger-130"></i>Add
                    </button>
                </div>
                <c:if test="${item.key == 'CSKH'}">
                    <div class="col-xs-12" >
                        <%--<table id="simple-table" class="table table-striped table-bordered table-hover">--%>
                            <%--<thead >--%>
                            <%--<tr >--%>
                                <%--<th>Ngày tạo</th>--%>
                                <%--<th>Người tạo</th>--%>
                                <%--<th>Ngày sửa</th>--%>
                                <%--<th>Người sửa</th>--%>
                                <%--<th>Chi tiết giao dịch</th>--%>
                                <%--<th>Thao tác</th>--%>
                            <%--</tr>--%>

                            <%--</thead>--%>

                            <%--<tbody>--%>
                            <%--<tr >--%>
                                <%--<td>123</td>--%>
                                <%--<td>123</td>--%>
                                <%--<td>123</td>--%>
                                <%--<td>123</td>--%>
                                <%--<td>123</td>--%>
                                <%--<td>--%>
                                    <%--<div class="hidden-sm hidden-xs btn-group">--%>
                                        <%--<button class="btn btn-xs btn-success" title="Sửa thông tin giao dịch" onclick="assignmentBuilding(${tableList.id})">--%>
                                            <%--<i class="ace-icon glyphicon glyphicon-list"></i>--%>
                                        <%--</button>--%>
                                    <%--</div>--%>
                                <%--</td>--%>
                            <%--</tr>--%>

                            <%--</tbody>--%>

                        <%--</table>--%>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Ngày tạo</th>
                                        <th>Người tạo</th>
                                        <th>Ngày sửa</th>
                                        <th>Người sửa</th>
                                        <th>Chi tiết giao dịch</th>
                                        <th>Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${transactionListCSKH}" var="transaction">
                                        <tr>
                                            <td>${transaction.createdDate}</td>
                                            <td>${transaction.createdBy}</td>
                                            <td>${transaction.modifiedDate}</td>
                                            <td>${transaction.modifiedBy}</td>
                                            <td>${transaction.note}</td>
                                            <td>
                                                <button class="btn btn-xs btn-success" title="Sửa thông tin giao dịch" onclick="UpdateTransaction('${item.key}','${transaction.id}')">
                                                    <i class="ace-icon glyphicon glyphicon-list"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                    </div>

                </c:if>
                <c:if test="${item.key == 'DDX'}">
                    <div class="col-xs-12" >
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>Ngày tạo</th>
                                    <th>Người tạo</th>
                                    <th>Ngày sửa</th>
                                    <th>Người sửa</th>
                                    <th>Chi tiết giao dịch</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${transactionListDDX}" var="transactionDDX">
                                    <tr>
                                        <td>${transactionDDX.createdDate}</td>
                                        <td>${transactionDDX.createdBy}</td>
                                        <td>${transactionDDX.modifiedDate}</td>
                                        <td>${transactionDDX.modifiedBy}</td>
                                        <td>${transactionDDX.note}</td>
                                        <td>
                                            <button class="btn btn-xs btn-success" title="Sửa thông tin giao dịch" onclick="UpdateTransaction('${item.key}',${transactionDDX.id})">
                                                <i class="ace-icon glyphicon glyphicon-list"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </c:if>


            </div>


        </c:forEach>


    </div>
</div><!-- /.main-content -->
<div class="modal fade" id="transactionTypeModal" role="dialog" >
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                <h4 class="modal-title">Nhập giao dịch</h4>
            </div>
            <div class="modal-body">
                <div class="form-group has-success">
                    <label for="transactionDetail" class="col-xs-12 col-sm-3 control-label no no-padding-right">Chi tiết giao dịch</label>
                    <div class="col-xs-12 col-sm-9">
                    <span class="block input-icon-right">
                        <input type="text" id="transactionDetail" class="width-100" value="">
                    </span>
                    </div>
                </div>

                <input type="hidden" id="customerId" name="customerId" value="">
                <input type="hidden" name="code" id="code" value="">
                <input type="hidden" id="id" name="id" value="">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAddorUpdateTransaction">Thêm giao dịch</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>

    </div>
</div>

<script>
    function transactionType(code,customerId){
        $('#transactionTypeModal').modal();
        $('#customerId').val(customerId);
        $('#code').val(code);
    }

    function UpdateTransaction(code,id){
        var customerid = $('#customerId').val();
        loadTransaction(id,customerid);
        $('#transactionTypeModal').modal();
        $('#code').val(code);
        $('#id').val(id);

    }

    $('#btnAddorUpdateTransaction').click(function (e) {
        e.preventDefault();
        var data = {};
        data['id'] = $('#id').val();
        data['customerid'] = $('#customerId').val();
        data['code'] = $('#code').val();
        data['note'] = $('#transactionDetail').val();
        addOrUpdateTransaction(data);

    });

    function addOrUpdateTransaction(data){
        var customerId = data['customerid']

        $.ajax({
            type: "POST",
            url: "${installmentAPI}/transaction",
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType: "JSON",
            success: function (respond) {
                console.log("Success");
                alert("Thêm/Sửa thành công");
                window.location.href= '<c:url value="/admin/customer-edit-' + customerId + '?message=success"/>';



            },
            error: function(respond){
                console.log("Failed");
                console.log(respond);
                window.location.href= '<c:url value="/admin/customer-edit-' + customerId + '?message=error"/>';

            }
        });
    }


    $('#btnAddOrUpdateInstallment').click(function(){
        var data= {};
        var formData = $('#listForm').serializeArray();
        $.each(formData, function(i,v){
                data[""+v.name+""] =v.value
        });

        if(data["code"]!="" && data["amount"]!="" ){
            addOrUpdateInstallment(data);
        }
        else {
            window.location.href= "<c:url value="/admin/customer-edit?nameorphone=require"/>";
        }

    });

    function addOrUpdateInstallment(data){
        $.ajax({
            type: "POST",
            url: "${installmentAPI}",
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType: "JSON",
            success: function (respond) {
                console.log("Success");
                alert("Thêm/Sửa thành công");
                window.location.href = "/admin/customer-list?message=success";


            },
            error: function(respond){
                console.log("Failed");
                console.log(respond);

            }
        });
    }

    function loadTransaction(id,customerId){
        $.ajax({
            type: "GET",
            url: "${installmentAPI}/"+ customerId +'/transaction/'+id,
            // data: JSON.stringify(data),
            // contentType:"application/json",
            dataType: "json",
            success: function (response) {
                var note = response.note;

                $('#transactionDetail').val(note);
                console.info("Success");
            },
            error: function(response){
                console.log("Failed");
                window.location.href= '<c:url value="/admin/customer-edit-' + customerId + '?message=failed"/>';
                console.log(response);
            }
        });
    }

    $('#btnCancel').click(function () {
        window.location.href="/admin/building-list";

    });



</script>
</body>
</html>