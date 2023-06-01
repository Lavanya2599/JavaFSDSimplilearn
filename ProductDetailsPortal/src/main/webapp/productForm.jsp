<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
<form action="product" method="post">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" required><br>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>