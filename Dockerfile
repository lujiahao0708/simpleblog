FROM maven:3.5.0-jdk-8-alpine

MAINTAINER lujiahao0708@gmail.com

WORKDIR /project
ADD . /project

RUN mvn package -Dmaven.test.skip=true
CMD ["mvn"]