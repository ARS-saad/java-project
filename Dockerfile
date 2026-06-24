FROM eclipse-temurin:8-jre
COPY target/demo-workshop-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
