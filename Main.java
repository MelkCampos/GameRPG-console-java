package game_rpg;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // menu principal do game
    static int Menu() {
        System.out.println("[ 1 ] - Start Game");
        System.out.println("[ 2 ] - Options");
        System.out.println("[ 3 ] - Credits");
        System.out.println("[ 4 ] - Exist");
        return input.nextInt();
    }

    // escolha de campiaão [ caso a escolha seja [1] ]
    static int ChooseChampion(int chooseOption) {
        System.out.println("[ 1 ] - Create New Champion ");
        System.out.println("[ 0 ] - Back");


        if(chooseOption == 0) {
            Menu();
        }

        return input.nextInt();
    }

    // menu de opções [ caso a escolha seja [2] ]
    static int Options(int chooseOption) {
        System.out.println("Music Sound: |||||||||");
        System.out.println("Effect Sound: ||||||");
        System.out.println("[ 0 ] - Back");

        if(chooseOption == 0) {
            Menu();
        }

        return input.nextInt();
    }

    //[ caso a escolha seja [3] ]
    static int Credits(int chooseOption) {
        System.out.println("by: NaSa");
        System.out.println("[ 0 ] - Back");

        if(chooseOption == 0) {
            Menu();
        }

        return input.nextInt();
    }

    static void CreateYourChampion() {
        String championName;

        System.out.print(" Choose a name for your champion: ");
        championName = input.next();

        if(championName == " ") { // essa validação não está funcionando.
            System.out.println("Type a valid name.");
        } else {
            System.out.println("You're Welcome " + championName + "!");
        }

        attack(championName);
    }


    static void gameStatus(int playerHP, int bossHP, int specialAttack){
        System.out.println("=-=-=--=-=-=--=-=-=--=-==-=-=-=-=-=-=-");
        System.out.println("Player HP: " + playerHP);
        System.out.println("Boss HP: " + bossHP);
        System.out.println("Especial Attack: " + specialAttack);
        System.out.println("=-=-=--=-=-=--=-=-=--=-==-=-=-=-=-=-=-");
    }

    static int PlayerAttack() {
        System.out.println("- choose your attack! -");
        System.out.println("[ 1 ] - push attack");
        System.out.println("[ 2 ] - magic");
        System.out.println("[ 3 ] - special attack");
        return input.nextInt();
    }

    static int BossAttack() {
        Random randomAttack = new Random();
        return randomAttack.nextInt(3) + 1;
    }

    static void attack(String championName) {
        int playerHP = 100;
        int bossHP = 120;
        int specialAttack = 3;
        int chooseAttack;

        while(playerHP > 0 && bossHP > 0) {
            gameStatus(playerHP, bossHP, specialAttack);
            chooseAttack = PlayerAttack();

            switch (chooseAttack){
                case 1:
                    System.out.println("You choosed: push!");
                    bossHP -= 30;
                break;

                case 2:
                    System.out.println("You choosed: magic!");
                    bossHP -= 40;
                break;

                case 3:
                    specialAttack--;

                    System.out.println("You choosed: special attack!");
                    System.out.println("You still have " + specialAttack + " special attack.");
                    bossHP -= 70;
                break;

                default:
                    System.out.println("Value Invalid.");
                break;
            }

                if(bossHP > 0) {
                    chooseAttack = BossAttack();

                switch (chooseAttack) {
                    case 1:
                        System.out.println("Boss choosed: push!");
                        playerHP -= 40;
                        break;

                    case 2:
                        System.out.println("Boss choosed: magic!");
                        playerHP -= 55;
                        break;

                    case 3:
                        System.out.println("Boss choosed: special attack!");
                        playerHP -= 72;
                        specialAttack--;
                        break;

                    default:
                        System.out.println("Boss choosed: Value Invalid.");
                        break;
                }
            }
        }

        if(bossHP <= 0 || playerHP <= 0) {

            if(bossHP < 0 || playerHP < 0) {
                bossHP = 0;
                playerHP = 0;
            }
            gameStatus(playerHP, bossHP, specialAttack);
        }

        // verificação de quem ganhou a partida || style dos status do Boss e do Player
        if(bossHP <= 0) {
            System.out.println("You Win " + championName + "!!!");
        }
        else if(playerHP <= 0) {
            System.out.println("You lose ;-;");
        }
    }


    // função que inializa o game
    static void startGame() {
        int chooseOption;
        chooseOption = Menu();

        switch (chooseOption) {
            case 1:
                ChooseChampion(chooseOption);
            break;

            case 2:
                Options(chooseOption);
            break;

            case 3:
                Credits(chooseOption);
             break;

            case 4:
                System.out.println("Are you sure you wanna quit the game?");
                System.out.println("[ 0 ] yes || [ 1 ] not");
                int existGame = input.nextInt();

                if (existGame == 0) {
                    System.out.println("Leaving the game...");
                    System.exit(4);
                } else {

                }

            break;
        }
    }


    public static void main(String[] args) {
        startGame();
        CreateYourChampion();
    }
}
