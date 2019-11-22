#!/bin/sh

echo "BOOTDIR=${BOOTDIR}"
echo "RUNDIR=${RUNDIR}"
cd ${RUNDIR}
ls -lh
sudo -u ${RUNAS} java ${JVMARGS} -jar ${BOOTDIR}/api.jar
