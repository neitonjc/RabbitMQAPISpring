FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=RabbitMQAPI/target/*.jar
COPY ${JAR_FILE} RabbitMQAPI/target/rabbitmq_api-0.0.5.jar
ENTRYPOINT ["java", "-jar", "rabbitmq_api.jar"]
