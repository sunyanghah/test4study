package test.study.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

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

        testExists();

    }

    /**
     * NodeCreated
     * NodeDeleted
     * NodeDataChanged
     * @throws Exception
     */
    public static void testExists() throws Exception{
        String path="/testWatcher";
//        if(zooKeeper.exists(path,false)==null) {
//            zooKeeper.create(path, "this is value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        }
        Thread.sleep(1000);
        System.out.println("-----------");
        Stat stat = zooKeeper.exists(path,true);
        System.in.read();
    }

    /**
     * NodeDeleted
     * NodeDataChanged
     * @throws Exception
     */
    public static void testGetData() throws Exception{
        String path="/testWatchGetData";
        if(zooKeeper.exists(path,false)==null) {
            zooKeeper.create(path, "this is value 22".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        byte[] data = zooKeeper.getData(path, true, null);
        System.out.println("---------");
        System.out.println(new String(data));
        System.out.println("---------");
        System.in.read();
    }

    /**
     * NodeDeleted
     * NodeChildrenChanged
     * @throws Exception
     */
    public static void testGetChildren() throws Exception{
        String path="/testWatchGetChildren";
        if(zooKeeper.exists(path,false)==null) {
            zooKeeper.create(path, "this is value 33".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        List<String> childrenList = zooKeeper.getChildren(path, true);
        System.out.println("---------");
        childrenList.forEach(System.out::println);
        System.out.println("---------");
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
