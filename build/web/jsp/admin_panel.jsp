<%-- 
    Document   : admin_panel
    Created on : May 29, 2025, 12:27:04 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
    </head>
    <body class="admin-page">
        <%@ page import="dto.User" %>
        
        <% User user = (User) session.getAttribute("user"); %>
        <%
        if (user == null || !"admin".equals(user.getRole())) {
            response.sendRedirect("../index.html");
            return;
        }
        %>
        
        <div class="">
            <div class="header">
                <h2>Wellcome back! </h2>
                <p><a href="../LogoutController">Log out</a></p>
            </div>

            <div class="content">
                <h2>Admin Dashboard</h2>
                <div><a href="controllers/SystemConfigController">system config</a></div>
                <div><a href="../BookController">Book Mangement</a></div>
                <div>update soon!</div>
            </div>

            <div class="footer">

            </div>
        </div>
    </body>
</html>
