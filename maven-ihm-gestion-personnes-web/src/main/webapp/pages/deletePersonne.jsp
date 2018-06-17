<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="com.dao.factory.complexe.AbstractDaoFactory"%>
<%@ page import ="com.dao.factory.complexe.AbstractDaoFactory.FactoryType"%>


<%@ page import ="com.cours.entities.Personne"%>

<%
    String id = request.getParameter("id");

    Personne p = new Personne();
    p = AbstractDaoFactory.getDaoFactory(FactoryType.SQL_DAO).getPersonneDao().findById(Integer.parseInt(id));
    AbstractDaoFactory.getDaoFactory(FactoryType.SQL_DAO).getPersonneDao().delete(p);
    
    response.sendRedirect("allPersonnes.jsp");  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>