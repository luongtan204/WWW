<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.luongminhtan_22677941_somay.model.Khoa" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>THEM BENH NHAN</title>
</head>
<body>
<div>
    <h2>THEM BENH NHAN MOI</h2>

    <form action="${pageContext.request.contextPath}/benhnhan" method="post">
        <p>
            <label>Ho ten:</label><br/>
            <input type="text" name="hoten" required/>
        </p>

        <p>
            <label>Ngay nhap vien:</label><br/>
            <input type="date" name="ngaynhapvien" required/>
        </p>

        <p>
            <label>Chuan doan:</label><br/>
            <input type="text" name="chuandoan" required/>
        </p>

        <p>
            <label>Khoa dieu tri:</label><br/>
            <select name="makhoa">
                <c:forEach var="k" items="${khoas}">
                    <option value="${k.maKhoa}">${k.tenKhoa}</option>
                </c:forEach>
            </select>
        </p>

        <p>
            <input type="submit" value="Luu"/>
            <a href="${pageContext.request.contextPath}/benhnhan?action=list">Huy</a>
        </p>
    </form>
</div>
</body>
</html>
