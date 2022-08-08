import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    public static List<Product> productList = new ArrayList<>();
    static ArrayList<Product> products;
    static Scanner scanner;

    public ProductManage() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void sortByPriceLowtoHight() {
        
    }

    public static void display() {
    }

    public static void editProduct(int check, Product product) {


    }

    public void createProduct() {
        try {
            System.out.println("Mã sản phẩm: ");
            String id = scanner.nextLine();
            while (checkID(id)) {
                System.out.println("Mã sản phẩm đã tồn tại!");
                System.out.println("Nhập lại mã sản phẩm: ");
                id = scanner.nextLine();
            }
            System.out.println("Tên: ");
            String name = scanner.nextLine();
            System.out.println("Giá: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Số lượng: ");
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.println("Mô tả sản phẩm: ");
            String description = scanner.nextLine();
            Product product = new Product(id,name,price,amount,description);
            products.add(product);
            System.out.println("Thêm sản phẩm thành công!");
        } catch (Exception e) {
            System.out.println("Dữ liệu nhập vào không hợp lệ!");
            System.out.println("Hãy nhập lại.");
            createProduct();
        }
    }

    public void updateProduct(Product product) {
        try {
            System.out.println("Mã sản phẩm mới: ");
            String id = scanner.nextLine();
            while (checkID(id)) {
                System.out.println("Mã sản phẩm đã tồn tại!");
                System.out.println("Nhập lại mã sản phẩm: ");
                id = scanner.nextLine();
            }
            System.out.println("Tên mới: ");
            String name = scanner.nextLine();
            System.out.println("Giá mới: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Số lượng mới: ");
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.println("Mô tả sản phẩm mới: ");
            String description = scanner.nextLine();
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setAmount(amount);
            product.setDescribe(description);
            System.out.println("Cập nhật sản phẩm thành công!");
        } catch (Exception e) {
            System.out.println("Dữ liệu nhập vào không hợp lệ!");
            System.out.println("Hãy nhập lại.");
            updateProduct(product);
        }
    }

    public static void deleteProduct(int product) {
        System.out.println("Bạn có muốn xóa sản phẩm này không?");
        System.out.println("Y: Đồng ý xóa!");
        System.out.println("Nhập kí tự bất kì để thoát!");
        String choice = scanner.nextLine();
        if (choice.equals("Y")) {
            products.remove(product);
            System.out.println("Xóa sản phẩm thành công!");
        }
    }
    public ArrayList<Product> sortByIncrementalPrice() {
        Collections.sort(products);
        return products;
    }

    public ArrayList<Product> sortByDescendPrice() {
        ArrayList<Product> newProducts = sortByIncrementalPrice();
        Collections.reverse(newProducts);
        return newProducts;
    }

    public Product searchById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product searchMaxPrice() {
        ArrayList<Product> productArrayList = sortByIncrementalPrice();
        return productArrayList.get((productArrayList.size() - 1));
    }
    public void displayAll() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public void displayProduct(Product product) {
        System.out.println(product);
    }

    public static int checkID(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}