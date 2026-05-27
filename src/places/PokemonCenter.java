package places;

import combat.Pokemon;
import java.util.List;

public class PokemonCenter extends Building {
	public PokemonCenter(String name) {
		this.name = name;
	}

	public void healTeam(List<Pokemon> team) {
		System.out.println("Healing Pokemon team in " + this.name + "...");
		for (Pokemon pokemon : team) {
			pokemon.heal(pokemon.getMaxHp());
		}
		System.out.println("All team members have been successfully healed at " + this.name);
	}
}