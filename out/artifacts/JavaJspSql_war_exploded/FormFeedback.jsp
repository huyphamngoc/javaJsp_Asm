<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Feedback" %>
<%@ page import="entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/8/2019
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
//    Feedback account = (Account) request.getAttribute("account");
//
//    if (account == null) {
//        account = new Account();
//    }
%>
<html>
<head>
    <title>Feedback</title>
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
            <form action="/feedback" method="post">

                <div class="form-group">
                    <label for="content">Content:</label>
                    <input type="text" class="form-control" name="content" id="content">
                    <% if (errors.containsKey("content")) {%>
                        <p class="text-danger"><%= errors.get("content")%>
                    </p>
                    <%}%>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
