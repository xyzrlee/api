#!/bin/sh

echo "BOOTDIR=${BOOTDIR}"
cd /api-boot
ls -lh
java $@ -jar api.jar
