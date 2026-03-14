package logger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LoggerService {
    public static Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
