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
	<h2>单位列表</h2>
	<c:forEach var="单位" items="${单位表}">
		<div>
			<c:out value="${单位.名称}"/>
		</div>
	</c:forEach>
	
	<h3>添加单位</h3>
	<form:form method="POST" modelAttribute="单位">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<label for="名称">名称:</label>
		<form:input type="text" path="名称" size="50" />
		<form:errors path="名称" cssClass="error"/>
		<br/>
		<input type="submit" value="提交"></input>
	</form:form>
</body>

</html>