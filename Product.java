package models;

public class Product {

private String id;
private String name;
private String brandId;
private String categoryId;
private int modelYear;
private double listPrice;

    public Product(String id,String name,String brandId,String categoryId, int modelYear,double listPrice) {
        this.id = id;
        this.listPrice = listPrice;
        this.modelYear = modelYear;
        this.categoryId = categoryId;
        this.name = name;
        this.brandId = brandId;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                ", Name: " + name  +
                ", BrandID: " + brandId  +
                ", CategoryID: " + categoryId +
                ", ModelYear: " + modelYear +
                ", ListPrice: " + listPrice;
    }
}