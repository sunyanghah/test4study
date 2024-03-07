package test.security.jwt.config.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;
import test.security.jwt.config.ApplicationBeanContext;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * JSON 工具
 * @date 2020-08-03
 */
@Slf4j
public class JSONUtils {

  private static class ObjectMapperHolder {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
      ObjectMapper objectMapper;
      try {
        objectMapper = ApplicationBeanContext.getBean(ObjectMapper.class);
      } catch (Exception ex) {
        if (log.isWarnEnabled()) {
          log
            .warn("Can not load [ObjectMapper] instance from spring context, fall back to default.",
              ex);
        }
        objectMapper = new ObjectMapper();
      }
      OBJECT_MAPPER = objectMapper;
    }
  }

  public static ObjectMapper getObjectMapper() {
    return ObjectMapperHolder.OBJECT_MAPPER;
  }
  public static JsonNode parseToJsonNode(String jsonString) {
    try {
      return getObjectMapper().readTree(jsonString);
    } catch (IOException e) {
      return NullNode.getInstance();
    }
  }

  public static <T> T parse(String str, Class<T> clazz) {
    return parse(str, clazz, false);
  }


  public static <T> T parseQuietly(String str, Class<T> clazz) {
    return parse(str, clazz, true);
  }


  public static <T> T parse(String str, Class<T> clazz, boolean nullWhenException) {
    try {
      return getObjectMapper().readValue(str, clazz);
    } catch (IOException e) {
      if (nullWhenException) {
        if (log.isWarnEnabled()) {
          log.warn("JSON parse failed.", e);
        }
        return null;
      } else {
        throw new RuntimeException(e.getMessage());
      }
    }
  }

  /**
   * 反序列化 List
   *
   * @param record str
   * @param clazz  clazz
   * @param <T>    T
   * @return List
   */
  public static <T> List<T> parseListQuietly(String record, Class<T> clazz) {
    if (null == record || "".equals(record)) {
      return Collections.emptyList();
    }
    CollectionType collectionType = getObjectMapper().getTypeFactory()
      .constructCollectionType(List.class, clazz);
    try {
      return getObjectMapper().readValue(record, collectionType);
    } catch (Exception ex) {
      log.warn("parse record to list error.", ex);
    }
    return Collections.emptyList();
  }
}
