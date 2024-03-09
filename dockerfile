FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ./target/websocket-0.0.1.jar app.jar
EXPOSE 3001
ENTRYPOINT ["java","-jar","/app.jar"]

