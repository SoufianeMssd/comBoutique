<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soufiane" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<body>

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
<div id="formProd" class="cadre">
	
	<table>
		
		<tr>
			<td><a href="Log">returnToLogin</a></td>
		</tr>
	</table>
	
</div>

</body>
</html>