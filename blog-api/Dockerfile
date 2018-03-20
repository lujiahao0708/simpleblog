FROM maven:3.5.0-jdk-8-alpine

MAINTAINER lujiahao0708@gmail.com

#mkdir code
RUN mkdir -p /appdata/blog-api

# add code
ADD blog-api/run.sh blog-api/target/blog-api-0.0.1.jar /appdata/blog-api/

# chmod
RUN chmod 775 /appdata/blog-api/run.sh && \
    chmod +x  /appdata/blog-api/run.sh

# entrypoint
ENTRYPOINT /appdata/blog-api/run.sh