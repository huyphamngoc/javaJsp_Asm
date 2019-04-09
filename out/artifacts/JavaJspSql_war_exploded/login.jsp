<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/8/2019
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="fragment/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h3>
                Login
            </h3>
            <form action="/login" method="post">

                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
                    <%--<% if (errors.containsKey("username")) {%>--%>
                    <%--<p class="text-danger"><%= errors.get("username")%>--%>
                    <%--</p>--%>
                    <%--<%}%>--%>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password"
                           name="password">
                    <%--<% if (errors.containsKey("password")) {%>--%>
                    <%--<p class="text-danger"><%= errors.get("password")%>--%>
                    <%--</p>--%>
                    <%--<%}%>--%>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
