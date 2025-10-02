<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Kết quả tìm kiếm vé máy bay</title></head>
<body>
<h2>Kết quả tìm kiếm vé máy bay theo tên</h2>
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
<a href="vemaybay?action=list">Quay lại danh sách vé máy bay</a>
</body>
</html>