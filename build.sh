#bin/bash
ls -la
echo "OrderService"
cd ./OrderService
./gradlew build
echo "ProductService"
cd ../ProductService
./gradlew build
echo "tracking-service"
cd ../tracking-service
./gradlew build
cd ../edge
./gradlew build