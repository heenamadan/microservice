

cd support/microservice-discovery-server;            note "Building Discovery Server...";       ./gradlew clean build;
 "Running Discovery Server...";     nohup java -jar -Xms256m -Xmx256m build/libs/*-SNAPSHOT.jar &
cd -

cd support/api-microservice-gateway;                 note "Building API Gateway Server...";     ./gradlew clean build;
 "Running API Microservice Gateway Server...";   nohup java -jar -Xms256m -Xmx256m build/libs/*-SNAPSHOT.jar &
cd -

cd core/product-catalog-service;            note "Building Product Catalog Service...";     ./gradlew clean build;
 "Running Product Catalog Server...";   nohup java -jar -Xms256m -Xmx512m build/libs/*-SNAPSHOT.jar &
cd -


 "Navigate to http://localhost:8070/ for service dashboard";