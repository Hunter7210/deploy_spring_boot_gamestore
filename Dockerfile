FROM ubuntu:latest AS build

RUN apt-get upgrade && apt-get install -y openjdk-17-jdk

COPY . .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:17-oracle

EXPOSE 8080

COPY ==from=built /target/gamestore.jar/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]