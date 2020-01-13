FROM java:8
MAINTAINER "wucstone"<2964956078@qq.com>
EXPOSE 8762
VOLUME /tmp
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]