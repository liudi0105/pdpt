package common.module.errors;

public class NotLoginError extends RuntimeException {
    public NotLoginError(String message) {
        super(message);
    }
}
