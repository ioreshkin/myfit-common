package center.myfit.starter.exception;

/** Исключение - не авторизован. */
public class UnauthorizedException extends RuntimeException {
  /**
   * Конструктор с информационным сообщением.
   *
   * @param message - сообщение о причинах ошибки.
   */
  public UnauthorizedException(String message) {
    super(message);
  }
}
