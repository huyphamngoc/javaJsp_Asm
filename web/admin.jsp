<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Feedback" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/9/2019
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Feedback> feedbacks = (ArrayList<Feedback>) request.getAttribute("listFeedback");
%>

<html>
<head>
    <title>Admin</title>
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
            <div class="col-md-12">
                <h3>Admin</h3>
            </div>
            <div class="col-md-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Username</th>
                        <th>Content</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>

                        <%
                        Iterator it=feedbacks.iterator();
                        while(it.hasNext())
                        {
                            Feedback b=(Feedback) it.next();
                        %>
                        <tr>
                            <td><%=b.getUserName()%></td>
                            <td><%=b.getConTent()%></td>
                            <td><a href="/delete?id=<%=b.getId()%>">Delete</a></td>
                        </tr>
                        <%
                            }
                        %>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
