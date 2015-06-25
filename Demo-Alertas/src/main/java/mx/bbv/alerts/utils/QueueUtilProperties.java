package mx.bbv.alerts.utils;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueUtilProperties {
	private Properties properties;
	private Logger logger = LoggerFactory.getLogger(QueueUtilProperties.class);
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public void printProperties() {
		logger.info("{}", properties.toString());
	}
	
	public String getByName (String key){
		return properties.getProperty(key);		
	}
}