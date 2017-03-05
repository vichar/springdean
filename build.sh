#bin/bash
cd ./springboot-data-jpa
./gradlew build
cd ../OrderService
./gradlew build
cd ../ProductService
./gradlew build
cd ../tracking-service
./gradlew build
