# Utiliser une image de base Java
FROM openjdk:21

# Ajouter un volume pour stocker temporairement les données
VOLUME /tmp

# Ajouter le fichier .jar de votre application
ADD target/rabbitmq-0.0.1-SNAPSHOT.jar rabbitmq-0.0.1-SNAPSHOT.jar

# Exposer le port sur lequel votre application s'exécute
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/rabbitmq-0.0.1-SNAPSHOT.jar"]