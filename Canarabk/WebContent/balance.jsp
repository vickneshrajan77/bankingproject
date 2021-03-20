<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="html1.css">
<title>Insert title here</title>
</head>
<body>
<h1 style="margin-left: 13em; color: blue;"> BALANCE</h1>
<h3 style="margin-left: 10em; color: blue;">your balance</h3>
<span style="margin-left: 13em;">
<%  
out.println(session.getAttribute("balance")); 
%> 
</span>
</body>
</html>