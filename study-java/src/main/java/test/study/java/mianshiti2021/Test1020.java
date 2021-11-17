package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test1020 {

    public static void main(String[] args) throws JsonProcessingException {
        Son son = new Son();
        son.setId("111");
        son.setName("张三");
        son.setAddress("address");
        son.setFlag(true);
        son.setList(Arrays.asList());
        son.setObj(new HashMap<>());

        Father f = son;
        String str = JSON.toJSONString(f);
        System.out.println(str);

        ObjectMapper objectMapper = new ObjectMapper();
        String str2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(f);
        System.out.println(str2);

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.config(SerializerFeature.SkipTransientField,false);
        serializer.write(f);
        String str3 = out.toString();
        System.out.println(str3);
    }


    public static class Father{
        private String name;

        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Son extends Father implements Serializable {


        private transient boolean flag;

        private transient List<String> list;

        private transient Object obj;

        private transient String address;

        private transient Integer age;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}

