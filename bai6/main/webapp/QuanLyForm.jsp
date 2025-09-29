<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Quản Lý Tin Tức</title>
  <style>
    body { font-family: Arial, sans-serif; }
    .container { width: 90%; margin: 0 auto; }
    h2 { margin-top: 20px; }
    table { width: 100%; border-collapse: collapse; margin-top: 15px; }
    th, td { border: 1px solid #ccc; text-align: left; padding: 8px; }
    th { background: #eee; }
    form { display: inline; }
    .btn-delete {
      background: #c00;
      color: #fff;
      border: none;
      padding: 6px 12px;
      border-radius: 3px;
      cursor: pointer;
    }
    .btn-delete:hover { background: #900; }
  </style>
  <script>
    function confirmDelete() {
      return confirm('Bạn có chắc chắn muốn xóa tin này không?');
    }
  </script>
</head>
<body>
<div class="container">
  <a class="add-btn" href="danhsachtintuc"> Quay ve trang tin tuc </a>
  <h2>Quản Lý Tin Tức (Hủy Tin)</h2>
  <table>
    <thead>
    <tr>
      <th>Mã Tin</th>
      <th>Tiêu Đề</th>
      <th>Nội Dung</th>
      <th>Liên Kết</th>
      <th>Danh Mục</th>
      <th>Thao Tác</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${not empty tinTucs}">
        <c:forEach var="tt" items="${tinTucs}">
          <tr>
            <td>${tt.maTT}</td>
            <td>${tt.tieude}</td>
            <td>${tt.noidungTT}</td>
            <td>
              <c:if test="${not empty tt.lienket}">
                <a href="${tt.lienket}" target="_blank">${tt.lienket}</a>
              </c:if>
            </td>
            <td>
              <c:if test="${not empty tt.danhMuc && not empty tt.danhMuc.tenDM}">
                ${tt.danhMuc.tenDM}
              </c:if>
            </td>
            <td>
              <form method="post" action="quanlytintuc" onsubmit="return confirmDelete();">
                <input type="hidden" name="maTT" value="${tt.maTT}" />
                <button type="submit" class="btn-delete">Hủy</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <tr>
          <td colspan="6" style="text-align:center;">Không có tin tức nào!</td>
        </tr>
      </c:otherwise>
    </c:choose>
    </tbody>
  </table>
</div>
</body>
</html>