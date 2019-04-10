package controller;

import entity.Feedback;
import model.ConnectSql;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int status = (int) req.getSession().getAttribute("loginId");
        if (status == 1){
            FeedbackModel feedbackModel = new FeedbackModel();
            req.setAttribute("listFeedback", feedbackModel.selectFeedbackAdmin());
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
