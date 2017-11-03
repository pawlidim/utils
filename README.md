# utils
Util class collection

### Logger Example ###
```java

// create logger with interpolator functionality
ILog log = Logging.getLog(LoggingTest.class);

log.info("This is my interpolated message - {0}", "foobar");

....

// create logger without interpolator functionality
LogProvider log = Logging.getLogProvider(LoggingTest.class);

log.info("This is my message - " + "foobar");
```