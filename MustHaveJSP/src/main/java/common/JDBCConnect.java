package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBCConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;


	public JDBCConnect() {
		try {

			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "musthave";
			String pwd = "1234";
			con = DriverManager.getConnection(url,id,pwd);

			System.out.println("DB 연결 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}



	public JDBCConnect(String drv, String url, String id, String pw) {
		try {

			Class.forName("oracle.jdbc.OracleDriver");

			url = "jdbc:oracle:thin:@localhost:1521:xe";
			id = "musthave";
			String pwd = "1234";
			con = DriverManager.getConnection(url,id,pwd);

			System.out.println("DB 연결 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}


	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(con != null) {
				con.close();
			}

			System.out.println("JDBC 자원 해제");
		}
		catch(Exception e ) {
			e.printStackTrace();
		}


	}


	public JDBCConnect(ServletContext application) {
		try {

			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);

			String url = application.getInitParameter("OracleURL");
			String id = application.getInitParameter("OracleId");
			String pwd = application.getInitParameter("OraclePwd");


			con = DriverManager.getConnection(url,id,pwd);

			System.out.println("DB 연결 성공(인수 생성자 2)");


		}
		catch(Exception e)	{

			e.printStackTrace();
		}
	}





}
