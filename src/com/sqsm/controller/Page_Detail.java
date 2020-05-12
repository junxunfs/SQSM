package com.sqsm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqsm.entity.Food;
import com.sqsm.entity.Users;
import com.sqsm.service.FoodService;
import com.sqsm.service.UserService;

/**
 * Servlet implementation class Page_Detail
 */
@WebServlet("/page_Detail")
public class Page_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operator = request.getParameter("operator");
		if("page".equals(operator)){
			page(request,response);	
		}
		else if("save".equals(operator)){
			save(request,response);	
		}
		else if("search01".equals(operator)){
			search01(request,response);	
		}
	}


	private void search01(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String foodname = request.getParameter("foodname01");
		request.setAttribute("foodname01", foodname);
		//System.out.println(foodname+"----");
		try {	
			
			//取到菜谱
			foodname = "%"+foodname+"%";
			Food food_one = new Food();
			FoodService foodService = FoodService.getInstance();
			food_one = foodService.getFoodByName(foodname);
			request.getSession().setAttribute("food_one", food_one);
			
			//推荐菜谱
			String sort = food_one.getSort();
			List<Food> food_tj=FoodService.getInstance().queryFoodTuijian(sort);
			request.getSession().setAttribute("food_tj", food_tj);
			
			//取到作者
			Food food_upload_user = (Food) request.getSession().getAttribute("food_one");
			
			String username =food_upload_user.getUpload_user();
			
			UserService userService = UserService.getInstance();
			Users upload_User =new Users();
			upload_User = userService.queryUploadUserByName(username);
			request.getSession().setAttribute("upload_User",upload_User);
			
			request.getRequestDispatcher("page_Detail.jsp").forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}


	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//检测是否已收藏
		String foodname = request.getParameter("foodname");
		String foodname2="%"+foodname+"%";
		Users user= (Users) request.getSession().getAttribute("user");
		if(user == null){
			response.getWriter().write("<script>alert('请先登录');window.location.href='Login.jsp';</script>");
			return ;
		}
		
		int result=FoodService.getInstance().getFoodInLikefood(foodname2,user.getUsername());
		if(result ==0 ){
			int re = FoodService.getInstance().UpdateLikeFood(foodname,user.getUsername());
			if(re>0){
				response.getWriter().write("<script>alert('收藏成功');window.location.href='Index.jsp';</script>");
				Users user01=UserService.getInstance().queryUserByName2(user.getUsername());
				request.getSession().setAttribute("user", user01);
			}else{
				
				response.getWriter().write("<script>alert('收藏失败');window.location.href='Index.jsp';</script>");
			}

		}else{
			response.getWriter().write("<script>alert('您已收藏该菜谱');window.location.href='Index.jsp';</script>");
		}
}


	private void page(HttpServletRequest request, HttpServletResponse response) {
	
		try {	
			
			//取到菜谱
			String foodname = request.getParameter("foodname");
			foodname = "%"+foodname+"%";
			Food food_one = new Food();
			FoodService foodService = FoodService.getInstance();
			food_one = foodService.getFoodByName(foodname);
			request.getSession().setAttribute("food_one", food_one);
			
			//推荐菜谱
			String sort = food_one.getSort();
			List<Food> food_tj=FoodService.getInstance().queryFoodTuijian(sort);
			request.getSession().setAttribute("food_tj", food_tj);
			
			//取到作者
			Food food_upload_user = (Food) request.getSession().getAttribute("food_one");
			
			String username =food_upload_user.getUpload_user();
			
			UserService userService = UserService.getInstance();
			Users upload_User =new Users();
			upload_User = userService.queryUploadUserByName(username);
			request.getSession().setAttribute("upload_User",upload_User);
			
			request.getRequestDispatcher("page_Detail.jsp").forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
	}

}
