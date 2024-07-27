#!/usr/bin/env bash

echo "==================================="
echo "Creating all images related"
echo "==================================="
echo "Create eureka image..."
cd image-build/
./eureka-image-builder.sh
echo "Create gateway image..."
./gateway-image-builder.sh
echo "Create Order image..."
./oreder-service-image-builder.sh
echo "Create Product image..."
./product-service-image-builder.sh
echo "Create user image..."
./product-service-image-builder.sh
cd ..
