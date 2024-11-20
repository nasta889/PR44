package PACKAGE_NAME;public class Electronics {
}
import lombok.Builder;

public class Electronics extends Product {
    private String brand;

    @Builder
    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
