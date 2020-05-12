package com.sqsm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sqsm.entity.Food;
import com.sqsm.entity.Users;
import com.sqsm.util.DBUtil;

public class FoodDao {

	private static final String QUERY_FOOD_BY_SORT = null;
	private static FoodDao foodDao = new FoodDao();
	public static FoodDao getInstance() {
		return foodDao;
	}
	
	private String QUERY_ALL_FOOD="select * from food_new where sort='人气菜谱'";
	private String QUERY_ALL_FOOD2="select * from food_new ";
	private String QUERY_FOOD_HOT="select foodname,foodimg from food_hot where id<9";
	private String QUERY_FOOD_GOOD="select foodname,foodimg,time from food_good";
	private String QUERY_FOOD_ONE_BY_NAME="select foodname,foodimg,time,material1,material2,material3"
			+ ",material4,material5,step1,step2,step3,step4,step5,sort,hot_degree,upload_user "
			+ "from food_new "
			+ "where foodname like ?";
	private String QUERY_ONE_FOOD="select id,foodname,foodimg,changetoa,time,sort from food_new where foodname like ?";
	private String QUERY_FOOD_STEAM="select foodname,foodimg,changetoa,time,sort,hot_degree,upload_user "
			+ "from food_new where sort = ?"
			+ " order by hot_degree DESC";
	private String QUERY_FOOD_BY_SORT2="select foodname,foodimg,changetoa,time,sort,hot_degree,upload_user "
			+ "from food_new where sort like ?";
	private String QUERY_FOOD_TJ="select * from food_new where sort =? and rownum<=3 order by hot_degree";
	private String ADD_FOOD = "insert into "
			+ "food_new (foodname,sort,material1,material2,material3,material4,material5,step1,step2,step3,step4,step5,time) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String QUERY_FOOD_IN_LIKEFOOD="select like_food from Users where username = ? and like_food like ?";
	private String ADD_SORT="update Users set like_food =? where username= ? ";
	private String QUERY_FOODSORT_IN_LIKEFOOD="select like_food from Users where username = ?";
	private String QUERY_FOOD_BY_USERNAME="select foodname from food_new where upload_user=?";
	private String UPDATE_LIKE_FOOD="update Users set like_food=? where username=? ";
	private String QUERY_FOOD_ORDER_BY_USER="select id,foodname,upload_user,sort,hot_degree from food_new order by upload_user";
	private String UPDATE_FOOD="update "
			+ "food_new set sort=?,material1=?,material2=?,material3=?,material4=?,material5=?,"
			+ "step1=?,step2=?,step3=?,step4=?,step5=?,time=? "
			+ "where foodname =? ";
	
