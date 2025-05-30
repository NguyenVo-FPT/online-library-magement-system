<%-- 
    Document   : config_edit
    Created on : May 29, 2025, 2:35:40 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- <link rel="stylesheet" href="../css/base.css">
        <link rel="stylesheet" href="../css/layout.css">
        <link rel="stylesheet" href="../css/pages.css">
        <link rel="stylesheet" href="../css/components.css"> -->
    </head>
    <body>

        <div class="form-container">
            <!-- <% @page import="java.util.ArrayList, dto.SystemConfig" %>
            <% ArrayList<SystemConfig> list = (ArrayList<SystemConfig>) request.getAttribute("list"); %> -->
            <table>
                    <tr>
                        <th>CONFIG KEY</th>
                        <th>CONFIG VALUE</th>
                        <th>DESCRIPTION</th>
                    </tr>
            </table>
                    <!-- <% for (SystemConfig sc : (ArrayList<SystemConfig>) request.getAttribute("list")) { %>        -->
                    <tr>
                        <form action="../ConfigEditController" method="post">
                        <label for="key" class="lbel">Config Key</label>
                        <input type="text" name="key" class="input-field">
                        <label for="" class="lbel">Config Value</label>
                        <input type="text" name="value" class="input-field">
                        <label for="desc" class="lbel">Description</label>
                        <input type="text" name="desc" class="input-field">
                        <input type="submit" value="Save" class="btn">
                        </form>
                    </tr>
                    <% } %>
        </div>
    </body>
</html>