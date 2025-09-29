<%-- Created by IntelliJ IDEA. User: nguye Date: 9/15/2025 Time: 12:39 AM To change this template use File | Settings |
    File Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <html>

            <head>
                <title>Shopping Cart</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        margin: 20px;
                    }

                    .container {
                        max-width: 800px;
                        margin: 0 auto;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                        margin: 20px 0;
                    }

                    th,
                    td {
                        border: 1px solid #ddd;
                        padding: 8px;
                        text-align: left;
                    }

                    th {
                        background-color: #f2f2f2;
                    }

                    input[type="number"] {
                        width: 60px;
                    }

                    input[type="submit"] {
                        background-color: #4CAF50;
                        color: white;
                        padding: 5px 10px;
                        border: none;
                        cursor: pointer;
                        margin: 2px;
                    }

                    input[type="submit"]:hover {
                        background-color: #45a049;
                    }

                    .remove-btn {
                        background-color: #f44336;
                    }

                    .remove-btn:hover {
                        background-color: #da190b;
                    }

                    .clear-btn {
                        background-color: #ff9800;
                        color: white;
                        padding: 8px 16px;
                        border: none;
                        cursor: pointer;
                        font-size: 14px;
                        margin: 10px 0;
                    }

                    .clear-btn:hover {
                        background-color: #e68900;
                    }

                    .total {
                        font-size: 18px;
                        font-weight: bold;
                        margin: 20px 0;
                    }

                    a {
                        color: #2196F3;
                        text-decoration: none;
                    }

                    a:hover {
                        text-decoration: underline;
                    }
                </style>
            </head>

            <body>
                <div class="container">
                    <h2>Cart</h2>


                    <c:if test="${empty cart.items}">
                        <p>Cart is emppty!</p>
                    </c:if>

                    <c:if test="${not empty cart.items}">
                        <table class="table table-border">
                            <tr>
                                <th>Model</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Total</th>
                                <th>Actions</th>
                            </tr>
                            <c:forEach var="item" items="${cart.items}">
                                <tr>
                                    <td>${item.product.model}</td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/cart" method="post"
                                            style="display:inline;">
                                            <input type="hidden" name="action" value="update" />
                                            <input type="hidden" name="productId" value="${item.product.id}" />
                                            <input type="number" name="quantity" value="${item.quantity}" min="1" />
                                            <input type="submit" value="Update" />
                                        </form>
                                    </td>
                                    <td>${item.product.price}</td>
                                    <td>${item.product.price * item.quantity}</td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/cart" method="post"
                                            style="display:inline;">
                                            <input type="hidden" name="action" value="remove" />
                                            <input type="hidden" name="productId" value="${item.product.id}" />
                                            <input type="submit" value="Remove" class="remove-btn" />
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <p><strong>Total: </strong> ${cart.total}</p>

                        <!-- Nút xóa hết giỏ hàng -->
                        <form action="${pageContext.request.contextPath}/cart" method="post"
                            style="display:inline; margin-top: 10px;">
                            <input type="hidden" name="action" value="clear" />
                            <input type="submit" value="Xóa hết giỏ hàng" class="clear-btn"
                                onclick="return confirm('Bạn có chắc chắn muốn xóa hết giỏ hàng?')" />
                        </form>
                    </c:if>

                    <a href="products">Tiếp tục mua</a>
                </div>
            </body>

            </html>