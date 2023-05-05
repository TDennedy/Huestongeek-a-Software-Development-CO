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

Java 19 is recommended, or if possible, GraalVM Java 19.

## Third Party Libraries

Please see `pom.xml` for all third party libraries used in the backend.
