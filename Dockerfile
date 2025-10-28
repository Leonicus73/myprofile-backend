# Use ARM64-compatible OpenJDK base image
FROM arm64v8/eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy your Maven-built JAR into the container
COPY target/myprofile-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose backend port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]