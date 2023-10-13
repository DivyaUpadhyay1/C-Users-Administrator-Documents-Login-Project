// TokenDao.java
package com.usermgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.usermgmt.modal.Token;
import com.usermgmt.modal.User;

public class TokenDao {
    public static boolean saveToken(Token token) {
        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user_token(email, token) VALUES (?, ?)");
            ps.setString(1, token.getEmail());
            ps.setString(2, token.getToken());
            int status = ps.executeUpdate();
            con.close();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
//        public static boolean getToken(Token t) {
//        	boolean token = false;
//            try {
//                Connection con = UserDao.getConnection();
//                PreparedStatement ps = con.prepareStatement("SELECT token FROM user_token WHERE email = ?");
//                ps.setString(1, t.getEmail());
//                ResultSet rs = ps.executeQuery();
//
////                if (rs.next()) {
////                    String userEmail = rs.getString("email");
////                    String userToken = rs.getString("token");
//                   
//                token=true;
//                rs.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return token;
//        }
    
  public static boolean getToken(String email, String token) {
	boolean result = false;
	System.out.println("email value "+email);
    try {
        Connection con = UserDao.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM user_token WHERE email = ? and token=?");
        ps.setString(1, email);
        ps.setString(2, token);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
//            String userEmail = rs.getString("email");
//            String userToken = rs.getString("token");
//           
        result=true;
        rs.close();
        con.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}
        

    public static boolean deleteToken(String email, String token) {
        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM user_token WHERE email = ? AND token = ?");
            ps.setString(1, email);
            ps.setString(2, token);
            int status = ps.executeUpdate();
            con.close();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
