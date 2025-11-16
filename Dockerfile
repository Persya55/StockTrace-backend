# --- Etapa 1: Construcción (Build) ---
FROM maven:3-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .

# --- ESTA ES LA LÍNEA QUE ARREGLA TODO ---
# Damos permisos de ejecución al Maven wrapper antes de usarlo
RUN chmod +x mvnw

# Copiamos el resto del código fuente y construimos el .jar
COPY src ./src
RUN ./mvnw clean install -DskipTests

# --- Etapa 2: Ejecución (Run) ---
FROM eclipse-temurin:21-jre

WORKDIR /app

# ¡IMPORTANTE! Verifica que este nombre coincida con tu pom.xml
COPY --from=build /app/target/stocktrack-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]