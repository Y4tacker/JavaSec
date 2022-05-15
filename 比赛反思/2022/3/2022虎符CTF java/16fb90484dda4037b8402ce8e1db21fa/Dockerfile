FROM openjdk:8u181-slim

MAINTAINER yxxx
ENV REFRESHED_AT 2022-03-09
ENV LANG C.UTF-8

RUN sed -i 's/http:\/\/security.debian.org/http:\/\/mirrors.163.com/g' /etc/apt/sources.list
RUN sed -i 's/http:\/\/deb.debian.org/http:\/\/mirrors.163.com/g' /etc/apt/sources.list
RUN apt-get update -y

ENV DEBIAN_FRONTEND noninteractive



RUN useradd ctf && mkdir /opt/app

COPY ezchain.jar /opt/app
WORKDIR /opt/app


EXPOSE 8090
USER ctf


CMD ["java", "-jar", "/opt/app/ezchain.jar"]