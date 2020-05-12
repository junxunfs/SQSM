package com.sqsm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sqsm.entity.Users;
import com.sqsm.util.DBUtil;

public class UserDao {
	private String QUERY_USER_BY_NAME_AND_PASS="select * "
			+ "from Users where username=? and password=?";
	private String INSERT_USER="insert into Users(UserID,UserName,Password,Role)"
			+ " values(SEQ_USERS_ID.nextval,?,?,2)";
	private String UPDATE_PSW="update Users set password=? where username=?";
	private String QUERY_UPLOAD_USER_BY_NAME="select username,password,realname,sex,age,message"
			+ " from Users"
			+ " where username =?";
	private String UPDATE_USER_MESSAGE="update Users set realname=?,sex=?,age=?,message=? where username=?";
	
	
	private static UserDao userDao = new UserDao();
	
	public static UserDao getInstance(){
		return userDao;
	}
	
	public Users queryUserByNameAndPassword(String username,String password) {
		Users user = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pres = null;
		ResultSet rs= null;
		try{
		
			pres = conn.prepareStatement(QUERY_USER_BY_NAME_AND_PASS);
			pres.setString(1, username);
			pres.setString(2, password);
			
			rs = pres.executeQuery();
			
			if(rs.next()){
				user=new Users();
				user.setUserID(rs.getInt("UserID"));
				user.setUsername(rs.getString("UserName"));
				user.setPassword(rs.getString("Password"));			
				user.setRole(rs.getInt("Role"));
				user.setAge(rs.getInt("age"));
				user.setLike_food(rs.getString("like_food"));
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getString("sex"));
				user.setMessage(rs.getString("message"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		return user;
		
	}

	public int insertUser(Users user,Connection conn) {
		PreparedStatement pres = null;
		int rows = 0;
		try{
			
			conn= DBUtil.getConnection();
			pres=conn.prepareStatement(INSERT_USER);
			
			pres.setString(1, user.getUsername());
			pres.setString(2, user.getPassword());
			
			rows=pres.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				pres.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rows;
		
	}

	public int querryName(String userName, Connection conn) {
		int row=0;
		PreparedStatement pres = null;
		ResultSet rs= null;
		try{
			pres = conn.prepareStatement("select * from Users where username=?");
			pres.setString(1, userName);
			rs = pres.executeQuery();
			if(rs.next()){
				row=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return row;
	}

	public int addUser(Users user) {
		Connection conn=null;
		PreparedStatement pres = null;
		int rows = 0;
		try{	
			conn= DBUtil.getConnection();
			pres=conn.prepareStatement(INSERT_USER);
			pres.setString(1, user.getUsername());
			pres.setString(2, user.getPassword());
			rows=pres.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				pres.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	public int queryUserByName(String username) {
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs= null;
		try{
			conn= DBUtil.getConnection();
			pres = conn.prepareStatement("select * from Users where username=?");
			pres.setString(1, username);
			rs = pres.executeQuery();
			if(rs.next()){
				return 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return 0;
	}
	
	public Users queryUserByName2(String username) {
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs= null;
		Users user= null;
		try{
			conn= DBUtil.getConnection();
			pres = conn.prepareStatement("select * from Users where username=?");
			pres.setString(1, username);
			rs = pres.executeQuery();
			if(rs.next()){
				user= new Users();
				user.setUsername(username);
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setMessage(rs.getString("message"));
				user.setLike_food(rs.getString("like_food"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return user;
	}

	public int updatePsw(Users user) {
		Connection conn = null;
		PreparedStatement pres=null;
		int result=0;
		try {
			conn= DBUtil.getConnection();
			pres=conn.prepareStatement(UPDATE_PSW);
			pres.setString(1, user.getPassword());
			pres.setString(2, user.getUsername());
			result = pres.executeUpdate();
			if(result>0){
				return 1;
			}
			else return 0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public Users queryUploadUserByName(String username) {
		Users upload_User = null;
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs= null;
		try{
			conn=DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_UPLOAD_USER_BY_NAME);
			pres.setString(1, username);
			rs = pres.executeQuery();
			if(rs.next()){
				upload_User=new Users();
				upload_User.setUsername(rs.getString("username"));
				upload_User.setPassword(rs.getString("password"));	
				upload_User.setRealname(rs.getString("RealName"));
				upload_User.setSex(rs.getString("sex"));
				upload_User.setAge(rs.getInt("age"));
				upload_User.setMessage(rs.getString("message"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return upload_User;
	}

	public int updateUserMess(String username,Users uu) {
		Connection conn = null;
		PreparedStatement pres=null;
		int result=0;
		try {
			conn= DBUtil.getConnection();
			pres=conn.prepareStatement(UPDATE_USER_MESSAGE);
			pres.setString(1, uu.getRealname());
			pres.setString(2, uu.getSex());
			pres.setInt(3, uu.getAge());
			pres.setString(4, uu.getMessage());
			pres.setString(5, username);
			result = pres.executeUpdate();
			if(result>0){
				return 1;
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return 0;
	}

	public List<Users> queryAllUsers() {
		List<Users> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		
		try {
			conn=DBUtil.getConnection();
			pres=conn.prepareStatement("select * from Users");
			rs=pres.executeQuery();
			while(rs.next()){
				Users user= new Users();
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getInt("role"));
				user.setRealname(rs.getString("realname"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setLike_food(rs.getString("like_food"));
				user.setMessage(rs.getString("message"));
				users.add(user);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	public String QueryLikeFoodByUsers(String username) {
		String like_foods = "";
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try {
			conn=DBUtil.getConnection();
			pres=conn.prepareStatement("select like_food from Users where username=?");
			pres.setString(1, username);
			rs=pres.executeQuery();
			if(rs.next()){
				Users user= new Users();
				user.setUsername(username);
				user.setLike_food(rs.getString("like_food"));
				like_foods=user.getLike_food();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}
		
		return like_foods;
	}


}
