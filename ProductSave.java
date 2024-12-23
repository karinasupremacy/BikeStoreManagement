package controller;
import models.Product;

//import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductSave {
    public List<Product> loadFromFile(){
        List<Product> listProduct = new ArrayList<>();
        File newFile = new File("C:\\FPTU\\FA24\\LAB211\\BikeStoreManagement\\Product.txt");
        try {
            Scanner sc = new Scanner(newFile);
            while(sc.hasNextLine()){ //Khi nào hàng tiếp khác null thì vẫn quét.
                //File Structure: id, name, brand_id, category_id, model_year, list_price
                String line = sc.nextLine(); //Hoàn tất đọc 1 hàng trong cái file
                String[] data = line.split(", ");
                String id = data[0];
                String name = data[1];
                String brandId = data[2];
                String categoryId = data[3];
                int year = Integer.parseInt(data[4]);
                double price =Double.parseDouble(data[5]);
                listProduct.add(new Product(id,name,brandId,categoryId,year,price));
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return listProduct;
    }

    public void saveToFile(List<Product> listProduct){
        //File Structure: id, name, brand_id, category_id, model_year, list_price
        try{
            FileWriter filewriter = new FileWriter("C:\\FPTU\\FA24\\LAB211\\BikeStoreManagement\\Product.txt"); //Tạo 1 object vào cái file cần viết vào
            for (Product product : listProduct){
                filewriter.write(product.getId()+", "+product.getName()+", "+product.getBrandId()+", "+product.getCategoryId()+", "+product.getModelYear()+", "+product.getListPrice()+"\n");
            }
            System.out.println("Save to file successfully!!!");
            filewriter.close();
        } catch (Exception e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }
}
