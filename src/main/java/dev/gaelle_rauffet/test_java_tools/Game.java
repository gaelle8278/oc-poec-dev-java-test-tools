package dev.gaelle_rauffet.test_java_tools;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Game {
	private Map<Integer, Character> players = new HashMap<Integer, Character>();
	public Scanner sc = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(Game.class);
	private static String[] typesCharacterAllowed= {"warrior"};
	
	
	/**
	 * Launch a game
	 */
	public void launchGame() {
		//default 2 characters
		for (int i = 0; i < 1; i ++ ) {
			System.out.println("= Création du personnage du joueur " + (i+1) + " : ");
			// type of character choose
			int typeCharacter = chooseCharacter();
			// init a character from the type selected
			Character character = initCharacter(typeCharacter);
			// load character values
			setCharacterProp(character, typeCharacter);
			//display charcter values
			displayCharacterProp(character);
			players.put(i+1, character);
           

        }
		playGame();
	}

	/**
	 * Display characters features
	 * @param character
	 */
	private void displayCharacterProp(Character character) {
		String msg = "Caractéristiques du personnage : niveau " + character.getLevel() + ", vitalité : " + character.getLife() + ", force : " + character.getStrength() + ", intelligence " + character.getIntelligence() + ", agilité " + character.getAgility();
		System.out.println(msg);
		logger.info(msg);
	}

	/**
	 * Allow user to choose a type of character
	 * 
	 * @return
	 */
	private int chooseCharacter() {
		boolean responseIsGood= false;
	    int typeCharacter = -1;
	    logger.info("Choix de la classe du personnage ");
		System.out.println("Veuillez choisir la classe de vortre personnage : 1 - Guerrier");
		do {
            try {
            	typeCharacter = sc.nextInt();
                responseIsGood = (typeCharacter == 1);
            } catch (InputMismatchException e) {
                sc.next();
            }
            
            if(responseIsGood) {
            	logger.warn("classe de personnage choisie : " + typesCharacterAllowed[typeCharacter-1]);
            	System.out.println("Vous avez choisi : " + typesCharacterAllowed[typeCharacter-1]);
            } else {
            	System.out.println("Vous devez saisir un nombre, correspondant à la classe du personnage souhaité");
                logger.warn("mauvais choix de classe de personnage, valeur indiquée " + typeCharacter);
            }
        } while ( !responseIsGood );
		
		return typeCharacter;
		
	}

	
	
	/**
	 * Create a character from the type selected
	 * @return
	 */
	private Character initCharacter(int type) {
		Character character = null;
		if(type == 1) {
			character = new Warrior();
		}
		return character;
	}

	/**
	 * Load character properties
	 * @return 
	 * 
	 */
	private void setCharacterProp(Character character, int type) {
		// load character properties depends on player choice
		int typeConfig = askConfigurationMode();
		if(typeConfig == 1) {
			loadDefaultProp(character, type);
		} else {
			loadCustomProp(character);
		}
		
		
	}

	
	/**
	 * Ask how characters properties should be loaded
	 * @return
	 */
	private int askConfigurationMode() {
		int typeConfig = -1;
		boolean responseIsGood = false;
		logger.info("Chargement des valeurs du personnage ");
		System.out.println("Configuration du personnage : 1 - Valeurs par défaut, 2 - Valeurs personnalisées");
		do {
            try {
            	typeConfig = sc.nextInt();
                responseIsGood = (typeConfig == 1 || typeConfig == 2);
            } catch (InputMismatchException e) {
                sc.next();
            }
            
            if(responseIsGood) {
            	String configChoice="";
            	if(typeConfig==1) {
            		configChoice = "automatique avec valeurs par défaut";
            	} else {
            		configChoice = "personnalisée";
            	}
            	System.out.println("Vous avez choisi la configuration : " + configChoice);
                logger.info("type de configuration du personnage " + configChoice);
            } else {
            	System.out.println("Vous devez saisir un nombre, correspondant à la configuration souhaitée");
                logger.warn("mauvais choix de configuration de personnage, valeur indiquée " + typeConfig);
            }
        } while ( !responseIsGood );
		
		return typeConfig;
	}

	/**
	 * Load character from properties file
	 * @param character 
	 */
	private void loadDefaultProp(Character character, int type) {
		logger.warn("chargement des valeurs par défaut du personnage");
		CharactersDefaultProperties propCharacters = new CharactersDefaultProperties();
		propCharacters.loadProperties();
		
		//character.getClass().getNAme();
		if(type == 1) {
			int level = Integer.parseInt(propCharacters.getPropValue("warrior.level"));
			int strength = Integer.parseInt(propCharacters.getPropValue("warrior.strength"));
			int agility = Integer.parseInt(propCharacters.getPropValue("warrior.agility"));
			int intelligence = Integer.parseInt(propCharacters.getPropValue("warrior.intelligence"));
			character.setCharacterProp(level,strength,agility,intelligence);
		}
		
		
	}

	/**
	 * Load character from user entries
	 */
	private void loadCustomProp(Character character) {
		System.out.println("Pas encore fonctionnelle");
		logger.error("la configuration personnalisée du personnage n'est pas encore iimplémentée");
	}

	/**
	 * 
	 */
	private void playGame() {
		System.out.println("Début du combat");
		System.out.println("Merci d'avoir joué");
		
		
	}

}
