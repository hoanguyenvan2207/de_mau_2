<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>Them moi</h2>
<form:form modelAttribute="phongRequest" action="/room/add" method="post">
    Ten phong:  <input type="text" name="tenPhong"> <br>
    So luong: <form:input path="soLuongPhong"/> <br>
    <form:errors path="soLuongPhong"/> <br>
    Trang thai:
    <input type="radio" value="Con phong" name="trangThai"> Con phong
    <input type="radio" value="Het phong" name="trangThai"> Het phong <br>
    Ghi chu: <input type="text" name="ghiChu"> <br>
    Loai phong:<select name="IdLoaiPhong">
        <c:forEach items="${dsLoaiPhong}" var="lp">
            <option value="${lp.id}">${lp.tenLoaiPhong}</option>
        </c:forEach>
    </select> <br>
    <button>Them moi</button>
</form:form>
<h2>Danh sach</h2>
<table>
    <tr>
        <th>Ten Phong</th>
        <th>So luong phong</th>
        <th>Trang thai</th>
        <th>Ghi chu</th>
        <th>Ten loai phong</th>
        <th>Hanh dong</th>
    </tr>
    <c:forEach items="${page.content}" var="p">
        <tr>
            <td>${p.tenPhong}</td>
            <td>${p.soLuongPhong}</td>
            <td>${p.trangThai}</td>
            <td>${p.ghiChu}</td>
            <td>${p.tenLoaiPhong}</td>
            <td>
                <a href="/room/delete?id=${p.id}">Xoa</a>
            </td>
        </tr>
    </c:forEach>

    <a href="?page=0">First</a>
    <a href="/room/groups?page=${page.first ? 0 : page.number - 1}">Pre</a>
    <c:forEach begin="0" end="${page.totalPages - 1}" var="i">
        <a href="/room/groups?page=${i}" style="margin: 0 5px;">
                ${i + 1}
        </a>
    </c:forEach>
    <a href="/room/groups?page=${page.last ? page.totalPages - 1 : page.number + 1}">Next</a>
    <a href="/room/groups?page=${page.totalPages - 1}">Last</a>
</table>
</body>
</html>