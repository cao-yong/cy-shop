FROM openjdk:8-jdk
VOLUME /tmp

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT+8","-jar","/programs-service.jar"]