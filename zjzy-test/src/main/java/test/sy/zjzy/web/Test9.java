package test.sy.zjzy.web;

/**
 * Created by dell on 2020/1/7.
 */
public class Test9 {

    public static void main(String[] args) {
        System.out.println(Weekday.WED);
        System.out.println(Weekday.WED.ordinal());
        System.out.println(Weekday.WED.getValue());

        System.out.println(Weekday2.WED);
        System.out.println(Weekday2.WED.ordinal());
    }


    enum Weekday{
        SUN(1),MON(2),TUS(3),WED(4),THU(5),FRI(6),SAT(7);

        private int value;

        private Weekday(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    enum Weekday2{
        SUN,MON,TUS,WED,THU,FRI,SAT;
    }

}
