<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout Success</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .success-box {
            background: #fff;
            border: 1px solid #bbb;
            border-radius: 7px;
            margin-top: 30px;
            padding: 30px 40px;
            text-align: center;
        }
        .success-title {
            font-size: 20px;
            font-weight: bold;
            color: #1976d2;
            margin-bottom: 18px;
        }
        .success-msg {
            font-size: 16px;
            color: #444;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<%@ include file="layout-header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%@ include file="layout-sidebar.jsp" %>
        </div>
        <div class="col-md-9">
            <div class="success-box">
                <div class="success-title">Order Successful!</div>
                <div class="success-msg">${message}</div>
                <div class="success-msg">Total paid: <b>${total}</b> VND</div>
                <a href="${pageContext.request.contextPath}/books" class="btn btn-primary btn-sm" style="margin-top:18px;">Back to Home</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

