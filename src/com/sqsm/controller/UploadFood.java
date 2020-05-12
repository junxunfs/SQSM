package com.sqsm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqsm.entity.Food;
import com.sqsm.service.FoodService;

@WebServlet("/uploadFood")
public class UploadFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operator = request.getParameter("operator");
		if(operator.equals("AddFood")){
			try {
				AddFood(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private void AddFood(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String food_name= request.getParameter("food_name");
		String food_type= request.getParameter("food_type");
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
		food.setFoodName(food_name);
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
		int result =FoodService.getInstance().AddFood(food);
		if(result>0){
			response.getWriter().write("<script>alert('上传成功');window.location.href='Index.jsp';</script>");
		}else{
			response.getWriter().write("<script>alert('上传失败');window.location.href='upload_food.jsp';</script>");
		}
		

		
	}

}
