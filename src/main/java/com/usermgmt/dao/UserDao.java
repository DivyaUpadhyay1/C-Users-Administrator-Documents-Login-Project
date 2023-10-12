package com.usermgmt.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.usermgmt.modal.User;

public class UserDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Crududb", "crud", "crud");
			System.out.println("cdfagh");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static boolean isCheckLoginUser(User e) {
		boolean isValid = false;

		try {
			Connection con = UserDao.getConnection();

			PreparedStatement ps = con.prepareStatement("select name from userdetail where name=? and password=?");
			
			String password=e.getPassword();
	    	 String encrptedpassword = null;
			
				encrptedpassword = UserDao.generateString(password);

			ps.setString(1, e.getName());
			ps.setString(2, encrptedpassword);

			ResultSet result = ps.executeQuery();

			if (result.next()) {
				System.out.println("** username "+result.getString("name"));
				isValid = true;
			}
			result.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return isValid;
	}
	public static boolean CheckLoginUser(User e) {
	    boolean isValid = false;

	    try {
	        Connection con = UserDao.getConnection();

	        PreparedStatement ps = con.prepareStatement("select password from userdetail where name=?");
	        ps.setString(1, e.getName());

	        ResultSet result = ps.executeQuery();

	        if (result.next()) {
	            String storedPassword = result.getString("password");
	            String enteredPassword = e.getPassword();
	            
	            // Encrypt the entered password for comparison
	            String encryptedEnteredPassword = UserDao.generateString(enteredPassword);
	            
	            // Compare the stored password with the entered password
	            if (storedPassword.equals(encryptedEnteredPassword)) {
	                isValid = true;
	            }
	        }

	        result.close();
	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return isValid;
	}

	    public static int updatePasswordByUsername(User user) {
	        int status = 0;
	        try {
	            Connection con = UserDao.getConnection();
	            PreparedStatement ps = con.prepareStatement("UPDATE userdetail SET password=? WHERE name=?");
	            
	            String newPassword = user.getPassword();
	            String encryptedPassword = UserDao.generateString(newPassword);

	            ps.setString(1, encryptedPassword);
	            ps.setString(2, user.getName());

	            status = ps.executeUpdate();
	            con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return status;
	    }

	    

	
	public static int updatePasswordByEmail(User e) {
	    int status = 0;
	    try {
	        Connection con = UserDao.getConnection();
	        PreparedStatement ps = con.prepareStatement("update userdetail set password=? where email=?");
	        String password=e.getPassword();
	    	 String encrptedpassword = null;
			
				encrptedpassword = UserDao.generateString(password);
	        ps.setString(1, encrptedpassword);
	        ps.setString(2, e.getEmail());
	        status = ps.executeUpdate();
	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return status;
	}

	public static int updatePasswordByName(User e) {
	    int status = 0;
	    try {
	        Connection con = UserDao.getConnection();
	        PreparedStatement ps = con.prepareStatement("update userdetail set password=? where name=?");
	        String password=e.getPassword();
	    	 String encrptedpassword = null;
			
				encrptedpassword = UserDao.generateString(password);
	        ps.setString(1, encrptedpassword);
	        ps.setString(2, e.getName());
	        status = ps.executeUpdate();
	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return status;
	}
	 public static boolean isUserExists(User e) {
	        boolean userExists = false;
	        try {
	            Connection con = getConnection();

	            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM userdetail WHERE email = ?");
	            ps.setString(1, e.getEmail());

	            ResultSet result = ps.executeQuery();
	            if (result.next() && result.getInt(1) > 0) {
	                userExists = true;
	            }

	            result.close();
	            con.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return userExists;
	    }
	


	public static int save(User e) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO userdetail(name,password,email,country) values (?,?,?,?)");
			 String password=e.getPassword();
	    	 String encrptedpassword = null;
			
				encrptedpassword = UserDao.generateString(password);
			
			
			ps.setString(1, e.getName());
			ps.setString(2, encrptedpassword);
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(User e) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update userdetail set name=?,password=?,email=?,country=? where id=?");
			
			String password=e.getPassword();
	    	 String encrptedpassword = null;
			
				encrptedpassword = UserDao.generateString(password);
			ps.setString(1, e.getName());
			ps.setString(2, encrptedpassword);
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from userdetail where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static User getEmployeeById(int id) {
		User e = new User();

		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from userdetail where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
		
		public static String generateString(String password)throws NoSuchAlgorithmException {
			
			
			String encryptedpassword =null;
			try   
	        {  
			 MessageDigest m = MessageDigest.getInstance("MD5");  
             
	           
	            m.update(password.getBytes());  
	              
	             
	            byte[] bytes = m.digest();  
	              
	             
	            StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	              
	            
	            encryptedpassword = s.toString(); 
	            System.out.println("Plain-text password: " + password); 
	          
	        }   
	        catch (NoSuchAlgorithmException e)   
	        {  
	            e.printStackTrace();  
	        }  
			
			return encryptedpassword;
		
		
			
			
		}
	
		
//	public static List<User> getAllEmployees() {
//		List<User> list = new ArrayList<User>();
//
//		try {
//			Connection con = UserDao.getConnection();
//			PreparedStatement ps = con.prepareStatement("select * from userdetail");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				User e = new User();
//				e.setId(rs.getInt(1));
//				e.setName(rs.getString(2));
//				e.setPassword(rs.getString(3));
//				e.setEmail(rs.getString(4));
//				e.setCountry(rs.getString(5));
//				list.add(e);
//			}
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
//	}
	
	

	    public static List<User> getEmployeesByPage(int page, int pageSize) {
	        List<User> list = new ArrayList<User>();
	        try {
	            Connection con = getConnection();
	            // Calculate the starting row for the given page
	            int startRow = (page - 1) * pageSize;

	            PreparedStatement ps = con.prepareStatement("SELECT * FROM userdetail LIMIT ? OFFSET ?");
	            ps.setInt(1, pageSize);
	            ps.setInt(2, startRow);

	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                User e = new User();
	                e.setId(rs.getInt(1));
	                e.setName(rs.getString(2));
	                e.setPassword(rs.getString(3));
	                e.setEmail(rs.getString(4));
	                e.setCountry(rs.getString(5));
	                list.add(e);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    public static int getTotalEmployees() {
	        int total = 0;
	        try {
	            Connection con = getConnection();
	            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM userdetail");
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                total = rs.getInt(1);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return total;
	    }
	}


