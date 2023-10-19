<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header><h2 style="text-align: center;">Sửa Kích Cỡ</h2></header>
<main>
    <form action="/giamgia/update?id=${giamGia.id}" method="post" class="container">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma" value="${giamGia.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Loại Giảm Giá</label>
            <input type="text" class="form-control" name="loaiGiamGia" value="${giamGia.loaiGiamGia}">
        </div>
        <div class="mb-3">
            <label class="form-label">Giá Trị Giảm</label>
            <input type="number" class="form-control" name="giaTriGiam" value="${giamGia.giaTriGiam}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày Bắt Đầu</label>
            <input type="date" class="form-control" name="ngayBatDau" value="${giamGia.ngayBatDau}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày Kết Thúc</label>
            <input type="date" class="form-control" name="ngayKetThuc" value="${giamGia.ngayKetThuc}">
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng Thái</label>
            <input type="text" class="form-control" name="trangThai" value="${giamGia.trangThai}">
        </div>
        <button class="btn btn-success" type="submit">Update</button>
    </form>
</main>
<footer style="text-align: center;margin-top: 100px">FOOTER SD118_NORDIC</footer>
</body>
</html>