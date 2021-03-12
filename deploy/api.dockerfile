## 1. mvn clean package -Dmaven.test.skip=true
## 2. 构建镜像
## docker build -t ccb-ui:v1 --build-arg pkgName=ccb-ui-1.0 .

FROM dante2012/java:centos-oraclejre-1.8.0_212

LABEL MAINTAINER="dante@dante7qx@126.com"

#ENV JAVA_OPTS="-Xms256m -Xmx512m -Xmn128m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m" 
ENV JAVA_OPTS="-XX:MinRAMPercentage=75.0 -XX:MaxRAMPercentage=75.0 -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m" 

ARG pkgName
ARG apUser=spirit
ARG logHome=/home/ap/logs

RUN set -eux; \
    groupadd -r ${apUser} --gid=1000; \
    useradd -r -g ${apUser} --uid=1000 ${apUser}; \
    mkdir -p ${logHome}; \
	chown -R ${apUser}:${apUser} ${logHome}

COPY ${pkgName}.jar /app.jar

USER ${apUser}

EXPOSE 8080

VOLUME ["${logHome}"]

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]