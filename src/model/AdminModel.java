package model;

import entity.Feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminModel {
//    public ArrayList<Feedback> selectFeedback(){
//        Connection connection;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/java-asm"  ,"huyngocpham","123");
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Feedback");
//            ResultSet rs = preparedStatement.executeQuery();
//            ArrayList<Feedback> listFeedback = new ArrayList<>();
//
//            while (rs.next()){
//                Feedback feedback = new Feedback();
//                feedback.setConTent(rs.getString("content"));
//                feedback.setStatus(rs.getInt("status"));
//                feedback.setUserName(rs.getString("username"));
//                listFeedback.add(feedback);
//                return listFeedback;
//            }
//        }catch (Exception e){
//            System.out.println("SQL select "+ e );
//        }
//        return null;
//    }


}
