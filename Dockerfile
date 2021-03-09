FROM openjdk:8-jdk-alpine

VOLUME /app

ARG version

ENV version_number=$version

COPY ./build/libs/sbr-user-service-$version-number.jar sbr-user-service.jar

ENTRYPOINT ["java","-jar","sbr-user-service.jar"]