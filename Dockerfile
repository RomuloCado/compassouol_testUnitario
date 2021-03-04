FROM openjdk:11

MAINTAINER Romulo Cado

COPY target/produtos-0.0.1-SNAPSHOT.jar /app/produtos.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar" , "produtos.jar"]

EXPOSE 8080
