package model;

import entity.Feedback;

import java.sql.*;
import java.util.ArrayList;

public class FeedbackModel {

    private static Connection connection;
    static {
        try {
            ConnectSql connectSql = new ConnectSql();
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection(connectSql.URL  ,connectSql.USER,connectSql.PASS);
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean insert(Feedback feedback){

        try {
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

    public ArrayList<Feedback> selectFeedbackAdmin(){

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Feedback WHERE status =2");

            ResultSet rs = preparedStatement.executeQuery();

            ArrayList<Feedback> listFeedback = new ArrayList<Feedback>();

            while (rs.next()){
                int id = rs.getInt(1);
                int status1 = rs.getInt(4);
                String content = rs.getString(3);
                String username =  rs.getString(2);
                Feedback fb = new Feedback(username,content,status1,id);
                listFeedback.add(fb);
            }
            return listFeedback;

        }catch (Exception e){
            System.out.println("SQL select "+ e );
        }
        return null;
    }

    public ArrayList<Feedback> selectFeedbackHome(){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Feedback WHERE status =1");
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Feedback> listFeedback = new ArrayList<Feedback>();

            while (rs.next()){
                int status1 = rs.getInt(4);
                String content = rs.getString(3);
                String username =  rs.getString(2);
                Feedback fb = new Feedback(content,status1,username);
                listFeedback.add(fb);
            }
            return listFeedback;

        }catch (Exception e){
            System.out.println("SQL select "+ e );
        }
        return null;
    }

    public Feedback deleteFeedback(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FeedBack WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Delete Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
