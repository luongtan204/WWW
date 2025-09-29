<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.luongminhtan_22677941_somay.model.BenhNhan" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>DANH SACH BENH NHAN</title>
</head>
<body>
<div>
  <h2>DANH SACH BENH NHAN</h2>

  <!-- Form tim kiem -->
  <form action="${pageContext.request.contextPath}/benhnhan" method="get">
    <input type="hidden" name="action" value="search"/>
    <input type="text" name="keyword" placeholder="Nhap ten benh nhan"/>
    <input type="submit" value="Tim kiem"/>
    <a href="${pageContext.request.contextPath}/benhnhan?action=new">Them moi</a>
  </form>
  <br/>

  <!-- Bang danh sach -->
  <table border="1" width="100%" cellspacing="0" cellpadding="5">
    <tr>
      <th>Ma BN</th>
      <th>Ho ten</th>
      <th>Ngay nhap vien</th>
      <th>Chuan doan</th>
      <th>Ma khoa</th>
    </tr>
    <c:forEach var="bn" items="${benhnhans}">
      <tr>
        <td>${bn.maBN}</td>
        <td>${bn.hoTen}</td>
        <td>${bn.ngayNhapVien}</td>
        <td>${bn.chuanDoan}</td>
        <td>${bn.maKhoa}</td>
      </tr>
    </c:forEach>
  </table>

  <br/>
  <a href="${pageContext.request.contextPath}/khoa">Xem danh sach Khoa</a>
</div>
</body>
</html>
