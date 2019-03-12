FROM java:8-jre
MAINTAINER study-jenkinsk8s

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/shanghai" > /etc/timezone

ADD target/*.jar /app/study-jenkinsk8s.jar
CMD ["nohup", "java", "-jar", "/app/study-jenkinsk8s.jar", ">", "/dev/null", "&"]

