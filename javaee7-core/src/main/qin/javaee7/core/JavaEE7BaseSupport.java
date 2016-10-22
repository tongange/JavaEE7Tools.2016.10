package qin.javaee7.core;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/**
 * JavaEE7最基础接口
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public interface JavaEE7BaseSupport extends Serializable, RandomAccess
{
    //region html各种模板字符串
    /**
     * 换行符
     */
    String html_br = "<br>";

    /**
     * nbsp换行
     */
    String html_nbsp = "&nbsp;";

    /**
     * 全角空格
     */
    String html_nbsp2 = "　";
    //endregion

    //region 控制层专用字符串
    /**
     * 成功
     */
    String str_success = "success";

    /**
     * 失败
     */
    String str_failed = "failed";
    //endregion

    //region 输出字符串
    /**
     * 开始字符串
     */
    char c_start = '[';

    /**
     * 结束字符串
     */
    char c_end = ']';
    //endregion

    //region 空集合
    List<Object> emptys = Collections.emptyList();
    //endregion

    //region DAO层专用字符串
    /**
     * DAO层输出结束
     */
    String dao_end = "\nend===";
    //endregion
}