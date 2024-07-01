# loggermodule
This Logger Module delivers extensive logging features for applications, utilizing Spring Boot and SLF4J with Logback for effective and adaptable logging solutions.

# Features
* Application Lifecycle Logging: Logs application start and stop events.
* Logging Utility: Provides utility methods for logging messages at different levels (TRACE, INFO, WARN, ERROR, FATAL).
* Contextual Logging: Supports setting and clearing context information using MDC (Mapped Diagnostic Context).
* Logback Configuration: Configures console and file appenders with rolling policies for effective log management.

# Steps to use this in other applications
* To add the logger-0.0.3.jar file to system`s local Maven repository, follow these steps:

- Locate the JAR file: Ensure you know the exact path to your logger-0.0.3.jar file. Let's assume it is located at /path/to/logger-0.0.3.jar.

- Run the mvn install:install-file Command: Open a terminal or command prompt and run the following command to install the JAR file into the system`s local Maven repository:

```
    mvn install:install-file -Dfile=/path/to/logger-0.0.3.jar -DgroupId=com.jobtwine -DartifactId=logger -Dversion=0.0.3 -Dpackaging=jar
```

Replace '/path/to/logger-0.0.3.jar' with the actual path to location of the JAR file.

## Verify Installation
After running the command, one can verify that the JAR file was installed correctly by checking the system`s local Maven repository, which is typically located at '~/.m2/repository/com/jobtwine/logger/0.0.3/'.

You should see the following files:

* logger-0.0.3.jar
* logger-0.0.3.pom (if a POM file is created)

Using the Installed JAR in Maven Project
Add the dependency to pom.xml in the Maven project:

```xml
<dependency>
    <groupId>com.jobtwine</groupId>
    <artifactId>logger</artifactId>
    <version>0.0.3</version>
</dependency>
```

Step 2:
In the application code, we can use the LoggerUtil class for logging messages. Below is the examples:

```java
import com.jobtwine.logger.util.LoggerUtil;

public class ExampleUsage {

    public void performTask() {
        LoggerUtil.info("Task started");
        
        try {
            // Task logic here
            LoggerUtil.trace("Detailed trace message");
        } catch (Exception e) {
            LoggerUtil.error("An error occurred: " + e.getMessage());
        } finally {
            LoggerUtil.info("Task completed");
        }
    }
}
```

Step 4:
    We can set and clear context information using the 'LoggerUtil' class, which can be useful for adding additional metadata to the logs.

```java
    LoggerUtil.setContext("userId", "12345");
    LoggerUtil.info("login of user");
    LoggerUtil.clearContext();
```

By following these steps, we can integrate the Logger Module for Jobtwine into any application and leverage its features for effective logging.







