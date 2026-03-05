# Stage 1: Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml and source code from your repo
COPY pom.xml .
COPY src ./src

# Build the application [cite: 12]
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the JAR using the artifact name from your pom.xml
COPY --from=build /app/target/ScientificCalculator-1.0-SNAPSHOT.jar app.jar

# Run the calculator [cite: 24]
ENTRYPOINT ["java", "-jar", "app.jar"]
