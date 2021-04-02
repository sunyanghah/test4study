package test.study.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author sunYang
 * @Date 2021-04-01
 */
public class TestWatcher {

    static ZooKeeper zooKeeper;
    static {
        try {
            zooKeeper = new ZooKeeper("212.64.40.52:2181,212.64.40.52:2182,212.64.40.52:2183", 4000,new MyWatcher());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        String path="/testWatcher";
        if(zooKeeper.exists(path,false)==null) {
            zooKeeper.create("/testWatcher", "this is value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        Thread.sleep(1000);
        System.out.println("-----------");
        Stat stat = zooKeeper.exists(path,true);
        System.in.read();

    }

    /**
     *
     */
    public static class MyWatcher implements Watcher{

        @Override
        public void process(WatchedEvent event) {
            System.out.println("eventType:"+event.getType());
        }
    }

}
