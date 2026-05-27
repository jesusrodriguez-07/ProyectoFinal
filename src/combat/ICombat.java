package combat;

import exceptions.MoveExhaustedException;
import exceptions.PokemonFaintedException;

public interface ICombat {
	void attack(Pokemon target, int moveIndex) throws MoveExhaustedException, PokemonFaintedException;

	void takeDamage(int damage);
}