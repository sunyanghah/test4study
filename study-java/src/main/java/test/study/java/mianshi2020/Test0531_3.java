package test.study.java.mianshi2020;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by dell on 2020/5/31.
 * @author dell
 */
public class Test0531_3 {
    public static void main(String[] args) throws Exception{
        Account a = new Test0531_3().new Account(5000);
        Account b = new Test0531_3().new Account(5000);
        Random random = new Random();
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                for (int i = 0;i < 1000;i++){
                    try {
                        a.transfer(b,random.nextDouble()*10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                for (int i = 0;i < 1000;i++){
                    try {
                        b.transfer(a,random.nextDouble()*10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a.money.add(b.money).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    class Account{
        private BigDecimal money;
        public Account(double money){
            this.money = new BigDecimal(money);
        }
        public void transfer(Account account,double money) throws Exception{
            synchronized (Account.class) {
                BigDecimal transferMoney = new BigDecimal(money);
                if (this.money.compareTo(transferMoney) > 0) {
                    this.money = this.money.subtract(transferMoney);
                    account.money = account.money.add(transferMoney);
                } else {
                    throw new Exception("余额不足，无法完成转账");
                }
            }
        }

    }


}
