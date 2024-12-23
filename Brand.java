package models;

public class Brand {
    private String brandName;
    private String brandId;
    private String brandLocation;

    public Brand(String id, String name,String brandLocation) {
        this.brandName = name;
        this.brandId = id;
        this.brandLocation=brandLocation;
    }

    public String getBrandLocation() {
        return brandLocation;
    }

    public void setBrandLocation(String brandLocation) {
        this.brandLocation = brandLocation;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
