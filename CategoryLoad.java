package controller;
import models.Category;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryLoad {
    public List<Category> loadCategoryFromFile(){
        List<Category> categories = new ArrayList<>();
        File newFile = new File("C:\\FPTU\\FA24\\LAB211\\BikeStoreManagement\\Category.txt");
        try {
            Scanner sc = new Scanner(newFile);
            while(sc.hasNextLine()){ //Khi nào hàng tiếp khác null thì vẫn quét.
                String line = sc.nextLine(); //Hoàn tất đọc 1 hàng trong cái file
                String[] data = line.split(", ");
                String id = data[0];
                String name = data[1];
                Category category = new Category(id,name);
                categories.add(category);
                }
            } catch (Exception e) {
                System.out.println("Error load categories: ");
            }
            return categories;
        }
    }


