package dev.gaelle_rauffet.test_java_tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info("Démarrage de l'application");
		Game game = new Game();
		game.launchGame();
		logger.info("Fin de l'application");
		

	}

}
