# Use OpenJDK 17 slim image as base
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy everything into the container
COPY . .

# Make Maven wrapper executable
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw clean install -DskipTests

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "Class_Model_Business/target/Class_Model_Business-0.0.1-SNAPSHOT.jar"]
