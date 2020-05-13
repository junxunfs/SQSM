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
	 * ��������У��ע����ķ���
	 * @param username
	 * @param password
	 * @param code
	 * @param sb
	 * @return
	 */
	private StringBuffer validateLoginForm(String username,String password,String code){
		StringBuffer sb=new StringBuffer();
		if(username==null||"".equals(username.trim())){
			sb.append("�û���Ϊ��");
		}if(password==null||"".equals(password.trim())){
			sb.append("����Ϊ��");
		}/*if(code==null||"".equals(code.trim())){
			sb.append("��֤��Ϊ��");
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
			//�Ѽ��Ϸŵ�session��
			request.getSession().setAttribute("food_new", food_one);
			queryUserByPage(request,response);
			request.getRequestDispatcher("Index.jsp").forward(request, response);	
		
	}

	private void login1(HttpServletRequest request,HttpServletResponse response) throws Exception{

		//��ȡ������
		String username=request.getParameter("username_login");
		String password= request.getParameter("password_login");
		String code= request.getParameter("code");
		password = Md5Utils.md5(password);
		
		//�ǿ���֤
		StringBuffer sb=validateLoginForm(username,password,code);
		//���У��ʧ�ܣ��зǿ�����
		if(sb.toString().length()>0){
			
			//���ص�¼ҳ�棬����ʾʧ����Ϣ
			request.setAttribute("message",sb.toString());
			request.getRequestDispatcher("/Login.jsp").forward(request, response);			
		}else{
			String real_name=(String)request.getSession().getAttribute("code");
			
			/*if(!real_name.equalsIgnoreCase(code)){
				request.setAttribute("message","��֤�����");
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
		//�Ѽ��Ϸŵ�session��
		request.getSession().setAttribute("food_new", foods);
	
		List<Food> food_hot = FoodService.getInstance().queryAllFoods_hot();
		//�Ѽ��Ϸŵ�session��
		request.getSession().setAttribute("food_hot", food_hot);
		
		List<Food> food_good = FoodService.getInstance().queryAllFoods_good();
		//�Ѽ��Ϸŵ�session��
		request.getSession().setAttribute("food_good", food_good);
	}
	
	private void foodSevlet_keepData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Food> foods = FoodService.getInstance().queryAllFoods();
		//�Ѽ��Ϸŵ�session��
		request.getSession().setAttribute("food_new", foods);
	
		List<Food> food_hot = FoodService.getInstance().queryAllFoods_hot();
		//�Ѽ��Ϸŵ�session��
		request.getSession().setAttribute("food_hot", food_hot);
		
		List<Food> food_good = FoodService.getInstance().queryAllFoods_good();
		//�Ѽ��Ϸŵ�session��
		request.getSession().setAttribute("food_good", food_good);
		queryUserByPage(request,response);
		request.getRequestDispatcher("Index.jsp").forward(request, response);	
		//System.out.println("����foodservletҳ��");
	}
	

	/**
	 * ����ҳ���ѯ��Ӧҳ�����ݵķ���
	 */
	private void queryUserByPage(HttpServletRequest request,
			HttpServletResponse response) {
		/**��ȡҳ��*/
		
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null){
			pageNum =Integer.parseInt(request.getParameter("pageNum"));
			
		}
		/**����ҳ���ȡ����*/
		List<Food> foods=(List<Food>) request.getSession().getAttribute("food_new");
		/**ʵ����PageUtil*/
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
