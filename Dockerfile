FROM maven:3.5.0-jdk-8-alpine

MAINTAINER lujiahao0708@gmail.com

WORKDIR /project
ADD . /project

ADD agent.zip /opt/

RUN mvn package -Dmaven.test.skip=true && \
    unzip /opt/agent.zip -d /opt

ADD agent.config /opt/agent/config/

CMD ["mvn"]