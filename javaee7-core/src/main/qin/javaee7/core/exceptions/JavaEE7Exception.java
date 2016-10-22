package qin.javaee7.core.exceptions;

import org.apache.log4j.Logger;

/**
 * JavaEE7最大的异常
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public class JavaEE7Exception extends Exception
{
    private static final long serialVersionUID = -6084986310575763201L;

    private Logger logger = Logger.getLogger(JavaEE7Exception.class);

    public JavaEE7Exception()
    {
        logger.error("发生了JavaEE7Exception大异常");
    }
}