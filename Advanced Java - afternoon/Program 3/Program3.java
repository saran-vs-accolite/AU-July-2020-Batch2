import jdk.internal.util.xml.impl.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Program3 {
    public static List<Products> getProductsWithinPriceRange(@NotNull List<Products> products, int x, int y) {
        return products.stream().filter(product-> product.getPrice()>=x && product.getPrice()<=y).collect(Collectors.toList());
    }

    public static int getTotalProductCategories(List<Products> products) {
        return products.stream().map(Products::getCategory).collect(Collectors.toSet()).size();
    }

    public static void getMaxMinProductPerCategory(List<Products> products) {
        Set<Integer> uniqueCategories = products.stream().map(Products::getCategory).collect(Collectors.toSet());

        for (Integer category: uniqueCategories) {
            int maxPrice = products.stream().filter(product -> product.getCategory() == category).map(Products::getPrice).max(Comparator.comparing(Integer::intValue)).get();
            int minPrice = products.stream().filter(product -> product.getCategory() == category).map(Products::getPrice).min(Comparator.comparing(Integer::intValue)).get();

            System.out.println("For category " + category + " the max price is " + maxPrice );
            System.out.println("The Products with the maximum price are:");

            List<Products> maxProducts = products.stream().filter(product -> product.getPrice()==maxPrice).collect(Collectors.toList());
            maxProducts.forEach(product -> System.out.println(product.getName()));

            System.out.println();

            System.out.println("For category " + category + " the min price is " + minPrice );
            System.out.println("The Products with the minimum price are:");

            List<Products> minProducts = products.stream().filter(product -> product.getPrice()==minPrice).collect(Collectors.toList());
            minProducts.forEach(product -> System.out.println(product.getName()));

            System.out.println();
        }
    }



    public static void main(String []args) {
        ProductFactory productFactory = new ProductFactory();
        List<Products> products = productFactory.getListOfProducts(25);
        List<Products> productsWithinPriceRange = getProductsWithinPriceRange(products, 400, 700);
        System.out.println("Products within the price range of 400 and 700 are: ");
        productsWithinPriceRange.forEach(product -> System.out.println(product.getName()));

        System.out.println();

        System.out.println("Total Categories Present: " + getTotalProductCategories(products));

        System.out.println();

        getMaxMinProductPerCategory(products);


    }
}

class Products {
    private String name;
    private int category, price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class ProductFactory {
    public List<Products> getListOfProducts(int numberOfProducts) {
        List<Products> products = new ArrayList<>();
        for (int i = 1; i <= numberOfProducts; i++) {
            products.add(createProduct(i));
        }

        return products;
    }

    private Products createProduct(int i) {
        Products product = new Products();
        product.setName("Product"+i);
        product.setCategory((int)(Math.random()*(20-1+1)+1)); //category between 1 - 20
        product.setPrice((int)(Math.random()*(1000-100+1)+1)); //price between 100 - 1000
        return product;
    }
}