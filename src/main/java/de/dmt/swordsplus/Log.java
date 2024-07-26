package de.dmt.swordsplus;

import io.netty.handler.codec.MessageAggregationException;
import org.apache.logging.log4j.core.config.status.StatusConfiguration;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class Log {

    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(Swordsplus.MOD_ID);
        }

        return logger;
    }

    private static String format(String message, Object... values) {
        return String.format(message, values);
    }

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void info(Supplier<String> supplier) {
        getLogger().info(supplier);
    }

    public static void infof(String message, Object... values) {
        info(format(message, values));
    }

    public static void warning(String message) {
        getLogger().warning(message);
    }

    public static void warning(Supplier<String> supplier) {
        getLogger().warning(supplier);
    }

    public static void warningf(String message, Object... values) {
        warning(format(message, values));
    }

    public static void severe(String message) {
        getLogger().severe(message);
    }

    public static void severe(Supplier<String> supplier) {
        getLogger().severe(supplier);
    }

    public static void severef(String message, Object... values) {
        severe(format(message, values));
    }
}
