<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Vé máy bay theo chuyến bay</title></head>
<body>
<h2>Danh sách vé máy bay của chuyến bay ${param.maChuyen}</h2>
<table border="1">
  <tr>
    <th>Mã vé</th>
    <th>Họ tên hành khách</th>
    <th>Giá vé</th>
    <th>Loại vé</th>
    <th>Chỉnh sửa</th>
  </tr>
  <c:forEach var="ve" items="${dsVeMayBay}">
    <tr>
      <td>${ve.maVe}</td>
      <td>${ve.hoTenHanhKhach}</td>
      <td>${ve.giaVe}</td>
      <td>${ve.loaiVe}</td>
      <td>
        <a href="vemaybay?action=edit&maVe=${ve.maVe}">Sửa</a>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="chuyenbay?action=list">Quay lại danh sách chuyến bay</a>
</body>
</html>