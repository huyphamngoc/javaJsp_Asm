package model;

import entity.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {

    public Account login(String username, String password){
        Connection connection;
        ConnectSql connectSql = new ConnectSql();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectSql.URL  ,connectSql.USER,connectSql.PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Account WHERE username = ? AND  password = ?"
            );
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String exitusername =  rs.getString("username");
                String exitpassword =  rs.getString("password");
                String exitfullname = rs.getString("fullname");
                int status = rs.getInt("status");
                Account user = new Account(exitusername,exitpassword,exitfullname,status);
                return user;
            }
        }catch (Exception e){
            System.out.println("SQL" + e.getMessage());
        }
        return null;
    }
}
