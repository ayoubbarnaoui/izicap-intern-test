FROM openjdk:17-alpine

VOLUME /app
WORKDIR /app

COPY src .
COPY pom.xml .
COPY target/izicap-intern-test.jar .

ENTRYPOINT ["java", "-jar", "izicap-intern-test.jar"]
