package qin.javaee7.core.exceptions;

import org.apache.log4j.Logger;

/**
 * 类无法转换
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public class ClassNotCastException extends JavaEE7Exception
{
    private static final long serialVersionUID = -6084986310575763201L;

    private Logger logger = Logger.getLogger(ClassNotCastException.class);

    public ClassNotCastException()
    {
        logger.error("发生了类无法换的异常");
    }
}