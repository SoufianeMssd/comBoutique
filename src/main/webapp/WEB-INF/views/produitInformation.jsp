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
<soufiane:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
<%-- 		<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 			value="${_csrf.token}" /> --%>
	</form>
	<script>
	function formSubmit() { 
		document.getElementById("logoutForm").submit(); 
	} 
</script> 

	<soufiane:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</soufiane:if>

</div>
 <div id="formProd" class="cadre">
 
 	<table>
 		<tr>
 		<td><img src="photoProd?idProd=${p.idProduit}" /></td>
 		</tr>
 		<tr>
 			<td>DESIGNATION :</td>
 			<td>${p.designation}</td>
 		</tr>
 		<tr>
 			<td>DESCRIPTION :</td>
 			<td>${p.description}</td>
 		</tr>
 		<tr>
 			<td>CATEGORIE :</td>
 			<td>${p.catego.nomCategorie}</td>
 		</tr>
 		<tr>
 			<td>PRIX :</td>
 			<td>${p.prix}</td>
 		</tr>
 		<tr>
 			<td>QUANTITE :</td>
 			<td>${p.quantite}</td>
 		</tr>
 	</table>
 </div>
<div id="formProd" class="cadre">
	
	<table>
		
		<tr>
			<td><a href="toCat">ReturnToCategorie</a></td>
		</tr>
	</table>
	
</div>
<div class="cadre">
	<table>
		<tr>
			<td><a href="goToProduit">versProduits</a></td>
		</tr>
	</table>
</div>


</body>
</html>