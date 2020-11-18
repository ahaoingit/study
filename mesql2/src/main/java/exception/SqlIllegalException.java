package exception;

/**
 * TODO
 *
 * @author ahao 2020-08-22
 */
public class SqlIllegalException extends Exception {
    public SqlIllegalException() {
    }

    public SqlIllegalException(String message) {
        super(message);
    }

    public SqlIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlIllegalException(Throwable cause) {
        super(cause);
    }

    public SqlIllegalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
