package com.sqsm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqsm.dao.UserDao;
import com.sqsm.entity.Users;
import com.sqsm.util.DBUtil;

public class UserService {
	
	private static UserService userService= new UserService();
	
	public static UserService getInstance(){
		return userService;
	}

	
	public Users queryUserByNameAndPassword(String username,String password) {
		UserDao userDao =UserDao.getInstance();
		Users user = new Users();
		user = userDao.queryUserByNameAndPassword(username, password);
		
		return user;
	}
	
	public static int register(Users user){
		int result=0;
		UserDao uDao=UserDao.getInstance();
		Connection conn = DBUtil.getConnection_transaction();
		try {
			
			if(uDao.querryName(user.getUsername(),conn)>0){
				result=1;
			}else{
				int row =uDao.insertUser(user,conn);
				if(row>0){
					conn.commit();
					result=2;
				}
			}
			
		}catch (SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();	
		}	
		return result;
	}


	public int addUser(Users user) {
		int result=0;
		UserDao uDao=UserDao.getInstance();
		result= uDao.addUser(user);
		return result;
	}


	public int queryUserByName(String username) {
		UserDao uDao = UserDao.getInstance();
		
		return uDao.queryUserByName(username);
	}

	public Users queryUserByName2(String username) {
		UserDao uDao = UserDao.getInstance();
		
		return uDao.queryUserByName2(username);
	}

	public int updatePsw(Users user) {
		int result=0;
		UserDao uDao=UserDao.getInstance();
		result= uDao.updatePsw(user);
		return result;
	}


	public Users queryUploadUserByName(String username) {
		UserDao userDao =UserDao.getInstance();
		Users upload_user= userDao.queryUploadUserByName(username);
		return upload_user;
	}


	public int updateUserMess(String username,Users uu) {
		int result=0;
		UserDao uDao=UserDao.getInstance();
		result= uDao.updateUserMess(username,uu);
		return result;
	}


	public List<Users> queryAllUsers() {
		List<Users> users = UserDao.getInstance().queryAllUsers();
		return users;
	}


	public String QueryLikeFoodByUsers(String username) {
		String like_foods = UserDao.getInstance().QueryLikeFoodByUsers(username);
		return like_foods;
	}
	

}
