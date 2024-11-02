
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
<form:form modelAttribute="sanPhamRequest" method="post" action="/san-pham/add">
    ID <form:input type="text" path="id" readonly=""/> <br> <br>
    Ma: <form:input path="ma" /> <br>
    <form:errors path="ma"/> <br>
    So luong: <form:input path="soLuong" /> <br>
    <form:errors path="soLuong"/> <br>
    Gia ban: <form:input path="giaBan" /> <br>
    <form:errors path="giaBan"/> <br>
    Trang thai:
    <form:radiobutton path="trangThai" value="true"/> Con hang
    <form:radiobutton path="trangThai" value="false"/> Het hang <br>

    Loai san pham:
    <select name="loaiSanPham">
        <c:forEach var="lsp" items="${dsLoaiSanPham}">
            <option value="${lsp.id}" ${sanPhamRequest.loaiSanPham.id == lsp.id ? "selected" : ""}>${lsp.ten}</option>
        </c:forEach>
    </select> <br>

    <button>Them moi</button>
</form:form>

<h2>Danh sach san pham</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>So luong</th>
        <th>Gia ban</th>
        <th>Trang thai</th>
        <th>Loai san pham</th>
        <th>Hanh dong</th>
    </tr>
    <c:forEach items="${page.content}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.giaBan}</td>
            <td>${sp.trangThai ? "Con hang" : "Het hang"}</td>
            <td>${sp.tenLoaiSanPham}</td>
            <td>
                <a href="/san-pham/detail?id=${sp.id}">Detail</a>
                <a href="/san-pham/delete?id=${sp.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>

<a href="/san-pham/groups?page=0">First</a>
<a href="/san-pham/groups?page=${page.first ? 0 : page.number - 1}">Pre</a>
<a href="/san-pham/groups?page=${page.last ? page.totalPages -1 : page.number + 1}">Next</a>
<a href="/san-pham/groups?page=${page.totalPages - 1}">Last</a>
</body>
</html>