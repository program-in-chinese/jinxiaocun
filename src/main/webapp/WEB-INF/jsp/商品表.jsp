<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h2>商品列表</h2>
	<c:forEach var="商品" items="${商品表}">
		<div>
			<c:out value="${商品.名称}"/> 单位:
			<c:out value="${商品.单位}"/>
		</div>
	</c:forEach>
	
	<h3>添加商品</h3>
	<form method="POST">
		<label for="名称">名称:</label>
		<input type="text" name="名称" size="50"></input><br/>
		<label for="单位">单位:</label>
		<input type="text" name="单位" size="50"></input><br/>
		<input type="submit" value="提交"></input>
	</form>
</body>

</html>