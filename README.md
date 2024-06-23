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

This will prompt a interactive input to process shopping carts, here is an example:
```
Enter the products in the cart separated by comma (ex: A,B,B,C,C,C,C,C,C,C,C,D,E,E,B,B,B)
>A,B,C,D,E,B,B,B,B,C,C,C,C,D
Enter the promotions that are active separated by comma (ex: multipriced:B:2:125,buynget1:C:3,mealdeal:D:E:300)
>multipriced:B:2:125,buynget1:C:3,mealdeal:D:E:300
Total: 9 pounds and 00 pence
continue processing carts ? (yes|no)
```

## Tests

To run the units tests run the following command inside the supermarket folder:
```mvn test```