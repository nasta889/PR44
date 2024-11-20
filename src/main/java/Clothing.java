package PACKAGE_NAME;public class Clothing {
}
import lombok.Builder;

public class Clothing extends Product {
    private String size;

    @Builder
    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
