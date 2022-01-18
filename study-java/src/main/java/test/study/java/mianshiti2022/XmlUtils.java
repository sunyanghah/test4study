package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * xml解析工具类
 */
public class XmlUtils {

    public static JSONObject xmlToJson(String xml) {
        return elementToJson((strToDocument(xml)).getRootElement());
    }

    public static String jsonToXml(String json) {
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            JSONObject jObj = JSON.parseObject(json);
            jsonToXmlStr(jObj, buffer);
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static Document strToDocument(String xml) {
        try {
            return DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            return null;
        }
    }

    private static JSONObject elementToJson(Element node) {
        JSONObject result = new JSONObject();
        List<Attribute> listAttr = node.attributes();
        for (Attribute attr : listAttr) {
            result.put(attr.getName(), attr.getValue());
        }
        List<Element> listElement = node.elements();
        if (!listElement.isEmpty()) {
            for (Element e : listElement) {
                if (e.attributes().isEmpty() && e.elements().isEmpty()) {
                    result.put(e.getName(), e.getTextTrim());
                } else {
                    if (!result.containsKey(e.getName())) {
                        result.put(e.getName(), new JSONArray());
                    }
                    ((JSONArray) result.get(e.getName())).add(elementToJson(e));
                }
            }
        }
        return result;
    }

    private static void jsonToXmlStr(JSONObject jObj, StringBuffer buffer) {
        Set<Map.Entry<String, Object>> se = jObj.entrySet();
        for (Map.Entry<String, Object> en : se) {
            if ("com.alibaba.fastjson.JSONObject".equals(en.getValue().getClass().getName())) {
                buffer.append("<").append(en.getKey()).append(">");
                JSONObject jo = jObj.getJSONObject(en.getKey());
                jsonToXmlStr(jo, buffer);
                buffer.append("</").append(en.getKey()).append(">");
            } else if ("com.alibaba.fastjson.JSONArray".equals(en.getValue().getClass().getName())) {
                JSONArray jarray = jObj.getJSONArray(en.getKey());
                for (int i = 0; i < jarray.size(); i++) {
                    buffer.append("<").append(en.getKey()).append(">");
                    JSONObject jsonobject = jarray.getJSONObject(i);
                    jsonToXmlStr(jsonobject, buffer);
                    buffer.append("</").append(en.getKey()).append(">");
                }
            } else if ("java.lang.String".equals(en.getValue().getClass().getName())) {
                buffer.append("<").append(en.getKey()).append(">").append(en.getValue());
                buffer.append("</").append(en.getKey()).append(">");
            }
        }
    }

}

