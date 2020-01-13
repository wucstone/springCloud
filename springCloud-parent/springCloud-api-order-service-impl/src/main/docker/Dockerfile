FROM java:8
MAINTAINER "wucstone"<2964956078@qq.com>
EXPOSE 8763
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


