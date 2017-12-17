<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soufiane" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="moussaid" %>
<%@page session="true"%>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<div class="cadre">
${exception }
</div>
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
			Welcome BOSS : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</soufiane:if>

</div>
<div>
	<moussaid:form action="searchUser" method="post">
			<table>
				<tr>
					<td>Search :</td>
					<td><input type="text" name="mc" value="${mc}"></td>
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
<div id="formProd" class="cadre">
	<table>
		<tr>
			<td><a href="goToProduit">versProduits</a></td>
		</tr>
	</table>
	
</div>
<div id="tabProd" class="cadre">
<soufiane:choose>
		<soufiane:when test="${empty users}">
			<h2 style="color:red;">Sorry, -- ${mc} --   isn't one of your users</h2>
		 </soufiane:when>
		 <soufiane:otherwise>
	<table class="tab1">
		<tr>
			<th>NAME</th> <th>E-MAIL</th> <th>COUNTRY</th><th>CITY</th><th>PHONENUMBER</th>  
		</tr>
		<soufiane:forEach items="${users}" var="u">
			<tr>
				<td>${u.userName}</td>
				<td>${u.email}</td>
				<td>${u.country}</td>
				<td>${u.city}</td>
				<td>${u.phoneNumber}</td>
				
				
				
				
				<td><a href="suppUser?idU=${u.idUtilisateur }">delete</a></td>
			</tr>
		</soufiane:forEach>
	</table>
	</soufiane:otherwise>
	</soufiane:choose>
</div>
