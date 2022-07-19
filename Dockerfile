FROM adoptopenjdk/openjdk11:latest
WORKDIR /app
COPY RabbitMQAPI/target/rabbitmq_api-0.0.5.jar /app/rabbitmq_api.jar
ENTRYPOINT ["java", "-jar", "rabbitmq_api.jar"]
