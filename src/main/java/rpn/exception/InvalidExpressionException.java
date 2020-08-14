package rpn.exception;

public class InvalidExpressionException extends RuntimeException {

  public InvalidExpressionException(String message) {
    super(message);
  }

  public InvalidExpressionException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
