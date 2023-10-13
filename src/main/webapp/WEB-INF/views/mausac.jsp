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
<header><h2 style="text-align: center">Quản Lý Màu Sắc</h2></header>
<main>
    <section class="container">
        <a class="btn btn-danger" style="margin-right: 1050px;margin-top: 100px" href="/mausac/view-add">Thêm Màu Sắc</a>
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
                        <th scope="col">Id </th>
                        <th scope="col">Mã Màu</th>
                        <th scope="col">Tên Màu</th>
                        <th scope="col">Trạng Thái</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listMauSac.content}" var="mauSac">
                        <tr>
                            <td>${mauSac.id}</td>
                            <td>${mauSac.ma}</td>
                            <td>${mauSac.tenMau}</td>
                            <td>${mauSac.trangThai}</td>
                            <td>
                                <a class="btn btn-danger" href="/mausac/view-update/${mauSac.id}">Cập Nhật</a>
                                <a class="btn btn-danger" href="/mausac/delete/${mauSac.id}">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <nav  aria-label="Page navigation example" style="margin-left: 600px;margin-top: 50px">
                <ul class="pagination" >
                    <c:forEach begin="0" end="${ listMauSac.totalPages -1}" varStatus="loop">
                        <li class="page-item" >
                            <a class="page-link" href="/mausac/hien-thi?page=${loop.begin + loop.count - 1}">
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