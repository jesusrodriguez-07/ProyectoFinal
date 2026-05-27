package items;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
	private Map<T, Integer> items;

	public Inventory() {
		this.items = new HashMap<>();
	}

	public void addItem(T item, int quantity) {
		this.items.put(item, this.items.getOrDefault(item, 0) + quantity);
		System.out.println("Added " + quantity + " units of " + item.toString() + " to the inventory");
	}

	public void listItems() {
		System.out.println("Inventory contents:");
		for (Map.Entry<T, Integer> entry : items.entrySet()) {
			System.out.println("- " + entry.getKey().toString() + ": " + entry.getValue());
		}
	}
}