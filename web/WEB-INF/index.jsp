<%-- 
    Document   : login
    Created on : Sep 19, 2017, 7:27:09 PM
    Author     : 686623
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="header.html"/>

        <h1>Login</h1>
        <form action="Login" method="POST">
            Username: <input type="text" name="uName" value="${username}">  <br>
            Password: <input type="text" name="pWord" values="${password}"><br>
            <input type="submit" value="Login">
        </form>
            ${errorMessage}
            ${message}
<c:import url="footer.html"/>