package qin.javaee7.test;

import org.junit.Test;
import qin.javaee7.core.JavaEE7Print;

public class JavaEE7PrintTest
{
    private String path = "D:\\idea2016WK\\javaee7tools2016.10\\src\\resources\\log4j.properties";

    @Test
    public void info()
    {
        JavaEE7Print j = new JavaEE7Print(path);
        j.prints("abc");//13061641015
        Object o = Long.MAX_VALUE;
        j.prints(o.toString().length());
    }
}