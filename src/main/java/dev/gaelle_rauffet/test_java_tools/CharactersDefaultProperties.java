package dev.gaelle_rauffet.test_java_tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharactersDefaultProperties {
	
	private Properties prop;
	private static final Logger logger = LogManager.getLogger(CharactersDefaultProperties.class);
	
	public CharactersDefaultProperties() {
		this.prop = new Properties();
	}
	
	/**
	 * Loads properties from a .properties file in classpath
	 */
	public void LoadProperties() {
		try {
			InputStream input = CharactersDefaultProperties.class.getClassLoader().getResourceAsStream("application.properties");

            //load a properties file from class path, inside static method
            prop.load(input);

        } catch (IOException e) {
        	logger.error("Erreur récupération fichier properties", e);
        } 
	}
	
	/**
	 * Returns value for the given properties key
	 * 
	 * @param propKey
	 * @return
	 */
	public String getPropValue(String propKey) {
		return prop.getProperty(propKey);
	}
	
	

}
