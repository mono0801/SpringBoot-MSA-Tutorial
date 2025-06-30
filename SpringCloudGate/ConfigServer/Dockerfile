FROM openjdk:17-jdk-slim

WORKDIR /app

# Gradle로 빌드한 .jar 파일을 컨테이너로 복사
COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]