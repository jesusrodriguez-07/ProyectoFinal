package combat;

import exceptions.MoveExhaustedException;
import exceptions.PokemonFaintedException;

public class Pikachu extends Pokemon {
	public Pikachu(String name, int level, int maxHp, int atk, int def) {
		this.name = name;
		this.type = "Electric";
		this.level = level;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.atk = atk;
		this.def = def;
	}

	@Override
	public void attack(Pokemon target, int moveIndex) throws MoveExhaustedException, PokemonFaintedException {
		if (this.hp <= 0) {
			throw new PokemonFaintedException(this.name + " cannot attack because it is fainted!");
		}

		Move selectedMove = this.getMoves()[moveIndex];
		if (selectedMove == null) {
			System.out.println(this.name + " tried to use an empty move slot!");
			return;
		}

		selectedMove.usePP();
		System.out.println(this.name + " uses " + selectedMove.getName() + " against " + target.getName());

		int baseDamage = (this.atk + selectedMove.getPower()) - (target.getDef() / 2);
		int finalDamage = Math.max(1, baseDamage);

		target.takeDamage(finalDamage);
	}
}