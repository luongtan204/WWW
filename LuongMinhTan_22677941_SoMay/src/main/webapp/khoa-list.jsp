<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.luongminhtan_22677941_somay.model.Khoa" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>DANH SACH KHOA</title>
</head>
<body>
<div>
    <h2>DANH SACH KHOA</h2>

    <table border="1" width="100%" cellspacing="0" cellpadding="5">
        <tr>
            <th>Ma khoa</th>
            <th>Ten khoa</th>
            <th>Truong khoa</th>
            <th>Mo ta</th>
            <th>Xem benh nhan</th>
        </tr>
        <c:forEach var="k" items="${khoas}">
            <tr>
                <td>${k.maKhoa}</td>
                <td>${k.tenKhoa}</td>
                <td>${k.truongKhoa}</td>
                <td>${k.moTa}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/benhnhan?action=byKhoa&makhoa=${k.maKhoa}">
                        Xem
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="${pageContext.request.contextPath}/benhnhan?action=list">Xem benh nhan</a>
</div>
</body>
</html>
