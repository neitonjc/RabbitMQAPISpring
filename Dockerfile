FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rabbitmq_api.jar
ENTRYPOINT ["java", "-jar", "/rabbitmq_api.jar"]
