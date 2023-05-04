import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Room> rooms;
    private Player player;
    private Scanner scanner;

    public Game() {
        this.rooms = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    //Method for the game to run
    //helps for easy access to objects
    public void run() {
        //creating the dungeon rooms and the 
        createRooms();
        createPlayer();

        //printing out the instructions and the user's goal
        System.out.println("Welcome to the CPSC Dungeons! " + player.getName() + " Your goal is to defeat all of the monsters in each room and collect as many coins as possible.");
        System.out.println("You will gain 2 health points each time you defeat a monster");
        System.out.println("You start with " + player.getCoins() + " coins.");

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.println("\nEntering room: " + room.getName());

            ArrayList<Monster> monsters = room.getMonsters();
            for (int j = 0; j < monsters.size(); j++) {
                Monster monster = monsters.get(j);

                System.out.println("\nA " + monster.getName() + " appears!");

                while (monster.getHealth() > 0 && player.getHealth() > 0) {
                    System.out.println("Your health: " + player.getHealth());
                    System.out.println("Monster health: " + monster.getHealth());
                    System.out.println("1. Attack");
                    System.out.println("2. Run away");

                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        int playerDamage = player.getDamage();
                        int monsterDamage = monster.getDamage();

                        System.out.println("You attack the " + monster.getName() + " for " + playerDamage + " damage.");
                        monster.setHealth(monster.getHealth() - playerDamage);

                        if (monster.getHealth() <= 0) {
                            System.out.println("You defeated the " + monster.getName() + "!");
                            player.setHealth(player.getHealth() + 2);
                            player.addCoins(10);
                            break;
                        }

                        System.out.println("The " + monster.getName() + " attacks you for " + monsterDamage + " damage.");
                        player.setHealth(player.getHealth() - monsterDamage);

                        if (player.getHealth() <= 0) {
                            System.out.println("You have been defeated by the " + monster.getName() + "!");
                            return;
                        }
                    } else if (choice == 2) {
                        System.out.println("You run away from the " + monster.getName() + ".");
                        break;
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }
                }
            }

            System.out.println("You have defeated all of the monsters in this room!");
            System.out.println("You found " + room.getCoins() + " coins.");
            player.addCoins(room.getCoins());
        }

        System.out.println("\nCongratulations! You have defeated all of the monsters and collected " + player.getCoins() + " coins.");
    }

    private void createRooms() {
        rooms.add(new Room("Room 1", 2, 10, 5, 20));
        rooms.add(new Room("Room 2", 3, 15, 7, 30));
        rooms.add(new Room("Room 3", 4, 20, 10, 40));
    }

    private void createPlayer() {
        System.out.println("Enter your name:");
        String name = scanner.next();

        System.out.println("\nYou start with 20 health points and 7 damage per hit\n");
        int maxHealth = 20;
        int damage = 7;

        player = new Player(name, maxHealth, damage);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
