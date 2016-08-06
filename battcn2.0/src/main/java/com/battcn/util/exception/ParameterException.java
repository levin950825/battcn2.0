package com.battcn.util.exception;

/**
 * 代码业务异常类
 * @author Administrator
 *
 */
public class ParameterException extends RuntimeException
{

	/** serialVersionUID */
	private static final long serialVersionUID = 6417641452178955756L;

	public ParameterException()
	{
		super();
	}

	public ParameterException(String message)
	{
		super(message);
	}

	public ParameterException(Throwable cause)
	{
		super(cause);
	}

	public ParameterException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
