# 1. Build stage
FROM maven:latest AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2. Run stage
FROM openjdk:latest
WORKDIR /app
VOLUME /app/data
COPY --from=build /workspace/target/restaurant-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
