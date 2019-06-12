#!/bin/sh

cd /api
ls -lh
java $@ -jar api.jar
