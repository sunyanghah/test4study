package test.sy.zjzy.functioninterface;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2019/10/18.
 * @author dell
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Test test = new Test();
        splitDoBatch(3,list,(s,objects) -> test.insert(s,(Date) objects[0]),new Date());

    }

    private void insert(List list){
        System.out.println("开始执行插入--------"+JSON.toJSONString(list));
    }
    private void insert(List list,String str){
        System.out.println("this is "+str);
        System.out.println("开始执行插入--------"+JSON.toJSONString(list));
    }

    private void insert(List list,String str,String str2){
        System.out.println("this is "+str+" and "+str2);
        System.out.println("开始执行插入--------"+JSON.toJSONString(list));
    }

    private void insert(List list, Date date){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("now is "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        System.out.println("开始执行插入--------"+JSON.toJSONString(list));
    }

    private static <T> void splitDoBatch(int size, List<T> list, DoBatch doBatch,Object... objects){
        for (int i=0;true;i++){
            int toIndex = (i+1)*size;
            boolean breakFlag = false;
            if (toIndex >= list.size()){
                toIndex = list.size();
                breakFlag = true;
            }
            List<T> tempList = list.subList(i * size, toIndex);
            doBatch.doBatch(tempList,objects);
            if (breakFlag){
                break;
            }
        }
    }


}
