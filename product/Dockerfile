# Start with a base image that has Java 17 installed
FROM openjdk:17-jdk-slim

WORKDIR /app
# Copy the Spring Boot application JAR file into the Docker image
COPY build/libs/product-0.0.1-SNAPSHOT.jar /app/product-app.jar

EXPOSE 8080

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/product-app.jar"]