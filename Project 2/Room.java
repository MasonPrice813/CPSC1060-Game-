import java.util.ArrayList;
import java.util.Random;

public class Room {
    private String name;
    private ArrayList<Monster> monsters;
    private int coins;

    public Room(String name, int numMonsters, int maxMonsterHealth, int maxMonsterDamage, int coins) {
        this.name = name;
        this.monsters = new ArrayList<>();
        this.coins = coins;

        Random random = new Random();
        String[] monsterNames = {"Minotaur", "Goblin", "Dragon", "DatingApp.java", "Troll", "Vampire", "Wolf", "Ogre", "Alien", "Hydra", "Witch"};
        for (int i = 0; i < numMonsters; i++) {
            String monsterName = monsterNames[random.nextInt(monsterNames.length)];
            int monsterHealth = random.nextInt(maxMonsterHealth) + 1;
            int monsterDamage = random.nextInt(maxMonsterDamage) + 1;
            monsters.add(new Monster(monsterName, monsterHealth, monsterDamage));
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public int getCoins() {
        return coins;
    }
}
