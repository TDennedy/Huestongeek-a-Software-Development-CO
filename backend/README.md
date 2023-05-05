# Huestongeek-a-Software-Development-CO

The SpringBoot backend for Huestongeek.

## Installation

1. After cloning, build with the following command:

```
mvn clean install spring-boot:repackage
```

2. `target` directory will now contain an executable jar named `hiking-backend-0.0.1-SNAPSHOT.jar`. **Before running anything**, configure `src/main/resources/application.properties` according to the instructions provided in it.

3. `cd target` and run the app (`hiking-backend-0.0.1-SNAPSHOT.jar`) as follows:

```
java -jar hiking-backend-0.0.1-SNAPSHOT.jar
```

Java 19 is recommended, or if possible, GraalVM Java 19.

## Third Party Libraries

Please see `<dependencies>` in `pom.xml` for all third party libraries used in the backend.
