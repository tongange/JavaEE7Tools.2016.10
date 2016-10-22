package qin.javaee7.core;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;

/**
 * JavaEE7输出功能
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public class JavaEE7Print implements Printable
{
    private static final long serialVersionUID = 6856819471840794228L;

    //region 定义log4j.properties文件路径
    private String log4jLocation;
    //endregion

    //region 私有化构造函数
    private JavaEE7Print()
    {

    }

    /**
     * 初始化log配置文件路径构造函数
     *
     * @param log4jLocation
     */
    public JavaEE7Print(String log4jLocation)
    {
        this.log4jLocation = log4jLocation;
    }
    //endregion

    //region 日志对象
    private Logger logger = Logger.getLogger(JavaEE7Print.class);
    //endregion

    //region 输出任意信息

    /**
     * 普通输出方法
     *
     * @param messages 任意想要输出的对象
     */
    private final void custInfo(Object... messages)
    {
        for (int i = 0; i < messages.length; i++)
        {
            System.out.println("普通输出功能:" + messages[i] + "----------------------");
        }
    }

    /**
     * 输出任意信息<br>
     * 模拟<code>System.out.println();</code>
     *
     * @param messages 任意想要输出的参数
     */
    public void info(Object... messages)
    {
        for (int i = 0; i < messages.length; i++)
        {
            //logger对象只有在log4j.properties文件存在的情况下输出语句
            logger.info(messages[i] + "=====================");
        }
    }

    /**
     * 输出任意信息
     *
     * @param msgs 可输出任意信息
     */
    @Override
    public void prints(Object... messages)
    {
        File file = new File(getLog4jLocationPath());

        if (!file.exists())
        {
            System.out.println(c_start + "log4j.properties配置文件不存在" + c_end);
            custInfo(messages);
        }
        else
        {
            //如果存在判断其内容是否为全注释
            try
            {
                //使用流来读取文件
                BufferedReader reader = new BufferedReader
                          (
                                    new InputStreamReader
                                              (
                                                        new FileInputStream(file), "utf-8"
                                              )
                          );

                String r = "";

                //读取文件中的所有内容
                for (String line = ""; (line = reader.readLine()) != null; )
                {
                    r += line + "\n";
                }

                if (r.contains("#log4j."))
                {
                    //如果log4j中是注解则使用普通注释
                    for (int i = 0; i < messages.length; i++)
                    {
                        custInfo(c_start + "" + messages[i] + c_end);
                    }
                }
                else
                {
                    for (int i = 0; i < messages.length; i++)
                    {
                        //如果log4j中没有注解则使用配置文件中的方式来打印
                        info(c_start + "" + messages[i] + c_end);
                    }
                }
            }
            catch (IOException e)
            {
                //Auto-generated catch block
                System.out.println(c_start + "" + e + c_end);
            }
        }
    }
    //endregion

    //region 获取log4j.properties文件路径

    /**
     * 获取log4j.properties文件路径
     *
     * @return 返回log4j.properties文件路径
     */
    @Override
    public String getLog4jLocationPath()
    {
        return log4jLocation;
    }
    //endregion

    //region 输出任意集合信息

    /**
     * 输出任意集合信息
     *
     * @param c
     * @param <T>
     */
    public <T> String printCollections(Collection<T>... c)
    {
        StringBuilder sb = new StringBuilder("集合中的值为[");

        for (int i = 0; i < c.length; i++)
        {
            for (Iterator<T> it = c[i].iterator(); it.hasNext(); )
            {
                sb.append(it.next());
            }
        }

        sb.append("\t");
        sb.append(c_end);

        return sb.toString();
    }
    //endregion

    //region 普通输出数组方法

    /**
     * 普通输出数组方法
     *
     * @param messages 任意想要输出的对象
     */
    public StringBuilder infoArray(Object... messages)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < messages.length; i++)
        {
            result.append(messages[i] + "----------------------");
        }

        return result;
    }
    //endregion
}