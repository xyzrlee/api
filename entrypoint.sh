#!/bin/sh

echo "BOOTDIR=${BOOTDIR}"
cd ${BOOTDIR}
ls -lh
sudo -u ${RUNAS} java ${JVMARGS} -jar api.jar
