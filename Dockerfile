# =====================================================
# 🧱 Stage 1: Build the Spring Boot app using Maven
# =====================================================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build the jar
COPY src ./src
RUN mvn clean package -DskipTests

# =====================================================
# 🚀 Stage 2: Run the Spring Boot app
# =====================================================
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built jar file
COPY --from=build /app/target/*.jar app.jar

# Expose default port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
