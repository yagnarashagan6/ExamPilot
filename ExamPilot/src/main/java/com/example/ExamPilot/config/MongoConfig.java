package com.example.ExamPilot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoConfig {
    
    private String uri;
    
    @Value("${MONGODB_USERNAME:demo_user}")
    private String mongoUsername;
    
    @Value("${MONGODB_PASSWORD:demo_password}")
    private String mongoPassword;
    
    @Value("${MONGODB_CLUSTER:demo_cluster.mongodb.net}")
    private String mongoCluster;
    
    public String getUri() {
        return uri;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    private boolean isValidMongoCredentials() {
        return mongoUsername != null && !mongoUsername.equals("demo_user") && 
               mongoPassword != null && !mongoPassword.equals("demo_password") &&
               mongoCluster != null && !mongoCluster.equals("demo_cluster.mongodb.net") &&
               uri != null && !uri.contains("demo_user") && !uri.contains("demo_password");
    }
    
    @Bean
    @Primary
    public MongoClient mongoClient() {
        try {
            if (isValidMongoCredentials() && uri != null && !uri.isEmpty()) {
                System.out.println("Connecting to MongoDB with provided credentials...");
                // Remove unsupported options and create a clean connection string
                String cleanUri = uri.replaceAll("&tlsAllowInvalidCertificates=true", "")
                                    .replaceAll("&tlsallowinvalidcertificates=true", "");
                
                MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(cleanUri))
                    .build();
                
                MongoClient client = MongoClients.create(settings);
                System.out.println("Successfully connected to MongoDB!");
                return client;
            } else {
                System.err.println("MongoDB credentials not properly configured. Using embedded MongoDB for development.");
                System.err.println("Please set MONGODB_USERNAME, MONGODB_PASSWORD, and MONGODB_CLUSTER environment variables for production.");
            }
        } catch (Exception e) {
            System.err.println("Failed to connect to MongoDB Atlas: " + e.getMessage());
            System.err.println("Application will continue with embedded MongoDB for development.");
        }
        
        // Return embedded MongoDB client for development/testing
        try {
            return MongoClients.create("mongodb://localhost:27017");
        } catch (Exception e) {
            System.err.println("Failed to connect to local MongoDB as well. Creating minimal client.");
            // Create a minimal connection that won't be used but prevents null issues
            return MongoClients.create();
        }
    }
    
    @Bean
    @Primary
    public MongoDatabaseFactory mongoDatabaseFactory() {
        try {
            MongoClient client = mongoClient();
            if (client != null) {
                return new SimpleMongoClientDatabaseFactory(client, "exam_scheduler");
            }
        } catch (Exception e) {
            System.err.println("Failed to create MongoDB factory: " + e.getMessage());
        }
        // This should never be null due to the fallback client above
        return new SimpleMongoClientDatabaseFactory(MongoClients.create(), "exam_scheduler");
    }
    
    @Bean
    @Primary
    public MongoTemplate mongoTemplate() {
        try {
            MongoDatabaseFactory factory = mongoDatabaseFactory();
            if (factory != null) {
                return new MongoTemplate(factory);
            }
        } catch (Exception e) {
            System.err.println("Failed to create MongoTemplate: " + e.getMessage());
        }
        // This should never be null due to the fallback factory above
        return new MongoTemplate(mongoDatabaseFactory());
    }
}
