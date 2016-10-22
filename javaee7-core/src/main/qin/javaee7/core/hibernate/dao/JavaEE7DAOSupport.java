package qin.javaee7.core.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateOperations;
import qin.javaee7.core.JavaEE7BaseSupport;
import qin.javaee7.core.hibernate.ClassSupport7;
import qin.javaee7.core.hibernate.SuperEntity7;

import java.io.Serializable;

/**
 * JavaEE7最顶层数据访问层
 *
 * @param <T>  实体类型
 * @param <ID> 主键类型
 */
@SuppressWarnings("all")
public interface JavaEE7DAOSupport<T extends SuperEntity7, ID extends Serializable>
          extends JavaEE7BaseSupport, HibernateOperations,
          ClassSupport7<ID>
{
    //region 获取Session工厂

    /**
     * 获取Session工厂
     *
     * @return
     */
    SessionFactory getSessionFactory();
    //endregion

    //region 获取log4j配置文件路径

    /**
     * 获取log4j配置文件路径
     */
    String getLog4jLocation();
    //endregion
}