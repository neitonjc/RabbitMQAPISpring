FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=RabbitMQAPI/target/*.jar
COPY ${JAR_FILE} RabbitMQAPI/target/rabbitmq_api.jar
ENTRYPOINT ["java", "-jar", "/app/rabbitmq_api.jar"]
