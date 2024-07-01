package com.jobtwine.logger.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggerUtil {

    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static void trace(String message) {
        logger.trace(message);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.error("FATAL: {}", message);
    }

    public static void setContext(String key, String value) {
        MDC.put(key, value);
    }

    public static void clearContext() {
        MDC.clear();
    }
}
