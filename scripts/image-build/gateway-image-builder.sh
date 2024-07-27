#!/bin/sh
cd ../../e-gateway
./gradlew clean build
export GATEWAY_IMAGE=alexb-io/gateway-server
echo "Building image $GATEWAY_IMAGE ..."
docker build -t $GATEWAY_IMAGE .