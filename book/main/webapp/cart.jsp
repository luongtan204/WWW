<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>IUH BOOKSTORE - Shopping Cart</title>
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
        .cart-table {
            width: 100%;
            background: #fff;
            border-collapse: collapse;
            margin-top: 10px;
        }
        .cart-table th, .cart-table td {
            border: 1px solid #bbb;
            padding: 8px 10px;
            text-align: center;
        }
        .cart-table th {
            background: #e4d5b7;
            font-size: 15px;
        }
        .cart-table td {
            font-size: 14px;
        }
        .cart-actions {
            margin-top: 12px;
        }
        .cart-total-row td {
            font-weight: bold;
            background: #f5f5f5;
        }
        .cart-remove-link {
            color: #1976d2;
            text-decoration: underline;
            cursor: pointer;
        }
        .cart-remove-link:hover {
            color: #b30000;
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
            <h5 style="margin-bottom:18px;">YOUR SHOPPING CART</h5>
            <c:if test="${not empty cart.items}">
                <form action="${pageContext.request.contextPath}/cart" method="post">
                    <table class="cart-table">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product name</th>
                                <th>Price</th>
                                <th>Qty</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${cart.items}">
                                <tr>
                                    <td>${item.book.id}</td>
                                    <td>${item.book.title}</td>
                                    <td><fmt:formatNumber value="${item.book.price}" type="number" maxFractionDigits="0"/></td>
                                    <td>${item.quantity}</td>
                                    <td><fmt:formatNumber value="${item.book.price * item.quantity}" type="number" maxFractionDigits="0"/></td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/cart" method="post"
                                              style="display:inline;">
                                            <input type="hidden" name="action" value="remove" />
                                            <input type="hidden" name="productId" value="${item.book.id}" />
                                            <input type="submit" value="Remove" class="remove-btn" />
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr class="cart-total-row">
                                <td colspan="4" style="text-align:right;">Total price</td>
                                <td colspan="2" style="text-align:left;">
                                    <fmt:formatNumber value="${cart.tao}" type="number" maxFractionDigits="0"/> (VND)
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                    <div class="cart-actions">
                        <a href="${pageContext.request.contextPath}/checkout" class="btn btn-primary btn-sm">Checkout</a>
                        <a href="${pageContext.request.contextPath}/books" class="btn btn-secondary btn-sm">Continue shopping</a>
                    </div>
                </form>
            </c:if>
            <c:if test="${empty cart.items}">
                <div class="alert alert-warning">Your cart is empty.</div>
                <a href="${pageContext.request.contextPath}/books" class="btn btn-secondary btn-sm">Continue shopping</a>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
