import enums.Measure;
import enums.ProductCategory;
import models.Product;
import models.products.Sugar;
import service.Operation;
import service.impl.Operationlmpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Operation operation = new Operationlmpl();

        System.out.println("Добро пожаловать");
        System.out.println("");
        System.out.println("Выберите категорию продукта: ");

        operation.getCategory();
        String category = scanner.next();

        Product[] products = operation.getProductByCategory(category);
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null){
                System.out.println("Name: " + products[i].getName() + " Cost: " + products[i].getCost());
            }
        }




    }
}