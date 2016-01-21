# Person Service

## Introduction
This project is intended to be used as an example for many of the new features in JAVA 8 in conjuncture with vagrant and spring boot.

Each demonstration will have an associated [branch](https://github.com/nsharpe/Person#branches-for-demonstrations) that will have some code removed.  The code that is removed will have unit tests associated with it.

The goal is to be able to get as many unit tests to pass as you can.

## Requirements
In order to run the project on your local machine you will need the following installed on your machine.
* Java 8
* Gradle
* Vagrant

If you do not have vagrant or virtual box installed and you are using a mac, you can use [brew](http://brew.sh/) to install all the required packages

You can also run the following in terminal to install homebrew, vagrant, virtual box, vagrant-manager

BEFORE RUNNING PLEASE REVIEW THE SCRIPT.  Generally you do not want to curl a bash script unless you trust the source.

```
curl https://raw.githubusercontent.com/nsharpe/Person/master/brew_install.sh | bash
```

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

Data aggregation 
```
git checkout data-agregation
```
