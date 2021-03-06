package com.chapter2;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCBasics
{
	public static void main(String[] args)
	{
		Connection conn =null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:db/test.db");//If test.db does not exist it creates one and opens it
			
System.out.println("\n\t" + conn.getMetaData().getDatabaseProductName());
System.out.println("\n\t" + conn.getMetaData().getDatabaseProductVersion());
System.out.println("\n\t" + conn.getMetaData().getDriverName());
		}catch (Exception e)
		{
System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(-1);
		}
		finally
		{
			if (null !=conn)
			{
				try
				{
					conn.close();
				}
				catch (Exception e)
				{
System.err.println(e.getClass().getName() + ": " + e.getMessage());
					System.exit(-1);
				}
			}
		}

	}

}
