#!/bin/bash

set -e

script_path=$(
  cd "$(dirname $0)"
  pwd
)

cd ${script_path}/api
chmod +x mvnw
./mvnw install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true --batch-mode --show-version --no-transfer-progress
./mvnw clean org.jacoco:jacoco-maven-plugin:prepare-agent org.jacoco:jacoco-maven-plugin:report package sonar:sonar
