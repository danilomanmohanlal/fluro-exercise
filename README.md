# fluro-exercise
Exercise code for a supermarket checkout that calculates the total price of several items with product promotions


## How to run

Using Java version 11 and maven 3.9.7

After cloning the repo from branch ```master``` run the following command inside the supermarket folder:
```
mvn clean compile assembly:single
```

This will generate a jar with dependencies that you can run in the command line like this:
```
java -jar supermarket-1.0-SNAPSHOT-jar-with-dependencies.jar
```