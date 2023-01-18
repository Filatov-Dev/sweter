FROM alpine:3.17.0

RUN apk add openjdk17
COPY target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]