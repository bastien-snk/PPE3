# PPE3 - BTS SIO - Logiciel de vente

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Le logiciel Perpi&Co est un logiciel développé en Java 8 qui permettra à votre entreprise de gérer son système de vente de manière instantanée et de pouvoir effectuer des ventes au près des clients.

### Nouveaux ajouts 🏷️

  - Ajout de la Javadoc, tout nos fichiers sont désormais commentés pour que vous puissez les éditer et nous proposer des forks ! ⌨️
  - Génération des factures de ventes en fichier PDF 💴
  - Ajout de la première pre-release du logiciel pour l'adapter dans vos entreprises ! ⚙️

### Pré-requis ⚠️

Pour pouvoir éditer le logiciel, vous devrez disposer des ressources suivantes:

* [IDE] - Un environnement de développement integré pour pouvoir visualiser, éditer et compiler le logiciel 🚇
* [Development Kit] - Kit de développement de Java en version 1.8 ♨️
* [Maven] - Outil de gestion et d'automatisation de production des projets logiciels en Java 🌊
* [Swing] - Bibliothèque graphique de Java 📚
* [SQL] - Un serveur de Base de données (PhpMyAdmin) ainsi que le language de requêtes SQL (MySQL) installés 📚

### Installation 📁

Pour installer le JAR, il suffit de cloner le repository et d'ouvrir le fichier:

```sh
mkdir PPE3
cd PPE3
git clone https://github.com/rootxls/PPE.git
```

Pour que le logiciel soit fonctionnel, il vous faut installer MySQL et PHPMyAdmin, il est possible de les installer grâce à WAMP (Windows), pour les utilisateurs de Linux voici un tutoriel: http://elisabeth.pointal.org/doc/code/server/lamp/phpmyadmin

Il vous faudra ensuite installer la base de données du logiciel:
 - Connectez vous sur PHPMyAdmin
 - Allez sur la page Importer
 - Cliquez sur choisir un fichier (cela vous ouvre un Explorateur de fichiers)
 - Rendez-vous dans le dossier PPE3 que nous avons fait auparavant
 - Séléctionnez le fichier PPE3.sql
 - Cliquez sur le boutton "Go"
 
 Ensuite, ouvrez le projet sur votre IDE, et maintenant, modifiez les informations de connexion au serveur MySQL (DataAccessObject.java), vous devrez changer:
 
 - L'IP par celle de votre serveur
 - Le port par celui que vous utilisez (si vous avez modifié le port de MySQL)
 - Les identifiants de connexion (username:password)
 
 En dernier temps, vous devrez accéder au FactureManager et modifier le chemin de sauvegarde des factures.
 
### Documentation ✏️

  - 📖 Documentation (développeurs & administrateurs) - https://docs.google.com/document/d/1pU1T9iv3ZP5yI126A3Z7TMTweKYT6JHhjVJc9FrccGs/edit?usp=sharing
  - 📖 Documentation (utilisateurs) - https://docs.google.com/document/d/1d3BfzXZf-edxrizproyTgFypcrfB59D74jVE4QkD7Qs/edit?usp=sharing
