# cliente-service
Ejercicio Cliente Service

# run cliente-service
mvn clean install && \
docker build -t cliente-service . && \
docker run --rm -p 8080:8080 -p cliente-service
