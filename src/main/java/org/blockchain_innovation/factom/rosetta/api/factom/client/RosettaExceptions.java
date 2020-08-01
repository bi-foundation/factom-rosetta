package org.blockchain_innovation.factom.rosetta.api.factom.client;

public class RosettaExceptions {

    public static class RuntimeException extends java.lang.RuntimeException {

        public RuntimeException(String message) {
            super(message);
        }

        public RuntimeException(String message, Throwable cause) {
            super(message, cause);
        }

        public RuntimeException(Throwable cause) {
            super(cause);
        }

    }

    public static class AssertionException extends java.lang.RuntimeException {
        public AssertionException(String message) {
            super(message);
        }
    }

    public static class NotImplementedException extends java.lang.RuntimeException {
        public NotImplementedException(String message) {
            super(message);
        }
    }

}
