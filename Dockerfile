FROM gradle:8.9.0-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon

FROM amazoncorretto:17-alpine-jdk

EXPOSE 8081

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]

