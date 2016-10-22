package qin.javaee7.core.hibernate;

import java.io.Serializable;

/**
 * 超级实体接口
 *
 * @param <ID> 任意实体类型
 */
@SuppressWarnings("all")
public interface SuperEntity7<ID extends Serializable>
{
    /**
     * 获取主键
     *
     * @return 获取到的主键
     */
    ID getId();

    /**
     * 设置主键
     *
     * @param id 实体类主键
     */
    void setId(ID id);
}