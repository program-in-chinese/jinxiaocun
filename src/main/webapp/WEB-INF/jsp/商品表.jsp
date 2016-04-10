<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<link type="text/css" href="css/common.css" rel="stylesheet"></link>
</head>

<body>
	<div>
		<a href="/">首页</a>
		<a href="https://git.oschina.net/zhishi/jinxiaocun">源码与项目管理主页</a>
	</div>
	<h2>商品列表</h2>
	<c:forEach var="商品" items="${商品表}">
		<div>
			<c:out value="${商品.名称}"/> 单位:
			<c:out value="${商品.单位.名称}"/>
		</div>
	</c:forEach>
	
	<h3>添加商品</h3>
	<form:form method="POST" modelAttribute="商品">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<label for="名称">名称:</label>
		<form:input type="text" path="名称" size="50" />
		<form:errors path="名称" cssClass="error"/>
		<br/>
		<label for="单位">单位:</label>
		<form:select path="单位" multiple="true" items="${所有单位}" itemLabel="名称" itemValue="id" />
		<input type="submit" value="提交" />
	</form:form>
</body>

</html>