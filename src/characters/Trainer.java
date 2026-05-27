package characters;

import combat.Pokemon;
import items.Inventory;
import items.Item;
import exceptions.FullTeamException;
import java.util.ArrayList;
import java.util.List;

public class Trainer extends Inhabitant {
	private int medals;
	private List<Pokemon> team;
	private Inventory<Item> inventory;

	public Trainer(String name) {
		this.name = name;
		this.medals = 0;
		this.team = new ArrayList<>();
		this.inventory = new Inventory<>();
	}

	@Override
	public void interact() {
		System.out.println("Trainer " + this.name + " challenges you to a Pokemon battle!");
	}

	public void addPokemon(Pokemon pokemon) throws FullTeamException {
		if (this.team.size() >= 6) {
			throw new FullTeamException(this.name + " cannot add more Pokemon. The team is full!");
		}
		this.team.add(pokemon);
		System.out.println(pokemon.getName() + " has been added to " + this.name + "'s team");
	}

	public void useItem(Item item, Pokemon target) {
		System.out.println(this.name + " is using " + item.getName() + " on " + target.getName());
		item.use(target);
	}

	public int getMedals() {
		return this.medals;
	}

	public void setMedals(int medals) {
		this.medals = medals;
	}

	public List<Pokemon> getTeam() {
		return this.team;
	}

	public Inventory<Item> getInventory() {
		return this.inventory;
	}

	public Pokemon getActivePokemon() {
		for (Pokemon pokemon : this.team) {
			if (pokemon.getHp() > 0) {
				return pokemon;
			}
		}
		return null;
	}

	public void removePokemon(int index) {
		if (index >= 0 && index < this.team.size()) {
			Pokemon removed = this.team.remove(index);
			System.out.println(removed.getName() + " has been released into the wild.");
		} else {
			System.out.println("Invalid team slot.");
		}
	}
}