## Spring Boot Monorepo (Multi-Module)

A Maven-based monorepo containing multiple Spring Boot microservices under `apps/`.

### Structure
```
java-demo/
  pom.xml                 # Parent (packaging=pom)
  apps/
    api/                 # API microservice
      pom.xml
      src/main/java/com/example/api/...
      src/main/resources/application.properties
    card/                # Card microservice
      pom.xml
      src/main/java/com/example/card/...
      src/main/resources/application.properties
  .vscode/launch.json     # VS Code run configs
```

### Prerequisites
- Java 21+
- Maven 3.9+
- VS Code (optional) with Extension Pack for Java

### Build
Run from the repo root:
```bash
mvn -q -DskipTests package
```

### Run (Maven)
- API service (port 8080):
```bash
mvn -q -pl apps/api -am spring-boot:run
```

- Card service (port 8081):
```bash
mvn -q -pl apps/card -am spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

### Run (VS Code)
- Run and Debug → "Run API"
- Run and Debug → "Run Card"

### Endpoints
- API: `GET http://localhost:8080/hello`
- Card: `GET http://localhost:8081/card/hello`

### Add a New Microservice
1) Create module under `apps/<name>` with a `pom.xml` inheriting the parent:
```xml
<parent>
  <groupId>com.example</groupId>
  <artifactId>java-demo</artifactId>
  <version>1.0.0</version>
  <relativePath>../../pom.xml</relativePath>
</parent>
```
2) Add a Spring Boot main class `com.example.<name>.<CapName>Application` and `application.properties`.
3) Register the module in the root `pom.xml` under `<modules>`.
4) Build: `mvn -q -DskipTests package`
5) Run just that service with `-pl apps/<name> -am`.

### Common Maven Commands
```bash
# Build all modules
mvn -q -DskipTests package

# Run a single module
mvn -q -pl apps/api -am spring-boot:run

# Clean
mvn -q clean
```

### Troubleshooting
- "Unable to find a suitable main class": Make sure you run against a module, e.g. `-pl apps/api`, or add `-Dspring-boot.run.main-class=...`.
- Parent POM resolution error: ensure the module `pom.xml` has `<relativePath>../../pom.xml</relativePath>` and run from the repo root.
- VS Code shows "not on classpath": run "Java: Clean Java Language vServer Workspace" and reload, or reimport Maven projects.

### Notes
- Each microservice is an independent Spring Boot app packaged as a JAR.
- Shared code can live in another module (e.g., `libs/common`) and be added as a dependency to services.


