package items;

import java.util.HashMap;
import java.util.Map;

// La <T> indica que esta clase es Genérica
public class Inventory<T> {
    
    // Atributo: Map donde la clave es el item (T) y el valor es la cantidad (Integer)
    private Map<T, Integer> items;

    // Constructor
    public Inventory() {
        this.items = new HashMap<>();
    }

    // Método para agregar un item con su cantidad
    public void addItem(T item, int amount) {
        if (items.containsKey(item)) {
            int currentAmount = items.get(item);
            items.put(item, currentAmount + amount);
        } else {
            items.put(item, amount);
        }
        System.out.println("Added " + amount + "x to the inventory.");
    }

    public void listItems() {
    	int count = 1;
        System.out.println("--- BACKPACK ---");
        if (items.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            for (Map.Entry<T, Integer> entry : items.entrySet()) {
                System.out.println(count + "- " + entry.getKey().toString() + " (Amount --> " + entry.getValue() + ")");
                count++;
            }
        }
        System.out.println("----------------");
    }
}