<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:forEach var="users" items="${select}">
<tr>
    <td>${users.user_id}</td> <br>
    <td>${users.passwd}</td> <br>	
    <td>${users.email}</td> <br>
    <td>${users.name}</td> <br>
    <td>${users.age}</td> <br>
    <td>${users.address}</td> <br>
    <td>${users.img_cont_type}</td> <br>
    <td>${users.img_file_name}</td> <br>
    <td>${users.backnum}</td> <br>
    <td>${users.member_auth}</td> <br>
    <td>${users.position}</td> <br>
    <td>${users.regdate}</td> <br>
</tr>
</c:forEach>

</body>
</html>