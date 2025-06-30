FROM gradle:7.6-jdk17 AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootjar --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
CMD echo "CONFIG_NAME: $CONFIG_NAME, CONFIG_ENV: $CONFIG_ENV" && java -jar app.jar