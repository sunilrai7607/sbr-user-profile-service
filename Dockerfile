FROM openjdk:8-jdk-alpine

VOLUME /app

ARG version

ENV version_number=$version

COPY ./build/libs/sbr-user-profile-service-$version-number.jar sbr-user-profile-service.jar

ENTRYPOINT ["java","-jar","sbr-user-profile-service.jar"]