<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
    <form action="AddProductServlet" method="POST">
        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>
        
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required>
        <br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description"></textarea>
        <br><br>
        
        <input type="submit" value="Add Product">
    </form>
</body>
</html>