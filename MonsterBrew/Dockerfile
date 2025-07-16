# vezmi JDK 17 na Alpine Linuxu
FROM eclipse-temurin:17-jdk-alpine

# nastav pracovní složku
WORKDIR /app

# zkopíruj jar
COPY build/libs/*.jar app.jar

# otevři port
EXPOSE 8080

# spusť jar
ENTRYPOINT ["java", "-jar", "app.jar"]
