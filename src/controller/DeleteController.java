package controller;

import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idFromReq = req.getParameter("id");
        if (idFromReq != null) {
            int id = Integer.parseInt(idFromReq);
            new FeedbackModel().deleteFeedback(id);

            resp.sendRedirect("/admin");
        }
    }
}
