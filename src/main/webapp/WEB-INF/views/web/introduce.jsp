<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Giới thiệu</title>

<style>
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
        font-family: "Roboto", sans-serif;
    }

    :root {
        --primary-color: #35BF76;
        --color-text: #434A6E;
    }

    .intro {
        background-image: url(//bizweb.dktcdn.net/100/328/362/themes/894751/assets/bg_breadcrumb.png?1664350964800);
        background-size: cover;
        background-position: center top;
        padding: 25px 0px;
        background-repeat: no-repeat;
        min-height: 320px;
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100%;
        float: left;
        flex-flow: column;
    }

    .title-page {
        font-weight: 700;
        font-size: 48px;
        font-family: "Roboto", sans-serif;
        color: #fff;
    }

    .desc-intro {
        font-family: "Roboto", sans-serif;
        margin: 0;
        font-size: 16px;
        padding: 15px 0px 15px;
        border-radius: 0;
        font-weight: 400;
        line-height: 24px;
        background-color: transparent;
        width: 100%;
        text-align: center;
    }

    .col-xs-12 {
        width: 100%;
    }

    .desc-intro li {
        display: inline;
    }

    .home:hover {
        color: var(--primary-color)
    }

    .intro-item {
        color: var(--primary-color);
    }

    .page-content {

        /* margin-top: 5px; */
    }

    .title-head {
        font-size: 20px;
    }

    .hover-title-header:hover {
        text-decoration: underline;
        color: var(--primary-color);
    }

    .desc-page-container p {
        width: 100%;
        float: left;
        margin-bottom: 50px;
    }

    .item-desc-page-content {
        font-size: 14px;
    }

</style>
</head>
<body>
<div class="page-wrapper">
    <%--<header>--%>
    <%--<div class="p-4">--%>
    <%--<div class="row navbar">--%>
    <%--<div class="col-12 col-md-3">--%>
    <%--<div class="logo">--%>
    <%--<a href="/trang-chu">--%>
    <%--<img src="https://bizweb.dktcdn.net/100/328/362/themes/894751/assets/logo.png?1676257083798"--%>
    <%--alt="">--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-12 col-md-6">--%>
    <%--<div class="item-menu">--%>
    <%--<div class="nav nav1">--%>
    <%--<div class="nav-item p-2">--%>
    <%--<a class="nav-item-link" href="/trang-chu">--%>
    <%--<span>Trang chủ</span>--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--<div class="nav-item p-2">--%>
    <%--<a class="nav-item-link" href="">--%>
    <%--<span style="color: var(--primary-color);">Giới thiệu</span>--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--<div class="nav-item p-2">--%>
    <%--&lt;%&ndash;<a class="nav-item-link" href="./Duan.html">&ndash;%&gt;--%>
    <%--<a href='<c:url value='/san-pham'/>'>--%>
    <%--<span>Sản phẩm</span>--%>
    <%--&lt;%&ndash;<span style="color: var(--primary-color);">Sản phẩm</span>&ndash;%&gt;--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--<div class="nav-item p-2">--%>
    <%--&lt;%&ndash;<a class="nav-item-link" href="./TinTuc.html">&ndash;%&gt;--%>
    <%--<a href='<c:url value='/tin-tuc'/>'>--%>
    <%--<span>Tin tức</span>--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--<div class="nav-item p-2">--%>
    <%--<a href='<c:url value='/lien-he'/>'>--%>
    <%--<span>Liên hệ</span>--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-12 col-md-3">--%>
    <%--<button class="btn btn-primary px-4">--%>
    <%--Liên hệ tư vấn--%>
    <%--</button>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</header>--%>
    <!-- INTRO  -->
    <div class="intro text-center">
        <div class="title-page">Giới thiệu</div>
        <div class="row">
            <div class="col-xs-12 a-left">
                <ul class="desc-intro">
                    <li class="home" style="color: #fff;">
                        <a href="/trang-chu#"><span style="color: #fff;">Trang chủ</span></a>
                        <span class="mx-1"> /</span>
                    </li>
                    <li class="intro-item"><span>Giới thiệu</span></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- CONTENT  -->
    <div class="page-content">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-12">
                    <h1 class="title-head mt-5"><a class="hover-title-header" href="./GioiThieu.html"><strong>Giới
                        thiệu</strong></a>
                    </h1>
                    <div class="desc-page-content">
                        <div class="content-page rte minpage">
                            <p>Để quản lý hiệu quả một doanh nghiệp kinh doanh bất động sản, cần có quy trình chuẩn mực,
                                không chỉ dựa vào con người mà còn cần sự hỗ trợ của công nghệ. Phần mềm quản lý bất
                                động sản ra đời nhằm giải quyết các khó khăn trong quản lý nhân lực, hợp đồng, thanh
                                toán, theo dõi doanh thu. Phần mềm giúp tiết kiệm thời gian, xử lý công việc nhanh chóng
                                và mang lại hiệu quả quản lý tối ưu. Trong lĩnh vực này, việc quản lý chuyên nghiệp các
                                hoạt động giao dịch, cho thuê, môi giới, tiếp thị là rất quan trọng. Phần mềm cung cấp
                                nền tảng tập trung để theo dõi và điều hành tất cả khía cạnh của doanh nghiệp, từ danh
                                mục bất động sản, khách hàng, hợp đồng, tài chính đến quản lý nhân viên và báo cáo. Với
                                phần mềm, các công việc cập nhật thông tin, quản lý khách hàng, soạn hợp đồng, tính phí
                                và thanh toán trở nên nhanh chóng, chính xác, hạn chế sai sót và minh bạch..</p>
                            <p><b>Mục tiêu:</b></p>

                            <p>– Chủ bất động sản có thể giao quyền cho các người quản lý để làm thanh toán cũng như
                                quản lý thông
                                tin nhà đất.</p>
                            <p>– Khách xem website có thể xem , tìm kiếm thông tin của các căn nhà hoặc phòng , và sau
                                đó có thể tiến
                                hành thanh toán nếu muốn.</p>
                            <p>– Người quản trị được phân quyền quản lí nhà đất , cũng như chủ đất , nhà có thể chỉnh
                                sửa các thông</p>
                            <p>+ Cập nhật thông tin nhà đất</p>
                            <p>+ Xem thông tin giao dịch giữa người mua và người bán</p>
                            <p>+ Xem thông tin thanh toán</p>
                            <p>+ Xem thông tin khách hàng</p>
                            <p>+ Xem thông tin báo cáo</p>

                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- FOOTER  -->
    <footer class="footer">
        <div class="container-fluid">
            <div class="top-footer text-center mt-0">
                <div class="logo logo-footer pt-5">
                    <div class="item-footer mt-5">
                        <div class="row">
                            <div class="col-12 col-md-4 text-center">
                                <div class="icon-footer">
                                    <img src="https://bizweb.dktcdn.net/100/328/362/themes/894751/assets/place_maps.png?1676257083798"
                                         alt="">
                                </div>
                                <div class="content-center-footer">
                                    <p class="mb-1 mt-3">Trụ sở chính</p>
                                    <p class="desc-footer">69 Tân Lập, Dĩ An, Bình Dương</p>
                                </div>
                            </div>
                            <div class="col-12 col-md-4 text-center">
                                <div class="icon-footer">
                                    <img src="https://bizweb.dktcdn.net/100/328/362/themes/894751/assets/place_phone.png?1676257083798"
                                         alt="">
                                </div>
                                <div class="content-center-footer">
                                    <p class="mb-1 mt-3">Hotline</p>
                                    <p class="desc-footer"><a class="a-text" href="#">0933516434</a></p>
                                </div>
                            </div>
                            <div class="col-12 col-md-4 text-center">
                                <div class="icon-footer">
                                    <img src="https://bizweb.dktcdn.net/100/328/362/themes/894751/assets/place_email.png?1676257083798"
                                         alt="">
                                </div>
                                <div class="content-center-footer">
                                    <p class="mb-1 mt-3">Email</p>
                                    <p class="desc-footer"><a class="a-text" href="#">22521405@gm.uit.edu.vn</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <div class="border-bottom mb-5 mt-4"></div>
                </div>
            </div>
            <div class="bottom-footer container">
                <div class="row">
                    <div class="col-12 col-md-3">
                        <h4 class="title-item-bottom-footer">Thông tin công ty</h4>
                        <p class="desc-item-bottom-footer desc-1"><a class="a-text" href="">Trang
                            chủ</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Giới thiệu</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Dự án bất động
                            sản</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Tin tức</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Liên hệ</a></p>
                    </div>
                    <div class="col-12 col-md-3">
                        <h4 class="title-item-bottom-footer">Chính sách hoạt động</h4>
                        <p class="desc-item-bottom-footer desc-1"><a class="a-text" href="">Trang
                            chủ</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Giới thiệu</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Dự án bất động
                            sản</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Tin tức</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Liên hệ</a></p>
                    </div>
                    <div class="col-12 col-md-3">
                        <h4 class="title-item-bottom-footer">Hỗ trợ khách hàng</h4>
                        <p class="desc-item-bottom-footer desc-1"><a class="a-text" href="">Trang
                            chủ</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Giới thiệu</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Dự án bất động
                            sản</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Tin tức</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Liên hệ</a></p>
                    </div>
                    <div class="col-12 col-md-3">
                        <h4 class="title-item-bottom-footer">Kết nối với chúng tôi</h4>
                        <p class="desc-item-bottom-footer desc-1"><a class="a-text" href="">Trang
                            chủ</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Giới thiệu</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Dự án bất động
                            sản</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Tin tức</a></p>
                        <p class="desc-item-bottom-footer"><a class="a-text" href="">Liên hệ</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
