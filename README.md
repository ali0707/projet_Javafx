# KODJavaFX
<h2>Mode d'emploi</h2>

<h4>Structure du projet</h4>
<ul>
  <li><strong>Controllers :</strong> Les controlleurs</li>
  <li>
    <strong>Core :</strong> contient les composants globaux du projet
    <br>DBConnection pour la connection avec la base de données
    <br>Main contient la fonction main()
  </li>
  <li><strong>Dependencies :</strong> Contient les bibliothèques externes du projet</li>
  <li><strong>Controllers :</strong> Les controlleurs</li>
  <li><strong>GUI :</strong> Contient les interfaces graphiques (fichiers .fxml)</li>
  <li><strong>Services :</strong> Contient les classes d'interaction avec la base de données </li>
</ul>
  
<h4>Bibliothèques utilisées</h4>
<ul>
  <li><strong><a href="https://github.com/kayahr/pherialize">Pherialize</a> :</strong> Pour la de/serialisation des objets comme PHP</li>
</ul>  

<h4>Utilisation :</h4>
<ol>
    <li>Cloner le projet</li>
    <li>Créer un projet netbeans dans le dossier du projet</li>
    <li>Ajouter la biliothèque "mysql-connector-java" dans le projet</li> 
    <li>Changer le nom de la BD dan DBConnection.DBname</li>
    <li>Ajouter vos fonctionnalités</li>
</ol>

<h4>Création d'une fonctionnalité :</h4>
<ol>
    <li>Ajouter les élements de votre menu dans la partie TODO dans la méthode init() du HeaderController dans le menu correspondant</li>
    <li>Traiter les actions de clics de chaque bouton du menu</li>
    <li>Créer un service dans le package services</li>
    <li>Ajouter "extends Service"</li>
    <li>Implementer les méthodes du service</li>
    <li>Créer une interface graphique contenant seulement la partie principale de la page</li>
    <li>Créer un controlleur avec une méthode init() qui charge le fichier fxml crée et mettre son contenu dans Main.pane.setCenter() (voir IndexController)</li>
</ol>
  
# projet_Javafx
