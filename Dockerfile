FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/pessoas-rest-*.jar
COPY ${JAR_FILE} entrypoint.jar

EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "entrypoint.jar", "--server.address=0.0.0.0"]
