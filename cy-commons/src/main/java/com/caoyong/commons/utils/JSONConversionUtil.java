package com.caoyong.commons.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

/**
 * JSON conversion utils
 *
 * @author caoyong
 * @since 2020-06-03 12:54:09
 */
@Slf4j
public class JSONConversionUtil {
    private static final ObjectMapper om;

    static {
        om = new ObjectMapper();
        om.setSerializationInclusion(Include.NON_NULL);
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * obj to string
     *
     * @param o object
     * @return object JSON string
     */
    public static String objToString(Object o) {
        log.info("objToString start.");
        StringWriter w = new StringWriter();
        try {
            om.writeValue(w, o);
            return w.toString();
        } catch (Exception e) {
            log.error("objToString error:{}", e.getMessage(), e);
        }
        log.info("objToString end.");
        return "";
    }

    /**
     * JSON string to obj
     *
     * @param content JSON string to obj
     * @param cls     class type
     * @return obj
     */
    public static <T> T stringToObj(String content, Class<T> cls) {
        log.info("stringToObj start.");
        try {
            return om.readValue(content, cls);
        } catch (Exception e) {
            log.error("stringToObj error:{}", e.getMessage(), e);
        }
        log.info("stringToObj end.");
        return null;
    }

    /**
     * JSON string to obj list
     *
     * @param content JSON string
     * @param clazz   list class
     * @param <T>     result type
     * @return obj list
     */
    public static <T> List<T> stringToList(String content, Class<T[]> clazz) {
        log.info("stringToList start, content:{}", content);
        List<T> list = null;
        try {
            list = Arrays.asList(om.readValue(content, clazz));
        } catch (Exception e) {
            log.error("stringToList error:{}", e.getMessage(), e);
        }
        log.info("stringToList end.");
        return list;
    }

    /**
     * JSON String to map
     *
     * @param strJSON JSON String
     * @return map value
     */
    public static Map<String, String> jsonToHashMap(String strJSON) {
        Map<String, String> dataMap = new HashMap<>();
        try {
            if (StringUtils.isNotBlank(strJSON)) {
                TypeReference<HashMap<String, String>> typeRef
                        = new TypeReference() {
                };
                dataMap = om.readValue(strJSON, typeRef);
            }
        } catch (Exception e) {
            log.error("jsonToHashMap error:{}", e.getMessage(), e);
        }
        return dataMap;
    }

    /**
     * ojb to HashMap
     *
     * @param o obj
     * @return HashMap
     */
    public static Map<String, String> objTOHashMap(Object o) {
        return jsonToHashMap(objToString(o));
    }

    /**
     * obj to HashMap
     *
     * @param obj          obj
     * @param ignoreFields ignore fields
     * @return result
     */
    public static Map<String, Object> objTOHashMap(Object obj, String... ignoreFields) {
        Map<String, Object> map = new HashMap<>();
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (ignoreFields != null && Arrays.asList(ignoreFields).contains(field.getName())) {
                    continue;
                }
                field.setAccessible(true);
                if (null != field.get(obj))
                    map.put(field.getName(), field.get(obj));
            }
        } catch (IllegalAccessException e) {
            log.info("objTOHashMap error:{}", e.getMessage(), e);
        }
        return map;
    }

    /**
     * get value by key from a JSON
     *
     * @param object JSON string, JsonNode or ArrayNode
     * @param key    the key
     * @return the value string content
     */
    public static String getValueByKeyFromJson(Object object, String key) {
        if (object == null || "".equals(object) || StringUtils.isBlank(key))
            return null;
        Class<?> cls = object.getClass();
        if (Stream.of(String.class, JsonNode.class, ObjectNode.class, ArrayNode.class).noneMatch(c -> cls == c))
            return null;
        if (cls == String.class) {
            try {
                JsonNode root = om.readTree((String) object);
                String tmp = getValueByKeyFromJson(root, key);
                if (tmp != null) {
                    return tmp;
                }
            } catch (Exception ignored) {
            }
        } else {
            JsonNode jsonNode = (JsonNode) object;
            if (jsonNode.isObject()) {
                if (jsonNode.has(key)) {
                    return jsonNode.get(key).asText();
                }
                Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> next = fields.next();
                    JsonNode value = next.getValue();
                    JsonNodeType nodeType = value.getNodeType();
                    if (Stream.of(JsonNodeType.NUMBER, JsonNodeType.STRING).anyMatch(nt -> nt.equals(nodeType)))
                        continue;
                    String tmp = getValueByKeyFromJson(value, key);
                    if (tmp != null) {
                        return tmp;
                    }
                }
            }
            if (jsonNode.isArray()) {
                for (JsonNode jn : jsonNode) {
                    String tmp = getValueByKeyFromJson(jn, key);
                    if (tmp != null) {
                        return tmp;
                    }
                }
            }
        }
        return null;
    }
}
