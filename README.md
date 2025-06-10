---

## 🔧 Prerequisites

Ensure the following tools are installed:

- Java 17+  
- Maven 3.6+  
- MySQL (or the DB your app uses)  
- Git  

---

## 💻 Running the Application
# Option 1: Using an IDE
Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

Locate the main class, typically found in src/main/java/.../Application.java.

Run the application directly from the IDE.

# Option 2: Using Maven Command
Open a terminal and navigate to the project's root directory.

Run the following command to start the app:

```mvn spring-boot:run```
# Option 3: Build and Run the JAR
Build the application:
mvn clean package
Navigate to the target directory and run the generated JAR file:

```java -jar target/your-app-name-1.0.0.jar```
🌐 Access the Application
Once the app is running, it will be available at:
http://localhost:8080

You can adjust the port by adding this to application.properties:

```server.port=9090```

## 🔐 Setting Up `application.properties`

To configure your Spring Boot application with database credentials and other settings, you'll need to create a local `application.properties` file. This file is **not included in version control** for security reasons.

### 📄 Steps to Create:

1. Navigate to the `src/main/resources` directory and create the file:
   ```bash
   touch src/main/resources/application.properties

```# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

# JPA Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

⚠️ Do not commit your application.properties file to the repository.
