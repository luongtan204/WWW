<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>IUH BOOKSTORE - Product Detail</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { background: #f9f9f9; font-family: Arial, sans-serif; }
        .header-bar {
            background: #b3a074;
            background: linear-gradient(to bottom, #b3a074 60%, #e4d5b7 100%);
            padding: 0;
            margin-bottom: 0;
        }
        .header-bar img { height: 50px; }
        .navbar-nav .nav-link {
            color: #fff !important;
            font-weight: bold;
            padding: 18px 22px;
        }
        .navbar-nav .nav-link.active {
            background: #a18a5b !important;
            border-radius: 4px;
        }
        .sidebar {
            background: #fff;
            border: 1px solid #ccc;
            border-radius: 6px;
            padding: 18px 16px;
            margin-top: 18px;
        }
        .sidebar-title {
            font-size: 18px;
            font-weight: bold;
            color: #444;
        }
        .sidebar-link {
            font-size: 13px; color: #555;
        }
        .search-box {
            border: 1px solid #aaa;
            border-radius: 4px;
            width: 100%;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<%@ include file="layout-header.jsp" %>
<div class="container" style="margin-top: 16px;">
    <div class="row">
        <div class="col-md-3">
            <%@ include file="layout-sidebar.jsp" %>
        </div>
        <div class="col-md-9">
            <c:if test="${not empty book}">
                <div>
                    <div style="font-size:16px;font-weight:bold;margin-bottom:10px;">
                        Product details: ${book.title}
                    </div>
                    <div style="display:flex;align-items:flex-start;gap:30px;">
                        <img src="${pageContext.request.contextPath}/images/${book.image}" alt="${book.title} Cover" style="width:200px;height:260px;object-fit:cover;border:1px solid #ccc;background:#eee;"/>
                        <div style="margin-top:10px;">
                            <div style="font-size:18px;font-weight:bold;margin-bottom:8px;">${book.title}</div>
                            <div style="font-size:15px;margin-bottom:8px;">Price (VND): <fmt:formatNumber value="${book.price}" type="number" maxFractionDigits="0"/></div>
                            <div style="font-size:15px;margin-bottom:8px;">Quantity: ${book.quantity}</div>
                            <div style="margin-top:18px;">
                                <a href="${pageContext.request.contextPath}/books">Back to Product List</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${empty book}">
                <div class="alert alert-warning">Book not found.</div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>

