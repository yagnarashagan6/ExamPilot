# ExamPilot 📚

A comprehensive exam scheduling and management web application built with Spring Boot backend and React frontend.

## 🌟 Live Demo

- **Frontend**: [https://your-app.netlify.app](https://exam-pilot-zeta.netlify.app/)

## 📋 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Environment Variables](#environment-variables)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

- **User Authentication**: Secure login system with basic authentication
- **Exam Folder Management**: Create and organize exam folders
- **Timetable Creation**: Generate and manage exam timetables
- **Responsive Design**: Works seamlessly on desktop and mobile devices
- **PDF Export**: Export timetables as PDF documents
- **Real-time Updates**: Dynamic updates without page refresh
- **CRUD Operations**: Complete Create, Read, Update, Delete functionality for exams
- **Data Persistence**: MongoDB integration for reliable data storage

## 🛠️ Tech Stack

### Frontend

- **Framework**: React 19.1.1
- **Build Tool**: Vite
- **Styling**: CSS3 with custom styles
- **PDF Generation**: jsPDF, html2canvas
- **HTTP Client**: Fetch API

### Backend

- **Framework**: Spring Boot 3.5.5
- **Language**: Java 21
- **Build Tool**: Maven
- **Database**: MongoDB Atlas
- **Authentication**: Spring Security
- **CORS**: Configured for cross-origin requests

### Deployment

- **Frontend**: Netlify
- **Backend**: Render (Docker)
- **Database**: MongoDB Atlas (Cloud)

## 🏗️ Architecture

```
┌─────────────────┐    HTTP/REST    ┌─────────────────┐    MongoDB    ┌─────────────────┐
│                 │ ────────────▶   │                 │ ──────────▶   │                 │
│  React Frontend │                 │ Spring Boot API │               │  MongoDB Atlas  │
│   (Netlify)     │ ◀──────────────  │    (Render)     │ ◀────────────  │    (Cloud)      │
└─────────────────┘                 └─────────────────┘               └─────────────────┘
```

## 🚀 Getting Started

### Prerequisites

- **Node.js** (v18 or higher)
- **Java** (v21 or higher)
- **Maven** (v3.6 or higher)
- **MongoDB** (Local installation or Atlas account)
- **Git**

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/yagnarashagan6/ExamPilot.git
   cd ExamPilot
   ```

2. **Backend Setup**

   ```bash
   cd ExamPilot
   ./mvnw clean install
   ```

3. **Frontend Setup**
   ```bash
   cd ../frontend
   npm install
   ```

## 🔧 Environment Variables

### Frontend (.env)

```env
VITE_API_BASE_URL=http://localhost:8084
```

### Backend (application.properties)

```properties
# MongoDB Configuration
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/database

# Server Configuration
server.port=8084

# CORS Configuration
cors.allowed.origins=http://localhost:3000,http://localhost:5173

# Admin Configuration
app.admin.username=admin
app.admin.password=admin123
```

## 💻 Usage

### Running Locally

1. **Start the Backend**

   ```bash
   cd ExamPilot
   ./mvnw spring-boot:run
   ```

2. **Start the Frontend**

   ```bash
   cd frontend
   npm run dev
   ```

3. **Access the Application**
   - Frontend: http://localhost:5173
   - Backend API: http://localhost:8084

### Default Credentials

- **Username**: admin
- **Password**: admin123

## 📡 API Endpoints

### Authentication

- `POST /api/auth/login` - User login

### Exam Folders

- `GET /api/exam-folders/user/{userId}` - Get user's exam folders
- `POST /api/exam-folders/create-with-timetable` - Create new exam folder with timetable
- `PUT /api/exam-folders/{folderId}/timetables/{timetableId}` - Update timetable
- `DELETE /api/exam-folders/{folderId}/timetables/{timetableId}` - Delete timetable
- `DELETE /api/exam-folders/{folderId}` - Delete exam folder

## 🚀 Deployment

### Frontend (Netlify)

1. **Build Configuration**

   ```toml
   [build]
     base = "frontend"
     publish = "dist"
     command = "npm run build"
   ```

2. **Environment Variables**
   - `VITE_API_BASE_URL`: Your backend API URL

### Backend (Render)

1. **Docker Configuration**

   - Uses the included `Dockerfile`
   - Root directory: `ExamPilot`

2. **Environment Variables**
   - `PORT`: 8084
   - `SPRING_DATA_MONGODB_URI`: Your MongoDB connection string
   - `CORS_ALLOWED_ORIGINS`: Your frontend URL

## 📁 Project Structure

```
ExamPilot/
├── ExamPilot/                          # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/ExamPilot/
│   │   │   │   ├── config/             # Configuration classes
│   │   │   │   ├── controller/         # REST controllers
│   │   │   │   ├── model/              # Data models
│   │   │   │   ├── repository/         # Data repositories
│   │   │   │   └── service/            # Business logic
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                       # Unit tests
│   ├── Dockerfile                      # Docker configuration
│   └── pom.xml                         # Maven configuration
├── frontend/                           # React Frontend
│   ├── src/
│   │   ├── components/                 # React components
│   │   ├── config/                     # Configuration files
│   │   └── assets/                     # Static assets
│   ├── public/
│   │   └── _redirects                  # Netlify redirects
│   ├── package.json                    # NPM dependencies
│   └── vite.config.js                  # Vite configuration
├── netlify.toml                        # Netlify deployment config
└── README.md                           # Project documentation
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Yagna Rashagan**

- GitHub: [@yagnarashagan6](https://github.com/yagnarashagan6)

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- React team for the amazing framework
- MongoDB for reliable cloud database services
- Netlify and Render for seamless deployment platforms

---

**⭐ If you found this project helpful, please give it a star!**
