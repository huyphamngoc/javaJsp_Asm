package controller;

import entity.Account;
import model.AccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int status = Integer.parseInt(req.getParameter("status"));

        Account account = new Account(fullname,username,password,status);
        if (!account.isValid()){
            HashMap<String, ArrayList<String>> errors = account.getErrors();
            req.setAttribute("account",account);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        AccountModel accountModel = new AccountModel();
        accountModel.insert(account);
        resp.sendRedirect("/home");
    }
}
