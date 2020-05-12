package com.sqsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
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


@WebServlet(name = "AdminServlet", urlPatterns = { "/adminServlet" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String operator=request.getParameter("operator");
			if(operator.equals("show")){
				show(request,response);
			}
			if(operator.equals("delete")){
				delete(request,response);
			}
			if(operator.equals("Mess_Edit")){
				Mess_Edit(request,response);
			}
			if(operator.equals("save_users")){
				save_users(request,response);
			}
			if(operator.equals("Food_Edit")){
				Food_Edit(request,response);
			}
			if(operator.equals("Old_Food_Save")){
				Old_Food_Save(request,response);
			}
			if(operator.equals("New_Food_Save")){
				New_Food_Save(request,response);
			}
			if(operator.equals("AddFood")){
				Add_Food(request,response);
			}if(operator.equals("checkFoodname")){
				checkFoodname(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void checkFoodname(HttpServletRequest request,
			HttpServletResponse response) {
		String foodname=request.getParameter("foodname");
		System.out.println("foodname:"+foodname);
		
		response.setCharacterEncoding("utf-8");;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Food food =null;
		food = FoodService.getInstance().getFoodByName(foodname);
		System.out.println(food);
		if(food.getFoodName()!=null)
		{
			pw.write("菜名不可用");
		}else 
		{
			pw.write("菜名可用");
		}
		
	}

	private void New_Food_Save(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String foodname = request.getParameter("foodname");
		String food_type= request.getParameter("foodtype");
		String material1= request.getParameter("material1");
		String material2= request.getParameter("material2");
		String material3= request.getParameter("material3");
		String material4= request.getParameter("material4");
		String material5= request.getParameter("material5");
		String step1= request.getParameter("step1");
		String step2= request.getParameter("step2");
		String step3= request.getParameter("step3");
		String step4= request.getParameter("step4");
		String step5= request.getParameter("step5");
		String time= request.getParameter("time");
		Food food = new Food();
		food.setFoodName(foodname);
		food.setSort(food_type);
		food.setMaterial1(material1);
		food.setMaterial2(material2);
		food.setMaterial3(material3);
		food.setMaterial4(material4);
		food.setMaterial5(material5);
		food.setStep1(step1);
		food.setStep2(step2);
		food.setStep3(step3);
		food.setStep4(step4);
		food.setStep5(step5);
		food.setTime(time);
		int result =FoodService.getInstance().AddFood(food);
		if(result>0){
			List<Food> foods=FoodService.getInstance().queryAllFoods2();
			request.getSession().setAttribute("foods_admin", foods);
			response.getWriter().write("<script>alert('上传成功');window.location.href='admin/menu-list.jsp';</script>");
		}else{
			response.getWriter().write("<script>alert('上传失败');window.location.href='menu-add.jsp';</script>");
		}
	}

	private void Food_Edit(HttpServletRequest request,
			HttpServletResponse response) {
		String foodname=request.getParameter("foodname");
		Food food= FoodService.getInstance().getFoodByName(foodname);
		request.getSession().setAttribute("food_edit", food);
		try {
			response.getWriter().write("<script>window.location.href='menu-edit.jsp';</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Add_Food(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.getWriter().write("<script>window.location.href='menu-add.jsp';</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void Old_Food_Save(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String foodname=request.getParameter("foodname");
		String food_type= request.getParameter("foodtype");
		String material1= request.getParameter("material1");
		String material2= request.getParameter("material2");
		String material3= request.getParameter("material3");
		String material4= request.getParameter("material4");
		String material5= request.getParameter("material5");
		String step1= request.getParameter("step1");
		String step2= request.getParameter("step2");
		String step3= request.getParameter("step3");
		String step4= request.getParameter("step4");
		String step5= request.getParameter("step5");
		String time= request.getParameter("time");
		Food food = new Food();
		food.setSort(food_type);
		food.setMaterial1(material1);
		food.setMaterial2(material2);
		food.setMaterial3(material3);
		food.setMaterial4(material4);
		food.setMaterial5(material5);
		food.setStep1(step1);
		food.setStep2(step2);
		food.setStep3(step3);
		food.setStep4(step4);
		food.setStep5(step5);
		food.setTime(time);
		System.out.println(food);
		System.out.println(foodname+"---");
		int result =FoodService.getInstance().UpdateFoodByName(food,foodname);
		
		if(result>0){
			List<Food> foods=FoodService.getInstance().queryAllFoods2();
			request.getSession().setAttribute("foods_admin", foods);
			response.getWriter().write("<script>alert('修改成功');window.location.href='admin/menu-list.jsp';</script>");
		}else{
			response.getWriter().write("<script>alert('修改失败');window.location.href='menu-edit.jsp';</script>");
		}
		

		
		
	}
	private void save_users(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String realname=request.getParameter("realname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String message = request.getParameter("message");
		Users user= new Users();
		user.setUsername(username);
		user.setRealname(realname);
		user.setSex(sex);
		user.setAge(Integer.parseInt(age));
		user.setMessage(message);
		int result = UserService.getInstance().updateUserMess(username, user);
		if(result>0){
			Users users= UserService.getInstance().queryUserByName2(username);
			request.getSession().setAttribute("user_edit", users);
			Users user_show= UserService.getInstance().queryUserByName2(username);
			request.getSession().setAttribute("user_edit", user_show);
			response.getWriter().write("<script>window.location.href='admin/member-list.jsp';</script>");
		}else{
			response.getWriter().write("<script>alert('修改失败');window.location.href='admin/memberxin.jsp';</script>");

		}
	}
	private void Mess_Edit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		Users user= UserService.getInstance().queryUserByName2(username);
		request.getSession().setAttribute("user_edit", user);
		menu_upload(request,response);
		menu_collect(request,response);
		response.getWriter().write("<script>window.location.href='admin/memberxin.jsp';</script>");
	}
	/**
	 * 删除方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] ids=request.getParameterValues("id_foodname");
		//1.直接调用service的删除方法删除
		//2.1把String数组转换为int数组
		boolean tmp=FoodService.getInstance().deleteFood(ids);
		//3.删除后重新清除session中保存的用户信息，弹出消息提示框
		PrintWriter pw=response.getWriter();
		if(tmp)
		{
			request.getSession().removeAttribute("foods_admin");
			pw.write("<script>alert('"+"删除成功"+"');</script>");
		}else
		{
			pw.write("<script>alert('"+"删除失败"+"');</script>");
		}
	}
	
	private void show(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Users> users=UserService.getInstance().queryAllUsers();
		request.getSession().setAttribute("users_admin", users);
		List<Food> foods=FoodService.getInstance().queryAllFoods2();
		request.getSession().setAttribute("foods_admin", foods);
		menu_upload(request,response);
		menu_collect(request,response);
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
	}

	private void menu_collect(HttpServletRequest request,
			HttpServletResponse response) {
		List<Users> user_collect = new ArrayList<>();
		user_collect = UserService.getInstance().queryAllUsers();
		request.getSession().setAttribute("user_collect", user_collect);
		
	}

	private void menu_upload(HttpServletRequest request,HttpServletResponse response) {
		List<Food> food_upload = new ArrayList<>();
		food_upload = FoodService.getInstance().queryFoodsOrderByUser();
		request.getSession().setAttribute("food_upload", food_upload);
	}


	

}
