package com.sqsm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqsm.entity.Food;
import com.sqsm.service.FoodService;

/**
 * Servlet implementation class Health_food
 */
@WebServlet("/health_food")
public class Health_food extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operator = request.getParameter("operator");
		if(operator.equals("jianfei")){
			jianfei(request,response);
		}else if(operator.equals("shimian")){
			shimian(request,response);
		}else if(operator.equals("buqi")){
			buqi(request,response);
		}else if(operator.equals("buxue")){
			buxue(request,response);
		}
		
	}

	private void buxue(HttpServletRequest request, HttpServletResponse response) {
		List<Food> food_bx = FoodService.getInstance().queryFoodOfRank("²¹Ñª");		
		request.getSession().setAttribute("food_health", food_bx);
		try {
			//queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("health-recipes.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void buqi(HttpServletRequest request, HttpServletResponse response) {
		List<Food> food_bq = FoodService.getInstance().queryFoodOfRank("²¹Æø");		
		request.getSession().setAttribute("food_health", food_bq);
		try {
			//queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("health-recipes.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void shimian(HttpServletRequest request,
			HttpServletResponse response) {
		List<Food> food_sm = FoodService.getInstance().queryFoodOfRank("Ê§Ãß");		
		request.getSession().setAttribute("food_health", food_sm);
		try {
			//queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("health-recipes.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void jianfei(HttpServletRequest request,
			HttpServletResponse response) {
		List<Food> food_jf = FoodService.getInstance().queryFoodOfRank("¼õ·Ê");		
		request.getSession().setAttribute("food_health", food_jf);
		try {
			//queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("health-recipes.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
