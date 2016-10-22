package qin.javaee7.core.spring;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring工具类
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public final class SpringTools
{
    //region 私有化构造函数
    private SpringTools()
    {

    }
    //endregion

    //region 此类引用
    public static final SpringTools spring_INSTANCE = new SpringTools();
    //endregion

    //region 获取ApplicationContext.xml

    /**
     * 获取ApplicationContext.xml(默认路径下的配置文件)
     *
     * @return
     */
    public ApplicationContext getApplicationContext()
    {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    //endregion

    //region 获取Session工厂
    public SessionFactory getSessionFactory()
    {
        return (SessionFactory) getApplicationContext()
                  .getBean("sessionFactory");
    }
    //endregion
}