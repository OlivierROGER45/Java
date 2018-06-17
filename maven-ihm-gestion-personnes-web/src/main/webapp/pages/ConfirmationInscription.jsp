<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = "";
    String userEmail = "";
    String userMessage = "";
    if (request.getAttribute("userName") != null)
    {
        userName = (String) request.getAttribute("userName");
    }
    if (request.getAttribute("userEmail") != null)
    {
        userEmail = (String) request.getAttribute("userEmail");
    }
    if (request.getAttribute("userMessage") != null)
    {
        userMessage = (String) request.getAttribute("userMessage");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de confirmation de Newletters</title>
</head>
<body>
	<h1>Confirmation de votre inscription à la Newsletters !</h1>
	<div>
		Nom : &nbsp;<%
	    out.println(userName);
	%>
	</div>
	<div>
		Courriel : &nbsp;<%
	    out.println(userEmail);
	%>
	</div>
	<div>
		Message : &nbsp;<%
	    out.println(userMessage);
	%>
	</div>
</body>
</html>