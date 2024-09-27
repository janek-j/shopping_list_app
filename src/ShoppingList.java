package src;

import java.lang.reflect.Array;
import java.util.*;

public class ShoppingList {
    public String shopping_name;
    public TreeMap<String, ArrayList<Product>> shopping_list;

    public static class Product {
        String name;
        float quantity;
        boolean isBought;

        public Product(String name, float quantity) {
            this.name = name;
            this.quantity = quantity;
            this.isBought = false;
        }

        public String toString() {
            return name + " (" + quantity + ")" + (isBought ? " - Bought" : "");
        }

        public void markAsBought() {
            isBought = true;
        }
    }

    public ShoppingList(String _shopping_name) {
        shopping_name = _shopping_name;
        shopping_list = new TreeMap<>();
    }

    public void add_item(String item, float how_much, String product_category) {
        Product product = new Product(item, how_much);
        shopping_list.putIfAbsent(product_category, new ArrayList<>());
        shopping_list.get(product_category).add(product);
    }

    public void remove_item(String item) {
        for (Map.Entry<String, ArrayList<Product>> entry : shopping_list.entrySet()) {
            ArrayList<Product> products = entry.getValue();
            if (products.removeIf(product -> product.name.equals(item))) {
                System.out.println("Removed " + item + " from category: " + entry.getKey());
                break;
            }
        }
    }

    public void mark_item_as_bought(String item) {
        for (Map.Entry<String, ArrayList<Product>> entry : shopping_list.entrySet()) {
            for (Product product : entry.getValue()) {
                if (product.name.equals(item)) {
                    product.markAsBought();
                    System.out.println("Marked " + item + " as bought.");
                    return;
                }
            }
        }
        System.out.println("Product " + item + " not found.");
    }

    public void print_shopping_list() {
        if (!shopping_list.isEmpty()) {
            System.out.println("Shopping list: " + shopping_name);
            for (Map.Entry<String, ArrayList<Product>> entry : shopping_list.entrySet()) {
                System.out.println("Category: " + entry.getKey());
                for (Product product : entry.getValue()) {
                    System.out.println(" - " + product);
                }
            }
        } else {
            System.out.println("Shopping list is empty.");
        }
    }
    public void edit_item(String oldItem, String newItem, float newQuantity) {
        for (ArrayList<Product> products : shopping_list.values()) {
            for (Product product : products) {
                if (product.name.equals(oldItem)) {
                    product.name = newItem;
                    product.quantity = newQuantity;
                    System.out.println("Edited item: " + oldItem + " to " + newItem + " with quantity " + newQuantity);
                    return;
                }
            }
        }
        System.out.println("Item " + oldItem + " not found.");
    }
}
