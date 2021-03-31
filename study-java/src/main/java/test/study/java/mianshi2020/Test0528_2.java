package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/28.
 */
public class Test0528_2 {

    public static void main(String[] args) {
        SingleInstance instance = SingleInstance.getInstance();
        System.out.println(instance);
    }

    static class SingleInstance{
        private static volatile SingleInstance singleInstance;

        private SingleInstance(){}

        public static SingleInstance getInstance(){
            if(singleInstance == null){
                synchronized(SingleInstance.class){
                    //double checking Singleton instance
                    if(singleInstance == null){
                        singleInstance = new SingleInstance();
                    }
                }
            }
            return singleInstance;
        }
    }

}
