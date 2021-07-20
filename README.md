# RabbitMQAPISpring
Projeto contendo aplicações Java Spring produzindo e consumindo mensagens síncronas e assíncronas utilizando o RabbitMQ

Config Docker(docker-compose.yml)
services:
    rabbitmq:
        image: rabbitmq:3-management
        container_name: rabbitmq
        restart: always
        ports: 
            - 5672:5672
            - 15672:15672
        volumes:
            - ./dados:/var/lib/rabbitmq/
        environment:
            - RABBITMQ_DEFAULT_USER=admin
            - RABBITMQ_DEFAULT_PASS=admin
 --
 
 Navegar até a pasta onde está o arquivo docker-compose.yml via cmd e executar o comando: docker-compose up -d
