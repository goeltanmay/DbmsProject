import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.descriptor.JspConfigDescriptor;

public class Model1 implements ServletContextListener

{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("Context Initialized!!");
		
	}

	
}
