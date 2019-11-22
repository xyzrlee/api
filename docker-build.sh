#!/bin/bash

set -e

script_path=$(
  cd "$(dirname $0)"
  pwd
)

cd ${script_path}

docker-compose build --no-cache