import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Product implements Comparable<Product>{
    public static List<Product> arr = new ArrayList<>();
    private String id;
    private String name;
    private int price;
    private int amount;
    private String description;

    public Product(String id, String newName, double newPrice, int newQuantity, String newDes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = getDescribe();
    }

    public Product(int i, String name, int price, int amount, String describe) {
    }

    public Product(InputStream in) {

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return description;
    }

    public void setDescribe(String describe) {
        this.description = describe;
    }

    @Override
    public int compareTo(Product product) {
        return this.price - product.getPrice();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", describe='" + description + '\'' +
                '}';
    }
}
