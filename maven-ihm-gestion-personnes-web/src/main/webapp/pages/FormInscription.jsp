<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./assets/css/style.css">
<script src="./assets/js/script.js" type="text/javascript"></script>
<title>Formulaire d'inscription</title>
</head>
<body>
	<h1>Bienvenue dans votre formulaire d'inscription !</h1>
	<%-- ${pageContext.request.contextPath} --%>
	<form action="/maven-ihm-gestion-personnes-web/PersonneServlet" method="post">
		<div>
			<label for="nom">Nom :</label> <input type="text" id="nom"
				name="userName" />
		</div>
		<div>
			<label for="courriel">Courriel :</label> <input type="email"
				id="courriel" name="userEmail" />
		</div>
		<div>
			<label for="message">Message :</label>
			<textarea id="message" name="userMessage"></textarea>
		</div>
		<div class="button">
			<button type="submit">Envoyer votre message</button>
		</div>
	</form>
</body>
</html>