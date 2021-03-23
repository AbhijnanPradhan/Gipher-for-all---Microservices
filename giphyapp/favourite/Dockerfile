FROM openjdk:8-jdk-alpine

# Set the current working directory inside the image
WORKDIR /app

# Copy maven executable to the image
COPY target/favourite-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","favourite-0.0.1-SNAPSHOT.jar"]