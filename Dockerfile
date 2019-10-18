#
# Dockerfile for api
#

FROM alpine
LABEL maintainer="Ricky Li <cnrickylee@gmail.com>"

USER root

ENV MVNWARGS="-Dmaven.test.skip=true -Dmaven.javadoc.skip=true --batch-mode --show-version --no-transfer-progress"

COPY api /repo

RUN set -ex \
 # Build environment setup
 && apk update \
 && apk add --no-cache --virtual .build-deps \
      openjdk11 \
      git \
 # Build & install
 && git clone https://github.com/xyzrlee/api.git /tmp/repo/api \
 && cd /repo \
 && chmod +x mvnw \
 && ./mvnw clean package ${MVNWARGS}\
 && mkdir -p /api \
 && cp target/api.jar /api/ \
 && rm -rf /repo \
 && rm -rf ${HOME}/.m2 \
 && apk del .build-deps \
 && ls -l /api \
 && apk add --no-cache openjdk11-jre

COPY entrypoint.sh /api/entrypoint.sh

ARG JVMARGS

ENTRYPOINT /api/entrypoint.sh ${JVMARGS}
