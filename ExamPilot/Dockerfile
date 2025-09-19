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
ENV MONGODB_DATABASE="exam_scheduler"

# Admin configuration environment variables
ENV ADMIN_USERNAME="admin"
ENV ADMIN_PASSWORD="admin123"
ENV ADMIN_EMAIL="admin@examscheduler.com"

# JWT configuration environment variables
ENV JWT_SECRET="mySecretKey"
ENV JWT_EXPIRATION="86400"

# Security configuration environment variables
ENV SECURITY_USERNAME="admin"
ENV SECURITY_PASSWORD="admin123"
ENV SECURITY_ROLES="ADMIN"

# CORS configuration environment variables
ENV CORS_ALLOWED_ORIGINS="http://localhost:3000,http://localhost:3001,http://localhost:5173,https://*.netlify.app"

# Run the jar file
CMD ["java", "-jar", "target/ExamPilot-0.0.1-SNAPSHOT.jar"]
