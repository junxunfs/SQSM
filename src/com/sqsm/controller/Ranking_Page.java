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
		List<Food> food_tp = FoodService.getInstance().queryFoodOfRank("��Ʒ���");		
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
		List<Food> food_steam = FoodService.getInstance().queryFoodOfRank("���ݼҳ���");		
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
		List<Food> food_hot = FoodService.getInstance().queryFoodOfRank("�����ҳ���");
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
		List<Food> food_show = FoodService.getInstance().queryFoodOfRank("����������");
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
	 * ����ҳ���ѯ��Ӧҳ�����ݵķ���
	 */
	private void queryUserByPage(HttpServletRequest request,
			HttpServletResponse response,String name) {
		/**��ȡҳ��*/
		
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null){
			pageNum =Integer.parseInt(request.getParameter("pageNum"));
			
		}
		/**����ҳ���ȡ����*/
		List<Food> foods=(List<Food>) request.getSession().getAttribute(name);
		/**ʵ����PageUtil*/
		PageUtil pageUtil = new PageUtil(foods,10,pageNum);
		
		request.setAttribute("list", foods.subList(pageUtil.getFromIndex(), pageUtil.getToIndex()));
		request.setAttribute("pageCount",pageUtil.getPageCount());
	}
}
