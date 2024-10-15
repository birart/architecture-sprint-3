FROM gradle:8.10.2-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17.0.1
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/telemetry-*.jar /app/telemetry.jar
ENTRYPOINT ["java", "-jar", "telemetry.jar"]