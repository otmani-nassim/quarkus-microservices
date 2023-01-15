# Quarkus Microservices (without API)
This is a simple application with two microservices:
- rest-number: Generate ISBNs numbers
- rest-book: It uses rest-number microservices to get an isbn13 number and returns a book.

# What was implemented
- Two microservices using Quarkus
- Writing unit tests for an API 
- Writing integration tests for a microservice
- Creating a Mock interface for the testing
- Fault taulerance and Fallback methods.

# How to run this application
## without docker

1- Start the rest-number microservice
cd rest-number 
mvn quarkus:dev

to test it:
curl http://localhost:8701/api/numbers -X get

2- Start the rest-book microservice
cd rest-book 
mvn quarkus:dev

to test it:
curl -d "title=TheTitle&author=TheAuthor&year=2023&genre=Action" -H "Content-Type: application/x-www-form-urlencoded" -X POST   http://localhost:8702/api/books

## with docker (native images)
1- Generate the image for rest-number 
mvn package -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

2- Generate the image for rest-book 
mvn package -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

3- Start the docker-compose
cd learnquarkus
docker-compose up 
