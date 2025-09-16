# Environment Variables Configuration

This document describes the environment variables used in the ExamPilot application for secure configuration management.

## Required Environment Variables

### MongoDB Configuration

- **MONGODB_USERNAME**: Your MongoDB Atlas username (default: yagnarashagan)
- **MONGODB_PASSWORD**: Your MongoDB Atlas password (default: rashagan63)
- **MONGODB_CLUSTER**: Your MongoDB cluster address (default: registration.ly1lbic.mongodb.net)
- **MONGODB_DATABASE**: Database name (optional, defaults to empty string)

### Admin Configuration

- **ADMIN_USERNAME**: Application admin username (default: admin)
- **ADMIN_PASSWORD**: Application admin password (default: admin123)
- **ADMIN_EMAIL**: Admin email address (default: admin@examscheduler.com)

### JWT Configuration

- **JWT_SECRET**: JWT signing secret key (default: mySecretKey)
- **JWT_EXPIRATION**: JWT token expiration time in seconds (default: 86400)

### Security Configuration

- **SECURITY_USERNAME**: Spring Security username (default: admin)
- **SECURITY_PASSWORD**: Spring Security password (default: admin123)
- **SECURITY_ROLES**: Spring Security roles (default: ADMIN)

### CORS Configuration

- **CORS_ALLOWED_ORIGINS**: Comma-separated list of allowed origins (default: http://localhost:3000,http://localhost:3001,http://localhost:5173,https://\*.netlify.app)

## Setting Environment Variables

### For Local Development (Windows PowerShell)

```powershell
# MongoDB Configuration
$env:MONGODB_USERNAME="your_username"
$env:MONGODB_PASSWORD="your_password"
$env:MONGODB_CLUSTER="your_cluster.mongodb.net"

# Admin Configuration (change defaults for production)
$env:ADMIN_USERNAME="your_admin_username"
$env:ADMIN_PASSWORD="your_secure_password"

# JWT Configuration (use a strong secret in production)
$env:JWT_SECRET="your_jwt_secret_key_here"

# Security Configuration
$env:SECURITY_USERNAME="your_security_username"
$env:SECURITY_PASSWORD="your_security_password"
```

### For Docker Deployment

Add these to your Docker run command or docker-compose.yml:

```bash
docker run -e MONGODB_USERNAME=your_username \
           -e MONGODB_PASSWORD=your_password \
           -e MONGODB_CLUSTER=your_cluster.mongodb.net \
           -e ADMIN_PASSWORD=your_secure_password \
           -e JWT_SECRET=your_jwt_secret \
           your_image_name
```

### For Production Deployment

Set these environment variables in your production environment:

- Cloud platforms (Heroku, AWS, etc.): Use their environment variable configuration
- Kubernetes: Use ConfigMaps and Secrets
- Traditional servers: Use system environment variables or .env files

## Security Best Practices

1. **Never commit sensitive values**: The defaults are only for development convenience
2. **Use strong passwords**: Change all default passwords in production
3. **Rotate credentials regularly**: Especially for database and JWT secrets
4. **Use different values per environment**: Development, staging, and production should have different credentials
5. **Secure JWT secret**: Use a long, random string (at least 256 bits)

## Migration from Hardcoded Values

The application now uses environment variables with fallback to the original values as defaults. This means:

- **No immediate action required**: Your application will continue working with the current values
- **For better security**: Set the environment variables with your actual credentials
- **For production**: Always set proper environment variables instead of relying on defaults

## Example .env File (for local development only)

Create a `.env` file in your project root (add it to .gitignore):

```
MONGODB_USERNAME=your_username
MONGODB_PASSWORD=your_password
MONGODB_CLUSTER=your_cluster.mongodb.net
ADMIN_USERNAME=admin
ADMIN_PASSWORD=secure_admin_password
JWT_SECRET=your_very_long_and_secure_jwt_secret_key_here
SECURITY_USERNAME=admin
SECURITY_PASSWORD=secure_security_password
```

**Important**: Never commit the .env file to version control!
