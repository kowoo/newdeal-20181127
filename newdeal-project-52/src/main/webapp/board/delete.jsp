<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<!-- html을 출력 후 1초 후에 상대경로 list로 새로고침을 실행하라. 누가? 웹브라우저에게 -->
<meta http-equiv="Refresh" content="1;url=list">
<title>게시물</title>
</head>
<body>
<h1>게시물 삭제</h1>
<c:choose>
  <c:when test="${count==0}">
    <p>해당 번호의 게시물이 없습니다.</p>
  </c:when>
  <c:otherwise>
    <p>삭제하였습니다</p>
  </c:otherwise>
</c:choose> 
</body>
</html>
