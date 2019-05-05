#
# Dockerfile for api
#

FROM alpine
LABEL maintainer="Ricky Li <cnrickylee@gmail.com>"

USER root

ARG MVNWARGS
ARG JVMARGS

RUN set -ex \
 # Build environment setup
 && apk update \
 && apk add --no-cache --virtual .build-deps \
      openjdk8 \
      maven \
      git \
 # Build & install
 && git clone https://github.com/xyzrlee/api.git /tmp/repo/api \
 && cd /tmp/repo/api/api \
 && chmod +x mvnw \
 && ./mvnw clean package ${MVNWARGS}\
 && mkdir -p /api \
 && cp target/api.jar /api/ \
 && ./mvnw clean \
 && rm -rf /tmp/repo/api \
 && rm -rf ${HOME}/.m2 \
 && apk del .build-deps \
 && ls -l /api \
 && apk add --no-cache openjdk8-jre

COPY entrypoint.sh /api/entrypoint.sh

ENTRYPOINT /api/entrypoint.sh ${JVMARGS}
