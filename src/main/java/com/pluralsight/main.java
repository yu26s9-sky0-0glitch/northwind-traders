package com.pluralsight;

public class main {
    static void main(){
    DataManager dm = new DataManager();
    int command;
    do {
        command = Console.promptForInt("""
                What do you want to do?
                1) Display all products
                2) Display all customers
                0) Exit
                Select an option: """);
        switch (command){
            case 1:
                dm.getProducts();
                break;
            case 2:
                dm.getCustomers();
                break;
            case 0:
                break;
            default:
                System.out.println(ColorUtils.RED+"Invalid Entry"+ColorUtils.RESET);

        }
    }while(command!=0);
    }
}
