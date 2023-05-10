FROM openjdk

WORKDIR /app

COPY target/backend-0.0.1-SNAPSHOT.jar /app/backend.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "backend.jar"]
