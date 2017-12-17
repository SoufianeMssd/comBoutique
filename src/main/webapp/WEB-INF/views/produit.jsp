<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soufiane"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="moussaid"%>
<%@page session="true"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>

<div>
	<soufiane:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm"></form>
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
	<moussaid:form action="search" method="post">
		<table>
			<tr>
				<td>Search :</td>
				<td><input type="text" name="mc" value="${mc }"></td>
				<td><input type="submit" value="Find"></td>
			</tr>
		</table>
	</moussaid:form>
</div>
<div id="formProd" class="cadre">
	<moussaid:form modelAttribute="produit" action="saveProd" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Produit</td>
				<td><moussaid:input path="idProduit" /></td>
				<td><moussaid:errors path="idProduit" cssClass="errors"
						style="color:red;"></moussaid:errors></td>
			</tr>
			<tr>
				<td>DESIGNATION</td>
				<td><moussaid:input path="designation" /></td>
				<td><moussaid:errors path="designation" cssClass="errors"
						style="color:red;"></moussaid:errors></td>
			</tr>
			<tr>
				<td>CATEGORIE</td>
				<td><moussaid:select path="catego.idCategorie"
						items="${ categories}" itemValue="idCategorie"
						itemLabel="nomCategorie" /></td>
				<td><moussaid:errors path="catego.idCategorie"
						cssClass="errors" style="color:red;"></moussaid:errors></td>
			</tr>
			<tr>
				<td>DESCRIPTION</td>
				<td><moussaid:textarea path="description" /></td>
				<td><moussaid:errors path="description" cssClass="errors"
						style="color:red;"></moussaid:errors></td>
			</tr>
			<tr>
				<td>PRIX</td>
				<td><moussaid:input path="prix" /></td>
				<td><moussaid:errors path="prix" cssClass="errors"
						style="color:red;"></moussaid:errors></td>
			</tr>
			<tr>
				<td>QUANTITE</td>
				<td><moussaid:input path="quantite" /></td>
				<td><moussaid:errors path="quantite" cssClass="errors"
						style="color:red;"></moussaid:errors></td>
			</tr>

			<tr>
				<td>PHOTO</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="submit" value="save"></td>
			</tr>

		</table>
	</moussaid:form>
</div>
<div class="cadre">
	<moussaid:form>
		<table>
			<tr>
				<td><a href="toCat">ReturnToCategorie</a></td>
			</tr>
		</table>
	</moussaid:form>
</div>
<div class="cadre">
	<table>
		<tr>
			<td><a href="users">Users</a></td>
		</tr>
	</table>
</div>
<div class="cadre">${exception}</div>
<div id="tabProd" class="cadre">
	<soufiane:choose>
		<soufiane:when test="${empty produits}">
			<h2 style="color: red;">Sorry, -- ${mc} -- doesn't exist in our
				list</h2>
		</soufiane:when>
		<soufiane:otherwise>
			<table class="tab1">
				<tr>
					<th>DESIGNATION</th>
					<th>DESCRIPTION</th>
					<th>CATEGORIE</th>
					<th>PRIX</th>
					<th>QUANTITE</th>
					<th>PHOTO</th>
				</tr>
				<soufiane:forEach items="${produits}" var="prod">
					<tr>

						<td>${prod.designation}</td>
						<td>${prod.description}</td>
						<td>${prod.catego.nomCategorie}</td>
						<td>${prod.prix}</td>
						<td>${prod.quantite}</td>

						<td><img src="photoProd?idProd=${prod.idProduit}" /></td>

						<td><a href="seeProd?idProd=${prod.idProduit  }">see</a></td>
						<td><a href="editProd?idProd=${prod.idProduit  }">edit</a></td>
						<td><a href="suppProd?idProd=${prod.idProduit }">delete</a></td>
					</tr>
				</soufiane:forEach>
			</table>
		</soufiane:otherwise>
	</soufiane:choose>

</div>
<div>
	<td><a href="logout">let's try loging out</a></td>
</div>
