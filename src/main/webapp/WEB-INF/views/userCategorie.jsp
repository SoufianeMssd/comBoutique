<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soufiane" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<body>


		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
<%-- 			<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 				value="${_csrf.token}" /> --%>
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
		<div id="tabCat" class="cadre">
	<table class="tab1">
		<tr>
			<th>NOM Cat</th> <th>DESCRIPTION</th><th>ACTION</th>  
		</tr>
		<soufiane:forEach items="${categories}" var="cat">
			<tr>
				
				<td>${cat.nomCategorie}</td>
				<td>${cat.description}</td>
				<td><a href="prodDeCat?idCat=${cat.idCategorie}">goIN</a></td>
			</tr>
			
		</soufiane:forEach>
		   
	</table>
	
</div>
<div id="formProd" class="cadre">
	
	<table>
<tr>
				<td><a href="goToProduit">toProduit</a></td>
			</tr>
</table>
	
</div>


</body>
</html>