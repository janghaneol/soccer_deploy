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

<c:forEach var="notice" items="${select}">
<tr>
    <td>${notice.notice_index}</td> <br>
    <td>${notice.notice_title}</td> <br>	
    <td>${notice.notice_content}</td> <br>
    <td>${notice.notice_date}</td> <br>
    <td>${notice.notice_count}</td> <br>
 
</tr>
</c:forEach>

</body>
</html>