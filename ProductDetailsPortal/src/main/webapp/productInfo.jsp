<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.details.Product" %>
<%
    Product product = (Product) session.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Information</title>
</head>
<body>
    <h1>Product Information</h1>
    <p><strong>ID:</strong> <%= product.getId() %></p>
    <p><strong>Name:</strong> <%= product.getName() %></p>
    <p><strong>Price:</strong> <%= product.getPrice() %></p>
    <p><strong>Description:</strong> <%= product.getDescription() %></p>
</body>
</html>