import enums.Measure;
import enums.ProductCategory;
import models.*;
import models.products.Sugar;
import service.Operation;
import service.impl.Operationlmpl;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Operation operation = new Operationlmpl();
        byte answer = 0;
        int count = 0;
        System.out.println(count);
        Details[] details = new Details[10];

        System.out.println("����� ����������");
        while (answer != 1) {
            System.out.println("�������� ��������� ��������: ");
            operation.getCategory();
            String category = scanner.next();

            Product[] products;
            try {
                products = operation.getProductByCategory(category);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("������� ��� ���");
                continue;
            }

            for (Product product : products) {
                if (product != null)
                    product.getInfo();
            }
            System.out.println("�������� �������: ");
            String productName = scanner.next();
            Product product = operation.getProductByName(productName);
            System.out.println("�������� ����������: ");
            int amount = scanner.nextInt();
            System.out.println("�������� ������: ");
            int discount = scanner.nextInt();
            Details detail = new Details(product, amount, discount);
            details[count] = detail;

            System.out.println("����������� ? 1 ���, 0 ��");
            answer = scanner.nextByte();
            count++;
        }
        for (Details iteam : details)
            if (iteam != null)
                System.out.println(iteam);

        System.out.println("�������� ������� ");
        operation.getName();
        String cashier = scanner.next();
        Cashier res = operation.getCashierByName(cashier);
        Order order = new Order();
        order.setDetails(details);
        order.setCashier(res);
        Receipt receipt = operation.getReceipt(order);
        System.out.println(receipt);

    }
}