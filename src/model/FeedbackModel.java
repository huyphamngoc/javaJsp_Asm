package model;

import entity.Feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FeedbackModel {

    public boolean insert(Feedback feedback){
        Connection connection;
        ConnectSql connectSql = new ConnectSql();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectSql.URL  ,connectSql.USER,connectSql.PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into feedback (username,content,status) value (?,?,?)");
            preparedStatement.setString(1, feedback.getUserName());
            preparedStatement.setString(2, feedback.getConTent());
            preparedStatement.setInt(3, 2);
            preparedStatement.execute();
            System.out.println("success feedback" );
            return true;
        }catch (Exception e){
            System.out.println("SQL" + e.getMessage());
        }
        return false;
    }
}
