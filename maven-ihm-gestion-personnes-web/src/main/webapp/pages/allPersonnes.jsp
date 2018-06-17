<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dao.factory.complexe.AbstractDaoFactory"%>
<%@ page
	import="com.dao.factory.complexe.AbstractDaoFactory.FactoryType"%>


<%@ page import="com.cours.entities.Personne"%>

<%
    Personne p = new Personne();
    p = (Personne) request.getAttribute("personne");
    if (null == p.getPrenom())
    {
        p.setPrenom("Toto");
        p.setNom("Tata");

    }

    List<Personne> listPersonne = new ArrayList<Personne>();
    if (request.getAttribute("listPersonne") != null)
    {
        listPersonne = (List<Personne>) request.getAttribute("listPersonne");
        //listPersonne = AbstractDaoFactory.getDaoFactory(FactoryType.SQL_DAO).getPersonneDao().findAll();
    }
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gestion Personnes</title>
<!-- CSS files -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800|Oswald:300,400,500,600,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./assets/css/master.css">
<link rel="icon" href="./assets/images/favicon.png" type="image/x-icon">

</head>
<body>
	<div class="outer">
		<div class="header-outer" id="header-outer">
			<!-- Header -->
			<header id="header" class="header">
				<div class="header padd-top">
					<a
						href="http://elhadji-gaye.fr/interface-graphique-exercice/gestion-personnes"
						title="Gestion Personnes" class="logo"> <img
						src="./assets/images/logo/logo.png" alt="Gestion Personnes">
					</a>
				</div>
		</div>
		</header>
	</div>
	<!-- Section -->
	<section>
		<div class="content">
			<div class="User export">
				<h2 style="margin-top: 20px; display: inline-block;">
					Bonjour <strong> <%
     out.println(p.getPrenom());
 %></strong> avec
					l'adresse :
					<%
     out.println(p.getRue());
 %>,
					<%
     out.println(p.getCodePostal());
 %>
					<%
					    out.println(p.getVille());
					%>, France.
				</h2>

				<h1 class="logout">
					<a href="index.html" role="button">Se Deconnecter</a>
				</h1>
				<ul class="User f-left">
					<li><a href="#" role="button">Export des Personnes au
							format Csv</a></li>
					<li><a href="#" role="button">Export des Personnes au
							format XML</a></li>
					<li><a href="#" role="button">Export des Personnes au
							format Json</a></li>
				</ul>
				<h1 class="clearfix">liste des Personnes</h1>


				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Prénom</th>
								<th>Nom</th>
								<th>Poids</th>
								<th>Taille</th>
								<th>Adresse</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<%
							    for (int i = 0; i < listPersonne.size(); i++)
							    {
							%>
							<tr>
								<td>
									<%
									    out.println(listPersonne.get(i).getPrenom());
									%>
								</td>
								<td>
									<%
									    out.println(listPersonne.get(i).getNom());
									%>
								</td>
								<td>
									<%
									    out.println(listPersonne.get(i).getPoids());
									%>
								</td>
								<td>
									<%
									    out.println(listPersonne.get(i).getTaille());
									%>
								</td>
								<td>
									<%
									    out.println(listPersonne.get(i).getRue());
									%>
								</td>
								<td><a
									href="pages/updatePersonne.jsp?id=<%out.println(listPersonne.get(i).getIdPersonne());%>"><i
										class="fa fa-edit"></i></a> <a
									href="pages/deletePersonne.jsp?id=<%out.println(listPersonne.get(i).getIdPersonne());%>"><i
										class="fa fa-trash-o"></i></a></td>
							</tr>
							<%
							    }
							%>
						</tbody>
					</table>
					<ul class="User">
						<li><a href="addPersonne.html" role="button">Ajouter
								Personne</a></li>
						<li><a href="#" role="button">Import de personnes Ã 
								partir d'un fichier CSV</a></li>
					</ul>
				</div>

			</div>
		</div>
	</section>
	<!-- Footer -->
	<footer>
		<div class="footer-container ">
			<div class="footer">
				<div class="footer-middle">
					<div class="footer-container_">
						<div class="row no-gutters">
							<div class="col-sm-6 col-md-3">
								<div class="block">
									<div class="block-title">
										<strong><span>Contactez Nous</span></strong>
									</div>
									<div class="block-content">
										<ul class="contact-info">
											<li><i class="icon-location">&nbsp;</i>
												<p>
													<b>Addresse:</b><br>123 Rue la victoire, 75000 Paris,
													France
												</p></li>
											<li><i class="icon-phone">&nbsp;</i>
												<p>
													<b>Tél:</b><br>(+33) 00 11 00 11 00
												</p></li>
											<li><i class="icon-mail">&nbsp;</i>
												<p>
													<b>Email:</b><br> <a href="mailto:mail@example.com">mail@example.com</a>
												</p></li>
											<li><i class="icon-clock">&nbsp;</i>
												<p>
													<b>Horaire : </b><br>Lundi au Samedi
												</p></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="block">
									<div class="block-title">
										<strong><span>Mon compte</span></strong>
									</div>
									<div class="block-content">
										<ul class="links">
											<li><i class="icon-right-dir theme-color"></i><a
												href="#" title="A propos de nous">Mon compte</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="block">
									<div class="block-title">
										<strong><span>Information</span></strong>
									</div>
									<div class="block-content">
										<ul class="features">
											<li><i class="icon-ok theme-color"></i><a href="#">Les
													informations</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="block">
									<div class="block-title">
										<strong><span>Nos Services</span></strong>
									</div>
									<div class="block-content">
										<ul class="features">
											<li><i class="icon-ok  theme-color"></i><a href="#">Service
													Client</a></li>
											<li><i class="icon-ok  theme-color"></i><a href="#">Politique
													d'Utilisation</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="footer-bottom">
					<div class="footer-container_">
						<address>Â© Gestion Personnes. 2018. Tous droit
							rÃ©servÃ©</address>
					</div>
				</div>
			</div>
		</div>
	</footer>
	</div>
	<!-- JS files -->
	<script src="./assets/js/bower.js" type="text/javascript"></script>
	<script src="./assets/js/application.js" type="text/javascript"></script>
</body>
</html>
