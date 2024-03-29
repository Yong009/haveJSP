<%@ page import="common.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>List 컬렉션 사용하기</h4>
	<%
	 ArrayList<Person> pList = new ArrayList<>();
	pList.add(new Person("성삼문",55));
	pList.add(new Person("박팽년",60));

	%>
	<c:set var="personList" value="<%= pList %>" scope="request" />
	<ul>
		<li>이름 : ${ requestScope.personList[0].name }</li>
		<li>나이 : ${ requestScope.personList[0].age }</li>

	</ul>

	<h4>Map 컬렉션 사용하기</h4>

	<%
	Map<String, Person> pMap = new HashMap<String, Person>();
	pMap.put("personArgs1", new Person("하위지", 65));
	pMap.put("personArgs2", new Person("이개",67));

	%>
	<c:set var="personMap" value="<%= pMap %>" scope="request"/>
	<ul>
		<li>이름 : ${ requestScope.personMap.personArgs2.name }</li>
		<li>나이 : ${ personMap.personArgs2.age }</li>


	</ul>
</body>
</html>