# Exercice Compte Bancaire 
## Objectif

Ce projet est une simple implémentation d'un système de gestion de compte bancaire personnel.

Il démontre :
- Une architecture inspirée de l’architecture Hexagonal mais simplifiée (sans les interfaces métoers ports)
- Une API REST
- Des tests (JUnit + Cucumber)

## Fonctionnalités

- Faire un **dépôt** (`POST /api/deposit`)
- Faire un **retrait** (`POST /api/withdrawal`)
- Consulter le **relevé de compte** (`GET /api/statement`)



## Structure du projet

- `domain` : logique métier (Compte, Transaction).
- `application` : services métiers (Dépôt, Retrait).
- `web` : contrôleurs REST
- `infrastructure` : outils techniques (impression console..)
- `config` : configuration Spring Boot
- `test` : JUnit & Cucumber

## Lancement de l'application Spring Boot

Lancez l'application avec :

```bash
mvn spring-boot:run
```

Accès API : [http://localhost:9092](http://localhost:9092) => redirige vers swagger-ui [http://localhost:9092/swagger-ui/index.html](http://localhost:9092/swagger-ui/index.html)

## Lancer tous les tests (JUnit + Cucumber)

```bash
mvn test
```

## Technologies

- Java 17 +
- Spring Boot 3 +
- Cucumber 7 +
- JUnit 5
