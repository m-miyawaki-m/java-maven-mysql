package com.mysql.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {
    private Logger logger;

    public AppLogger() {
        logger = LoggerFactory.getLogger(AppLogger.class);
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logwarn(String message) {
        logger.warn(message);
    }

    public void logerror(String message) {
        logger.error(message);
    }

    public void logdebug(String message) {
        logger.debug(message);
    }

    // このメソッドはテスト用です
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}