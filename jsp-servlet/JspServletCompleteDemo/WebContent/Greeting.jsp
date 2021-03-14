<%@page import="com.app.model.UserModel"%>
<%@page import="com.app.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="func" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greeting Page!</title>
</head>
<body>


<br /><h1>Using Java Codes</h1>
<h1>Hello, <%=session.getAttribute("username")%></h1>

<%
// UserModel user = (UserModel)session.getAttribute("userinfo");
UserModel user = (UserModel)request.getAttribute("userinfo");
pageContext.setAttribute("session_username", request.getParameter("username")+"session" , PageContext.SESSION_SCOPE);
pageContext.setAttribute("application_username", request.getParameter("username")+"application" , PageContext.APPLICATION_SCOPE);
%>

<h4>
<br />User's name is: <%=user.getUserName()%>
<br />User's location is: <%=user.getCity()%>
<br />User's Pin is: <%=user.getPincode()%>
</h4>

<!-- Using EL -->
<br /><h1>Using Expression Language</h1>
<h3>Request scope message: ${requestScope.greetingMessage}</h3>
<h3>Request scope message2: ${greetingMessage}</h3>
<h3>Cookie: ${cookie.username.value}</h3>
<h3>Param: ${param.username eq 'username1'} </h3>
<h3>Session Scope: ${sessionScope.userinfo}</h3>
<h3>Session Scope2: ${userinfo}</h3>

<!-- Using JSTL -->
<br /><h1>Using JSTL</h1>
<jsp:useBean id="userinfo" class="com.app.model.UserModel" scope="request">
</jsp:useBean>
<h4>
<br />User's name is: <jsp:getProperty property="userName" name="userinfo"/>
<br />User's location is: <jsp:getProperty property="city" name="userinfo"/>
<br />User's Pincode is: <jsp:getProperty property="pincode" name="userinfo"/>
</h4>

<jsp:useBean id="newuser" class="com.app.model.UserModel" scope="request">
	<jsp:setProperty name="newuser" property="userName" value="new user name"/>
	<jsp:setProperty name="newuser" property="city" value="new user's city"/>
	<jsp:setProperty name="newuser" property="pincode" value="new user's pin"/>
</jsp:useBean>
<br /><h4>Value set for new user: <%=newuser %></h4>

	<core:set var="jstlParam" value="JSTLSetParam" scope="session" />
	
	<core:out value="out.print using JSTL"></core:out>
	
	<br />Hello Servlet<form action="Hello" method="Get"><input type="submit"></form>
	<br />Hello JSP<form action="Hello.jsp" method="Get"><input type="submit"></form>
	<br />Processor Servlet<form action="Processor" method="Get"><input type="submit"></form>
	<br />UserServlet <form action="userDetails.html" method="Get"><input type="submit"></form>
	<br />UserForm 2<form action="UserForm2" method="Get"><input type="submit"></form>
	<br />Redirecting Servlet<form action="RedirectingServlet" method="Get"><input type="submit"></form>
	<br />Initialized JSP Param<form action="InitJSP" method="Get"><input type="submit"></form>
	<br />User Registration Form<form action="userRegistrationForm.jsp" method="Get"><input type="submit"></form>
	<br />
	
<form action="Logout.jsp">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>