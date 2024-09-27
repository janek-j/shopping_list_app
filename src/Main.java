package src;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList("Weekend Shopping");

        shoppingList.add_item("Tomatoes", 5, "Vegetables");
        shoppingList.add_item("Milk", 2, "Dairy");
        shoppingList.add_item("Bread", 1, "Bakery");
        shoppingList.add_item("Cheese", 0.5f, "Dairy");

        shoppingList.print_shopping_list();

        shoppingList.mark_item_as_bought("Milk");
    }
}
