package test.study.jna.test;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author sun yang
 * @date 2024/9/4
 */
public interface TestLibrary extends Library {

    TestLibrary INSTANCE = Native.load("test_dell", TestLibrary.class);

    void SayHello(String name);

    void SayHello2();


}
