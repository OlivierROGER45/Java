<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gestion Personnes</title>
        <!-- CSS files -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800|Oswald:300,400,500,600,700" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/master.css"> 
        <link rel="icon" href="../assets/images/favicon.png" type="image/x-icon">

    </head>
    <body>
        <div class="outer">
            <div class="header-outer" id="header-outer">
                <!-- Header -->
                <header id="header"  class="header">
                    <div class="header padd-top">
                        <a href="http://elhadji-gaye.fr/interface-graphique-exercice/gestion-personnes" title="Gestion Personnes" class="logo"> 
                            <img src="./assets/images/logo/logo.png" alt="Gestion Personnes"> 
                        </a>
                    </div>
                </header>
            </div>
            <!-- Section -->
            <section>
                <div class="content">
                    <div class="account-login">
                        <div class="page-title">
                            <h1>Identifiez vous</h1>
                        </div>
                     <form class="login-form" action="/maven-ihm-gestion-personnes-web/HomeServlet" method="Post" id="customer-info-form"> 
                            <div class="row">
                                <div class="col-md-5 registered-users">
                                    <div>
                                        <h2>CONNECTEZ-VOUS</h2>
                                        <p>On se connait déjà  ?</p>
                                        <p>Connectez-vous avec votre <strong>Prénom </strong> et votre <strong>Nom</strong> pour accéder Ã  votre espace client.</p>
                                        <ul class="form-list">
                                            <li>
                                                <label for="Prenom" class="required">Prénom<em>*</em></label>
                                                <div class="input-box">
                                                    <input type="text" name="firstname" value="" id="Prenom" class="input-text" title="Prenom">
                                                </div>
                                            </li>
                                            <li>
                                                <label for="Nom" class="required">Nom<em>*</em></label>
                                                <div class="input-box">
                                                    <input type="text" name="lastname" class="input-text" id="Nom" title="Nom">
                                                </div>
                                            </li>
                                        </ul>
                                        <p class="required-msg">* champs obligatoires</p>
                                    </div>
                                    <br>
                                    <button class="btn btn-default" type="submit">Connexion</button>
                                </div>
                            </div>
                        </form>

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
                                            <div class="block-title"><strong><span>Contactez Nous</span></strong></div>
                                            <div class="block-content">
                                                <ul class="contact-info">
                                                    <li><i class="icon-location">&nbsp;</i><p><b>Addresse:</b><br>123 Rue la victoire, 75000 Paris, France</p></li>
                                                    <li><i class="icon-phone">&nbsp;</i><p><b>Tél:</b><br>(+33) 00 11 00 11 00</p></li>
                                                    <li><i class="icon-mail">&nbsp;</i><p><b>Email:</b><br><a href="mailto:mail@example.com">mail@example.com</a></p></li>
                                                    <li><i class="icon-clock">&nbsp;</i><p><b>Horaire : </b><br>Lundi au Samedi</p></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 col-md-3"><div class="block">
                                            <div class="block-title"><strong><span>Mon compte</span></strong></div>
                                            <div class="block-content">
                                                <ul class="links">
                                                    <li><i class="icon-right-dir theme-color"></i><a href="#" title="A propos de nous">Mon compte</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>                

                                    <div class="col-sm-6 col-md-3"><div class="block">
                                            <div class="block-title"><strong><span>Information</span></strong></div>
                                            <div class="block-content">
                                                <ul class="features">
                                                    <li><i class="icon-ok theme-color"></i><a href="#">Les informations</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-6 col-md-3">
                                        <div class="block">
                                            <div class="block-title"><strong><span>Nos Services</span></strong></div>
                                            <div class="block-content">
                                                <ul class="features">
                                                    <li><i class="icon-ok  theme-color"></i><a href="#">Service Client</a></li>
                                                    <li><i class="icon-ok  theme-color"></i><a href="#">Politique d'Utilisation</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>              
                                </div>
                            </div>
                        </div>
                        <div class="footer-bottom">
                            <div class="footer-container_">               
                                <address>A Gestion Personnes. 2018. Tous droit réservé</address>
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
