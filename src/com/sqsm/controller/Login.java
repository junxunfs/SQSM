package com.sqsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqsm.entity.Food;
import com.sqsm.entity.Users;
import com.sqsm.service.FoodService;
import com.sqsm.service.UserService;
import com.sqsm.util.Md5Utils;
import com.sqsm.util.PageUtil;

@WebServlet("/login")
public class Login extends HttpServlet{
	/**
	 * 定义服务端校验注册表单的方法
	 * @param username
	 * @param password
	 * @param code
	 * @param sb
	 * @return
	 */
	private StringBuffer validateLoginForm(String username,String password,String code){
		StringBuffer sb=new StringBuffer();
		if(username==null||"".equals(username.trim())){
			sb.append("用户名为空");
		}if(password==null||"".equals(password.trim())){
			sb.append("密码为空");
		}/*if(code==null||"".equals(code.trim())){
			sb.append("验证码为空");
		}*/
		
		return sb;
	}	
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operator=request.getParameter("operator");
		if(operator.equals("search")){
			try {
				search(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(operator.equals("login1")){
			try {
				login1(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(operator.equals("foodServlet")){
			try {
				foodSevlet_keepData(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String foodname=request.getParameter("search_food");
			foodname = "%"+foodname+"%";
			List<Food> food_one = FoodService.getInstance().queryOneFood(foodname);
			//把集合放到session中
			request.getSession().setAttribute("food_new", food_one);
			queryUserByPage(request,response);
			request.getRequestDispatcher("Index.jsp").forward(request, response);	
		
	}

	private void login1(HttpServletRequest request,HttpServletResponse response) throws Exception{

		//获取表单数据
		String username=request.getParameter("username_login");
		String password= request.getParameter("password_login");
		String code= request.getParameter("code");
		password = Md5Utils.md5(password);
		
		//非空验证
		StringBuffer sb=validateLoginForm(username,password,code);
		//如果校验失败，有非空数据
		if(sb.toString().length()>0){
			
			//返回登录页面，并显示失败信息
			request.setAttribute("message",sb.toString());
			request.getRequestDispatcher("/Login.jsp").forward(request, response);			
		}else{
			String real_name=(String)request.getSession().getAttribute("code");
			
			/*if(!real_name.equalsIgnoreCase(code)){
				request.setAttribute("message","验证码错误");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);	
				return ;
			}*/
			Users user=UserService.getInstance().queryUserByNameAndPassword(username,password);
			
			request.getSession().setAttribute("user", user);
			if(user!=null){	
				//String operator=request.getParameter("operator");
				//if("foodSevlet".equals(operator))
				{
					foodSevlet(request,response);
				}
				queryUserByPage(request,response);
				if(user.getRole()==1){
					
					request.getRequestDispatcher("/adminServlet?operator=show").forward(request, response);					
				}else{	
					request.getRequestDispatcher("/Index.jsp").forward(request, response);		
				}
				
			}else{
				request.getRequestDispatcher("/Login.jsp").forward(request, response);	
			}
			
			
		}
	}
	
	
	private void foodSevlet(HttpServletRequest request,
			HttpServletResponse response) {
		List<Food> foods = FoodService.getInstance().queryAllFoods();
		//把集合放到session中
		request.getSession().setAttribute("food_new", foods);
	
		List<Food> food_hot = FoodService.getInstance().queryAllFoods_hot();
		//把集合放到session中
		request.getSession().setAttribute("food_hot", food_hot);
		
		List<Food> food_good = FoodService.getInstance().queryAllFoods_good();
		//把集合放到session中
		request.getSession().setAttribute("food_good", food_good);
	}
	
	private void foodSevlet_keepData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Food> foods = FoodService.getInstance().queryAllFoods();
		//把集合放到session中
		request.getSession().setAttribute("food_new", foods);
	
		List<Food> food_hot = FoodService.getInstance().queryAllFoods_hot();
		//把集合放到session中
		request.getSession().setAttribute("food_hot", food_hot);
		
		List<Food> food_good = FoodService.getInstance().queryAllFoods_good();
		//把集合放到session中
		request.getSession().setAttribute("food_good", food_good);
		queryUserByPage(request,response);
		request.getRequestDispatcher("Index.jsp").forward(request, response);	
		//System.out.println("进入foodservlet页面");
	}
	

	/**
	 * 根据页码查询对应页码数据的方法
	 */
	private void queryUserByPage(HttpServletRequest request,
			HttpServletResponse response) {
		/**获取页码*/
		
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null){
			pageNum =Integer.parseInt(request.getParameter("pageNum"));
			
		}
		/**根据页码获取数据*/
		List<Food> foods=(List<Food>) request.getSession().getAttribute("food_new");
		/**实例化PageUtil*/
		PageUtil pageUtil = new PageUtil(foods,18,pageNum);
		
		request.setAttribute("list", foods.subList(pageUtil.getFromIndex(), pageUtil.getToIndex()));
		request.setAttribute("pageCount",pageUtil.getPageCount());
		/*try {
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}*/
	}
	
}
