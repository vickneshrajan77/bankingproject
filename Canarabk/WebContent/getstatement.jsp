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
<h1 style="margin-left: 13em; color: blue;">your statements are listed below</h1>

<h4 style="margin-left: 10em; color: blue;">FROM ACC|TO ACC|Debited</h4>
<span style="margin-left: 10em;">
<% session = request.getSession();

out.println( session.getAttribute("al")); %>
</span>
</body>
</html>