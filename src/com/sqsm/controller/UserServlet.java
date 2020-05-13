package com.sqsm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqsm.entity.Food;
import com.sqsm.util.PageUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operator=request.getParameter("operator");
		if("queryUserByPage".equals(operator))
		{
			queryUserByPage(request,response);
		}
	}

	
	/**
	 * ����ҳ���ѯ��Ӧҳ�����ݵķ���
	 */
	private void queryUserByPage(HttpServletRequest request,HttpServletResponse response) {
		/**��ȡҳ��*/
		
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null){
			pageNum =Integer.parseInt(request.getParameter("pageNum"));
			
		}
		/**����ҳ���ȡ����*/
		List<Food> foods=(List<Food>) request.getSession().getAttribute("food_new");
		/**ʵ����PageUtil*/
		PageUtil pageUtil = new PageUtil(foods,12,pageNum);
		
		request.setAttribute("list", foods.subList(pageUtil.getFromIndex(), pageUtil.getToIndex()));
		request.setAttribute("pageCount",pageUtil.getPageCount());
		try {
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}
}
