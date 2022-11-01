<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <div class="wrapper">
        <div class="user-container">
            대화명 : <input type="text" id="nickname">
        </div>

        <div class="display-container">
            <ul class="chatting-list"></ul>
        </div>

        <div class="input-container">
            <input type="text" class="chatting-input">
            <button class="send-button">전송</button>
        </div>

    </div>
    <h1>Hello!</h1>
    <!-- <script src="/socket.io/socket.io.js"></script> -->
    <!-- Test HD -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/4.5.3/socket.io.js"></script>

    <script src="js/chat.js"></script>
</body>
</html>