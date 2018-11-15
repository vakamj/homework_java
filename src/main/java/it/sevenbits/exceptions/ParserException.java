package it.sevenbits.exceptions;

/**
 * class ParserException
 */
public final class ParserException extends Exception {
    /**
     *
     * @param message message
     */

    public ParserException(final String message) {
        super(message);
    }

    /**
     *
     * @param throwable throwable
     */
    public ParserException(final Throwable throwable) {
        super(throwable);
    }
}
