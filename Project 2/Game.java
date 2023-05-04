/*
Mason Price & Jude Slade 
4/18/223
Pizza Project
CPSC 1060 lab section 2
*/

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //private variables used throughout the class
    private ArrayList<Room> rooms;
    private Player player;
    private Scanner scanner;

    public Game() {
        //Arraylist for the rooms in this game and a scanner for taking in the user's input
        this.rooms = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    //Method for the game to run
    //helps for easy access to objects
    public void run() {
        String fileName = "";
        //creating the dungeon rooms and the player's object
        createRooms();
        createPlayer();
        //printing out the instructions and the user's goal
        System.out.println("Welcome to the CPSC Dungeons " + player.getName() + "! Your goal is to defeat all of the monsters in each room and collect as many coins as possible.");
        System.out.println("You will gain 2 health points each time you defeat a monster.");
        System.out.println("You start with " + player.getCoins() + " coins.");

        //printing out to the user what room they are in
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.println("\nEntering room: " + room.getName());

            //getting the monsters that are in each room
            ArrayList<Monster> monsters = room.getMonsters();
            for (int j = 0; j < monsters.size(); j++) {
                Monster monster = monsters.get(j);
                //printing out the monster that is located in the room
                System.out.println("\nA " + monster.getName() + " appears!");

                //printing out the user and monster's health and prompting them if they would like to attack or run away from the monster
                while (monster.getHealth() > 0 && player.getHealth() > 0) {
                    System.out.println("Your health: " + player.getHealth());
                    System.out.println("Monster health: " + monster.getHealth());
                    System.out.println("1. Attack");
                    System.out.println("2. Run away");

                    int choice = scanner.nextInt();
                    //If statement for the user if they choose 1
                    if (choice == 1) {
                        //using methods located in the monster class to see what damage the user has done to the monster 
                        //also to know how much damage the monster did to the user
                        int playerDamage = player.getDamage();
                        int monsterDamage = monster.getDamage();

                        //printing out the damage for the user and setting the monsters health after the damage is dealt
                        System.out.println("You attack the " + monster.getName() + " for " + playerDamage + " damage.");
                        monster.setHealth(monster.getHealth() - playerDamage);

                        //if statement for the user to know how much damage was dealt to them
                        if (monster.getHealth() <= 0) {
                            System.out.println("You defeated the " + monster.getName() + "!");
                            player.setHealth(player.getHealth() + 2);
                            player.addCoins(10);
                            break;
                        }

                        System.out.println("The " + monster.getName() + " attacks you for " + monsterDamage + " damage.");
                        player.setHealth(player.getHealth() - monsterDamage);
                        
                        //if the user has died this will come and the game will end
                        if (player.getHealth() <= 0) {
                            System.out.println("You have been defeated by the " + monster.getName() + "!");
                            return;
                        }
                        //if statement for the user if they run away from a monster
                    } else if (choice == 2) {
                        System.out.println("You run away from the " + monster.getName() + ".");
                        break;
                    } else {
                        //input validation for the user's input
                        System.out.println("Invalid choice. Try again.");
                    }
                }
            }

            //telling the user how many coins they acquired and that they have defeated all monsters
            System.out.println("You have defeated all of the monsters in this room!");
            System.out.println("You found " + room.getCoins() + " coins.");

            player.addCoins(room.getCoins());
        }

        //telling the user tey have won the game
        System.out.println("\nCongratulations! You have defeated all of the monsters and collected " + player.getCoins() + " coins.");
    }

        private void createRooms() {
            //creating each room in the dungeon
            rooms.add(new Room("Catacombs of the Haunted Knight", 2, 10, 5, 20));
            rooms.add(new Room("Grotto of the Poisoned Scorpion", 3, 15, 7, 30));
            rooms.add(new Room("The Rugged Quarters", 4, 20, 10, 40));
        }

        //method for creating the player and telling the player how much damage and health they start out with
        private void createPlayer() {
            System.out.println("Enter your name:");
            String name = scanner.next();

            System.out.println("\nYou start with 20 health points and 7 damage per hit\n");
            int maxHealth = 20;
            int damage = 7;

            player = new Player(name, maxHealth, damage);
        }

        //main for starting the game
        public static void main(String[] args) {
            Game game = new Game();
            game.run();
            String fileName = "Game_file.txt";
            try {
                FileOutputStream outputStream = new FileOutputStream(fileName);
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println("Thank you for playing the game");
                printWriter.close();
            } catch (Exception e) {

            }
        }
    }
