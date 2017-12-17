<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soufiane" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="moussaid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="sfn" %>


<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<body>


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
	
	<table>
		
		<tr>
			<td><a href="toCat">ReturnToCategorie</a></td>
		</tr>
	</table>
	
</div>

<div id="tabProd" class="cadre">
	<table class="tab1">
	<soufiane:choose>
		<soufiane:when test="${empty produits}">
			<h2>Sorry,  -- ${mc} --   doesn't exist in our list</h2>
		 </soufiane:when>
		 <soufiane:otherwise>
		<tr>
			 <th>DESIGNATION</th> <th>DESCRIPTION</th><th>CATEGORIE</th><th>PRIX</th><th>QUANTITE</th>  <th>PHOTO</th>
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
			</soufiane:otherwise>
			</soufiane:choose>
		
	</table>
</div>
</body>
</html>