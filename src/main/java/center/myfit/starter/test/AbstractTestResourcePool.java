package center.myfit.starter.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

/** Используется в unit тестах для упрощения получения данных из файлов-ресурсов. */
@Slf4j
public abstract class AbstractTestResourcePool {
  public static final String ERROR_IO = "Ошибка при получении данных из файла-ресурса";
  private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

  /** Конструктор. */
  protected AbstractTestResourcePool() {}

  /**
   * Чтение и десериализация.
   *
   * @param resource Файл-ресурс.
   * @param objectClass Класс для десериализации.
   * @return Получившийся объект.
   */
  public static <T> T read(Resource resource, Class<T> objectClass) {
    try {
      return mapper.readValue(resource.getInputStream(), objectClass);
    } catch (IOException e) {
      log.error(ERROR_IO, e);
      throw new ResourcePoolException(e);
    }
  }

  /**
   * Чтение и десериализация.
   *
   * @param resource Файл-ресурс.
   * @param tr Класс для десериализации.
   * @return Получившийся объект.
   */
  public static <T> T read(Resource resource, TypeReference<T> tr) {
    try {
      return mapper.readValue(resource.getInputStream(), tr);
    } catch (IOException e) {
      log.error(ERROR_IO, e);
      throw new ResourcePoolException(e);
    }
  }

  /**
   * Чтение файла-ресурса в строку.
   *
   * @param resource Файл-ресурс.
   * @return Строка из файла.
   */
  public static String getString(Resource resource) {
    try {
      return IOUtils.toString(resource.getInputStream(), Charset.defaultCharset());
    } catch (IOException e) {
      log.error(ERROR_IO, e);
      throw new ResourcePoolException(e);
    }
  }

  private static class ResourcePoolException extends RuntimeException {
    public ResourcePoolException(Throwable cause) {
      super(cause);
    }
  }
}
