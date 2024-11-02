<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2>Tim kiem</h2>
<form action="/nhan-vien/search">
    Nhap Ten: <input type="text" name="ten"><br>
    <button>Tim kiem</button>
</form>
<h2>Them moi</h2>
<form action="/nhan-vien/add" method="post">
    ID: <input type="text" name="id" readonly value="${nv.id}"> <br>
    Ma: <input type="text" name="ma" value="${nv.ma}"> <br>
    Ten: <input type="text" name="ten" value="${nv.ten}"> <br>
    Gioi tinh:
    <input type="radio" name="gioiTinh" value="Nam" ${nv.gioiTinh == "Nam" ? "checked" : ""}> Nam
    <input type="radio" name="gioiTinh" value="Nu" ${!nv.gioiTinh == "Nam" ? "checked" : ""}> Nu <br>
    Dia chi:
    <input type="text" name="diaChi" value="${nv.diaChi}"> <br>
    Chuc vu:
    <select name="chucVu">
        <c:forEach items="${dsChucVu}" var="cv">
            <option value="${cv.id}" ${nv.idChucVu == cv.id ? "selected" : ""}>${cv.ten}</option>
        </c:forEach>
    </select> <br>
    <button>Them moi</button>
</form>
<h2>Danh sach</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gioi tinh</th>
        <th>Dia chi</th>
        <th>Chuc vu</th>
        <th>Hanh dong</th>
    </tr>
    <c:forEach items="${page.content}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.tenChucVu}</td>
            <td>
                <a href="/nhan-vien/detail?id=${nv.id}">Chi tiet</a>
                <a href="/nhan-vien/delete?id=${nv.id}">Xoa</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/nhan-vien/groups?page=0">First</a>
<a href="/nhan-vien/groups?page=${page.first ? 0 : page.number - 1}">Pre</a>
<a href="/nhan-vien/groups?page=${page.last ? page.totalPages - 1 : page.number + 1}">Next</a>
<a href="/nhan-vien/groups?page=${page.totalPages - 1}">Last</a>
</body>
</html>