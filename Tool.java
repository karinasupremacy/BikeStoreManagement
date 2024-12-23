package controller;

import java.util.Scanner;

public class Tool {
    public static final Scanner sc= new Scanner(System.in);
    public static int menu(Object... options){

        int L=options.length;
        for(int i=0;i<L;i++)
            System.out.println((i+1)+"-"+options[i].toString());
        System.out.println("Choose(1 to "+L+") ");
        return Integer.parseInt(sc.nextLine());
    }
}
