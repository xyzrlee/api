#
# Dockerfile for api
#

FROM alpine
LABEL maintainer="Ricky Li <cnrickylee@gmail.com>"

RUN set -ex \
 # Build environment setup
 && apk update \
 && apk add --no-cache --virtual .build-deps \
      openjdk8 \
      maven \
      git \
 # Build & install
 && git clone git@github.com:xyzrlee/api.git /tmp/repo/api \
 && cd /tmp/repo/api/api \
 && chmod +x mvnw \
 && ./mvnw clean package \
 && mkdir /api \
 && cp target/api.jar /api/ \
 && ./mvnw clean \
 && apk del .build-deps
