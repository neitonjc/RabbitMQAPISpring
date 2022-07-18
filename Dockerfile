FROM adoptopenjdk/openjdk11:latest
EXPOSE 8081
ADD RabbitMQAPI/target/rabbitmq_api-0.0.2.jar rabbitmq_api-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/opt/app/rabbitmq_api.jar"]
