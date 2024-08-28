package database;

import com.company.models.Category;
import com.company.models.Product;
import com.company.models.ProductType;

import java.util.ArrayList;

public class Database {

    public static ArrayList<Product>getProducts() {
        ArrayList<Product> products =new ArrayList<>();
        Product a = new Product("1", ProductType.ALCOHOLIC, "vodka", "Flirt", 2.20, 2000);
        Product b = new Product("2", ProductType.NONALCOHOLIC, "coca-cola", "Coca-cola", 2.00, 1500);
        Product c = new Product("3", ProductType.FOOD, "nuts", "Almonds", 5.00, 1000);
        Product a1 = new Product("4", ProductType.ALCOHOLIC, "Johnnie Walker", "Whisky", 2.20, 2000);
        Product b1 = new Product("5", ProductType.NONALCOHOLIC, "Fanta", "Fanta", 2.00, 1500);
        Product c1 = new Product("6", ProductType.FOOD, "Bar branded", "Cake", 5.00, 1000);
        Product a2 = new Product("7", ProductType.ALCOHOLIC, "Heineken", "Beer", 2.20, 2000);
        Product b2 = new Product("8", ProductType.NONALCOHOLIC, "Bar branded", "Juice", 2.00, 1500);
        Product c2 = new Product("9", ProductType.FOOD, "Bar branded", "Sandwich", 5.00, 1000);
        products.add(a);
        products.add(b);
        products.add(c);
        products.add(a1);
        products.add(b1);
        products.add(c1);
        products.add(a2);
        products.add(b2);
        products.add(c2);

        return products;


    }
    public static ArrayList<Category> getCategories(){
        ArrayList<Category>category = new ArrayList<>();
        category.add(new Category(ProductType.ALCOHOLIC, "Alcohol"));
        category.add(new Category(ProductType.NONALCOHOLIC,"Non-Alcoholic"));
        category.add(new Category(ProductType.FOOD,"Food"));
        return category;
    }
}
