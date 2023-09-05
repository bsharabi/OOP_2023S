package L02.IntroInheritance;

public class Product {
    float price;
    String productName;

    public Product(float price, String productName) {
        this.price = price;
        this.productName = productName;
    }

    public Product(Product product) {
        this.price = product.price;
        this.productName = product.productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }
}


class Order {

    String orderDate;
    Product[] products;

    public Order(String orderDate) {
        this.orderDate = orderDate;
        this.products = new Product[100];
    }

    public Order(Order order) {
        this.orderDate = order.orderDate;
        this.products= new Product[order.products.length];
        for (int i = 0; i < order.products.length; i++) {
            this.products[i]=new Product(order.products[i]);
        }

    }
}
