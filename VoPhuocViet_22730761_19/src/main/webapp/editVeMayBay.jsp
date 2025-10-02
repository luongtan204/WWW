<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Chỉnh sửa vé máy bay</title></head>
<body>
<h2>Chỉnh sửa vé máy bay</h2>
<form action="vemaybay" method="post">
  <input type="hidden" name="action" value="update"/>
  <input type="hidden" name="maVe" value="${veMayBay.maVe}"/>
  <table>
    <tr>
      <td>Họ tên hành khách:</td>
      <td><input type="text" name="hoTenHanhKhach" value="${veMayBay.hoTenHanhKhach}"/></td>
    </tr>
    <tr>
      <td>Giá vé:</td>
      <td><input type="text" name="giaVe" value="${veMayBay.giaVe}"/></td>
    </tr>
    <tr>
      <td>Loại vé:</td>
      <td>
        <select name="loaiVe">
          <option value="Economy" ${veMayBay.loaiVe == 'Economy' ? 'selected' : ''}>Economy</option>
          <option value="Business" ${veMayBay.loaiVe == 'Business' ? 'selected' : ''}>Business</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>Mã chuyến bay:</td>
      <td><input type="text" name="maChuyen" value="${veMayBay.maChuyen}" readonly/></td>
    </tr>
    <tr>
      <td colspan="2"><button type="submit">Lưu</button></td>
    </tr>
  </table>
</form>
<a href="vemaybay?action=byChuyenbay&maChuyen=${veMayBay.maChuyen}">Quay lại danh sách vé chuyến này</a>
<c:if test="${not empty thongbao}">
  <div style="color: green">${thongbao}</div>
</c:if>
</body>
</html>