package com.pluralsight;

public class main {
    static DataManager dm = new DataManager();
    static void main(){
    int command;
    do {
        command = Console.promptForInt("""
                What do you want to do?
                1) Display all products
                2) Display all customers
                3) Display All Categories
                0) Exit
                Select an option: """,0,3);
        switch (command){
            case 1:
                dm.getProducts();
                break;
            case 2:
                dm.getCustomers();
                break;
            case 3:
                processCategory();
                break;
            case 0:
                break;
            default:
                System.out.println(ColorUtils.RED+"Invalid Entry"+ColorUtils.RESET);

        }
    }while(command!=0);
    }

    private static void processCategory() {
        dm.getCategories();
        int categoryID = Console.promptForInt("Lookup by Category Enter Category ID");
        dm.getProductByCategory(categoryID);
    }
}
