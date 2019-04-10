<%@ page import="entity.Feedback" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.FeedbackModel" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/8/2019
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    FeedbackModel feedbackModel = new FeedbackModel();
    ArrayList<Feedback> feedbacks1 = (ArrayList<Feedback>) feedbackModel.selectFeedbackHome();
    if (feedbacks1 == null){
        feedbacks1 = new ArrayList<>();
    }
%>
<html>
  <head>
    <title>Homepage</title>
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
                <h3 class="text-center">Feedback System</h3>
            </div>
            <div class="col-md-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Username</th>
                        <th>Content</th>
                    </tr>
                    </thead>
                    <tbody>

                    <%if (feedbacks1.size() > 0 ){
                        for ( Feedback feedbacks : feedbacks1  ) {
                    %>
                    <tr>
                        <td><%=feedbacks.getUserName()%></td>
                        <td><%=feedbacks.getConTent()%></td>
                    </tr>
                    <%
                        }
                    }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

  </body>
</html>
