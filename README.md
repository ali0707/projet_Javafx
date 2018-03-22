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

<h4>Creation d'une fonctionnalité :</h4>
<ol>
  <li>Créer un service dans le package services</li>
  <li>Ajouter "extends CommunService"</li>
  <li>Implementer les methodes du services</li>
  <li>Créer l'interface graphique et les méthodes du controlleur</li>
</ol>

<h4>Classes importantes</h4>
<ul>
  <li><strong>Core/DBConnection :</strong> Fournit la connection avec la BD (vous devez changer le username, password et dbname quand vous faites un clone du projet </li>
  <li><strong>Services/CommunsService :</strong> Contients les fonctionnalitées communs de tous les services et l'instance de la connection BD
  </li>
</ul>
  
