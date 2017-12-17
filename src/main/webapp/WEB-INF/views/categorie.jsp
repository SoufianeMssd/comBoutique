<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soufiane" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="moussaid" %>
<%@page session="true"%>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>

<div>
<soufiane:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
<%-- 		<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 			value="${_csrf.token}" /> --%>
	</form>
	<script>
		function formSubmit() { 
	document.getElementById("logoutForm").submit(); } 
</script> 

	<soufiane:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome BOSS : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</soufiane:if>

</div>
<div id="formCat" class="cadre">
	<moussaid:form modelAttribute="categorie" action="saveCat" method="post" enctype="multipart/form-data" >
	<table>
		<tr>
			<td>ID Categorie</td>
			<td><moussaid:input path="idCategorie"/></td>
			<td><moussaid:errors path="idCategorie" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>NOM Categorie</td>
			<td><moussaid:input path="nomCategorie"/></td>
			<td><moussaid:errors path="nomCategorie" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>DESCRIPTION</td>
			<td><moussaid:textarea path="description"/></td>
			<td><moussaid:errors path="description" cssClass="errors"></moussaid:errors></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="save"></td>
		</tr>
		
	</table>
	</moussaid:form>
</div>
<div class="cadre">
	<table>
		<tr>
			<td><a href="goToProduit">versProduits</a></td>
		</tr>
	</table>
</div>
<div id="tabCat" class="cadre">
	<table class="tab1">
		<tr>
			 <th>NOM Cat</th> <th>DESCRIPTION</th>  
		</tr>
		<soufiane:forEach items="${categories}" var="cat">
			<tr>
				
				<td>${cat.nomCategorie}</td>
				<td>${cat.description}</td>				
				
				<td><a href="prodDeCat?idCat=${cat.idCategorie}">goIN</a></td>				
				<td><a href="editCat?idCat=${cat.idCategorie }">edit</a></td>
				<td><a href="suppCat?idCat=${cat.idCategorie }">delete</a></td>				
			</tr>
		</soufiane:forEach>
	</table>
</div>