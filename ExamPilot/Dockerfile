# Use OpenJDK 21 as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml first (for better caching)
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn

# Make the Maven wrapper executable
RUN chmod +x ./mvnw

# Copy the source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port that the application runs on
EXPOSE 8084

# Set environment variables with defaults
ENV SPRING_PROFILES_ACTIVE=prod
ENV PORT=8084

# Run the jar file
CMD ["java", "-jar", "target/ExamPilot-0.0.1-SNAPSHOT.jar"]
