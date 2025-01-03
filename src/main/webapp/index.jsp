<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>وضعیت کد</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
      background-color: #f4f4f9;
    }
    .container {
      background-color: #fff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      text-align: center;
    }
    h1 {
      color: #333;
    }
    p {
      margin-bottom: 20px;
      color: #666;
    }
    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
    }
    input[type="number"] {
      padding: 10px;
      width: calc(100% - 20px);
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    button {
      padding: 10px 20px;
      background-color: #007BFF;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
    }
    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>وارد کردن وضعیت کد</h1>
  <p>لطفاً یک کد وضعیت (Status Code) وارد کنید:</p>
  <form action="index" method="post">
    <label for="statusCode">وضعیت کد:</label>
    <input type="number" id="statusCode" name="statusCode" required>
    <br/>
    <button type="submit">Submit</button>
  </form>
</div>
</body>
</html>
