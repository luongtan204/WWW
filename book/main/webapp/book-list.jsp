<%--
  Created by IntelliJ IDEA.
  User: HPP
  Date: 9/15/2025
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>IUH BOOKSTORE - Danh sách sách</title>
    <!-- Bootstrap CDN (có thể thay bằng file local của bạn) -->
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
        .book-list {
            display: flex;
            flex-wrap: wrap;
            gap: 22px;
        }
        .book-card {
            background: #fff;
            border: 1px solid #aaa;
            border-radius: 7px;
            padding: 13px 12px 10px 12px;
            min-width: 190px;
            max-width: 210px;
            margin-bottom: 18px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.02);
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .book-card img {
            width: 110px;
            height: 160px;
            object-fit: cover;
            border: 1px solid #ccc;
            margin-bottom: 9px;
            background: #eee;
        }
        .book-title {
            font-size: 15px;
            font-weight: bold;
            margin-bottom: 4px;
        }
        .book-meta {
            font-size: 13px;
            margin-bottom: 1px;
        }
        .book-link {
            font-size: 13px;
            color: #1976d2; text-decoration: underline;
            margin-bottom: 3px;
        }
        .book-link:hover { color: #0d395f; }
        .btn-add-cart {
            font-size: 13px;
            padding: 3px 14px;
            margin-top: 2px;
        }
        @media (max-width: 1000px) {
            .book-list { justify-content: center; }
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
            <c:if test="${not empty books}">
                <div class="book-list">
                    <c:forEach var="b" items="${books}">
                        <div class="book-card">
                            <div class="book-title">${b.title}</div>
                            <img src="${pageContext.request.contextPath}/images/${b.image}" alt="${b.title}" />
                            <div class="book-meta">
                                Price: <fmt:formatNumber value="${b.price}" type="number" maxFractionDigits="0"/>
                            </div>
                            <div class="book-meta">Quantity: ${b.quantity}</div>
                            <a class="book-link" href="${pageContext.request.contextPath}/book?id=${b.id}">Product details</a>
                            <form action="${pageContext.request.contextPath}/cart" method="post" style="margin:0;">
                                <input type="hidden" name="id" value="${b.id}"/>
                                <input type="hidden" name="action" value="add"/>
                                <input type="hidden" name="quantity" value="1"/>
                                <button type="submit" class="btn btn-primary btn-add-cart">Add to cart</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${empty books}">
                <div>Không có sách nào.</div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>