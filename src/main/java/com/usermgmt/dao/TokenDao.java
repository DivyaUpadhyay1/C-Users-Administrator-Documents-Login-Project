package com.usermgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.usermgmt.modal.Token;

public class TokenDao {
    public static boolean saveToken(Token token) {
        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user_token(email, token) VALUES (?, ?)");
            ps.setString(1, token.getEmail());
            ps.setString(2, token.getToken());
           // ps.setTimestamp(3, new java.sql.Timestamp(token.getExpirationDate().getTime()));
           
            int status = ps.executeUpdate();
            con.close();
            return status > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Token getToken(String email, String token) {
        Token tokenObject = null;
        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user_token WHERE email = ? AND token = ?");
            ps.setString(1, email);
            ps.setString(2, token);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String userEmail = rs.getString("email");
                String tokenValue = rs.getString("token");
                
                tokenObject = new Token(userEmail, tokenValue);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tokenObject;
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

