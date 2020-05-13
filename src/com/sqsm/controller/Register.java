package com.sqsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqsm.entity.Users;
import com.sqsm.service.UserService;
import com.sqsm.util.Md5Utils;


@WebServlet("/register")
public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String oper=request.getParameter("operator");
		if("checkUsername".equals(oper))
		{
			checkUsername(request,response);
		} 
		
		String username= request.getParameter("username_signup");
		String password = request.getParameter("password_signup");
		String password2 = request.getParameter("password2");
		if(password!=null &&!"".equals(password.trim())){
			password = Md5Utils.md5(password);
		}	
		if(password2!=null &&!"".equals(password2.trim())){
			password2 = Md5Utils.md5(password2);
		}	

		
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setPassword2(password2);
		//request.setAttribute("user", user);
		
		PrintWriter pw=response.getWriter();
				
		 StringBuffer sb=new StringBuffer();
			if((sb=validateRegisterForm(user)).toString().length()>0)
			{
				//2.����б�����Ϊ�գ���ô�����û���д���ݷ��ؿͻ���ע��ҳ��
				pw.write("<script>alert('"+sb.toString()+"');window.location.href='Login.jsp';</script>");
				return;
			}
		int result=UserService.getInstance().register(user);
		if( result==1){
			pw.write("<script>alert('�û����ѱ�ռ��,ע��ʧ��');window.location.href='Login.jsp';</script>");
		}else{
			pw.write("<script>alert('ע��ɹ�');window.location.href='Login.jsp';</script>");
		}
		
		
	}
	
	private StringBuffer validateRegisterForm(Users user){
		StringBuffer sb = new StringBuffer();
		
		if(user.getUsername()==null || "".equals(user.getUsername().trim())){
			sb.append("�û���Ϊ��!");
		}
		if(user.getPassword()==null || "".equals(user.getPassword().trim())){
			sb.append("����Ϊ��!");
		}
		if(user.getPassword2()!=null)
		{
			if(!user.getPassword().equals(user.getPassword2())){
				sb.append("�����������벻һ��");
			}
		}
		else{
			sb.append("ȷ������Ϊ��");
		}
		
		return sb;
	}
	/**
	 * У���û����Ƿ����
	 * @param request
	 * @param response
	 */
	private void checkUsername(HttpServletRequest request,HttpServletResponse response) {
		
		String username=request.getParameter("username");
		//System.out.println("username:"+username);
		
		response.setCharacterEncoding("utf-8");;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row=UserService.getInstance().queryUserByName(username);
		if(row>0)
		{
			pw.write("�û���������");
		}else
		{
			pw.write("�û�������");
		}
		
	}
	
}
