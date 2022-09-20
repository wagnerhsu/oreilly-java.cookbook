# README

## 2022-09-20

* Add basic log4j2.xml under src/main/resources
* Update pom.xml

```xml
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.19.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.19.0</version>
</dependency>
```

* Use it

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

static Logger logger = LogManager.getLogger(App.class.getName());
```