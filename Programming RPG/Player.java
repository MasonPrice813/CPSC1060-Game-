/*
Mason Price 
4/18/223
Programming Assignment 2
CPSC 1060
*/

public class Player {
    //different variables used across the class
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private int coins;

    //Constructor to make the player
    public Player(String name, int maxHealth, int damage) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
        this.coins = 0;
    }

    //method to get the name
    public String getName() {
        return name;
    }
    //method to get the health of the player
    public int getHealth() {
        return health;
    }
    //method to get the maximum health of the player
    public int getMaxHealth() {
        return maxHealth;
    }
    //method to set the name of the player
    public void setHealth(int health) {
        this.health = health;
    }
    //method to get the damage for the player
    public int getDamage() {
        return damage;
    }
    //method to get the amount of coins the player has
    public int getCoins() {
        return coins;
    }
    //method to add the coins for the player
    public void addCoins(int coins) {
        this.coins += coins;
    }
    //method to remove the coins from the room
    public void removeCoins(int coins) {
        this.coins -= coins;
    }
}
