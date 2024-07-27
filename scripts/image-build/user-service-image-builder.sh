#!/bin/sh
cd ../../user
./gradlew clean build
export USER_IMAGE=alexb-io/user-service
echo "Building image $USER_IMAGE ..."
docker build -t $USER_IMAGE .