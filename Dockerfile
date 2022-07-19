FROM adoptopenjdk/openjdk11:latest
ADD RabbitMQAPI/target/rabbitmq_api.jar rabbitmq_api.jar
ENTRYPOINT ["java", "-jar", "/opt/app/rabbitmq_api.jar"]
