# Huestongeek-a-Software-Development-CO

The SpringBoot backend for Huestongeek.

## Installation

After cloning, run a Maven install with the following command:

```
mvn clean install spring-boot:repackage
```

`target` directory will now contain an executable jar named `hiking-backend-0.0.1-SNAPSHOT.jar`. Run it as follows:

```
java -jar hiking-backend-0.0.1-SNAPSHOT.jar
```

**NOTE: You will need to configure the `application.properties` file and add the proper credentials to connect to the database.**

Java 19 is recommended, or if possible, GraalVM Java 19.

## Third Party Libraries

Please see `<dependencies>` in `pom.xml` for all third party libraries used in the backend.
