package combat;

import characters.Trainer;
import exceptions.MoveExhaustedException;
import exceptions.PokemonFaintedException;

public class Combat {
	private int combatId;
	private Trainer challenger;
	private Trainer rival;

	public Combat(int combatId, Trainer challenger, Trainer rival) {
		this.combatId = combatId;
		this.challenger = challenger;
		this.rival = rival;
	}

	public boolean hasAvailablePokemon(Trainer trainer) {
		for (Pokemon pokemon : trainer.getTeam()) {
			if (pokemon.getHp() > 0) {
				return true;
			}
		}
		return false;
	}

	public void executeTurn(Pokemon attacker, Pokemon target, int moveIndex) {
		try {
			attacker.attack(target, moveIndex);
		} catch (PokemonFaintedException e) {
			System.out.println("Combat Error: " + e.getMessage());
		} catch (MoveExhaustedException e) {
			System.out.println("Combat Error: " + e.getMessage());
		}
	}

	public void checkCombatStatus() {
		if (!hasAvailablePokemon(challenger)) {
			System.out.println(rival.getName() + " wins the combat!");
		} else if (!hasAvailablePokemon(rival)) {
			System.out.println(challenger.getName() + " wins the combat!");
		} else {
			System.out.println("The combat continues!");
		}
	}
}