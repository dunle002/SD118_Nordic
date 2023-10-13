<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center">Quản Lý Loại Giày</h2></header>
<main>
    <section class="container">
        <a class="btn btn-danger" style="margin-right: 1050px;margin-top: 100px" href="/loaigiay/view-add">Thêm Loại Giày</a>
    </section>
    <div>
<%--        <form class="search-bar__form" action="/product/list">--%>
<%--            <button class="go-btn search__button" type="submit">--%>
<%--                <i class="icon anm anm-search-l"></i>--%>
<%--            </button>--%>
<%--            <input class="search__input" type="search" name="kw"--%>
<%--                   value="${sessionScope.keyword}" placeholder="Search entire store..."--%>
<%--                   aria-label="Search" autocomplete="off">--%>
<%--        </form>--%>
    <section>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Id Loại Giày</th>
                        <th scope="col">Mã Loại Giày</th>
                        <th scope="col">Tên Loại Giày</th>
                        <th scope="col">Trạng Thái</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listLoaiGiay.content}" var="loaiGiay">
                        <tr>
                            <td>${loaiGiay.id}</td>
                            <td>${loaiGiay.ma}</td>
                            <td>${loaiGiay.tenTheLoai}</td>
                            <td>${loaiGiay.trangThai}</td>
                            <td>
                                <a class="btn btn-danger" href="/loaigiay/view-update/${loaiGiay.id}">Cập Nhật</a>
                                <a class="btn btn-danger" href="/loaigiay/delete/${loaiGiay.id}">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <nav  aria-label="Page navigation example" style="margin-left: 600px;margin-top: 50px">
                <ul class="pagination" >
                    <c:forEach begin="0" end="${ listLoaiGiay.totalPages -1}" varStatus="loop">
                        <li class="page-item" >
                            <a class="page-link" href="/loaigiay/hien-thi?page=${loop.begin + loop.count - 1}">
                                    ${loop.begin + loop.count }
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </section>
    </div>
</main>
<footer style="text-align: center;margin-top: 100px">FOOTER SD118_NORDIC</footer>
</body>
</html>