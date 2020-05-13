package com.sqsm.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	public static Connection getConnection()
	{
		Connection conn=null;
		try{
			//ʵ����Context������ʵ��ȡContext.xml�ļ��е���Դ
			Context context = new InitialContext();
			//ʹ��lookup����Ѱ������Դ��Դ�������ͳ�DataSource
			 DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/shiQshi");
			 conn = ds.getConnection();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getConnection_transaction() {
		Connection conn=getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void release(Connection conn,PreparedStatement pres,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();	
			}
			if(pres!=null){
				pres.close();
			}	
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
