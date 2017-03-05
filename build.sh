#bin/bash
echo "springboot-data-jpa"
cd ./springboot-data-jpa
./gradlew build
echo "OrderService"
cd ../OrderService
./gradlew build
echo "ProductService"
cd ../ProductService
./gradlew build
echo "tracking-service"
cd ../tracking-service
./gradlew build
