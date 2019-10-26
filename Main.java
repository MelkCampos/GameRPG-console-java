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
    }


    static void gameStatus(int playerHP, int bossHP, int specialAttack){
        System.out.println("\n=-=-=--=-=-=--=-=-=--=-==-=-=-=-=-=-=-");
        System.out.println("Player HP: " + playerHP);
        System.out.println("Boss HP: " + bossHP);
        System.out.println("Especial Attack: " + specialAttack);
        System.out.println("=-=-=--=-=-=--=-=-=--=-==-=-=-=-=-=-=-");
    }

    static int PlayerAttack() {
        System.out.println("\n- choose your attack! -");
        System.out.println("[ 1 ] - push attack");
        System.out.println("[ 2 ] - magic");
        System.out.println("[ 3 ] - special attack");
        return input.nextInt();
    }

    static int BossAttack() {
        Random randomAttack = new Random();
        return randomAttack.nextInt(3) + 1;
    }

    // mundos iniciais
    static void firstWorld() {
        System.out.println("=-=-=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=-");
        System.out.println("\nWelcome to Azarel!");
        System.out.println("\n THE BATTLE START NOW!");

        bossEasy();
    }
    
    static void secondtWorld() {
        System.out.println("=-=-=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=-");
        System.out.println("\nWelcome to Insomnia!");
        System.out.println("\n THE BATTLE START NOW!");

        bossEasy();
    }

    static void thirdtWorld() {
        System.out.println("=-=-=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=-");
        System.out.println("\nWelcome to Sarquize!");
        System.out.println("\n THE BATTLE START NOW!");

        bossEasy();
    }


    static int chooseWorld() {
        System.out.println("Choose your world!");
        System.out.println("[ 1 ] - Azarel");
        System.out.println("[ 2 ] - Insomnia");
        System.out.println("[ 3 ] - Sarquize");
        return input.nextInt();
    }

    // configurações de escolhas da primeira fase || segundo menu principal de configurações
    static void startWorld() {
        int chooseOption;
        chooseOption = chooseWorld();

        System.out.println("=-=-=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=-");
        System.out.println("Fish! You found a monster..");
        System.out.println("Now choose a name for your champion and fight with him!");
        System.out.println("=-=-=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=-");

        CreateYourChampion();

        switch (chooseOption) {
            case 1:
                firstWorld();
                break;

            case 2:
                secondtWorld();
                break;

            case 3:
                thirdtWorld();
                break;
        }
    }

    
    // função que inializa o game || primeiro menu principal de configurações
    static void startGame() {
        int chooseOption;
        chooseOption = Menu();

        switch (chooseOption) {
            case 1:
                startWorld();
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

    static void bossEasy() {
        int playerHP = 100;
        int bossHP = 120;
        int specialAttack = 2;
        int chooseAttack;

        while(playerHP > 0 && bossHP > 0) {
            gameStatus(playerHP, bossHP, specialAttack);
            chooseAttack = PlayerAttack();

            switch (chooseAttack){
                case 1:
                    System.out.println("YOU CHOOSED: PUSH!");
                    bossHP -= 17;
                    break;

                case 2:
                    System.out.println("YOU CHOOSED: MAGIC!");
                    bossHP -= 35;
                    break;

                case 3:
                    specialAttack--;

                    System.out.println("YOU CHOOSE: SPECIAL ATTACK!");
                    System.out.println("You still have " + specialAttack + " special attack.");
                    bossHP -= 42;
                    specialAttack--;


                    if(specialAttack <= 0) {
                        specialAttack = 0;

                        System.out.println("You don't have special attack anymore..");
                    }
                    break;

                default:
                    System.out.println("Value Invalid.");
                    break;
            }

            if(bossHP > 0) {
                chooseAttack = BossAttack();

                switch (chooseAttack) {
                    case 1:
                        System.out.println("BOSS CHOOSED: PUSH!");
                        playerHP -= 20;
                        break;

                    case 2:
                        System.out.println("BOSS CHOOSED: MAGIC!");
                        playerHP -= 32;
                        break;

                    case 3:
                        System.out.println("BOSS CHOOSED: SPECIAL ATTACK!");
                        playerHP -= 40;
                        specialAttack--;


                        if(specialAttack <= 0) {
                            specialAttack = 0;

                            System.out.println("You don't have special attack anymore..");
                        }
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
            System.out.println("\nYou Win!");
            bossMedium();
        }
        else if(playerHP <= 0) {
            System.out.println("\nYou lose ;-;");
        }
    }


    static void bossMedium() {
        int playerHP = 200;
        int bossHP = 230;
        int specialAttack = 3;
        int chooseAttack;

        while(playerHP > 0 && bossHP > 0) {
            gameStatus(playerHP, bossHP, specialAttack);
            chooseAttack = PlayerAttack();

            switch (chooseAttack){
                case 1:
                    System.out.println("You choosed: push!");
                    bossHP -= 40;
                    break;

                case 2:
                    System.out.println("You choosed: magic!");
                    bossHP -= 55;
                    break;

                case 3:
                    specialAttack--;

                    System.out.println("You choosed: special attack!");
                    System.out.println("You still have " + specialAttack + " special attack.");
                    bossHP -= 60;
                    specialAttack--;

                    if(specialAttack <= 0) {
                        specialAttack = 0;

                        System.out.println("You don't have special attack anymore..");
                    }
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
                        playerHP -= 42;
                        break;

                    case 2:
                        System.out.println("Boss choosed: magic!");
                        playerHP -= 53;
                        break;

                    case 3:
                        System.out.println("Boss choosed: special attack!");
                        playerHP -= 65;
                        specialAttack--;


                        if(specialAttack <= 0) {
                            specialAttack = 0;

                            System.out.println("Boss don't have special attack anymore..");
                        }
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
            System.out.println("\nYou Win!");
            bossHard();
        }
        else if(playerHP <= 0) {
            System.out.println("\nYou lose ;-;");
        }
    }


    static void bossHard() {
        int playerHP = 300;
        int bossHP = 360;
        int specialAttack = 3;
        int chooseAttack;

        while(playerHP > 0 && bossHP > 0) {
            gameStatus(playerHP, bossHP, specialAttack);
            chooseAttack = PlayerAttack();

            switch (chooseAttack){
                case 1:
                    System.out.println("You choosed: push!");
                    bossHP -= 52;
                    break;

                case 2:
                    System.out.println("You choosed: magic!");
                    bossHP -= 58;
                    break;

                case 3:
                    specialAttack--;

                    System.out.println("You choosed: special attack!");
                    System.out.println("You still have " + specialAttack + " special attack.");
                    bossHP -= 75;
                    specialAttack--;

                    if(specialAttack <= 0) {
                        specialAttack = 0;

                        System.out.println("You don't have special attack anymore..");
                    }
                    break;

                default:
                    System.out.println("Value Invalid.");
                    break;
            }

            if(bossHP > 0) {
                chooseAttack = BossAttack();

                // 52, 58, 75
                switch (chooseAttack) {
                    case 1:
                        System.out.println("Boss choosed: push!");
                        playerHP -= 55;
                        break;

                    case 2:
                        System.out.println("Boss choosed: magic!");
                        playerHP -= 60;
                        break;

                    case 3:
                        System.out.println("Boss choosed: special attack!");
                        playerHP -= 72;
                        specialAttack--;

                        if(specialAttack <= 0) {
                            specialAttack = 0;

                            System.out.println("Boss don't have special attack anymore..");
                        }
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
            System.out.println("\nYou Win!");

        }
        else if(playerHP <= 0) {
            System.out.println("\nYou lose ;-;");
        }
    }



    public static void main(String[] args) {
        startGame();
    }
}
