# loggermodule
This Logger Module delivers extensive logging features for applications, utilizing Spring Boot and SLF4J with Logback for effective and adaptable logging solutions.

# Features
* Application Lifecycle Logging: Logs application start and stop events.
* Logging Utility: Provides utility methods for logging messages at different levels (TRACE, INFO, WARN, ERROR, FATAL).
* Contextual Logging: Supports setting and clearing context information using MDC (Mapped Diagnostic Context).
* Logback Configuration: Configures console and file appenders with rolling policies for effective log management.

# Steps to use this in other applications
* To add the logger-0.0.3.jar file to your local Maven repository, follow these steps:

- Locate the JAR file: Ensure you know the exact path to your logger-0.0.3.jar file. Let's assume it is located at /path/to/logger-0.0.3.jar.

- Run the mvn install:install-file Command: Open a terminal or command prompt and run the following command to install the JAR file into your local Maven repository:

```
    mvn install:install-file -Dfile=/path/to/logger-0.0.3.jar -DgroupId=com.jobtwine -DartifactId=logger -Dversion=0.0.3 -Dpackaging=jar
```