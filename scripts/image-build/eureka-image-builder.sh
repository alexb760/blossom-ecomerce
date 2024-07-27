#!/bin/sh
cd ../../eurecka-server
./gradlew clean build
export EUREKA_IMAGE=alexb-io/eureka-server
echo "Building image $EUREKA_IMAGE ..."
docker build -t $EUREKA_IMAGE .