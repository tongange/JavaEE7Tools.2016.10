package qin.javaee7.core;

/**
 * 专用输出接口
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public interface Printable extends JavaEE7BaseSupport
{
    //region 输出任意信息

    /**
     * 输出任意信息
     *
     * @param msgs 可输出任意信息
     */
    void prints(Object... msgs);
    //endregion

    //region 获取log4j.properties文件路径

    /**
     * 获取log4j.properties文件路径
     *
     * @return 返回log4j.properties文件路径
     */
    String getLog4jLocationPath();
    //endregion
}