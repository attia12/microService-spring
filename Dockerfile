FROM openjdk:17
EXPOSE 8093
ADD target/Reclamations-0.0.1-SNAPSHOT.jar Reclamations-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","Reclamations-0.0.1-SNAPSHOT.jar"]