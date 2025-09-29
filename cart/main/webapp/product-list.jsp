<%-- Created by IntelliJ IDEA. User: nguye Date: 9/15/2025 Time: 12:37 AM To change this template use File | Settings |
    File Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%--<%@taglib prefix="c" uri="jakarta.tags.core" %>--%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                <html>

                <head>
                    <title>Product List</title>
                    <style>
                        .product-class {
                            border: 1px solid #ccc;
                            margin: 10px;
                            padding: 10px;
                            display: inline-block;
                            width: 200px;
                            text-align: center;
                        }

                        .hinh {
                            width: 30%;
                            height: auto;
                            object-fit: cover;
                            display: block;
                            margin: 0 auto;
                        }

                        .product-name {
                            text-align: center;
                            margin: 10px 0;
                        }

                        .price {
                            text-align: center;
                            margin: 10px 0;
                            font-weight: bold;
                        }

                        .quantity-input {
                            text-align: center;
                            margin: 10px 0;
                        }

                        .add-to-cart-btn {
                            display: block;
                            margin: 10px auto;
                            padding: 8px 16px;
                            background-color: #4CAF50;
                            color: white;
                            border: none;
                            cursor: pointer;
                            border-radius: 4px;
                        }

                        .add-to-cart-btn:hover {
                            background-color: #45a049;
                        }

                        .product-detail-link {
                            display: block;
                            text-align: center;
                            margin: 10px 0;
                            color: #2196F3;
                            text-decoration: none;
                        }

                        .product-detail-link:hover {
                            text-decoration: underline;
                        }
                    </style>
                </head>

                <body>

                    <body>
                        <p>
                            <a href="cart">View Cart</a>
                        </p>
                        <c:forEach items="${products}" var="p">
                            <div class="product-class">
                                <div class="product-name">${p.model}</div>
                                <img src="${pageContext.request.contextPath}/images/${p.imgURL}" class="hinh">
                                <div class="price">Price: ${p.price}</div>
                                <form action="${pageContext.request.contextPath}/cart" method="post">
                                    <div class="quantity-input">
                                        <input type="text" size="2" value="1" name="quantity">
                                    </div>
                                    <input type="hidden" name="id" value="${p.id}">
                                    <input type="hidden" name="price" value="${p.price}">
                                    <input type="hidden" name="model" value="${p.model}">
                                    <input type="hidden" name="action" value="add">
                                    <input type="submit" name="addToCart" value="Add To Cart" class="add-to-cart-btn">
                                </form>
                                <a href="${pageContext.request.contextPath}/product?id=${p.id}"
                                    class="product-detail-link">Product Detail</a>
                            </div>
                        </c:forEach>
                    </body>
                </body>

                </html>