package zav.test.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonUtils {
  private static final Path RESOURCES = Paths.get("src/test/resources");
  
  /**
   * Deserializes the file with the specified name.
   *
   * @param fileName The file name of the serialized class.
   * @param clazz The desired target class.
   * @param <T> The desired class type.
   * @return A deserialized instance.
   */
  public static <T> T read(String fileName, Class<T> clazz) {
    try {
      ObjectMapper om = new ObjectMapper();
      return om.readValue(RESOURCES.resolve(fileName).toFile(), clazz);
    } catch (IOException e) {
      throw new IllegalArgumentException(e.getMessage(), e);
    }
  }
}
