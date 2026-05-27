package items;

import combat.Pokemon;

public class Pokeball extends Item {
	public Pokeball() {
		this.name = "Pokeball";
		this.description = "A device used for catching wild Pokemon";
	}

	@Override
	public void use(Pokemon target) {
		System.out.println("Throwing a Pokeball at " + target.getName());
	}
}