<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/8/2019
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Account account = (Account) request.getAttribute("account");

    if (account == null) {
        account = new Account();
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
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
            <h3>Register Account</h3>
            <form action="/account" method="post">
                <div class="form-group">
                    <label for="fullname">Fullname:</label>
                    <input type="text" class="form-control" id="fullname" placeholder="Enter fullname" name="fullname">
                    <% if (errors.containsKey("fullname")) {%>
                    <p class="text-danger"><%= errors.get("fullname")%>
                    </p>
                    <%}%>
                </div>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
                    <% if (errors.containsKey("username")) {%>
                    <p class="text-danger"><%= errors.get("username")%>
                    </p>
                    <%}%>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password"
                           name="password">
                    <% if (errors.containsKey("password")) {%>
                    <p class="text-danger"><%= errors.get("password")%>
                    </p>
                    <%}%>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" name="status" class="form-check-input" value="1">Admin
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" name="status" class="form-check-input" value="2">Member
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<%--<span>--%>
<%--<% if (errors.containsKey("username")) {--%>
<%--ArrayList<String> userError = errors.get("username");--%>
<%--for (String error : userError) {--%>
<%--%>--%>
<%--<span><%= error %> </span>--%>
<%--<%--%>
<%--}--%>
<%--}--%>
<%--%>--%>

<%--<% if (errors.containsKey("fullname")) {--%>
<%--ArrayList<String> userError = errors.get("fullname");--%>
<%--for (String error : userError) {--%>
<%--%>--%>
<%--<span><%= error %> </span>--%>
<%--<%--%>
<%--}--%>
<%--}--%>
<%--%>--%>
<%--<% if (errors.containsKey("password")) {--%>
<%--ArrayList<String> userError = errors.get("password");--%>
<%--for (String error : userError) {--%>
<%--%>--%>
<%--<span><%= error %> </span>--%>
<%--<%--%>
<%--}--%>
<%--}--%>
<%--%>--%>
<%--</span>--%>