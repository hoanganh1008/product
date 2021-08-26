package Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        ProductManagement productManagement=new ProductManagement();
        int choice;
        do{
            menu();
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                {
                    addProduct(scanner,productManagement);
                    writeToFile(productManagement.getProducts(),"product.txt");
                    break;
                }
                case 2:
                {
                    productManagement.displayProduct();
                    break;
                }
                case 3:
                {
                    System.out.println("nhập id sản phẩm");
                    String id= scanner.nextLine();
                    findProductFromId(id,productManagement);
                }
                case 4:
                {
                    List<Product> backupProduct=getProductFromFileStream("product.txt");
                    productManagement.setProducts(backupProduct);
                }
            }
        } while(choice !=0);
    }

    private static int findProductFromId(String id,ProductManagement productManagement) {

        int index=-1;
        for(int i = 0; i< productManagement.getProducts().size(); i++)
        {
            if(id.equals(productManagement.getProducts().get(i).getId()))
            {
                index=i;
                break;
            }

        }
        return index;
    }

    private static void addProduct(Scanner scanner,ProductManagement productManagement) {
        Product product=initProduct(scanner);
        productManagement.addProduct(product);
        System.out.println("đã thêm thành công");
    }

    private static Product initProduct(Scanner scanner) {
        System.out.println("nhập id sản phẩm muốn thêm");
        String id= scanner.nextLine();
        System.out.println("nhập tên sản phẩm muốn thêm");
        String name=scanner.nextLine();
        System.out.println("nhập hãng sản phẩm");
        String brand=scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        int price= scanner.nextInt();
        Product product=new Product(id,name,brand,price);
        return product;
    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị sản phẩm");
        System.out.println("3.Tìm kiếm sản phẩm");
        System.out.println("4. Backup dữ liệu");
    }
    public static void writeToFile(List<Product> productList,String path)
    {
        try{
            FileOutputStream fos=new FileOutputStream(path);

            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(productList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<Product> getProductFromFileStream(String path) {
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
}
