<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết Quả Thêm Tin Tức</title>
    <style>
        body { font-family: Arial,sans-serif; }
        .container { width: 500px; margin: 40px auto; border: 1px solid #ccc; padding: 28px; border-radius: 7px;}
        .header { text-align: center; margin-bottom: 18px; }
        .info {margin-bottom: 20px;}
        .info p { margin: 8px 0; }
        a { color: #0066cc; text-decoration: none; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Thêm Tin Tức Thành Công</h2>
    </div>
    <div class="info">
        <p><strong>Mã tin:</strong> ${tinTuc.maTT}</p>
        <p><strong>Tiêu đề:</strong> ${tinTuc.tieude}</p>
        <p><strong>Nội dung:</strong> ${tinTuc.noidungTT}</p>
        <p><strong>Liên kết:</strong>
            <c:choose>
                <c:when test="${not empty tinTuc.lienket}">
                    <a href="${tinTuc.lienket}" target="_blank">${tinTuc.lienket}</a>
                </c:when>
                <c:otherwise>
                    Không có
                </c:otherwise>
            </c:choose>
        </p>
        <p><strong>Danh mục:</strong>
            <c:choose>
                <c:when test="${not empty tinTuc.danhMuc && not empty tinTuc.danhMuc.tenDM}">
                    ${tinTuc.danhMuc.tenDM}
                </c:when>
                <c:otherwise>
                    Không rõ
                </c:otherwise>
            </c:choose>
        </p>
    </div>
    <a href="danhsachtintuc">Quay về danh sách tin tức</a>
</div>
</body>
</html>