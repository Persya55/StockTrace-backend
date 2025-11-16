# --- Etapa 1: Construcción (Build) ---
# Usamos una imagen de Maven con Java 21 para compilar el proyecto
FROM maven:3.8-openjdk-21 AS build

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo de proyecto para descargar dependencias
COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .

# Descargamos dependencias (opcional pero acelera)
# RUN ./mvnw dependency:go-offline

# Copiamos el resto del código fuente y construimos el .jar
COPY src ./src
RUN ./mvnw clean install -DskipTests

# --- Etapa 2: Ejecución (Run) ---
# Usamos una imagen ligera de solo Java 21 para ejecutar
FROM openjdk:21-jre-slim

WORKDIR /app

# Copiamos el .jar construido de la etapa anterior
# ¡IMPORTANTE! Verifica que este nombre coincida con tu pom.xml
COPY --from=build /app/target/stocktrack-backend-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080 (aunque Render usará la variable PORT)
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]