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
<header><h2 style="text-align: center;">Sửa Màu Sắc</h2></header>
<main>
    <form action="/mausac/update?id=${mauSac.id}" method="post" class="container">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma" value="${mauSac.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên Màu</label>
            <input type="text" class="form-control" name="tenMau" value="${mauSac.tenMau}">
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng Thái</label>
            <input type="text" class="form-control" name="trangThai" value="${mauSac.trangThai}">
        </div>
        <button class="btn btn-success" type="submit">Update</button>
    </form>
</main>
<footer style="text-align: center;margin-top: 100px">FOOTER SD118_NORDIC</footer>
</body>
</html>