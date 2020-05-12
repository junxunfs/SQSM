package com.sqsm.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sqsm.dao.FoodDao;
import com.sqsm.dao.UserDao;
import com.sqsm.entity.Food;
import com.sqsm.util.DBUtil;

public class FoodService {
	
	private static FoodService foodService=new FoodService() ;
	
	public static FoodService getInstance() {
		return foodService;
	}

	public List<Food> queryAllFoods() {
		List<Food> foods = FoodDao.getInstance().queryAllFoods();		
		return foods;
	}
	public List<Food> queryAllFoods2() {
		List<Food> foods = FoodDao.getInstance().queryAllFoods2();		
		return foods;
	}

	public List<Food> queryAllFoods_hot() {
		List<Food> foods_hot = FoodDao.getInstance().queryAllFoods_hot();	
		return foods_hot;
	}
	
	public List<Food> queryAllFoods_good() {
		List<Food> foods_good = FoodDao.getInstance().queryAllFoods_good();	
		return foods_good;
	}

	public Food getFoodByName(String foodname) {
		Food food = FoodDao.getInstance().getFoodByName(foodname);
		return food;
	}

	public List<Food> queryOneFood(String foodname) {
		List<Food> food = FoodDao.getInstance().queryOneFood(foodname);
		return food;
	}

	public List<Food> queryFoodOfRank(String sort) {
		List<Food> food = FoodDao.getInstance().queryFoodOfRank(sort);
		return food;
	}

	public List<Food> getFoodsBySort(String sort) {
		List<Food> food = FoodDao.getInstance().getFoodsBySort(sort);
		return food;
	}

	public List<Food> queryFoodTuijian(String sort) {
		List<Food> food = FoodDao.getInstance().queryFoodTuijian(sort);
		return food;
	}

	public int AddFood(Food food) {
		int result = FoodDao.getInstance().AddFood(food);
		return result;
	}

	public int getFoodInLikefood(String foodname,String username) {
		int result = FoodDao.getInstance().getFoodInLikefood(foodname,username);
		return result;
	}

	public int UpdateLikeFood(String foodname,String username) {
		int result = FoodDao.getInstance().UpdateLikeFood(foodname,username);
		return result;
	}

	public List<String> QueryFoodByUsers(String username) {
		List<String> foodnames = FoodDao.getInstance().QueryFoodByUsers(username);
		return foodnames;
	}

	public int deleteSortByUser(String username, String new_like) {
		int result = FoodDao.getInstance().deleteSortByUser(username,new_like);
		return result;
	}

	public List<Food> queryFoodsOrderByUser() {
		List<Food> food = FoodDao.getInstance().queryFoodsOrderByUser();
		return food;
	}
	
	/**
	 * 批量删除的方法
	 * @param ids
	 * @return
	 */
	public boolean deleteFood(String[] ids)
	{
		boolean tmp=false;
		Connection conn=DBUtil.getConnection_transaction();
		FoodDao dao=FoodDao.getInstance();
		try {
			int rows=0;
			for(int i=0;i<ids.length;i++)
			{
				rows+=dao.deleteFood(ids[i], conn);
			}
			if(rows==ids.length)
			{
				conn.commit();
				tmp=true;
			}else
			{
				conn.rollback();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, null, null);
		}
		return tmp;
	}

	public int UpdateFoodByName(Food food, String foodname) {
		int result = FoodDao.getInstance().UpdateFoodByName(food,foodname);
		return result;
	}

	
}