	public List<Food> queryAllFoods2() {
		List<Food> foods = new ArrayList<>();
		Food food =null;
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_ALL_FOOD2);
			rs = pres.executeQuery();
			while(rs.next()){
				food = new Food();
				food.setId(rs.getInt("id"));
				food.setFoodName(rs.getString("foodname"));
				food.setFoodImg(rs.getString("foodimg"));
				food.setChangeToA(rs.getString("changetoa"));
				food.setTime(rs.getString("time"));
				food.setMaterial1(rs.getString("material1"));
				food.setMaterial2(rs.getString("material2"));
				food.setMaterial3(rs.getString("material3"));
				food.setMaterial4(rs.getString("material4"));
				food.setMaterial5(rs.getString("material5"));
				food.setStep1(rs.getString("step1"));
				food.setStep2(rs.getString("step2"));
				food.setStep3(rs.getString("step3"));
				food.setStep4(rs.getString("step4"));
				food.setStep5(rs.getString("step5"));
				food.setSort(rs.getString("sort"));
				food.setHot_degree(rs.getString("hot_degree"));
				food.setUpload_user(rs.getString("upload_user"));
				foods.add(food);
			}
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		return foods;
	}
	
	public List<Food> queryAllFoods() {
		List<Food> foods = new ArrayList<>();
		Food food =null;
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_ALL_FOOD);
			rs = pres.executeQuery();
			while(rs.next()){
				food = new Food();
				food.setId(rs.getInt("id"));
				food.setFoodName(rs.getString("foodname"));
				food.setFoodImg(rs.getString("foodimg"));
				food.setChangeToA(rs.getString("changetoa"));
				food.setTime(rs.getString("time"));
				foods.add(food);
			}
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		return foods;
	}
	
	public List<Food> queryAllFoods_hot() {
		List<Food> foods_hot= new ArrayList<>();
		Food food =null;
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_HOT);
			rs = pres.executeQuery();
			while(rs.next()){
				food = new Food();
				food.setFoodName(rs.getString("foodname"));
				food.setFoodImg(rs.getString("foodimg"));
				foods_hot.add(food);
			}
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		return foods_hot;
	}
	public List<Food> queryAllFoods_good() {
		List<Food> foods_good= new ArrayList<>();
		Food food =null;
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_GOOD);
			rs = pres.executeQuery();
			while(rs.next()){
				food = new Food();
				food.setFoodName(rs.getString("foodname"));
				food.setFoodImg(rs.getString("foodimg"));
				food.setTime(rs.getString("time"));
				
				foods_good.add(food);
			}
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		return foods_good;
	}

	public Food getFoodByName(String foodname) {
		Food food_one= new Food();
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_ONE_BY_NAME);
			pres.setString(1,foodname);
			rs = pres.executeQuery();
			
			if(rs.next()){
				food_one.setFoodName(rs.getString("foodName"));
				food_one.setFoodImg(rs.getString("foodImg"));
				food_one.setTime(rs.getString("time"));
				food_one.setMaterial1(rs.getString("material1"));
				food_one.setMaterial2(rs.getString("material2"));
				food_one.setMaterial3(rs.getString("material3"));
				food_one.setMaterial4(rs.getString("material4"));
				food_one.setMaterial5(rs.getString("material5"));
				food_one.setStep1(rs.getString("step1"));
				food_one.setStep2(rs.getString("step2"));
				food_one.setStep3(rs.getString("step3"));
				food_one.setStep4(rs.getString("step4"));
				food_one.setStep5(rs.getString("step5"));
				food_one.setSort(rs.getString("sort"));
				food_one.setHot_degree(rs.getString("hot_degree"));
				food_one.setUpload_user(rs.getString("upload_user"));			
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		return food_one;
	}

	public List<Food> queryOneFood(String foodname) {
		List<Food> food= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_ONE_FOOD);
			pres.setString(1,foodname);
			rs = pres.executeQuery();		
			while(rs.next()){
				Food food_one = new Food();
				food_one.setId(rs.getInt("id"));
				food_one.setFoodName(rs.getString("foodname"));
				food_one.setFoodImg(rs.getString("foodimg"));
				food_one.setChangeToA(rs.getString("changetoa"));
				food_one.setTime(rs.getString("time"));
				food.add(food_one);
			}		
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		
		return food;
	}

	public List<Food> queryFoodOfRank(String sort) {
		List<Food> foods= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_STEAM);
			pres.setString(1,sort);
			rs = pres.executeQuery();		
			while(rs.next()){
				Food food_one = new Food();		
				food_one.setFoodName(rs.getString("foodname"));
				food_one.setFoodImg(rs.getString("foodimg"));
				food_one.setChangeToA(rs.getString("changetoa"));
				food_one.setTime(rs.getString("time"));
				food_one.setHot_degree(rs.getString("hot_degree"));
				food_one.setUpload_user(rs.getString("upload_user"));
				foods.add(food_one);
			}		
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		
		return foods;
	}

	public List<Food> getFoodsBySort(String sort) {
		List<Food> foods= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		sort = "%"+sort+"%";
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_BY_SORT2);
			pres.setString(1,sort);
			rs = pres.executeQuery();		
			while(rs.next()){
				Food food_one = new Food();		
				food_one.setFoodName(rs.getString("foodname"));
				food_one.setFoodImg(rs.getString("foodimg"));
				food_one.setChangeToA(rs.getString("changetoa"));
				food_one.setTime(rs.getString("time"));
				food_one.setHot_degree(rs.getString("hot_degree"));
				food_one.setUpload_user(rs.getString("upload_user"));
				foods.add(food_one);
			}		
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		
		return foods;
	}

	public List<Food> queryFoodTuijian(String sort) {
		List<Food> foods= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_TJ);
			pres.setString(1,sort);
			rs = pres.executeQuery();		
			while(rs.next()){
				Food food_one = new Food();		
				food_one.setFoodName(rs.getString("foodname"));
				food_one.setFoodImg(rs.getString("foodimg"));
				food_one.setChangeToA(rs.getString("changetoa"));
				food_one.setTime(rs.getString("time"));
				foods.add(food_one);
			}		
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		
		return foods;
	}

	public int AddFood(Food food) {
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs= null;
		int result = 0;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(ADD_FOOD);
			pres.setString(1,food.getFoodName());
			pres.setString(2,food.getSort());
			pres.setString(3,food.getMaterial1());
			pres.setString(4,food.getMaterial2());
			pres.setString(5,food.getMaterial3());
			pres.setString(6,food.getMaterial4());
			pres.setString(7,food.getMaterial5());
			pres.setString(8,food.getStep1());
			pres.setString(9,food.getStep2());
			pres.setString(10,food.getStep3());
			pres.setString(11,food.getStep4());
			pres.setString(12,food.getStep5());
			pres.setString(13,food.getTime());
			result = pres.executeUpdate();
			if(result>0){
				return 1;
			}		
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public int getFoodInLikefood(String foodname2,String username) {
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs= null;
		int result = 0;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_IN_LIKEFOOD);
			pres.setString(1,username);
			pres.setString(2,foodname2);
			rs = pres.executeQuery();
			if(rs.next()){
				result=1;
			}		
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int UpdateLikeFood(String foodname,String username) {
		FoodDao foodDao = FoodDao.getInstance();
		String like_food = foodDao.getFoodSortInLikefood(username);
		String like_food2 = like_food+"、"+foodname;
		Connection conn = null;
		PreparedStatement pres = null;
	
		int result = 0;
	
		conn = DBUtil.getConnection();
		try {
			pres = conn.prepareStatement(ADD_SORT);
			pres.setString(1, like_food2);
			pres.setString(2,username);
			result = pres.executeUpdate();
			if(result>0){
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
						
	}

	public String getFoodSortInLikefood(String username) {
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs= null;
		String like_food="";
		
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOODSORT_IN_LIKEFOOD);
			pres.setString(1, username);
			
			rs = pres.executeQuery();
			if(rs.next()){
				Users user = new Users();
				user.setLike_food(rs.getString("like_food"));
				like_food=user.getLike_food();

			}		
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return like_food;
	}

	public List<String> QueryFoodByUsers(String username) {
		List<String> foodnames= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_BY_USERNAME);
			pres.setString(1,username);
			rs = pres.executeQuery();		
			while(rs.next()){
				String foodname = null;		
				foodname = rs.getString("foodname");
				foodnames.add(foodname);
			}		
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		
		return foodnames;
	}
	public int deleteSortByUser(String username,String new_likefood){
		Connection conn = null;
		PreparedStatement pres = null;
		int result = 0;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(UPDATE_LIKE_FOOD);
			pres.setString(1,new_likefood);
			pres.setString(2,username);
			result = pres.executeUpdate();
			if(result>0){
				return 1;
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<Food> queryFoodsOrderByUser() {
		List<Food> foods = new ArrayList<>();
		Food food =null;
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(QUERY_FOOD_ORDER_BY_USER);
			rs = pres.executeQuery();
			while(rs.next()){
				food = new Food();
				food.setId(rs.getInt("id"));
				food.setFoodName(rs.getString("foodname"));	
				food.setUpload_user(rs.getString("upload_user"));
				food.setSort(rs.getString("sort"));
				food.setHot_degree(rs.getString("hot_degree"));
				foods.add(food);
			}
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}	
		return foods;
	}

	/**
	 * 删除的方法
	 * @param id
	 * @param c
	 * @return
	 */
	public int deleteFood(String id,Connection c) {
		
		PreparedStatement stmt=null;
		int rows=0;
		try {
			stmt=c.prepareStatement("delete from food_new where foodname=?");
			stmt.setString(1,id);
			
			rows=stmt.executeUpdate();
		} catch (Exception e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return rows;
		
	}

	public int UpdateFoodByName(Food food, String foodname) {
		Connection conn = null;
		PreparedStatement pres = null;
		ResultSet rs= null;
		int result = 0;
		try{
			conn = DBUtil.getConnection();
			pres = conn.prepareStatement(UPDATE_FOOD);
			pres.setString(1,food.getSort());
			pres.setString(2,food.getMaterial1());
			pres.setString(3,food.getMaterial2());
			pres.setString(4,food.getMaterial3());
			pres.setString(5,food.getMaterial4());
			pres.setString(6,food.getMaterial5());
			pres.setString(7,food.getStep1());
			pres.setString(8,food.getStep2());
			pres.setString(9,food.getStep3());
			pres.setString(10,food.getStep4());
			pres.setString(11,food.getStep5());
			pres.setString(12,food.getTime());
			pres.setString(13,foodname);
			result = pres.executeUpdate();
			if(result>0){
				return 1;
			}		
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, pres, rs);
		}
		
		return 0;
	}

	
	
}
