<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name,id,pw;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
id=(String)session.getAttribute("id");
pw=(String)session.getAttribute("pw");
name=(String)session.getAttribute("name");
%>
<%=id %>님 안녕하세요?
<%=pw %>님 안녕하세요?
<%=name %>님 안녕하세요?


</body>
</html>