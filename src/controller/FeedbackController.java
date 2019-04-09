package controller;

import entity.Feedback;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FeedbackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int status = (int) req.getSession().getAttribute("loginId");
        if (status == 2){
            req.getRequestDispatcher("FormFeedback.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("loginUser");
        String content = req.getParameter("content");
        int status = (int) req.getSession().getAttribute("loginId");
        if (status == 2){
            Feedback feedback = new Feedback(username,content);
            if (!feedback.isValid()){
                HashMap<String, ArrayList<String>> errors = feedback.getErrors();
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("FormFeedback.jsp").forward(req,resp);
                return;
            }
            FeedbackModel feedbackModel = new FeedbackModel();
            feedbackModel.insert(feedback);
            resp.sendRedirect("/home");
        }else {
            resp.sendRedirect("/login");
        }
    }
}
