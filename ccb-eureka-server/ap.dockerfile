FROM dante2012/java:centos-oraclejre-1.8.0_212

LABEL maintainer="sunchao.zh <dante@dante7qx@126.com>"

ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m" 

RUN rm /bin/sh && ln -s /bin/bash /bin/sh 

WORKDIR app/	 
	 
COPY target/ccb-eureka-server-1.0.jar app.jar	 
COPY init.sh init.sh

RUN sh -c 'touch app.jar'

EXPOSE 8761

ENTRYPOINT ["/bin/bash","-c","source init.sh"] 