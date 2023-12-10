FROM openjdk:17
EXPOSE 8084
ADD target/webdistribue-0.0.1-SNAPSHOT.jar Webdistribue-docker.jar
ENTRYPOINT ["java", "-jar", "Webdistribue-docker.jar"]

