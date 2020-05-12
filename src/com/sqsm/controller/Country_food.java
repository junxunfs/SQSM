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


@WebServlet("/country_food")
public class Country_food extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operator = request.getParameter("operator");
		if(operator.equals("search02")){	
			search(request,response);
		}
		if(operator.equals("ranking")){	
			try {
				ranking(request,response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
	}


	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sort = request.getParameter("sort01");	
		List<Food> foods_xc = FoodService.getInstance().getFoodsBySort(sort);	
		request.getSession().setAttribute("foods_xc", foods_xc);
		request.getSession().setAttribute("sort01", sort);
		request.getRequestDispatcher("steam_of_people.jsp").forward(request, response);
		
	}


	private void ranking(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String sort = request.getParameter("sort");
		List<Food> foods_xc = FoodService.getInstance().getFoodsBySort(sort);
		request.getSession().setAttribute("foods_xc", foods_xc);
		request.getRequestDispatcher("steam_of_people.jsp").forward(request, response);
	}

}
