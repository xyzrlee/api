#!/bin/sh

echo "BOOTDIR=${BOOTDIR}"
echo "RUNDIR=${RUNDIR}"
cd ${RUNDIR}
ls -lh
java ${JVMARGS} -jar ${BOOTDIR}/api.jar
