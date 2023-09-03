# User Service

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
Below are the development specifications used for this project which can be downloaded through the provided links.

* Java SDK v17.0.8 [download here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* Apache Maven v3.9.0 [download here](https://maven.apache.org/download.cgi)
* IntelliJ IDEA v2023.1.5 [download here](https://www.jetbrains.com/idea/download/other.html)
* Docker Desktop [download here](https://www.docker.com/products/docker-desktop/)

### Setup PostgreSQL
After completing the prerequisites, you can run the following command to setup PostgreSQL with Docker.

```shell
docker compose up -d postgres_db
```

### Running
In order to run the project, all you need to do is run the following command or press the run button in IntelliJ IDEA.

```shell
mvn spring-boot:run
```

You can run the following command to make sure that the project is up and running.

```shell
curl http://localhost:8080/actuator/health
```

If the project is up and running, you should see the following response.

```json
{"status":"UP"}
```