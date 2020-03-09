package com.d365lab.eatery.cache.aircloudposredis.utils.exceptions;


public class KeyAlreadyPresentException extends RuntimeException
{
	public KeyAlreadyPresentException(String msg)
	{
		super(msg);
	}
}
