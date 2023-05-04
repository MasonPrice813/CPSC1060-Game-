public class Monster {
    private String name;
    private int health;
    private int damage;

    //constructor for creating a monster
    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    //method for getting the name of the monster
    public String getName() {
        return name;
    }
    //method for getting the health of the monster
    public int getHealth() {
        return health;
    }
    //method for setting the health of the monster
    public void setHealth(int health) {
        this.health = health;
    }
    //method for getting the damage of the monster
    public int getDamage() {
        return damage;
    }
}
