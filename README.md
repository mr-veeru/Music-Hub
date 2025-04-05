# 🎵 Music Hub

A comprehensive web application for managing and streaming music, built with Spring Boot.

![Music Hub Banner])

## ✨ Features

- **🔐 User Authentication**: Register and login functionality with different user roles (Admin and Customer)
- **🎧 Song Management**: Upload, browse, and manage songs
- **📋 Playlist Creation**: Create and manage personalized playlists
- **💳 Payment Integration**: Payment processing using Razorpay
- **📱 Responsive UI**: User-friendly interface built with Thymeleaf templates

## 🛠️ Technology Stack

- **Backend**: ![Java](https://img.shields.io/badge/Java%2017-ED8B00?style=flat&logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot%203.2.2-6DB33F?style=flat&logo=spring&logoColor=white)
- **Database**: ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white) with Spring Data JPA
- **Frontend**: ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white) ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white)
- **Build Tool**: ![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)
- **Payment Gateway**: ![Razorpay](https://img.shields.io/badge/Razorpay-0066FF?style=flat&logoColor=white)

## 🚀 Getting Started

### Prerequisites

- JDK 17
- Maven
- MySQL Database

### Installation

1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/Music-Hub.git
   ```

2. Navigate to the project directory
   ```bash
   cd Music-Hub
   ```

3. Configure the database in `application.properties`
   ```properties
   # Example configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/musichub
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

4. Build the project
   ```bash
   mvn clean install
   ```

5. Run the application
   ```bash
   mvn spring-boot:run
   ```

6. Access the application at `http://localhost:8080`

## 📂 Project Structure

- **Controller**: Handles HTTP requests and responses
- **Services**: Contains business logic
- **Repositories**: Data access layer for database operations
- **Entities**: Object models representing database tables
- **Templates**: Thymeleaf HTML templates for the frontend

## 🌟 Features in Detail

### 👥 User Management
- User registration and login
- Role-based access control (Admin/Customer)

### 🎵 Song Management
- Upload and manage songs
- Browse available songs
- Search functionality

### 📑 Playlist Management
- Create personal playlists
- Add songs to playlists
- View and manage playlists

### 💰 Payment Processing
- Secure payment integration with Razorpay
- Transaction history

## 👏 Acknowledgments

- Spring Boot framework
- Razorpay for payment processing
