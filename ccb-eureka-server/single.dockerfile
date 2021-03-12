FROM dante2012/java:centos-oraclejre-1.8.0_212

LABEL maintainer="sunchao.zh <dante@dante7qx@126.com>"

ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m" 

WORKDIR app/	 
	 
COPY target/ccb-eureka-server-1.0.jar app.jar	 

RUN sh -c 'touch app.jar'

EXPOSE 8761

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar " ]