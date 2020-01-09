FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
#ARG JAR_FILE=../bpi/target/bpi-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=bpi.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
