<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
<!DOCTYPE html>
<html>
<%
int a = 10;
int b = 10;
%>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> DSL(Domain-Specific Language) : 특정 영역에서 사용되는 언어. (jsp에선 java, build.gradle에서는 groovy가 예시.)
<%
int sum = a+b;
%>
  a + b = <%= sum %>
</body>
</html>