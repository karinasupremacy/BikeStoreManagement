package controller;
import models.Brand;
import models.Category;
import models.Product;
import java.util.*;

public class Management{
public static Scanner sc = new Scanner(System.in);
public List<Product> listProduct = new ArrayList<>();
public List<Brand> listBrand = new ArrayList<>();
public List<Category> listCategory = new ArrayList<>();
public ProductSave productSave = new ProductSave();
public BrandLoad brandLoad = new BrandLoad();
public CategoryLoad categoryLoad = new CategoryLoad();
public Input input = new Input();

public Management() {
      listProduct = productSave.loadFromFile();
      listBrand = brandLoad.loadBrandFromFile();
      listCategory = categoryLoad.loadCategoryFromFile();
    }

public boolean checkIdProductExist(String id){
        for(Product product : listProduct){
            if(product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

public boolean checkIdFromList(String str, String id){
    switch (str){
        case "Category":
            for(Category category : listCategory){
                if(category.getCategoryId().equals(id)){
                    return true;
                }
            }
            System.out.println("Not valid CategoryID.");
            return false;
            case "Brand":
                for(Brand brand : listBrand){
                    if(brand.getBrandId().equals(id)){
                        return true;
                    }
                }
                System.out.println("Not valid BrandID.");
                return false;
            default:
                System.out.println("ID does not exist!!!");
                break;
        }
        return false;
    }


public void addProduct(){
String id="",name,categoryId,brandId;
int modelYear=0;
double listPrice=0;
boolean check = true;

do{
    System.out.println("Enter the ID of the product: ");
    id=sc.nextLine();
    if(checkIdProductExist(id)==false){
        check=false;
    }else{
        System.out.println("Invalid ID input!!! ID already exist.");
    }
}while(check==true);

do{
    System.out.println("Please enter name of the product: ");
    name=sc.nextLine();
}while (name.isEmpty());

do{
    System.out.println("Enter BrandID: (BXXX) ");
    brandId=sc.nextLine();
}while (checkIdFromList("Brand",brandId)==false);

do{
    System.out.println("Enter Category ID: (CXXX)");
    categoryId=sc.nextLine();
}while (checkIdFromList("Category",categoryId)==false);

boolean check1=true;
do{
    try {
        System.out.println("Enter model year: ");
        modelYear=sc.nextInt();
        sc.nextLine();
        if(modelYear<2000 || modelYear>2024){
            System.out.println("Invalid year!!! Please enter again.");
        }else{
            check1=false;
        }
    } catch (Exception e) {
        System.out.println("Not allowed string!!!");
        sc.nextLine();
    }
}while (check1==true);

do{
    try {
        System.out.println("Enter list price: ");
        listPrice=sc.nextDouble();
        sc.nextLine();
        if(listPrice<=0){
            System.out.println("Invalid price!!! Please enter again.");
        }
    } catch (Exception e) {
        System.out.println("Not allowed string!!!");
        sc.nextLine();
    }
}while (listPrice<=0);

Product product = new Product(id,name,brandId,categoryId,modelYear,listPrice);
listProduct.add(product);
}

public void searchProduct() {
    List<Product> result = new ArrayList<>();
    String name;
    System.out.println("Enter the name of the product you want to search: ");
    name = sc.nextLine();
    for (Product product : listProduct) {
        if (product.getName().toLowerCase().contains(name.toLowerCase())) {
            result.add(product);
        }
    }
    if (result.isEmpty()) {
        System.out.println("Product not found!!!");
    } else {
        System.out.print("Product found: ");
        for (Product product : result) {
            System.out.print(product);
        }
        System.out.println("");
    }
}

public Product findProductById(String id){
    for(int i =0; i<listProduct.size();i++){
        Product product = listProduct.get(i);
        if (product.getId().equals(id)){
            return product;
        }
    }
    return null;
}

public boolean checkToProceed(){
    boolean check=true;
    String answer;
        do {
            System.out.println("Do you want to quit?  [Y/N]");
            answer = sc.nextLine();
            switch (answer) {
                case "Y":
                    check = false;
                    break;
                case "N":
                    System.out.println("Continue the program.");
                    break;
                default:
                    System.out.println("Invalid options!!!");
                    break;
            }
        }while (!answer.equals("Y") && !answer.equals("N"));
    return check;
}

public void updateProduct(){
    if(listProduct.isEmpty()){
        System.out.println("This list is empty!!!");
    }
    int choice;
    String id;
    boolean check=true;
    do{
        System.out.println("Enter the ID of the product you want to update: ");
        id=sc.nextLine();
        if(checkIdProductExist(id)){
            Product product=findProductById(id);
                    System.out.println("Which information you want to update:");
                    System.out.println("1. Update all information.");
                    System.out.println("2. Update a specific information.");
                    System.out.println("Select: ");
                    choice=Integer.parseInt(sc.nextLine());
                    switch (choice){
                        case 1:
                        product.setName(input.inputName());
                        product.setBrandId(input.inputBrandId());
                        product.setCategoryId(input.categoryId());
                        product.setModelYear(input.modelYear());
                        product.setListPrice(input.listPrice());
                            System.out.println("Update information successfully.");
                            check= checkToProceed();
                            break;

                        case 2:
                            int choice2;
                            System.out.println("Choose which information you want to update: ");
                            choice2= Tool.menu("Update name.",
                                    "Update BrandID.", "Update CategoryID.","Update model year.",
                                             "Update list price.","Quit program.");
                            switch (choice2){
                                case 1:
                                    product.setName(input.inputName());
                                    System.out.println("Update information successfully!!!");
                                    check=checkToProceed();
                                    break;
                                case 2:
                                    product.setBrandId(input.inputBrandId());
                                    System.out.println("Update information successfully!!!");
                                    check=checkToProceed();
                                    break;
                                case 3:
                                    product.setCategoryId(input.categoryId());
                                    System.out.println("Update information successfully!!!");
                                    check=checkToProceed();
                                    break;
                                case 4:
                                    product.setModelYear(input.modelYear());
                                    System.out.println("Update information successfully!!!");
                                    check=checkToProceed();
                                    break;
                                case 5:
                                    product.setListPrice(input.listPrice());
                                    System.out.println("Update information successfully!!!");
                                    check=checkToProceed();
                                    break;
                                case 6:
                                    System.out.println("Quitting");
                                    check=checkToProceed();
                                    break;
                                default:
                                    System.out.println("Invalid choice!!!");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Invalid choice!!!");
                            break;
                  }
        }else{
            System.out.println("Product does not exist.");
        }
    }while(check==true);
}

public void deleteProduct(){
if(listProduct.isEmpty()){
    System.out.println("This list is empty!!!");
}
boolean check=true;
do {
    String id;
    String answer;
    System.out.println("Enter the ID of the product you want to delete: ");
    id=sc.nextLine();
    if(checkIdProductExist(id)) {
        for(Product product : listProduct){
            if(product.getId().equals(id)){
                do {
                    System.out.println("Do you want to delete this product?  [Y/N]");
                    answer=sc.nextLine();
                    switch(answer){
                        case"Y":
                            listProduct.remove(product);
                            System.out.println("Product delete successfully!!!");
                            check=false;
                            break;
                        case"N":
                            System.out.println("Select product again.");
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                }while (!answer.equals("Y") && !answer.equals("N"));
            }
        }
    }else{
        System.out.println("Product does not exist!!!");
    }
}while (check==true);

}

public void saveToFile(){
productSave.saveToFile(listProduct);
    }

public String getBrandNameById(String brandId) {
     for (Brand brand : listBrand) {
         if (brand.getBrandId().equals(brandId)) {
             return brand.getBrandName();
            }
        }
        return "Null";
    }

public String getCategoryNameById(String categoryId) {
    for (Category category : listCategory) {
        if (category.getCategoryId().equals(categoryId)) {
            return category.getCategoryName();
            }
        }
        return "Null";
    }

public void printAllFile(){
Collections.sort(listProduct,((o1, o2) -> Double.compare(o1.getListPrice(), o2.getListPrice())));
Collections.sort(listProduct,((o1, o2) -> Integer.compare(o1.getModelYear(), o2.getModelYear())));
for (Product product : listProduct){
String brandName = getBrandNameById(product.getBrandId());
String categoryName = getCategoryNameById(product.getCategoryId());
System.out.printf("ID: %s,  Name: %s,  Brand Name: %s,  Category Name: %s,  Model Year: %d,  List Price: %.2f\n",
        product.getId(),
        product.getName(),
        brandName,
        categoryName,
        product.getModelYear(),
        product.getListPrice());
        }
    }
}


