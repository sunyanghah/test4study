package test.sy.zjzy.functioninterface;

import java.util.List;

/**
 * Created by dell on 2019/10/18.
 * @author dell
 */
@FunctionalInterface
public interface DoBatch {

    void doBatch(List list,Object... objects);

}
