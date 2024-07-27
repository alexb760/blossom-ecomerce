#!/bin/sh
cd ../../oreder
./gradlew clean build
export ORDER_IMAGE=alexb-io/order-service
echo "Building image $ORDER_IMAGE ..."
docker build -t $ORDER_IMAGE .