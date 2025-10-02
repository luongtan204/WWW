<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Danh sách vé máy bay</title></head>
<body>
<h2>Danh sách vé máy bay</h2>
<table border="1">
  <tr>
    <th>Mã vé</th>
    <th>Họ tên hành khách</th>
    <th>Giá vé</th>
    <th>Loại vé</th>
    <th>Mã chuyến bay</th>
    <th>Chỉnh sửa</th>
  </tr>
  <c:forEach var="ve" items="${dsVeMayBay}">
    <tr>
      <td>${ve.maVe}</td>
      <td>${ve.hoTenHanhKhach}</td>
      <td>${ve.giaVe}</td>
      <td>${ve.loaiVe}</td>
      <td>${ve.maChuyen}</td>
      <td>
        <a href="vemaybay?action=edit&maVe=${ve.maVe}">Sửa</a>
      </td>
    </tr>
  </c:forEach>
</table>
<form action="vemaybay" method="get">
  <input type="hidden" name="action" value="search"/>
  <input type="text" name="ten" placeholder="Nhập tên hành khách để tìm kiếm"/>
  <button type="submit">Tìm kiếm</button>
</form>

<a href="chuyenbay">Xem danh sach chuyen bay</a>
</body>
</html>