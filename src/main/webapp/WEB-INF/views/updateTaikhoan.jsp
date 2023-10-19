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
<header><h2 style="text-align: center;">Sửa Tài Khoản</h2></header>
<main>
    <form action="/taikhoan/update?id=${taiKhoan.id}" method="post" class="container">
        <div class="mb-3">
            <label class="form-label">User name</label>
            <input type="text" class="form-control" name="userName" value="${taiKhoan.userName}">
        </div>
        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="password" value="${taiKhoan.password}">
        </div>
        <div class="mb-3">
            <label class="form-label">Role </label>
            <input type="radio" name="role" value="True" ${taiKhoan.role == "True" ? "checked" : ""} checked>True
            <input type="radio" name="role" value="False" ${taiKhoan.role == "False" ? "checked" : ""}>False
        </div>
        <button class="btn btn-success" type="submit">Update</button>
    </form>
</main>
<footer style="text-align: center;margin-top: 100px">FOOTER SD118_NORDIC</footer>
</body>
</html>