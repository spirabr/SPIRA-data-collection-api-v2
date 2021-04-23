# spira-backend project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

You can check out Quarkus guides and tutorials [here](https://quarkus.io/guides/)

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

## Setting up the environment
Create a .env file in project root. **DO NOT COMMIT THIS FILE TO THIS REPOSITORY** as it should be where we can store sensitive data like database passwords, api keys, etc... . For non-sensitive configuration properties, use `application.properties` or another configuration file. (See: [Quarkus - Configuring Your Application](https://quarkus.io/guides/config))

###### Example .env
```env
QUARKUS_MONGODB_CONNECTION_STRING=mongodb://localhost:27017
MY_AWESOME_API_KEY=123456
```

## Related guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

