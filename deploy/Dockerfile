## 1. mvn clean package -Dmaven.test.skip=true
## 2. 构建镜像
## docker build -t ccb-ui:v1 --build-arg pkgName=ccb-ui-1.0 .

FROM dante2012/java:jre8-221

LABEL MAINTAINER="sunchap <sunchao.0129@163.com>"

ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m" 

ARG pkgName 

COPY ${pkgName}.jar app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar " ]