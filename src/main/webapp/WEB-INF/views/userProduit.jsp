<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soufiane" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="moussaid" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<body>
<div>
		<!-- For login user -->
		<soufiane:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">

		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<soufiane:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</soufiane:if>
</div>
<div>
	<moussaid:form action="search" method="post">
			<table>
				<tr>
					<td>Search :</td>
					<td><input type="text" name="mc" value="${mc }"></td>
					<td><input type="submit" value="Find" ></td>
				</tr>			
			</table>
		</moussaid:form>
</div>
<div id="formProd" class="cadre">
	<moussaid:form modelAttribute="produit" action="saveProd" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>ID Produit</td>
			<td><moussaid:input path="idProduit"/></td>
			<td><moussaid:errors path="idProduit" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>DESIGNATION</td>
			<td><moussaid:input path="designation"/></td>
			<td><moussaid:errors path="designation" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>CATEGORIE</td>
			<td><moussaid:select path="catego.idCategorie" items="${ categories}" itemValue="idCategorie" itemLabel="nomCategorie"/></td>
			<td><moussaid:errors path="catego.idCategorie" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>DESCRIPTION</td>
			<td><moussaid:textarea path="description"/></td>
			<td><moussaid:errors path="description" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>PRIX</td>
			<td><moussaid:input path="prix"/></td>
			<td><moussaid:errors path="prix" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>QUANTITE</td>
			<td><moussaid:input path="quantite"/></td>
			<td><moussaid:errors path="quantite" cssClass="errors"></moussaid:errors></td>
		</tr>
			<tr>
			<td>PHOTO</td>
			<td><input type="file" name="file"></td>
		</tr>

		<tr>
			<td><input type="submit" value="save"></td>
		</tr>
		<tr>
			<td><a href="toCat">ReturnToCategorie</a></td>
		</tr>
	</table>
	</moussaid:form>
</div>
<div id="tabProd" class="cadre">
<soufiane:choose>
		<soufiane:when test="${empty produits}">
			<h2>Sorry, -- ${mc} -- doesn't exist in our list</h2>
		 </soufiane:when>
		 <soufiane:otherwise>
	<table class="tab1">
		<tr>
			<th>DESIGNATION</th> <th>DESCRIPTION</th><th>CATEGORIE</th><th>PRIX</th><th>QUANTITE</th> <th>PHOTO</th> 
		</tr>
		<soufiane:forEach items="${produits}" var="prod">
			<tr>
				<td>${prod.designation}</td>
				<td>${prod.description}</td>
				<td>${prod.catego.nomCategorie}</td>
				<td>${prod.prix}</td>
				<td>${prod.quantite}</td>
				<td><img src="photoProd?idProd=${prod.idProduit}" /></td>
				<td><a href="seeProd?idProd=${prod.idProduit}">see</a></td>				
			</tr>
		</soufiane:forEach>
	</table>
	</soufiane:otherwise>
	</soufiane:choose>
</div>
</body>
</html>