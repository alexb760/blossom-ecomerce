#!/bin/sh
cd ../../product
./gradlew clean build
export PRODUCT_IMAGE=alexb-io/product-service
echo "Building image $PRODUCT_IMAGE ..."
docker build -t $PRODUCT_IMAGE .