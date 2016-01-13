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

To build and run the person service run the following
```
gradle run
```

## Accessing the Rest Service

From running from your local machine the rest base will be ``` localhost:8008/person  ```

You can post to this location with the following header
```
"Content-Type" : "application/json"
{
  "firstName": "Joe",
  "lastName": "Smith",
  "birthDate": [
    1985,
    1,
    31
  ],
  "weightInPounds": 160,
  "height": {
    "feet": 5,
    "inches": 11
  }
}
```

It will return with the created person
```
"Content-Type" : "application/json"
{
  "id":1
  "firstName": "Joe",
  "lastName": "Smith",
  "birthDate": [
    1985,
    1,
    31
  ],
  "weightInPounds": 160,
  "height": {
    "feet": 5,
    "inches": 11
  }
}
```

You can get the person by performing a get at the following location
```
localhost:8008/person/1
```

Performing a delete on the previous location will remove it from the date base.

You can update a person by using a put method.

## Branches For Demonstrations
master
```
git checkout master
```

Functional Interfaces
```
git checkout function-interface
```

Predicate Interface
```
git checkout predicate-interface
```

Default Keyword
```
git checkout default-keyword
```

Supplier interface
```
git checkout supplier-function
```

Stream Interface
```
git checkout stream-interface
```