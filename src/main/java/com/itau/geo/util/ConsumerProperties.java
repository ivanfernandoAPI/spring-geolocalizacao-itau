package com.itau.geo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConsumerProperties {
	
    public static Properties getProp() throws IOException {
		
	InputStream inputStream = ConsumerProperties.class.getClassLoader().getResourceAsStream("application.properties");
		
        Properties props = new Properties();
        
        props.load(inputStream);
        
        return props;
 
    }
	
    public static Properties getPropEnvironment() throws IOException {
		
	String environment = getProp().getProperty("spring.profiles.active");
		
	InputStream inputStream = ConsumerProperties.class.getClassLoader().getResourceAsStream("application-"+  environment + ".properties");
		
        Properties props = new Properties();
        
        props.load(inputStream);
        
        return props;
 
    }
}
