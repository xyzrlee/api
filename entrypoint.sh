#!/bin/sh

echo "BOOTDIR=${BOOTDIR}"
cd ${BOOTDIR}
ls -lh
java $@ -jar api.jar
