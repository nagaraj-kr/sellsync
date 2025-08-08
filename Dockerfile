# Step 1: Build the app
FROM eclipse-temurin:17-jdk as build
WORKDIR /app

# Copy Maven wrapper & pom.xml first for dependency caching
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

# Copy the rest of the project and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Step 2: Run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
