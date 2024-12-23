package view;

import controller.Management;
import controller.Tool;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Management manager =new Management();
        int choice=0;
        do {
            try {
                choice= Tool.menu("Add a product.",
                        "Search product by product name, return a list of all products that same name.",
                        "Update product.",
                        "Delete product.",
                        "Save products to file.",
                        "Print list products from the file.",
                        "Quit program.");
                switch(choice){
                    case 1:
                        manager.addProduct();
                        break;
                    case 2:
                        manager.searchProduct();
                        break;
                    case 3:
                        manager.updateProduct();
                        break;
                    case 4:
                        manager.deleteProduct();
                        break;
                    case 5:
                        manager.saveToFile();
                        break;
                    case 6:
                        manager.printAllFile();
                        break;
                    case 7:
                        System.out.println("Quitting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice!!!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Not allow String");
            }
        } while (choice!=7);
    }
}
