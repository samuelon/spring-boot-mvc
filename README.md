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
