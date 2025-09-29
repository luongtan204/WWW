<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Thêm Tin Tức</title>
  <style>
    body { font-family: Arial, sans-serif; }
    .container { width: 440px; margin: 40px auto; border: 1px solid #ccc; padding: 28px; border-radius: 7px; }
    label { display: block; margin-top: 12px; }
    input[type="text"], textarea, select {
      width: 100%; padding: 7px; margin-top: 4px; box-sizing: border-box;
    }
    textarea { resize: vertical; }
    .btns { margin-top: 24px; }
    button { padding: 8px 18px; border: none; background: #0066cc; color: #fff; border-radius: 3px; cursor: pointer; }
    button:hover { background: #004999; }
    .header { text-align: center; margin-bottom: 18px; }
    .error { color: red; }
  </style>
  <script>
    function validateForm() {
      // Lấy giá trị các trường
      var maTT = document.getElementById("maTT").value.trim();
      var tieude = document.getElementById("tieude").value.trim();
      var noidungTT = document.getElementById("noidungTT").value.trim();
      var lienket = document.getElementById("lienket").value.trim();
      var maDM = document.getElementById("maDM").value;

      // Kiểm tra bắt buộc nhập
      if (!maTT || !tieude || !noidungTT || !lienket || !maDM) {
        alert("Vui lòng điền đầy đủ tất cả các trường!");
        return false;
      }

      // Liên kết phải bắt đầu bởi http://
      var regLink = /^http:\/\//;
      if (!regLink.test(lienket)) {
        alert("Liên kết phải bắt đầu bằng http://");
        document.getElementById("lienket").focus();
        return false;
      }

      // Nội dung không quá 255 ký tự
      if (noidungTT.length > 255) {
        alert("Nội dung không được vượt quá 255 ký tự!");
        document.getElementById("noidungTT").focus();
        return false;
      }

      // Có thể kiểm tra thêm bằng Regular Expression nếu muốn
      var regContent = /^.{1,255}$/;
      if (!regContent.test(noidungTT)) {
        alert("Nội dung không hợp lệ (1-255 ký tự)!");
        document.getElementById("noidungTT").focus();
        return false;
      }

      return true;
    }
  </script>
</head>
<body>
<div class="container">
  <div class="header">
    <h2>Thêm Tin Tức Mới</h2>
  </div>
  <c:if test="${not empty message}">
    <div class="error">${message}</div>
  </c:if>
  <form method="post" action="danhsachtintuc?action=add" onsubmit="return validateForm();">
    <label for="maTT">Mã tin tức</label>
    <input type="text" name="maTT" id="maTT" required />

    <label for="tieude">Tiêu đề</label>
    <input type="text" name="tieude" id="tieude" required />

    <label for="noidungTT">Nội dung</label>
    <textarea name="noidungTT" id="noidungTT" rows="5" required maxlength="255"></textarea>

    <label for="lienket">Liên kết</label>
    <input type="text" name="lienket" id="lienket" required />

    <label for="maDM">Danh mục</label>
    <select name="maDM" id="maDM" required>
      <c:forEach var="dm" items="${danhMucs}">
        <option value="${dm.maDM}">${dm.tenDM}</option>
      </c:forEach>
    </select>

    <div class="btns">
      <button type="submit">Lưu</button>
      <a href="danhsachtintuc" style="margin-left: 12px; color: #666;">Hủy</a>
    </div>
  </form>
</div>
</body>
</html>