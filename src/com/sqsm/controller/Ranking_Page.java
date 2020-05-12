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
import com.sqsm.util.PageUtil;


@WebServlet("/ranking_Page")
public class Ranking_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operator=request.getParameter("operator");
		if(operator.equals("show")){
			show(request,response);
		}
		if(operator.equals("hot_week")){
			hot_week(request,response);
		}
		if(operator.equals("steam_of_people")){
			steam_of_people(request,response);
		}
		if(operator.equals("tianpin")){
			tianpin(request,response);
		}
		
	}

	private void tianpin(HttpServletRequest request,
			HttpServletResponse response) {
		List<Food> food_tp = FoodService.getInstance().queryFoodOfRank("甜品面包");		
		request.getSession().setAttribute("food_ranking", food_tp);
		try {
			queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("ranking-page4.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void steam_of_people(HttpServletRequest request,
			HttpServletResponse response) {
		List<Food> food_steam = FoodService.getInstance().queryFoodOfRank("广州家常菜");		
		request.getSession().setAttribute("food_ranking", food_steam);
		try {
			queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("ranking-page2.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void hot_week(HttpServletRequest request,
			HttpServletResponse response) {
		List<Food> food_hot = FoodService.getInstance().queryFoodOfRank("北京家常菜");
		request.getSession().setAttribute("food_ranking", food_hot);
		try {
			queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("ranking-page1.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		List<Food> food_show = FoodService.getInstance().queryFoodOfRank("向往的生活");
		request.getSession().setAttribute("food_ranking", food_show);
		try {
			queryUserByPage(request,response,"food_ranking");
			request.getRequestDispatcher("ranking-page3.jsp").forward(request, response);
		} catch (ServletException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据页码查询对应页码数据的方法
	 */
	private void queryUserByPage(HttpServletRequest request,
			HttpServletResponse response,String name) {
		/**获取页码*/
		
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null){
			pageNum =Integer.parseInt(request.getParameter("pageNum"));
			
		}
		/**根据页码获取数据*/
		List<Food> foods=(List<Food>) request.getSession().getAttribute(name);
		/**实例化PageUtil*/
		PageUtil pageUtil = new PageUtil(foods,10,pageNum);
		
		request.setAttribute("list", foods.subList(pageUtil.getFromIndex(), pageUtil.getToIndex()));
		request.setAttribute("pageCount",pageUtil.getPageCount());
	}
}
