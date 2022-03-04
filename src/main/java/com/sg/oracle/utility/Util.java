package com.sg.oracle.utility;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Util
{
	
	private static final String PACKAGE_NAME = "com.sg.utility";
	private static final String FILE_NAME_GENERAL = "sistem_hata_kayit";
	private static final String FILE_NAME_EXCEPTION = "sistem_hata_kayit_istisna";
	private static final String LOG_PATH = "C:/sg/log/" + FILE_NAME_GENERAL;
	private static final String LOG_PATH_EXCEPTION = "D:/sg/log/" + FILE_NAME_EXCEPTION;

	private Util() {}
	
	public static <E> void showList(List<E> list)
	{
		for (E entity : list) 
		{
			System.out.println(entity);
		}
	}
	
	public static void createLogFile(Level level, String message)
	{
		Logger loggerGeneral = Logger.getLogger(PACKAGE_NAME);
		Logger loggerException = Logger.getLogger(PACKAGE_NAME);
		
		FileHandler fileHandlerGeneral = null;
		FileHandler fileHandlerException = null;
		try
		{
			fileHandlerGeneral = new FileHandler(LOG_PATH);
			fileHandlerException = new FileHandler(LOG_PATH_EXCEPTION);
			
			loggerGeneral.addHandler(fileHandlerGeneral);
			loggerGeneral.log(level, message);
		}
		catch (SecurityException e) 
		{
			
			loggerException.addHandler(fileHandlerException);
			loggerException.log(level, showGeneralException(e));
		}
		catch (IOException e) 
		{
			loggerException.addHandler(fileHandlerException);
			loggerException.log(level, showGeneralException(e));
		}
	}
	
	
	public static String showGeneralException(Exception e)
	{
		return e.getClass().getSimpleName() 
				+ " id occured. Error message: " + e.getMessage();
	}
	
}
