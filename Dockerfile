FROM maven:3.6.3-openjdk-11 AS maven_build

COPY app /tmp/

WORKDIR /tmp/
