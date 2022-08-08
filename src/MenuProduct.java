import javax.sql.RowSetInternal;
import javax.sql.RowSetWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuProduct {
    public static List<Product> userList = new ArrayList<>();
    static Product object = new Product(System.in) {
    };
    private static List<Product> arr = Product.arr;
    private static RowSetWriter readWrite;


    static{
        Product product = new Product(1,"Gạo ST25",12000,100,"ngon,dẻo,được mùa");
        Product product1 = new Product(2,"khăn lau mặt",10000,50,"Khăn mềm, bền");
    }

    public static void main(String[] args) {
   Scanner scanner =new Scanner(System.in);
         int Option = 0;
        do {
            System.out.println("-----MENU----");
            System.out.println("Vui lòng chọn chức năng: ");
            System.out.println(
                    "1.\tThêm sản phẩm vào danh sách.\n" +
                            "2.\tXem danh sách sản phẩm có trong cửa hàng.\n" +
                            "3.\tCập nhật danh sách sản phẩm.\n" +
                            "4.\tXoá sản phẩm.\n" +
                            "5.\tSắp xếp sản phẩm.\n" +
                            "6.\tTìm kiếm sản phẩm có giá đắt nhất.\n" +
                            "7.\tĐọc File.\n" +
                            "8.\tGhi File.\n" +
                            "9.\tThoát.\n");

            Option = scanner.nextInt();
            scanner.nextLine();
            // Thêm nhân viên vào danh sách
            switch (Option) {
                case 1:
                    try {
                        System.out.println("Nhập mã sản phẩm: ");
                        scanner.nextLine();
                        System.out.println("Nhập tên sản phẩm: ");
                        scanner.nextLine();
                        System.out.println("Nhập giá sản phẩm: ");
                        scanner.nextLine();
                        System.out.println("Nhập số lượng sản phẩm: ");
                        scanner.nextLine();
                        System.out.println("Nhập mô tả sản phẩm: ");
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Sai kiểu dữ liệu");
                    }
                    break;
                case 2:
                    ProductManage.display();
                    break;
                case 3:
                    try {
                        System.out.println("Mời bạn nhập ID");
                        String id = scanner.nextLine();
                        int check = ProductManage.checkID(id);
                        if (check == -1) {
                            System.out.println("Không có sản phẩm theo ID");
                        } else {
                            System.out.println("Mời bạn nhập ID mới");
                            String newID = scanner.nextLine();
                            System.out.println("Mời bạn nhập tên mới");
                            String newName = scanner.nextLine();
                            System.out.println("Mời bạn nhập giá mới");
                            Scanner scanner1 = new Scanner(System.in);
                            double newPrice = scanner1.nextDouble();
                            System.out.println("Mời bạn nhập số lượng mới");
                            int newQuantity = scanner.nextInt();
                            System.out.println("Mời bạn nhập mô tả mới");
                            String newDes = scanner1.nextLine();
                            Product product1 = new Product(id, newName, newPrice, newQuantity, newDes);
                            Product product = new Product();
                            ProductManage.editProduct(check, product);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Bạn đã nhập sai dữ liệu");
                        System.out.println("------------------------------");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Mời bạn nhập ID: ");
                        String id = scanner.nextLine();
                        int check = ProductManage.checkID(id);
                        if (check == -1) {
                            System.out.println("Không có sản phẩm theo ID");
                            System.out.println("----------------------------------");
                        } else {
                            ProductManage.deleteProduct(check);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Bạn đã nhập sai dữ liệu");
                        System.out.println("------------------------------");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("1. Sắp xếp");
                        System.out.println("2. Hiển thị danh sách đã sắp xếp");
                        System.out.println("3. Trở về menu chính");
                        int case5 = scanner.nextInt();
                        switch (case5) {
                            case 1:
                                ProductManage.sortByPriceLowtoHight();
                                break;
                            case 2:
                                ProductManage.display();
                                break;
                            case 3:
                                menuOfProduct();
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Bạn đã nhập sai dữ liệu");
                        System.out.println("------------------------------");
                    }
                    break;
                case 6:
                    ProductManage.sortByPriceLowtoHight();
                    List<Product> productsListInMain = ProductManage.productList;
                    System.out.println(productsListInMain.get(productsListInMain.size()-1));
                    break;
                case 7:
                    try {
                        readWrite.writeData((RowSetInternal) ProductManage.productList);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 8:
                    ProductManage.productList = readWrite.writeData();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                    break;
            }
        } while (Option == 10);
    }

    private static void menuOfProduct() {
    }
}


