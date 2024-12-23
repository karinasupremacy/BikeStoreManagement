package controller;
import models.Brand;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrandLoad {
    public List<Brand> loadBrandFromFile(){
        List<Brand> brands = new ArrayList<>();
       File newFile = new File("C:\\FPTU\\FA24\\LAB211\\BikeStoreManagement\\Brand.txt");
        try {
            Scanner sc = new Scanner(newFile);
            while(sc.hasNextLine()){ //Khi nào hàng tiếp khác null thì vẫn quét.
                String line = sc.nextLine(); //Hoàn tất đọc 1 hàng trong cái file
                String[] data = line.split(", ");
                String id = data[0];
                String name = data[1];
                String location = data[2];
                Brand brand = new Brand(id,name,location);
                brands.add(brand);
            }
       } catch (Exception e) {
            System.out.println("Error load brands: ");
        }
        return brands;
    }
}
