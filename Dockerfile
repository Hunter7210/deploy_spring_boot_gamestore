# Define o estágio de compilação
FROM ubuntu:latest AS build

# Instala o JDK e o Maven
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Copia os arquivos do projeto
COPY . .

# Compila o projeto
RUN mvn clean install

# Define o estágio final
FROM openjdk:17-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Copia o JAR do estágio de compilação para o estágio final
COPY --from=build /target/gamestore.jar /app.jar

# Define o ponto de entrada
ENTRYPOINT ["java", "-jar", "/app.jar"]
