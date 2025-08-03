# Use an official JDK image as base
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the Maven wrapper and project files
COPY . .

# Package the Spring Boot application (skip tests)
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot app
CMD ["java", "-jar", "target/backend"]
