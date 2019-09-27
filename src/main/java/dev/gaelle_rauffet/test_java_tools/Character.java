package dev.gaelle_rauffet.test_java_tools;

/**
 * Defines the base of a character
 * 
 * @author gaelle
 *
 */
public abstract class Character {
	private int level;
	private int life;
	private int strength;
	private int agility;
	private int intelligence;
	
	
	public Character (int level, int strength, int agility, int intelligence) {
		this.level = level;
		this.life = 5 * this.level;
		this.strength = strength;
		this.agility = agility;
		this.intelligence = intelligence;
	}
	
	

}
