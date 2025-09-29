<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>IUH BOOKSTORE - Checkout</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { background: #f9f9f9; font-family: Arial, sans-serif; }
        .checkout-box {
            background: #fff;
            border: 1px solid #bbb;
            border-radius: 7px;
            margin-top: 10px;
            padding: 18px 24px 18px 24px;
            min-width: 350px;
        }
        .checkout-title {
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 12px;
            color: #444;
        }
        .checkout-label {
            font-size: 14px;
            font-weight: bold;
            color: #444;
            width: 140px;
        }
        .checkout-input {
            width: 100%;
            padding: 4px 8px;
            border: 1px solid #bbb;
            border-radius: 4px;
            font-size: 14px;
        }
        .checkout-row {
            display: flex;
            align-items: center;
            margin-bottom: 12px;
        }
        .checkout-radio {
            margin-right: 10px;
        }
        .checkout-actions {
            text-align: right;
            margin-top: 10px;
        }
        .checkout-actions button, .checkout-actions a {
            min-width: 70px;
            margin-left: 6px;
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
            <div class="checkout-box">
                <div class="checkout-title">Checkout - Already registered? ...</div>
                <form action="${pageContext.request.contextPath}/checkout" method="post">
                    <div class="checkout-row">
                        <label class="checkout-label" for="fullname">Fullname:</label>
                        <input type="text" class="checkout-input" id="fullname" name="fullname" required />
                    </div>
                    <div class="checkout-row">
                        <label class="checkout-label" for="address">Shipping address:</label>
                        <input type="text" class="checkout-input" id="address" name="address" required />
                    </div>
                    <div class="checkout-row">
                        <label class="checkout-label" for="total">Total price:</label>
                        <input type="text" class="checkout-input" id="total" name="total" value="<fmt:formatNumber value='${cart.total}' type='number' maxFractionDigits='0'/>" readonly />
                    </div>
                    <div class="checkout-row">
                        <label class="checkout-label">Payment method:</label>
                        <div>
                            <label class="checkout-radio"><input type="radio" name="payment" value="Paypal" required />Paypal</label>
                            <label class="checkout-radio"><input type="radio" name="payment" value="ATM" />ATM Debit</label>
                            <label class="checkout-radio"><input type="radio" name="payment" value="Visa" />Visa/Master card</label>
                        </div>
                    </div>
                    <div class="checkout-actions">
                        <button type="submit" class="btn btn-primary btn-sm">Save</button>
                        <a href="${pageContext.request.contextPath}/cart" class="btn btn-secondary btn-sm">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

