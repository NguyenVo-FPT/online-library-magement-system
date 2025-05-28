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
        <title>System Config</title>
    </head>
    <body>
        <div>
            <%@ page import="java.util.ArrayList, dto.SystemConfig" %>
            <%
                ArrayList<SystemConfig> list = (ArrayList<SystemConfig>) request.getAttribute("list");
            %>
            <table>
                <tr>
                    <th>CONFIG KEY</th>
                    <th>DESCRIPTION</th>
                </tr>
                <% for (SystemConfig sc : (ArrayList<SystemConfig>) request.getAttribute("list")) { %>
                <form action="">
                    <tr>
                        <td><%= sc.getKey() %></td>
                        <td><%= sc.getValue() %></td>
                        <td><%= sc.getDescription() %></td>
                        <td><input type="submit" value="edit"></td>
                    </tr>
                </form>
                <% } %>
            </table>

        </div>
    </body>
</html>
