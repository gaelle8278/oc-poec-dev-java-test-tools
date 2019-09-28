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
	
	
	public void setCharacterProp(int level, int strength, int agility, int intelligence) {
		this.level = level;
		this.life = 5 * this.level;
		this.strength = strength;
		this.agility = agility;
		this.intelligence = intelligence;
	}


	public int getLevel() {
		return level;
	}


	public int getLife() {
		return life;
	}


	public int getStrength() {
		return strength;
	}


	public int getAgility() {
		return agility;
	}


	public int getIntelligence() {
		return intelligence;
	}
	
	

}
