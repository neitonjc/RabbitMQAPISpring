FROM adoptopenjdk/openjdk11:latest
WORKDIR /app
COPY RabbitMQAPI/target/rabbitmq_api.jar /app/rabbitmq_api.jar
ENTRYPOINT ["java", "-jar", "rabbitmq_api.jar"]
