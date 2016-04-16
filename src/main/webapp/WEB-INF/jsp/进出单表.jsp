<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<link type="text/css" href="css/common.css" rel="stylesheet"></link>
</head>

<body>
	<jsp:include page="置顶.jsp" />
	<h2>进出单列表</h2>
	<c:forEach var="进出单" items="${进出单表}">
		<div>
			<c:out value="${进出单.进 ? '进' : '出'}"/>
			<c:out value="${进出单.数量}"/>
			<c:out value="${进出单.商品.单位.名称}"/>
			<c:out value="${进出单.商品.名称}"/>
		</div>
	</c:forEach>

	<h3>添加进出单</h3>
	<form:form method="POST" modelAttribute="进出单">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<form:radiobutton path="进" value="true" />进
		<form:radiobutton path="进" value="false" />出
		<br/>
		<label for="数量">数量:</label>
		<form:input type="text" path="数量" size="50" />
		<form:errors path="数量" cssClass="error"/>
		<br/>
		<label for="商品">商品:</label>
		<form:select path="商品" multiple="true" items="${所有商品}" itemLabel="名称" itemValue="id" />
		<input type="submit" value="提交" />
	</form:form>
</body>

</html>