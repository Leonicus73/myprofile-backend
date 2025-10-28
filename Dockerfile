# Use a lightweight OpenJDK base image for ARM64
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR into the container
COPY build/libs/myprofile-backend.jar app.jar

# Expose the backend port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]