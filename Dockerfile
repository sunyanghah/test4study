FROM java:8-jre
MAINTAINER study-jenkinsK8s

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/shanghai" > /etc/timezone

CMD ["nohup", "java", "-jar", "/app/study-jenkinsK8s-1.0-SNAPSHOT.jar", ">", "/dev/null", "&"]

EXPOSE 8021
