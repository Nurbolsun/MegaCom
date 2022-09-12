import enums.Measure;
import enums.ProductCategory;
import models.*;
import models.products.Sugar;
import service.Operation;
import service.impl.Operationlmpl;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operation operation = new Operationlmpl();
        byte answer = 0;
        int count=0;
        System.out.println(count);
        Details[] details = new Details[10];

        System.out.println("Добро пожаловать");

        while (answer!=1) {
            System.out.println("Выберите категорию продукта: ");
            operation.getCategory();
            String category = scanner.next();
            Product[] products = operation.getProductByCategory(category);
            for (Product product : products) {
                if (product != null)
                    product.getInfo();
            }
            System.out.println("Выберите продукт: ");
            String productName = scanner.next();
            Product product = operation.getProductByName(productName);
            System.out.println("Выберите количество: ");
            int amount = scanner.nextInt();
            System.out.println("Выберите скидку: ");
            int discount = scanner.nextInt();
            Details detail = new Details(product, amount, discount);
            details[count] = detail;

            System.out.println("Продолжаете ? 1 нет, 0 да");
            answer = scanner.nextByte();
            count++;
        }
            for (Details iteam:details)
            if (iteam!=null)
                System.out.println(iteam);

            System.out.println("Выберите кассира ");
            String cashier = scanner.next();
            Cashier res = operation.getCashierByName(cashier);

            Order order = new Order();
            order.setDetails(details);
            order.setCashier(res);

        Receipt receipt = operation.getReceipt(order);
        System.out.println(receipt);

    }
}