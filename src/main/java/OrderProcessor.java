package PACKAGE_NAME;public class OrderProcessor {
}
public class OrderProcessor<T extends Product> {
    private T product;

    public OrderProcessor(T product) {
        this.product = product;
    }

    public void process() {
        System.out.println("Processing order for: " + product.getName());
    }
}
import java.util.Arrays;
import java.util.List;

public class OrderProcessingApp {
    public static void main(String[] args) {
        Product electronics1 = Electronics.builder()
                .name("Smartphone")
                .price(599.99)
                .brand("Samsung")
                .build();

        Product clothing1 = Clothing.builder()
                .name("T-shirt")
                .price(19.99)
                .size("M")
                .build();

        List<Product> orderList = Arrays.asList(electronics1, clothing1);

        // Створення потоків для обробки замовлень
        orderList.stream()
                .map(OrderProcessor::new)  // використання посилання на метод
                .forEach(order -> new Thread(order::process).start());  // запуск обробки замовлення в окремому потоці
    }
}
module order.processing {
    requires java.base;
    exports com.example.order.processing;
}
module order.storage {
        requires order.processing;
        exports com.example.order.storage;
        }
        module order.synchronization {
        requires java.base;
        requires order.processing;
        exports com.example.order.synchronization;
        }
        public class OrderProcessor<T extends Product> {
        private T product;

        public OrderProcessor(T product) {
        this.product = product;
        }

        public void process() {
        try {
        if (product == null) {
        throw new IllegalArgumentException("Product cannot be null");
        }
        System.out.println("Processing order for: " + product.getName());
        } catch (IllegalArgumentException e) {
        System.err.println("Error processing order: " + e.getMessage());
        }
        }
        }
