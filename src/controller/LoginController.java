package controller;

import entity.Account;
import model.AccountModel;
import model.LoginModel;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class LoginController extends HttpServlet {
    LoginModel loginModel = new LoginModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        AccountModel accountModel = new AccountModel();
        String username = req.getParameter("username");
//        String password = accountModel.md5(req.getParameter("password"));
        String password = req.getParameter("password");
        Account account = checkLogin(username,password);
        if (account != null){
            HttpSession session = req.getSession();
            session.setAttribute("loginId",account.getStatus());
            session.setAttribute("loginUser", account.getUserName());
            if (account.getStatus() == 1){
                resp.sendRedirect("/admin");
            }else if (account.getStatus() == 2){
                resp.sendRedirect("/home");
            }
        }else {
            resp.getWriter().println("Sai thông tin tài khoản.");
        }
    }

    private Account checkLogin(String username, String password) {
        Account user = loginModel.login(username,password);
        if (user != null) {
            return user;
        }
        return null;
    }
}
