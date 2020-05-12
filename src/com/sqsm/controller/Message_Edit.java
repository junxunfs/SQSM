package com.sqsm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqsm.entity.Users;
import com.sqsm.entity.Food;
import com.sqsm.service.FoodService;
import com.sqsm.service.UserService;


@WebServlet("/message_Edit")
public class Message_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operator = request.getParameter("operator");
		if(operator.equals("Edit")){
			Edit(request,response);
		}else if(operator.equals("show_mess_save")){
			show_mess_save(request,response);
		}else if(operator.equals("show_mess_upload")){
			show_mess_upload(request,response);
		}else if(operator.equals("update_message")){
			update_message(request,response);
		}else if(operator.equals("delete_save")){
			delete_save(request,response);
		}
	}

	private void delete_save(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String foodname=request.getParameter("foodname_delete");
		Users user = (Users) request.getSession().getAttribute("user");
		String username=user.getUsername();
		String like = user.getLike_food();
		String[] like_food=like.split("¡¢");
		String new_like="";
		
		for(int i=0 ;i<like_food.length;i++){
			if("".equals(like_food[i].trim()) || like_food[i]==null){
				continue;
			}else{
				if(!like_food[i].equals(foodname)){	
					new_like=new_like+"¡¢"+like_food[i];
				}
			}
		}
		int result= FoodService.getInstance().deleteSortByUser(username,new_like);
		if(result>0){
			List<Food> foods=new ArrayList<>();
			String likes=UserService.getInstance().QueryLikeFoodByUsers(username);
			String[] like_foods =likes.split("¡¢");
			for(int j=0;j<like_foods.length;j++){
				Food food = new Food();
				food=FoodService.getInstance().getFoodByName(like_foods[j]);
				foods.add(food);
			}
			request.getSession().setAttribute("foods", foods);
			response.getWriter().write("<script>window.location.href='user_Message_save.jsp';</script>");
		}else{
			response.getWriter().write("<script>alert('É¾³ýÊ§°Ü');window.location.href='user_Message_save.jsp';</script>");
		}
	}

	private void update_message(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String message=request.getParameter("mess");
		Users uu= new Users();
		uu.setRealname(realname);
		uu.setAge(Integer.parseInt(age));
		uu.setSex(sex);
		uu.setMessage(message);
		
		Users user = (Users) request.getSession().getAttribute("user");
		String username=user.getUsername();
		int result=UserService.getInstance().updateUserMess(username,uu);
		if(result>0){
			Users user01=UserService.getInstance().queryUserByName2(username);
			request.getSession().setAttribute("user", user01);
			response.getWriter().write("<script>window.location.href='user_Message_upload.jsp';</script>");
		}else{
			response.getWriter().write("<script>alert('ÐÞ¸ÄÊ§°Ü');window.location.href='user_Message_upload.jsp';</script>");
		}
		
	}

	private void show_mess_save(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Users user = (Users) request.getSession().getAttribute("user");
		String likes=UserService.getInstance().QueryLikeFoodByUsers(user.getUsername());
		String[] like_food=likes.split("¡¢");
		List<Food> foods=new ArrayList<>();
		for(int i=0 ;i<like_food.length;i++){
			if("".equals(like_food[i].trim()) || like_food[i]==null){
				continue;
			}else{
				Food food=new Food();
				food=FoodService.getInstance().getFoodByName(like_food[i]);
				foods.add(food);
			}
		}
		
		request.getSession().setAttribute("foods", foods);
		request.getRequestDispatcher("user_Message_save.jsp").forward(request, response);
		
	}
	private void show_mess_upload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Users user = (Users) request.getSession().getAttribute("user");
		String username=user.getUsername();
		List<String> foodnames=new ArrayList<>();
		List<Food> foods=new ArrayList<>();
		foodnames=FoodService.getInstance().QueryFoodByUsers(username);
	
		for(int j=0;j<foodnames.size();j++){
			Food food = new Food();
			food=FoodService.getInstance().getFoodByName(foodnames.get(j));
			foods.add(food);
		}
		request.getSession().setAttribute("foods", foods);
		request.getRequestDispatcher("user_Message_upload.jsp").forward(request, response);
		
	}

	private void Edit(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

}
