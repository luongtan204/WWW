<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Danh sách chuyến bay</title></head>
<body>
<h2>Danh sách chuyến bay</h2>
<table border="1">
  <tr>
    <th>Mã chuyến</th>
    <th>Tên chuyến</th>
    <th>Nơi đi</th>
    <th>Nơi đến</th>
    <th>Ngày bay</th>
    <th>Xem vé</th>
  </tr>
  <c:forEach var="cb" items="${dsChuyenBay}">
    <tr>
      <td>${cb.maChuyen}</td>
      <td>${cb.tenChuyen}</td>
      <td>${cb.noiDi}</td>
      <td>${cb.noiDen}</td>
      <td>${cb.ngayBay}</td>
      <td>
        <a href="vemaybay?action=byChuyenbay&maChuyen=${cb.maChuyen}">Xem vé</a>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="vemaybay">Xem danh sach ve</a>
</body>
</html>