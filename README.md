Présentation du projet

Cette application Android est développée en Kotlin dans le but d’apprendre les bases du développement mobile.
Elle permet de gérer une liste de personnes (Person) à travers une interface simple et intuitive.



--Structure du projet

Le projet est organisé en plusieurs packages pour rendre le code propre et facile à comprendre :
- `adapter` : contient l’adapter du RecyclerView.
- `entity` : contient la classe Person.
- `service` : contient la gestion des données (liste des personnes).
- Les activities (`MainActivity`, `DetailsActivity`, `addPersonActivity`, `updatePersonActivity`) sont placées directement dans le dossier principal du projet.

Cette structure reste simple et facile à comprendre pour un débutant.



--Fonctionnement de l’application

L’application contient 4 activities principales :
1. Une activity pour afficher la liste des personnes.
2. Une activity pour ajouter une nouvelle personne.
3. Une activity pour afficher les détails d’une personne.
4. Une activity « À propos » qui présente des informations sur l’application.

Les données sont stockées localement en mémoire, sans utiliser de base de données.



--RecyclerView

Le RecyclerView est utilisé pour afficher dynamiquement la liste des personnes.
Chaque personne est affichée dans une carte (CardView) avec ses informations principales.



--Emplacement des captures d’écran

Les captures d’écran des différentes activities doivent être placées dans un dossier nommé :


Les images sont placées dans le même dossier que ce fichier README.

### MainActivity – Liste des personnes
![MainActivity](https://github.com/abderrafia20/App-recycleV-Adapter/blob/main/main.jpeg)

---

### AddPersonActivity – Ajouter une personne
![AddPersonActivity](https://github.com/abderrafia20/App-recycleV-Adapter/blob/main/add.jpeg)

---

### DetailsActivity – Détails de la personne
![DetailsActivity](https://github.com/abderrafia20/App-recycleV-Adapter/blob/main/details.jpeg)

---

### UpdatePersonActivity – Modifier une personne
![UpdatePersonActivity](https://github.com/abderrafia20/App-recycleV-Adapter/blob/main/update.jpeg)

