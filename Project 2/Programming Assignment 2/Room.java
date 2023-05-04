import java.util.ArrayList;
import java.util.Random;

public class Room {
    //variables used throughout the class
    private String name;
    private ArrayList<Monster> monsters;
    private int coins;

    //constructor for creating the rooms
    public Room(String name, int numMonsters, int maxMonsterHealth, int maxMonsterDamage, int coins) {
        this.name = name;
        this.monsters = new ArrayList<>();
        this.coins = coins;
        //random number generator implemented to randomize the monster's health, attack damage, and name
        Random random = new Random();
        String[] monsterNames = {"Minotaur", "Goblin", "Dragon", "DatingApp.java", "Troll", "Vampire", "Wolf", "Ogre", "Alien", "Hydra", "Witch"};
        //for loop to create the monster
        for (int i = 0; i < numMonsters; i++) {
            String monsterName = monsterNames[random.nextInt(monsterNames.length)];
            int monsterHealth = random.nextInt(maxMonsterHealth) + 1;
            int monsterDamage = random.nextInt(maxMonsterDamage) + 1;
            monsters.add(new Monster(monsterName, monsterHealth, monsterDamage));
        }
    }
    //method for getting the name of the room
    public String getName() {
        return name;
    }
    //method to get all of the monsters
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
    //method for getting the coins in the room
    public int getCoins() {
        return coins;
    }
}
