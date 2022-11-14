package com.company.services.impl;

import com.company.exception.ProductNotFoundExc;
import com.company.models.Check;
import com.company.models.CheckProduct;
import com.company.models.Product;
import com.company.services.ProductService;
import com.company.services.SellOperationService;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SellOperationServiceImpl implements SellOperationService {
    ProductService productService=new ProductServiceImpl();
    TreeSet<Product> selectedProduct=new TreeSet<>();

    Scanner scanner=new Scanner(System.in);

    @Override
    public void sell() {
        System.out.println("Выберите продукты для продажи ");
        List<Product> products=productService.getList();
        System.out.println(products);

        CheckProduct checkProduct=new CheckProduct();
//        private Product product;
//        private Check check;
//        private double cost;
//        private double count;

        //save CheckProduct
        //save check


        double countOfProduct;
        while (true){
//            Long productId=scanner.nextLong();
            System.out.println("Введите id продукта ");
            Product product=null;
            try {
                 product=productService.findById(scanner.nextLong());
            }catch (ProductNotFoundExc e){
                System.out.println(e.getMessage());
                continue;
            }

            checkProduct.setProduct(product);

            System.out.println("Введите количество");
            checkProduct.setCount(scanner.nextDouble());
            checkProduct.setCost(product.getPrice());

//
//            System.out.println("Продолжить? 1 да 0 нет");
//            if (scanner.nextInt())
//        }

//        Check check=new Check();
//        private double totalSum;
//        private Long num;
//        private int fd;













        /*
        Вывести продукты для продажи
        Выбрать продукты ( Составить уникальный список продуктов для корзины и определять их количество )
        Создать Чек

           Подсчет стоимости всех продуктов с учетом количества

           Вывод чека со стоимостью, списком продуктов, продавцом совершимшим операцию, магазином, где была произведена операция

        *
        * */

    }}
}
