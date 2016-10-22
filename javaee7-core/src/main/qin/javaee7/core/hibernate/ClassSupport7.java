package qin.javaee7.core.hibernate;

import java.io.Serializable;

/**
 * 获取实体类 类信息
 *
 * @param <T> 任意实体类
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public interface ClassSupport7<T extends Serializable>
{
    //region 获取实体类信息

    /**
     * 获取实体类信息
     *
     * @return 返回指定的实体类
     */
    Class<T> getEntityClass();
    //endregion
}