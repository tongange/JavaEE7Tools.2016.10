package qin.javaee7.core.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import qin.javaee7.core.JavaEE7Print;
import qin.javaee7.core.exceptions.ClassNotCastException;
import qin.javaee7.core.exceptions.JavaEE7Exception;
import qin.javaee7.core.hibernate.SuperEntity7;
import qin.javaee7.core.hibernate.dao.JavaEE7DAOSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * JavaEE7最顶层数据访问层实现
 *
 * @param <T>  任意实体类
 * @param <ID> 任意主键类型
 */
@Repository(value = "objectDAO7")
@SuppressWarnings("all")
public class JavaEE7DAOSupportImpl<T extends SuperEntity7, ID extends Serializable>
          extends HibernateTemplate
          implements JavaEE7DAOSupport<T, ID>
{
    private static final long serialVersionUID = 5362007569184097393L;

    //region 定义数据访问层中变量
    /**
     * 输出
     */
    private final JavaEE7Print print = new JavaEE7Print(getLog4jLocation());

    /**
     * 定义控制访问层程序运行标识符
     */
    protected boolean daoFlag = false;
    //endregion

    //region 注入Session工厂
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    @Resource
    @Override
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    //endregion

    //region 获取实体类信息

    /**
     * 获取实体类信息
     *
     * @return 返回指定的实体类
     */
    @Override
    public Class<ID> getEntityClass()
    {
        return (Class<ID>) Serializable.class;
    }
    //endregion

    //region 获取log4j配置文件路径
    @Override
    public String getLog4jLocation()
    {
        return "";
    }
    //endregion

    //region 重写父类数据访问层中的功能

    /**
     * 查询实体类中的所有数据
     *
     * @param entityClass 实体类
     * @param <T>         任意类型实体类
     * @return 查询结果
     * @throws DataAccessException Spring大异常
     */
    @Override
    public <T> List<T> loadAll(Class<T> entityClass) throws DataAccessException
    {
        List<T> result = null;

        try
        {
            //首先判断接收的实体类是否是实现SuperEntity的
            //SuperEntity是项目中所有实体类都要实现的接口
            if (!SuperEntity7.class.isAssignableFrom(entityClass))
            {
                //如果接收的实体类不是SuperEntity的子类则报出类无法转换异常
                throw new ClassNotCastException();
            }

            //指定hql语句
            String hql = new StringBuilder()
                      .append("from ")
                      .append(entityClass.getCanonicalName())
                      .toString();

            //查询全部记录
            result = getSessionFactory()
                      .openSession()
                      .createQuery(hql)
                      .list();

            //输出结果
            print.prints
                      (
                                new StringBuilder()
                                          .append("===in <T> List<T> loadAll(")
                                          .append(entityClass)
                                          .append("\n")
                                          .append("HQL:")
                                          .append(hql)
                                          .append("\n查询结果为:")
                                          .append(print.printCollections(result))
                                          .append("\nend===")
                      );
        }
        catch (JavaEE7Exception ex)
        {
            //如果发生了异常则返回空集合
            result = (List<T>) emptys;
        }
        //项目发生了大异常
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return result;
    }
    //endregion

    //region hql条件查询
    @Override
    public List<?> findByNamedParam(String queryString, String[] paramNames, Object[] values)
              throws DataAccessException
    {
        //输出信息
        print.prints
                  (
                            new StringBuilder()
                                      .append("===in List<?> findByNamedParam(queryString:{")
                                      .append(queryString)
                                      .append('}')
                                      .append("paramNames:{")
                                      .append(print.infoArray(paramNames).toString())
                                      .append('}')
                                      .append("values:{")
                                      .append(print.infoArray(values).toString())
                                      .append("})")
                                      .append("\nend===")
                  );

        return super.findByNamedParam(queryString, paramNames, values);
    }
    //endregion
}