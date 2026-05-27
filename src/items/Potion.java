package items;

import combat.Pokemon;

public class Potion extends Item {
	public Potion() {
		this.name = "Potion";
		this.description = "Heals 20 HP to a damaged Pokemon";
	}

	@Override
	public void use(Pokemon target) {
		System.out.println("Using Potion on " + target.getName());
		target.heal(20);
	}
}