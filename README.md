# Implementation des tests
> Implémentation des tests unitaires et d'intégration pour la partie back de l'application [Back Stock Car](https://github.com/BriceRsl/esieaBack/ "Back Stock Car").

## Prérequis
1. Les tests d'intégration testent la base de données en situation réelle (ajout, suppression d'éléments etc), il faut donc mettre en place la base de données du projet [esieaBack](https://github.com/BriceRsl/esieaBack/ "esieaBack"), avec les droits accès de base au niveau de la configuration (l'user stockcar)
2. Il faut maven installé sur la machine, pour lancer la série de test

## Installation et execution des tests

1. Cloner le dépôt
2. se mettre au niveau du projet esieaBack, et lancer la commande `mvn test`