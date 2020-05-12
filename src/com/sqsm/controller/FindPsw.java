package com.sqsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;

import com.sqsm.entity.Users;
import com.sqsm.service.UserService;
import com.sqsm.util.Md5Utils;

/**
 * Servlet implementation class FindPsw
 */
@WebServlet("/findPsw")
public class FindPsw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String operator=request.getParameter("operator");
		if("findPsw".equals(operator))
		{
			findPsw(request,response);
		}
	
	}
	
	private void findPsw(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String username = request.getParameter("username_findPSW");
		String password_old = request.getParameter("password_old");
		String password_new = request.getParameter("password_new");
		if(password_old!=null&&"".equals(password_old.trim())){
			password_old = Md5Utils.md5(password_old);
		}
		if(password_new!=null&&"".equals(password_new.trim())){
			password_new = Md5Utils.md5(password_new);
		}
		
		Users user = new Users();	
		user.setUsername(username);		
		user.setPassword(password_old);
		
		
		PrintWriter pw = response.getWriter();
			
		 StringBuffer sb=new StringBuffer();
		
		if((sb=validateRegisterForm(user)).toString().length()>0)
		{
			//如果有必填项为空，那么提醒用户填写数据
			pw.write("<script>alert('"+sb.toString()+"');window.location.href='FindPsw.jsp';</script>");
			return;
		}
		if(password_new==password_old){
			pw.write("<script>alert('新旧密码一致。');</script>");
			return;
		}
		int row=UserService.getInstance().updatePsw(user);
		if(row==1){
			pw.write("<script>alert('密码修改成功');window.location.href='Login.jsp';</script>");
			
		}else{
			//request.getRequestDispatcher("/FindPsw.jsp").forward(request, response);
			//pw.write("密码修改失败");
			pw.write("<script>alert('密码修改失败');window.location.href='FindPsw.jsp';</script>");

		}
			
		
	}

	private StringBuffer validateRegisterForm(Users user){
		StringBuffer sb = new StringBuffer();
		
		if(user.getUsername()==null || "".equals(user.getUsername().trim())){
			sb.append("用户名为空!");
		}else if(user.getPassword()==null || "".equals(user.getPassword().trim())){
			sb.append("密码为空!");
		}	
		return sb;
	}
	
	
	

}
