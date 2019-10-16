package com_game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public static boolean save(User user){

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "123456");
			
			String sql = "insert into user values(?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getTruecount());
			preparedStatement.setInt(3, user.getScore());
//			preparedStatement.setInt(4, user.getTime());
			int count = preparedStatement.executeUpdate();
			
			if(count > 0){
				return true;
			}else {
				return false;
			}			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try{
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static List<User> query(){
		List<User> users = new ArrayList<>();
		User user = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "123456");
			String sql = "select * from user";
			pstmt = connection.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				String name = rst.getString("name");
				int truecount = rst.getInt("truecount");
				int score = rst.getInt("score");
				user = new User(name, truecount, score);
				users.add(user);
			}
			return users;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			try{
				if(rst != null)  rst.close();
				if(pstmt != null)  pstmt.close();
				if(connection != null)  connection.close();
			}catch ( SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
