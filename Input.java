package controller;

import java.util.Scanner;

public class Input {
public Scanner sc = new Scanner(System.in);

    public String inputName(){
        String name;
        boolean check=false;
        do{
            System.out.println("Enter the name of the product: ");
            name=sc.nextLine();
            if(name.isEmpty()){
                System.out.println("Name can not be empty!!!");
            }else{
                check=true;
            }
        }while (!check);
    return name;
    }

    public String inputBrandId(){
        String brandId;
        boolean check=false;
        do {
            System.out.println("Enter Brand ID: (BXXX) ");
            brandId=sc.nextLine();
            if(brandId.matches("B[0-9]{3}")){
                check=true;
            }else{
                System.out.println("Invalid brand ID!!!");
            }
        } while (!check);

        return brandId;
    }

    public String categoryId(){
        String categoryId;
        boolean check=false;
        do {
            System.out.println("Enter Category ID:  (CXXX) ");
            categoryId=sc.nextLine();
            if(categoryId.matches("C[0-9]{3}")){
                check=true;
            }else{
                System.out.println("Invalid Category ID!!!");
            }

        } while (!check);
        return categoryId;
    }

    public int modelYear(){
        int year=0;
        boolean check=false;
        do {
            try {
                System.out.println("Enter a year: ");
                year=sc.nextInt();
                sc.nextLine();
                if(year>=2000&&year<=2024){
                    check=true;
                }
                else{
                    System.out.println("This is not a valid year, please re-enter!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid year input!!!");
                sc.nextLine();
            }
        }  while (!check);
        return year;
    }

    public double listPrice(){
        double listPrice=0;
        boolean check=false;
        do {
            try {
                System.out.println("Enter the price of product: ");
                listPrice=sc.nextDouble();
                sc.nextLine();
                if(listPrice>0){
                    check=true;
                }
            } catch (Exception e) {
                System.out.println("Invalid price!!!");
                sc.nextLine();
            }
        } while (!check);
        return listPrice;
    }

}
