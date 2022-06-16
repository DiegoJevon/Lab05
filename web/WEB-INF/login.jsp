<%-- 
    Document   : login
    Created on : Jun 10, 2022, 9:28:32 AM
    Author     : Diego Maia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="POST" action="">
            <label>Username: </label>
            <input type="text" name="username" value="${username}"><br>
            <label>Password: </label>
            <input type="password" name="password" value="${password}"><br>
            <input type="submit" value="Log in">
            <p>${message}</p>
        </form>
    </body>
</html>
