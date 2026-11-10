package main.io;

import java.util.Scanner;

public class DisplayManager {
    public static Scanner input = new Scanner(System.in);

    public static void displaySequence(int[] sequence) {
        System.out.println("---------------------------------------------------------------------------------");

        for(int i = 0; i < sequence.length; i++) {
            if(i%20 == 0 && i != 0) {
                System.out.println("|");
            }
            System.out.printf("|%3d", sequence[i]);
        }

        System.out.println("|\n---------------------------------------------------------------------------------");
    }

    public static void pressEnterToContinue() {
        
        System.out.println("Press enter to continue.");
        input.nextLine();
    }
}
