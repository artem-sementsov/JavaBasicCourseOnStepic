package org.stepic.java.logging;

import sun.rmi.runtime.Log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {

    public static void main(String[] args) {

    }

    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        Logger loggerC = Logger.getLogger("org.stepic.java");
        loggerC.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());

        loggerC.addHandler(consoleHandler);
    }
}

class ClassA {
    private static final Logger LOGGER = Logger.getLogger(ClassA.class.getName());

    ClassA() {
//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setLevel(Level.ALL);
//        consoleHandler.setFormatter(new XMLFormatter());
//        LOGGER.setUseParentHandlers(true);
//        LOGGER.addHandler(consoleHandler);
    }
    public void SetLoggerLevel(){
        LOGGER.setLevel(Level.ALL);
    }
}

class ClassB {
    private static final Logger LOGGER = Logger.getLogger(ClassB.class.getName());

    ClassB() {
//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setLevel(Level.ALL);
//        consoleHandler.setFormatter(new XMLFormatter());
//        LOGGER.addHandler(consoleHandler);
    }
    public void SetLoggerLevel(){
        LOGGER.setLevel(Level.WARNING);
    }

}