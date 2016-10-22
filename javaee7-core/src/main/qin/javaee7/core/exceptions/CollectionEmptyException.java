package qin.javaee7.core.exceptions;

import org.apache.log4j.Logger;

/**
 * 集合为空异常
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public class CollectionEmptyException extends JavaEE7Exception
{
    private static final long serialVersionUID = -6084986310575763201L;

    private Logger logger = Logger.getLogger(CollectionEmptyException.class);

    public CollectionEmptyException()
    {
        logger.error("发生了集合为空的异常");
    }
}