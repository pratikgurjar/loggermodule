# loggermodule
This Logger Module delivers extensive logging features for applications, utilizing Spring Boot and SLF4J with Logback for effective and adaptable logging solutions.

# Features
    - Application Lifecycle Logging: Logs application start and stop events.
    - Logging Utility: Provides utility methods for logging messages at different levels (TRACE, INFO, WARN, ERROR, FATAL).
    - Contextual Logging: Supports setting and clearing context information using MDC (Mapped Diagnostic Context).
    - Logback Configuration: Configures console and file appenders with rolling policies for effective log management.

# Steps to use this in other applications
    - To add the logger-0.0.3.jar file to system`s local Maven repository, follow these steps:

    - Locate the JAR file: Ensure you know the exact path to your logger-0.0.3.jar file. Let's assume it is located at /path/to/logger-0.0.3.jar.

    - Run the mvn install:install-file Command: Open a terminal or command prompt and run the following command to install the JAR file into the system`s local Maven repository:

```
    mvn install:install-file -Dfile=/path/to/logger-0.0.3.jar -DgroupId=com.jobtwine -DartifactId=logger -Dversion=0.0.3 -Dpackaging=jar
```

Replace '/path/to/logger-0.0.3.jar' with the actual path to location of the JAR file.

## Verify Installation
After running the command, one can verify that the JAR file was installed correctly by checking the system`s local Maven repository, which is typically located at '~/.m2/repository/com/jobtwine/logger/0.0.3/'.

You should see the following files:

    - logger-0.0.3.jar
    - logger-0.0.3.pom (if a POM file is created)

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

# How Logs Will Be Stored
The Logger Module uses Logback for logging configuration, and the logs will be stored both in the console and in files with specific rolling policies.

Logback Configuration Details
1. Console Logging:

   - Logs are output to the console using the *jobTwineConsoleAppender*.
   - The log pattern includes the date, time, thread, log level, logger name, and the log message.

```xml
<appender name="jobTwineConsoleAppender" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
        <pattern>%d{yy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg %n</pattern>
    </encoder>
</appender>
```

2. File logging
   - Logs are also stored in files using the jobTwineAppender.
   - Log files are written to the logs directory, with the main log file named logs.txt.
   - A rolling policy is configured to create new log files based on both size and time.
   - The log file pattern includes the date and time of creation and an index.
   - Each log file has a maximum size of 10MB.
   - Up to 10 log files are kept in the history before older files are deleted.

```xml
    <appender name="jobTwineAppender" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <file>logs/logs.txt</file>
    <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
        <fileNamePattern>logs/log-%d{yy-MM-dd_HH-mm}.%i.txt</fileNamePattern>
        <maxFileSize>10MB</maxFileSize>
        <maxHistory>10</maxHistory>
    </rollingPolicy>
    <encoder>
        <pattern>%d{yy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg %n</pattern>
    </encoder>
</appender>
```

# Log Storage Locations
    - Console: Logs are displayed in the application console during runtime.
    - Files: Logs are stored in the logs directory within the application root. The files follow a naming pattern like *log-YY-MM-DD_HH-mm.i.txt*.

# Log Retention and Rotation
    - Maximum File Size: Each log file can grow up to 10MB.
    - File Rotation: New log files are created based on size and time. For example, *log-24-07-01_12-30.0.txt* would be created at 12:30 on July 1st, 2024, and subsequent logs will be stored in *log-24-07-01_12-30.1.txt* if the first file exceeds 10MB.
    - Log History: Up to 10 old log files are kept. When the limit is reached, the oldest log files are deleted to make space for new ones.

Following this configuration, the Logger Module ensures efficient log data management, offering real-time visibility in the console and persistent file storage with automatic rotation and cleanup.



