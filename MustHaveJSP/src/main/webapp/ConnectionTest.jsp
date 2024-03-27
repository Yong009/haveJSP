<%@ page import="common.JDBCConnect" %>
<%@ page import="common.DBConnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JDBC 테스트</h2>
	<%
	JDBCConnect jdbc1 = new JDBCConnect();
	jdbc1.close();

	%>

	<h2>JDBC 테스트2</h2>
	<%
	String driver = application.getInitParameter("OracleDriver");
	String url = application.getInitParameter("OracleURL");
	String id  = application.getInitParameter("OracleId");
	String pwd = application.getInitParameter("OraclePwd");


	JDBCConnect jdbc2 = new JDBCConnect();
	jdbc2.close();
	%>

	<h3>JDBC 테스트3</h3>
	<%
	JDBCConnect jdbc3 = new JDBCConnect();
	jdbc3.close();

	%>

	<h2>커넥션 풀 테스트</h2>
	<%
	DBConnPool pool = new DBConnPool();
	pool.close();

	%>
</body>
</html>