## Inicia con la imagen base que contiene java runtine
#FROM openjdk:21-jdk-slim as build
#
## Se agrega el jar del microservicio al contenedor
#COPY target/hotels-0.0.1-SNAPSHOT.jar hotels-0.0.1-SNAPSHOT.jar
#
## Se ejecuta el microservicio
#ENTRYPOINT ["java", "-jar", "/hotels-0.0.1-SNAPSHOT.jar"]

FROM openjdk:21-jdk-slim

RUN addgroup -S devopsc && adduser -S javams -G devopsc

USER javams:devopsc

ENV JAVA_OPTS=""

ARG JAR_FILE

ADD ${JAR_FILE} app.jar

VOLUME /tmp

EXPOSE 7280

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
