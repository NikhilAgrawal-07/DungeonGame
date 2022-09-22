package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Game Variables
        String[] enemies = {"Skeleton","Zombieee","Gladitor","Hunterrr"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // Player Variable
        int playerHealth = 100;
        int playerAttackDamage = 50;
        int potions = 3;
        int healthGain = 30;
        int healthPotionDropChance = 50;

        boolean running = true;
        Thread.sleep(800);
        System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\tWelcome to the Dungeon!!\t\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
        System.out.println();
        Thread.sleep(800);
        GAME:
        while (running)
        {
            System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t# "+enemy +" appeared!!! # \t\t|");
            Thread.sleep(800);
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
            while (enemyHealth > 0)
            {
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> Your HP: " + playerHealth + "\t\t\t\t|");
                Thread.sleep(800);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t"+"> " +enemy + "'s HP: " + enemyHealth+ "\t\t\t|");
                Thread.sleep(800);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t> What would you like to do?"+ "\t|");
                Thread.sleep(800);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t1. Attack"+ "\t\t\t\t\t|");
                Thread.sleep(800);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t2. Use health potion"+ "\t\t|");
                Thread.sleep(800);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t3. Retreat"+ "\t\t\t\t\t|");
                Thread.sleep(800);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t4. Exit the Dungeon"+ "\t\t\t|");
                Thread.sleep(800);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> Enter the option Number"+ "\t|");
                String answer = sc.nextLine();
                if(answer.equals("1"))
                {
                    int damageDealt = rand.nextInt(playerAttackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    enemyHealth = enemyHealth - damageDealt;
                    playerHealth = playerHealth - damageTaken;
                    Thread.sleep(800);
                    System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> " + enemy + " damage taken " + damageDealt + ".\t|");
                    Thread.sleep(800);
                    System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> Your damage taken " + damageTaken + ".\t\t|");
                    if (playerHealth < 1) {
                        Thread.sleep(800);
                        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
                        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> You have taken too much damage.\t|");
                        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> You are too weak too go.\t\t\t|");
                        break;
                    }
                }
                else if (answer.equals("2"))
                {
                    if (potions > 0) {
                        playerHealth = playerHealth + healthGain;
                        potions--;
                        Thread.sleep(700);
                        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> Health Gain: " + healthGain+ ".\t\t\t|");
                        Thread.sleep(700);
                        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> Potions left: " + potions+ ".\t\t\t|");
                    } else
                        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> You have 0 potions. " + ".\t|");
                    System.out.println(("\t\t\t\t\t\t\t\t\t\t|\t> Defeat an " + enemy + " to get one.\t|"));
                }
                else if (answer.equals("3")) {
                    Thread.sleep(650);
                    System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> You ran away from the " + enemy+ ".\t|");
                    continue GAME;
                }
                else if (answer.equals("4"))
                    break GAME;
                else
                    System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t> Invalid Command.\t\t\t|");
            }
            if(playerHealth < 1)
            {
                Thread.sleep(650);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> Thrown out of the Dungeon.\t\t|");
                break;
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
            Thread.sleep(700);
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> # " + enemy + " was defeated: # \t\t|");
            Thread.sleep(650);
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> You have " + playerHealth + " HP left!! #\t\t\t|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
            System.out.println();

            if (rand.nextInt(100) > healthPotionDropChance)
            {
                potions++;
                Thread.sleep(600);
                System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> # The "+ enemy+" dropped a potion. #|");
                Thread.sleep(600);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t> # You now have " + potions + " potion. #\t\t|");
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
                System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
            }
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
            Thread.sleep(750);
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\tWhat would you like to do?"+ "\t\t|");
            Thread.sleep(750);
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t1. Continue Fighting.\t\t\t|");
            Thread.sleep(750);
            System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t2. Retreat\t\t\t\t\t\t|");
            String answer = sc.nextLine();
            while (!answer.equals("1") && !answer.equals("2"))
            {
                Thread.sleep(650);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t> # Invalid Command. #\t\t\t|");
                answer = sc.nextLine();
            }
            if (answer.equals("1"))
            {
                Thread.sleep(680);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t> # Continue you Adventure. #\t|");
            }
            else if (answer.equals("2"))
            {
                Thread.sleep(600);
                System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t> # You exit the Dungeon!! # \t|");
                break;
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t-----------------------------------------\t\t\t\t\t\t\t\t\t\t");
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\t*****************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
        Thread.sleep(680);
        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t>  Thanks For Playing!!! \t\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("\t\t\t\t\t\t\t\t\t\t*****************************************");
    }

}
