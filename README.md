# Person Service

## Introduction
This project is intended to be used as an example for many of the new features in JAVA 8 in conjuncture with vagrant and spring boot.

## Requirements
In order to run the project on your local machine you will need the following installed on your machine.
* Java 8
* Maven
* Gradle
* Vagrant

## Running the application
To run the application run the following in your command line

To start the mysql server run
```
vagrant up
```
To log into the mysql server run 
```
mysql -u root -h 192.168.60.2
```

To start up the person service run the following
```
./gradlew build && java -jar build/libs/person-service-0.1.0.jar
```