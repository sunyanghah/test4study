package test.study.news.web;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2019/8/27.
 */
public class MyTest7 {


    public static void main(String[] args) throws Exception{

        write();
        getNum();
        System.out.println(JSON.toJSONString(readList(1000)));
        getNum();
    }

    private static void getNum() throws Exception{
        System.out.println(getData().size());
    }

    private static List<String> readList(Integer num) throws Exception{
        List<String> rtList = new ArrayList<>();
        ArrayList<String> list = getData();
        if (num > list.size()){
            throw new Exception("剩余识别码数量不足，剩余"+list.size());
        }
        for (int i = 0;i < num ;i++){
            rtList.add(list.remove(list.size()-1));
        }
        writeObj(list);
        return rtList;

    }
    private static String readSingle() throws Exception{
        ArrayList<String> list = getData();
        String item = list.remove(list.size()-1);
        writeObj(list);
        return item;
    }

    /**
     * 这个方法IO速度是性能瓶颈
     * @return
     * @throws Exception
     */
    private static ArrayList<String> getData() throws Exception{
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("E:/test/a.txt")));
            return (ArrayList<String>) ois.readObject();
        }finally {
            if (ois != null){
                ois.close();
            }
        }
    }

    private static void write() throws Exception{
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<1000000;i++){
            String iStr = String.valueOf(i);
            StringBuilder sb = new StringBuilder("");
            if (iStr.length() < 6){
                for (int j =0;j<6-iStr.length();j++){
                    sb.append("0");
                }
            }
            sb.append(iStr);
            list.add(sb.toString());
        }
        chaos(list);
        writeObj(list);
    }

    /**
     * 百万数据打乱，平均用时仅0.3秒左右
     * @param arr
     */
    private static void chaos(ArrayList<String> arr){
        int i = arr.size();
        Random random = new Random();
        while(i > 0){
            i--;
            Integer randomIndex = random.nextInt(arr.size());
            String temp = arr.get(i);
            arr.set(i,arr.get(randomIndex));
            arr.set(randomIndex,temp);
        }
    }

    /**
     * 这个方法IO速度是性能瓶颈
     * @return
     * @throws Exception
     */
    private static void writeObj(Object object) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("E:/test/a.txt")));
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }


}
