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

# MongoDB environment variables (set these when running the container)
ENV MONGODB_USERNAME=""
ENV MONGODB_PASSWORD=""
ENV MONGODB_CLUSTER=""
ENV MONGODB_DATABASE=""

# Admin configuration environment variables
ENV ADMIN_USERNAME=""
ENV ADMIN_PASSWORD=""
ENV ADMIN_EMAIL=""

# JWT configuration environment variables
ENV JWT_SECRET=""
ENV JWT_EXPIRATION=""

# Security configuration environment variables
ENV SECURITY_USERNAME=""
ENV SECURITY_PASSWORD=""
ENV SECURITY_ROLES=""

# CORS configuration environment variables
ENV CORS_ALLOWED_ORIGINS=""

# Run the jar file
CMD ["java", "-jar", "target/ExamPilot-0.0.1-SNAPSHOT.jar"]
