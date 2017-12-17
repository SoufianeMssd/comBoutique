<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="moussaid" %>
<%@page session="true"%>
<html>
<head>
<title>SignIN Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 570px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

	

	<div id="login-box">

		<h2>Inscription du l'utilisateur</h2>
 

		<moussaid:form name="f1" modelAttribute="utilisateur" action="signIn" method="post" >
	<table>
		
		<tr>
			<td>Username</td>
			<td><moussaid:input path="userName" name="username"/></td>
			<td><moussaid:errors path="userName" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><moussaid:input name="pass1" type='password' path="password"/></td>
			<td><moussaid:errors path="password" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>Re-enter Password</td>
			<td><moussaid:input name="pass2" type='password' path="confirmPassword" /></td>
			<td><moussaid:errors path="confirmPassword" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><moussaid:input name="email" type='text' path="email" /></td>
			<td><moussaid:errors path="email" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><moussaid:input path="country" name="country"/></td>
			<td><moussaid:errors path="country" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>City</td>
			<td><moussaid:input path="city" name="city"/></td>
			<td><moussaid:errors path="city" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td>PhoneNumber</td>
			<td><moussaid:input  path="phoneNumber" name="phonenumber"/></td>
			<td><moussaid:errors path="phoneNumber" cssClass="errors"></moussaid:errors></td>
		</tr>
		<tr>
			<td><input type="submit" value="SignIN" ></td>
		</tr>
		<tr>
			<td><a href="toLogin" type="button">Login</a></td>
		</tr>
		
	</table>
	</moussaid:form>
</div>
</body>
</html>