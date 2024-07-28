# Srping Microservices 

## Table of Contents
* About the project.
* Patters.
* Technologies.
* Setup.
* Check and Play.
* References

### About

We build a simple e-commerce microservice


BDD architecture splitting up in domains all aur logics business we were able to create
separate domains that can be translated as a service:

* order - services.
* Product - services.
* user - services.

The second stage in this project is apply common microservices patters to make
or system resilient, fault-tolerant, loose coupled and scalable:
### Patters:
* Gateway: Will apply common routing between services given as ability to point to
  a single point make our client agnostic about infra structure in the back end.
* Registry Service: An microservice architecture needs to know somehow where and which services are available
  then we implement a service discovery where any single services in our system will register in.

Last but not the least we added Containerization we go for Docker as a container platform where we can ready an up
all our system in a single script using docker-composer. All needed script are available in
script folder.

Our system is cloud friendly now, scalable and resilient, etc.

## Technologies:
1. Java 17.
2. Spring Boot 3.2.2
3. Spring Cloud 2023.0.3 (Gateway,Service discovery).
4. Docker.
5. Docker-compose v3.

## Setup:
1. Clone project.
2. Let's create all service images.
  ```shell
  cd ../scripts
  ./create-images.sh
  ```
3. checks all images were created.
```shell
docker images
```
4. start up all the services
```shell
cd ../scripts
docker-compose up
```
6.1 scalability after run step 4 we can scale.
````shell
docker-compose up --scale order-service=2 --scale product-service=2
````

## Check and play
* Interface should run in localhost:8080/api/

## Future actions:
* Load Balancer: Comes handy when we set up many instances of our services
  Front end do not need to know how to balance request instead we use Load balancer.
* Centralized logs: once all aur service are go and up ich service will own its logs track potential bugs or errors will become in a nightmare
    then we apply centralized logs to channel all logs to a specific place. also
    we apply a traceable logs technics to track down logs "AWS CloudWatch".
* A part of mentioned above, we also implement a event-drive-architecture by applying these we can gain loose couple
  since now our microservices can share message between in a non-blocking fashion just publishing events and subscribing to tehm
  to achieve this project go for RabbitMQ for tracing logs and messages sharing.
