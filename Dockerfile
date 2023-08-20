FROM ubuntu:latest
RUN useradd -U -l -d /okw okw
COPY --chown=okw:okw . /okw

RUN apt-get update && apt-get -y install openjdk-17-jdk-headless \
&& apt-get -y install maven

RUN apt-get update

USER okw
WORKDIR /okw

ENTRYPOINT ["./runjar.sh"]

