<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Danh Sách Tin Tức Theo Danh Mục</title>
  <style>
    body { font-family: Arial, sans-serif; }
    .container { width: 90%; margin: 0 auto; }
    h2 { margin-top: 20px; }
    table { width: 100%; border-collapse: collapse; margin-top: 15px; }
    th, td { border: 1px solid #ccc; text-align: left; padding: 8px; }
    th { background: #eee; }
    select { padding: 4px; }
    .header { display: flex; align-items: center; justify-content: space-between; }
    .header h2 { margin: 0; }
    .add-btn { padding: 6px 14px; background: #0066cc; color: white; border: none; border-radius: 3px; text-decoration: none; margin-left: 10px;}
    .add-btn:hover { background: #004999; }
  </style>
</head>
<body>
<div class="container">
  <div class="header">
    <h2>Danh Sách Tin Tức</h2>
    <div>
      <form method="get" action="danhsachtintuc" style="display:inline;">
        <label for="maDM">Chọn danh mục:</label>
        <select name="maDM" id="maDM" onchange="this.form.submit()">
          <c:forEach var="dm" items="${danhMucs}">
            <option value="${dm.maDM}" <c:if test="${dm.maDM == selectedMaDM}">selected</c:if>>
                ${dm.tenDM}
            </option>
          </c:forEach>
        </select>
      </form>
      <a class="add-btn" href="danhsachtintuc?action=new">+ Thêm tin tức</a>
    </div>
  </div>
  <table>
    <thead>
    <tr>
      <th>Mã Tin</th>
      <th>Tiêu Đề</th>
      <th>Nội Dung</th>
      <th>Liên Kết</th>

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
              <c:choose>
                <c:when test="${not empty tt.lienket}">
                  <a href="${tt.lienket}" target="_blank">${tt.lienket}</a>
                </c:when>
                <c:otherwise>
                  Không có
                </c:otherwise>
              </c:choose>
            </td>

          </tr>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <tr>
          <td colspan="5" style="text-align:center;">Không có tin tức nào!</td>
        </tr>
      </c:otherwise>
    </c:choose>
    </tbody>
  </table>
  <br>
  <a class="add-btn" href="quanlytintuc">Quản lí</a>
</div>
</body>
</html>