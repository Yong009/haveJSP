<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="common.JDBCConnect" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 목록 조회 테스트</h2>
	<%
	JDBCConnect jdbc = new JDBCConnect();

	String sql = "SELECT id, pass, regidate FROM member";
	Statement stmt = jdbc.con.createStatement();

	ResultSet rs = stmt.executeQuery(sql);

	while(rs.next()){
		String id = rs.getString(1);
		String pass = rs.getString(2);
		String name = rs.getString(3);
		java.sql.Date regidate = rs.getDate("regidate");

		out.println(String.format("%s %s %s %s",id,pass,name,regidate) + "<br/>");
	}


	jdbc.close();
	%>
</body>
</html>