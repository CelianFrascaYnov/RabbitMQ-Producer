# TP RabbitMQ Producer

Réalisation d'un TP rabbitMQ avec Spring Boot dans le cadre d'un TP pour le cours de WebService.

## Prérequis

- Docker
- Docker Compose

## Installation et Lancement

### Cloner le Répertoire

Clonez le dépôt Git :

```bash
git clone https://github.com/CelianFrascaYnov/RabbitMQ-Producer.git
cd RabbitMQ-Producer
```

## Construire l'Image Docker et Démarrer avec Docker Compose

Construisez l'image Docker et lancer votre application avec :
```bash
docker-compose up --build
```

Votre application devrait maintenant être accessible à l'adresse `http://localhost:8080`.
RabbitMQ devrait être accessible à l'adresse `http://localhost:15672`.

## Utilisation

Vous pouvez maintenant faire une requête de création à `http://localhost:8080/users`

Pour effectuer des requêtes, vous pouvez utiliser Postman :

post : `http://localhost:8080/users`

Body : 
```json
{
    "name": "John Doe",
    "email": "john@example.com"
}
```