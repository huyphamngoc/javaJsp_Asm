package model;

import entity.Account;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountModel {

    public boolean insert(Account account){
        Connection connection;
        ConnectSql connectSql = new ConnectSql();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectSql.URL  ,connectSql.USER,connectSql.PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into account (fullname,username,password,status) value (?,?,?,?)");
            preparedStatement.setString(1, account.getFullName());
            preparedStatement.setString(2, account.getUserName());
//            preparedStatement.setString(3, md5(account.getPassWord()));
            preparedStatement.setString(3, account.getPassWord());
            preparedStatement.setInt(4, account.getStatus());
            preparedStatement.execute();
            System.out.println("success Usermodel" );
            return true;
        }catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String md5(String str){
        MessageDigest md;
        String result = "";
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            BigInteger bi = new BigInteger(1, md.digest());

            result = bi.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}
