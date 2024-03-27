<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Style>
	div#popup{
		postion : absolute; top:100px, left:50px; color:yellow;
		width:270px; height:100px; background-color:gray;
	
	}
	div#popup>div {
		position: relative; background-color:#ffffff; top:0px;
		border: 1px solid gray; padding:10px; color:black;
	}
	

</Style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#closeBtn').click(function(){
			$('#popup').hide();	
		
		
		});
	
	});
	


</script>
</head>
<body>
	<h2>팝업 메인 페이지(ver 0.1)</h2>
	


</body>
</html>