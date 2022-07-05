package com.company;

import java.util.Scanner;

public class Commands {
    private final Scanner scanner = new Scanner(System.in);
    private final String[] commands;

    public Commands(String[] commands) {
        this.commands = commands;
    }

    public void printCommands(){
        printCommands(commands);
    }

    private void printCommands(String[] commands){
        for (int i = 0; i < commands.length; i++) {
            System.out.println((i + 1) + " : " + commands[i]);
        }
    }

    private int getIntegerInput(int rangeLimit){

        int input = 0;
        boolean isActive = true;

        while(isActive){
            System.out.println("Enter a number between 1 - " + rangeLimit);
            int userInput = scanner.nextInt();

            if(userInput > 0 && userInput <= rangeLimit){
                isActive = false;
                input = userInput;
            } else {
                System.out.println("Unable to understand input, try again");
            }
        }

        scanner.nextLine();

        return input;
    }

    public int getIntegerInput(){
        return getIntegerInput(commands.length);
    }


}
