package controller;

import entity.Feedback;
import model.AdminModel;
import model.ConnectSql;

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
            Connection connection;
            ConnectSql connectSql = new ConnectSql();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection( connectSql.URL ,connectSql.USER,connectSql.PASS);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Feedback");
                ResultSet rs = preparedStatement.executeQuery();
                ArrayList<Feedback> listFeedback = new ArrayList<>();
                while (rs.next()){
                    Feedback feedback = new Feedback();
                    feedback.setConTent(rs.getString("content"));
                    feedback.setStatus(rs.getInt("status"));
                    feedback.setUserName(rs.getString("username"));
                    listFeedback.add(feedback);
                }
                req.setAttribute("listFeedback", listFeedback);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }catch (Exception e){
                System.out.println("SQL select "+ e );
            }

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

    private Feedback checkGetFeedback(){

        return null;
    }
}
