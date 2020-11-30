TP 1/2

Etape 5 :

	— Web : Permet de construire des applications Web avec le modèle MVC de Spring
	— JPA : Permet la persistance des données SQL et le lien avec Hibernate
	— Hibernate : Framework qui transforme les objets SQL en objets Java et inversement
	— H2 : Base de données SQL pour Java in-memory
	— DevTools : Ajoute des outils de Spring pour faciliter le développement (Redémarrage plus rapide de l'appli par exemple)
	— Thymeleaf : Permet de créer des modèles et de faciliter leur affichage en HTML sur tous les navigateurs
	
Etape 13 :

	1. Avec quelle partie du code avons-nous paramétré l’url d’appel /greeting ?
	
	Dans la classe HelloWorldController, le décorateur @GetMapping("/greeting") permet d'appeler la fonction juste en dessous du décorateur, dès qu'un utilisateur veut accéder à /greeting
	
	2. Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?
	
	La méthode sous le décorateur retourne un string qui indique le fichier à afficher
	
	3. Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?
	
	Il suffit de passer le nom, représenté par l'attribut getNAME, dans l'URL:
	http://localhost:8080/greeting?nameGET=MettreLeNomIci

Etape 17 :

	On voit désormais la table ADDRESS et ses différents champs sur l'interface d'H2
	
Etape 18 :

	Le décorateur @Entity au dessus de la classe Address, qui provient de l'api javax.persistence.Entity (JPA) permet de faire le lien avec Hibernate, qui crée automatiquement la table associée à la classe
	
Etape 20 :
	
	La requête SELECT * FROM ADDRESS me permet effectivement d'afficher toutes les informations provenant du fichier data.sql
 
 	ID  	CONTENT  								CREATION  
	1		57 boulevard demorieux					2020-11-30
	2		51 allee du gamay, 34080 montpellier	2020-11-30

Etape 23 :

	D'après la doc de Spring, l'annotation @Autowired sur un champs lui permet d'être automatiquement relié aux injections de dépendances de Spring 
	
Etape 30 : 

	J'utilise Bootstrap à l'aide de CDN (https://www.bootstrapcdn.com)
	
TP 2/2

Etape 6 :

	— Faut-il une clé API pour appeler OpenWeatherMap ?
	
	Il faut une clé pour toutes les requêtes à placer dans l'url à la place de Api Key -> api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	
	— Quelle URL appeler ?
	
	J'utilise l'url ci-dessous afin d'avoir un résultat en fonction de coordonnées gps
	api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
	
	— Quelle méthode HTTP utiliser ?
	
	GET avec RestTemplate
	
	— Comment passer les paramètres d’appels ?
	
	Je construis une string en concaténant les différentes parties de l'URL avec les paramètres
	
	— Où est l’information dont j’ai besoin dans la réponse :
		— Pour afficher la température du lieu visé par les coordonnées GPS
		
		main -> temp
		
		— Pour afficher la prévision de météo du lieu visé par les coordonnées GPS
		
		weather -> description
