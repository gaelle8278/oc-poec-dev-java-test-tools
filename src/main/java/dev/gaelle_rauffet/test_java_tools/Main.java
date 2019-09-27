package dev.gaelle_rauffet.test_java_tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info("Démarrage de l'application");
		CharactersDefaultProperties propCharacters = new CharactersDefaultProperties();
		propCharacters.LoadProperties();
		
		System.out.println(propCharacters.getPropValue("warrior.strength"));
		

	}

}
