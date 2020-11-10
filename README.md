# README #

The repository contains <ins>source codes for my educational purpose only.</ins> Should you find anything wrong, better way of implementation, or any suggestions, please kindly let me know.


### What is this repository for? ###

As mentioned above, currently the repository contains data structure / algorithm implementation in Java.

### Develop / Test Environment ###

* Eclipse version: 2020-03(4.15.0) with openJDK14.01 on Ubuntu 20.04 and MacOS 10.15.7
* Maven 3.6.1
* JUnit 5

### Project Structure ###
```
java/algo-ds
	|-- src/main/java
	|-- src/test/java  
	|-- src/resources     
	pom.xml               
```

### How to ###

#### 1. compile and run JUnit test cases ####
   You need to have [Maven](http://maven.apache.org/download.cgi) installed.

	1. cd into the '/education/java/algo-ds' directory
	2. mvn test

#### 2. import the project to Eclipse ####

	File -> import -> Existing Maven Projects -> education -> java -> algo-ds

#### 3. Create the jar file ####

	1. cd into the '/education/java/algo-ds' directory.
	2. mvn install
