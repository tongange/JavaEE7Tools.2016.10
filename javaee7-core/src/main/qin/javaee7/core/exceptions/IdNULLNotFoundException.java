package qin.javaee7.core.exceptions;

import org.apache.log4j.Logger;

/**
 * Id为空异常
 *
 * @author qinzhengying
 * @since 1.7
 */
@SuppressWarnings("all")
public class IdNULLNotFoundException extends JavaEE7Exception
{
    private static final long serialVersionUID = -6084986310575763201L;

    private Logger logger = Logger.getLogger(IdNULLNotFoundException.class);

    public IdNULLNotFoundException()
    {
        logger.error("发生了实体类主键为空的异常");
    }
}